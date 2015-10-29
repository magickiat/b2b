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

import com.starboard.b2b.dto.ProductSearchResult;
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
				"SELECT new com.starboard.b2b.dto.search.SearchProductModelDTO(p.productId, p.productCode, p.productPictureMedium, p.productModelId, m.productModelName, p.productNameEn, p.productPrice, p.productUnitId, p.productCurrency, m.image) ");
		StringBuffer sbTotal = new StringBuffer("select count(distinct p.productModelId ) ");

		// common query
		StringBuffer sb = new StringBuffer();
		sb.append("FROM Product p, ProductBuyerGroup pbg, ProductModel m where p.productBuyerGroupId = pbg.productBuyerGroupId ");

		sb.append("and p.productModelId = m.productModelId ");
		sb.append("and p.isActive = 1 ");

		SearchProductForm condition = req.getCondition();
		if (condition != null) {
			if (StringUtils.isNotEmpty(condition.getSelectedBrand())) {
				sb.append("and p.productTypeId = :productTypeId ");
			} else {
				sb.append(
						"and p.productTypeId in (select a.productTypeId from ProductType as a , ProductBrandGroup b where a.productTypeId = b.id.productTypeId and b.id.brandGroupId = :brandGroupId) ");
			}

			if (StringUtils.isNotEmpty(condition.getSelectedBuyerGroup())) {
				sb.append("and p.productBuyerGroupId = :productBuyerGroupId ");
			}

			if (StringUtils.isNotEmpty(condition.getSelectedModel())) {
				sb.append("and p.productModelId = :productModelId ");
			}

			if (StringUtils.isNotEmpty(condition.getSelectedYear())) {
				sb.append("and p.productYearId = :productYearId ");
			}

			if (StringUtils.isNotEmpty(condition.getSelectedTechnology())) {
				sb.append("and p.productTechnologyId = :productTechnologyId ");
			}

			if (StringUtils.isNotEmpty(condition.getKeyword())) {
				sb.append("and (");
				sb.append("   m.productModelName 	like :keyword ");
				sb.append("or p.productNameEn 	like :keyword ");
				sb.append("or p.productLength 	like :keyword ");
				sb.append("or p.productBand 	like :keyword ");
				sb.append(")");
			}
		}

		// Set common query
		sbTotal.append(sb);

		if ("image".equals(req.getCondition().getShowType())) {
			sb.append(" GROUP BY p.productModelId ");
		}
		sb.append(" ORDER BY pbg.seq, p.productCode ");
		sbQuery.append(sb);

		// create query and set parameter
		Query queryTotal = sf.getCurrentSession().createQuery(sbTotal.toString());
		Query query = sf.getCurrentSession().createQuery(sbQuery.toString());

		if (condition != null) {

			if (StringUtils.isNotEmpty(condition.getSelectedBrand())) {
				query.setString("productTypeId", condition.getSelectedBrand());
				queryTotal.setString("productTypeId", condition.getSelectedBrand());
			} else {
				query.setLong("brandGroupId", condition.getBrandId());
				queryTotal.setLong("brandGroupId", condition.getBrandId());
			}

			if (StringUtils.isNotEmpty(condition.getSelectedBuyerGroup())) {
				query.setString("productBuyerGroupId", condition.getSelectedBuyerGroup());
				queryTotal.setString("productBuyerGroupId", condition.getSelectedBuyerGroup());
			}

			if (StringUtils.isNotEmpty(condition.getSelectedModel())) {
				query.setString("productModelId", condition.getSelectedModel());
				queryTotal.setString("productModelId", condition.getSelectedModel());
			}

			if (StringUtils.isNotEmpty(condition.getSelectedYear())) {
				query.setString("productYearId", condition.getSelectedYear());
				queryTotal.setString("productYearId", condition.getSelectedYear());
			}

			if (StringUtils.isNotEmpty(condition.getSelectedTechnology())) {
				query.setString("productTechnologyId", condition.getSelectedTechnology());
				queryTotal.setString("productTechnologyId", condition.getSelectedTechnology());
			}

			if (StringUtils.isNotEmpty(condition.getKeyword())) {
				query.setString("keyword", "%" + condition.getKeyword() + "%");
				queryTotal.setString("keyword", "%" + condition.getKeyword() + "%");
			}
		}
		// query
		Object total = queryTotal.uniqueResult();
		List list = query.setFirstResult(req.getFirstResult()).setMaxResults(req.getPageSize()).list();

		SearchResult<SearchProductModelDTO> result = new SearchResult<>();
		result.setTotal(total == null ? 0 : (long) total);
		result.setResult(list);

		log.info("List size: " + (list != null ? list.size() : 0));
		log.info("Total " + result.getTotal());
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<ProductSearchResult> findProductModel(String modelId, String withnoseProtection) {
		StringBuffer sb = new StringBuffer();
		sb.append(
				" select new com.starboard.b2b.dto.ProductSearchResult(p.productCurrency, p.productId,p.productTypeId,p.productCatalogId,p.productGroupId,p.productCode,p.productNameTh,p.productNameEn,p.productPrice,p.productDiscount,p.productTotalPrice,p.productBand,p.productQuantity,p.productWeight,p.productPreintro,p.productIntro,p.productDetail,p.productSummarize,p.productLink,p.productPictureMedium,p.productPictureBig,p.productStatus,p.productStock,p.productItemGroupId,p.vendor,p.productItemTypeId,p.productSubcategoryId,p.searchName,p.productTechnologyId,p.productDesign,p.supCatG,p.productWidth,p.productLength,p.supGroup,p.productBuyerGroupId,p.productCategoryId,p.productModelId,p.productYearId,p.productUnitId,p.sortBy,p.isActive,p.company,p.soCategory,p.productPictureSmallHorizontal,p.productPictureSmallVertical,p.userCreate,p.userUpdate,p.timeCreate,p.timeUpdate, t.productTypeName)");
		sb.append(" from Product p, ProductType t");
		sb.append(" where t.productTypeId = p.productTypeId");
		sb.append(" and p.productModelId = :modelId");
		sb.append(" AND p.productPreintro = :withnose");
		sb.append(" ORDER BY p.productTechnologyId , p.productIntro ASC");

		List list = sf.getCurrentSession().createQuery(sb.toString()).setString("modelId", modelId).setString("withnose", withnoseProtection).list();

		log.info("result size: " + (list == null ? 0 : list.size()));

		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<ProductSearchResult> findProductModel(String modelId) {
		StringBuffer sb = new StringBuffer();
		sb.append(
				" select new com.starboard.b2b.dto.ProductSearchResult(p.productId,p.productTypeId,p.productCatalogId,p.productGroupId,p.productCode,p.productNameTh,p.productNameEn,p.productPrice,p.productDiscount,p.productTotalPrice,p.productBand,p.productQuantity,p.productWeight,p.productPreintro,p.productIntro,p.productDetail,p.productSummarize,p.productLink,p.productPictureMedium,p.productPictureBig,p.productStatus,p.productStock,p.productItemGroupId,p.vendor,p.productItemTypeId,p.productSubcategoryId,p.searchName,p.productTechnologyId,p.productDesign,p.supCatG,p.productWidth,p.productLength,p.supGroup,p.productBuyerGroupId,p.productCategoryId,p.productModelId,p.productYearId,p.productUnitId,p.sortBy,p.isActive,p.company,p.soCategory,p.productPictureSmallHorizontal,p.productPictureSmallVertical,p.userCreate,p.userUpdate,p.timeCreate,p.timeUpdate, t.productTypeName)");
		sb.append(" from ProductType t, Product p");
		sb.append(" where t.productTypeId = p.productTypeId");
		sb.append(" and p.productModelId = :modelId");
		sb.append(" ORDER BY p.productTechnologyId , p.productIntro ASC");

		List list = sf.getCurrentSession().createQuery(sb.toString()).setString("modelId", modelId).list();

		log.info("result size: " + (list == null ? 0 : list.size()));

		return list;
	}

	@Override
	public Product findById(long productId) {
		return (Product) sf.getCurrentSession().get(Product.class, productId);
	}
}
