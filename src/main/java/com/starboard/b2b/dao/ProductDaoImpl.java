package com.starboard.b2b.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dto.search.CommonSearchRequest;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.Brand;
import com.starboard.b2b.model.Product;
import com.starboard.b2b.web.form.product.SearchProductForm;

@Repository
public class ProductDaoImpl implements ProductDao {

	private static final Logger log = LoggerFactory.getLogger(ProductDaoImpl.class);

	@Autowired
	private SessionFactory sf;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Product> list() {
		return sf.getCurrentSession().createCriteria(Product.class).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Product> list(Integer brandId) {
		Session session = sf.getCurrentSession();
		Brand brand = (Brand) session.get(Brand.class, brandId);
		return session.createCriteria(Product.class).add(Restrictions.eq("brand", brand)).list();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@Transactional(readOnly = true)
	public SearchResult<SearchProductModelDTO> search(CommonSearchRequest<SearchProductForm> req) {

		StringBuffer sbQuery = new StringBuffer(
				"SELECT new com.starboard.b2b.dto.search.SearchProductModelDTO(p.productId, p.productCode, p.productPictureMedium, p.productModelId, m.productModelName) ");
		StringBuffer sbTotal = new StringBuffer("select count(distinct p.productModelId ) ");

		// common query
		StringBuffer sb = new StringBuffer();
		sb.append(
				"FROM Product p, ProductBuyerGroup pbg, ProductModel m where p.productBuyerGroupId = pbg.productBuyerGroupId ");

		sb.append("and p.productModelId = m.productModelId ");
		sb.append("and p.isActive = 1 ");

		if (req.getCondition() != null) {
			if (StringUtils.isNotEmpty(req.getCondition().getSelectedBrand())) {
				sb.append("and p.productCategoryId = :productCategoryId ");
			}

			if (StringUtils.isNotEmpty(req.getCondition().getSelectedBuyerGroup())) {
				sb.append("and p.productBuyerGroupId = :productBuyerGroupId ");
			}

			if (StringUtils.isNotEmpty(req.getCondition().getSelectedModel())) {
				sb.append("and p.productModelId = :productModelId ");
			}

			if (StringUtils.isNotEmpty(req.getCondition().getSelectedYear())) {
				sb.append("and p.productYearId = :productYearId ");
			}
			
			if(StringUtils.isNotEmpty(req.getCondition().getSelectedTechnology())){
				sb.append("and p.productTechnologyId = :productTechnologyId ");
			}
		}

		// Set common query
		sb.append("GROUP BY p.productModelId ");

		sbQuery.append(sb);
		sbTotal.append(sb);

		// create query and set parameter
		Query queryTotal = sf.getCurrentSession().createQuery(sbTotal.toString());
		Query query = sf.getCurrentSession().createQuery(sbQuery.toString());

		if (req.getCondition() != null) {
			if (StringUtils.isNotEmpty(req.getCondition().getSelectedBrand())) {
				query.setString("productCategoryId", req.getCondition().getSelectedBrand());
				queryTotal.setString("productCategoryId", req.getCondition().getSelectedBrand());
			}

			if (StringUtils.isNotEmpty(req.getCondition().getSelectedBuyerGroup())) {
				query.setString("productBuyerGroupId", req.getCondition().getSelectedBuyerGroup());
				queryTotal.setString("productBuyerGroupId", req.getCondition().getSelectedBuyerGroup());
			}

			if (StringUtils.isNotEmpty(req.getCondition().getSelectedModel())) {
				query.setString("productModelId", req.getCondition().getSelectedModel());
				queryTotal.setString("productModelId", req.getCondition().getSelectedModel());
			}

			if (StringUtils.isNotEmpty(req.getCondition().getSelectedYear())) {
				query.setString("productYearId", req.getCondition().getSelectedYear());
				queryTotal.setString("productYearId", req.getCondition().getSelectedYear());
			}
			
			if(StringUtils.isNotEmpty(req.getCondition().getSelectedTechnology())){
				query.setString("productTechnologyId", req.getCondition().getSelectedTechnology());
				queryTotal.setString("productTechnologyId", req.getCondition().getSelectedTechnology());
			}
		}
		// query
		Object total = queryTotal.uniqueResult();
		List list = query.setFirstResult(req.getFirstResult()).setMaxResults(req.getPageSize()).list();
		log.info("List size: " + (list != null ? list.size() : 0));
		SearchResult<SearchProductModelDTO> result = new SearchResult<>();
		result.setTotal(total == null ? 0 : (long) total);
		result.setResult(list);

		log.info("Total " + result.getTotal());
		return result;
	}
}
