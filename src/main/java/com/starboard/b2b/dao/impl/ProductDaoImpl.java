package com.starboard.b2b.dao.impl;

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

import com.starboard.b2b.common.B2BConstant;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.dto.ProductSearchResult;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.Product;
import com.starboard.b2b.web.form.product.SearchProductForm;

@Repository("productDao")
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@Transactional(readOnly = true)
	public SearchResult<SearchProductModelDTO> searchProductForFrontend(SearchRequest<SearchProductForm> req, Long custId) {

		StringBuilder sbQuery = new StringBuilder("SELECT " + getSearchProductConstructor());
		StringBuilder sbTotal = new StringBuilder("");
		if ("image".equals(req.getCondition().getShowType())) {
			sbTotal.append(" select count(distinct p.productModelId) ");
		} else {
			sbTotal.append(" select count(p.productId)  ");
		}

		// common query
		StringBuffer sb = new StringBuffer();
		sb.append("FROM Product p, ProductModel m where ");

		sb.append(" p.productModelId = m.productModelId ");
		sb.append("and p.isActive = 1 ");

		SearchProductForm condition = req.getCondition();
		if (condition != null) {
			if (StringUtils.isNotEmpty(condition.getSelectedBrand())) {
				sb.append("and p.productTypeId = :productTypeId ");
			} else {
				sb.append(
						"and p.productTypeId in (select a.productTypeId from ProductType as a , CustBrandGroup b where a.productTypeId = b.id.brandGroupId and b.id.custId = :custId) ");
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
				sb.append("and ( ");
				sb.append("m.productModelName 	like :keyword ");
				sb.append("or p.productNameEn 	like :keyword ");
				sb.append("or p.productLength 	like :keyword ");
				sb.append("or p.productBand 	like :keyword ");
				sb.append("or p.productCode		like :keyword ");
				sb.append(")");
			}
		}

		// Set common query
		sbTotal.append(sb);

		if ("image".equals(req.getCondition().getShowType())) {
			sb.append(" GROUP BY p.productModelId ");
		}
		sb.append(" ORDER BY p.productCode ");
		sbQuery.append(sb);

		// create query and set parameter
		Query queryTotal = sf.getCurrentSession().createQuery(sbTotal.toString());
		Query query = sf.getCurrentSession().createQuery(sbQuery.toString());

		if (condition != null) {

			if (StringUtils.isNotEmpty(condition.getSelectedBrand())) {
				query.setString("productTypeId", condition.getSelectedBrand());
				queryTotal.setString("productTypeId", condition.getSelectedBrand());
			} else {
				query.setLong("custId", custId);
				queryTotal.setLong("custId", custId);
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

		if (req.getPageSize() != B2BConstant.SEARCH_ALL) {
			query.setFirstResult(req.getFirstResult()).setMaxResults(req.getPageSize());
		}
		List list = query.list();

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
		StringBuilder sb = new StringBuilder();
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
		StringBuilder sb = new StringBuilder();
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

	@Override
	public Product findByProductCode(String productCode) {
		return (Product) sf.getCurrentSession().createCriteria(Product.class).add(Restrictions.eq("productCode", productCode)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByBrandGroupId(long brandGroupId) {
		String queryString = " from Product p";
		queryString += " where p.productTypeId in (";
		queryString += " 	select bg.id.productTypeId from ProductBrandGroup bg where bg.id.brandGroupId = :brandGroupId";
		queryString += " )";

		return (List<Product>) sf.getCurrentSession().createQuery(queryString).setLong("brandGroupId", brandGroupId).list();
	}

	@Override
	public void save(Product product) {
		sf.getCurrentSession().save(product);
	}

	@Override
	public void merge(Product product) {
		sf.getCurrentSession().merge(product);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public SearchResult<SearchProductModelDTO> searchProductForBackend(SearchRequest<SearchProductForm> req) {

		StringBuilder sbQuery = new StringBuilder("SELECT  " + getSearchProductConstructor());
		StringBuilder sbTotal = new StringBuilder("");
		if ("image".equals(req.getCondition().getShowType())) {
			sbTotal.append(" select count(distinct p.productModelId) ");
		} else {
			sbTotal.append(" select count(p.productId)  ");
		}

		// common query
		StringBuffer sb = new StringBuffer();
		sb.append("FROM Product p, ProductModel m ");

		sb.append("where p.productModelId = m.productModelId ");

		SearchProductForm condition = req.getCondition();
		if (condition != null) {
			if (StringUtils.isNotEmpty(condition.getSelectedBrand())) {
				sb.append("and p.productTypeId = :productTypeId ");
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
				sb.append("and ( ");
				sb.append("m.productModelName 	like :keyword ");
				sb.append("or p.productNameEn 	like :keyword ");
				sb.append("or p.productLength 	like :keyword ");
				sb.append("or p.productBand 	like :keyword ");
				sb.append("or p.productCode		like :keyword ");
				sb.append(")");
			}
		}

		// Set common query
		sbTotal.append(sb);

		if ("image".equals(req.getCondition().getShowType())) {
			sb.append(" GROUP BY p.productModelId ");
		}
		sb.append(" ORDER BY p.productCode ");
		sbQuery.append(sb);

		// create query and set parameter
		Query queryTotal = sf.getCurrentSession().createQuery(sbTotal.toString());
		Query query = sf.getCurrentSession().createQuery(sbQuery.toString());

		if (condition != null) {

			if (StringUtils.isNotEmpty(condition.getSelectedBrand())) {
				query.setString("productTypeId", condition.getSelectedBrand());
				queryTotal.setString("productTypeId", condition.getSelectedBrand());
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

	private String getSearchProductConstructor() {
		return "new com.starboard.b2b.dto.search.SearchProductModelDTO(p.productId, p.productCode, p.productPictureMedium, "
				+ "p.productModelId, m.productModelName, p.productNameEn, p.productPrice, p.productUnitId, p.productCurrency, "
				+ "m.image, p.productPreintro, p.isActive, p.productTechnologyId, p.productYearId, p.productTypeId, p.productBuyerGroupId, "
				+ "p.productLength, p.vendor, p.productCategoryId) ";
		
	}

	@Override
	public boolean delete(long productId) {
		Session session = sf.getCurrentSession();
		Product product = (Product) session.get(Product.class, productId);
		if (product == null) {
			return false;
		} else {
			session.delete(product);
			return true;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SearchProductModelDTO> findAll() {
		StringBuilder sbQuery = new StringBuilder("SELECT " + getSearchProductConstructor());

		// common query
		StringBuffer sb = new StringBuffer();
		sb.append("FROM Product p,  ProductModel m  ");

		sb.append("where p.productModelId = m.productModelId ");

		sb.append(" ORDER BY p.productCode ");
		sbQuery.append(sb);

		// create query and set parameter
		Query query = sf.getCurrentSession().createQuery(sbQuery.toString());

		return query.list();

	}
}
