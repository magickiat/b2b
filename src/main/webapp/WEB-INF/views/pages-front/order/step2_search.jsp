<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Starboard</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>
	<div class="container">
		<%@include
			file="/WEB-INF/views/pages-front/include/common_header.jspf"%>


		<div class="row">
			<img alt="step 1"
				src='<c:url value="/images/pages-front/icon/step1.png" />'
				width="100%">
		</div>
		<div class="row">&nbsp;</div>


		<!-- Search condition -->
		<div class="row">
			<form:form modelAttribute="searchProductForm"
				servletRelativeAction="/frontend/order/step2_search" method="POST">
				<div class="row">
					<div class="col-md-3">&nbsp;</div>
					<div class="col-md-2">
						<form:select path="selectedBrand" cssClass="form-control"
							multiple="false">
							<form:option value="NONE" label="ALL BRAND" />
							<form:options items="${productCategory}"
								itemLabel="productCategoryName" itemValue="productCategoryId" />
						</form:select>
					</div>

					<div class="col-md-2">
						<form:select path="selectedCategory" cssClass="form-control"
							multiple="false">
							<form:option value="NONE" label="ALL CATEGORY" />
							<form:options items="${productCategory}"
								itemLabel="productCategoryName" itemValue="productCategoryId" />
						</form:select>
					</div>

					<div class="col-md-2">
						<form:select path="selectedModel" cssClass="form-control"
							multiple="false">
							<form:option value="NONE" label="ALL MODEL" />
							<form:options items="${productModel}"
								itemLabel="productModelName" itemValue="productModelId" />
						</form:select>
					</div>

					<div class="col-md-3">&nbsp;</div>

				</div>

				<div class="row">&nbsp;</div>

				<div class="row">
					<div class="col-md-3">&nbsp;</div>
					<div class="col-md-2">
						<form:select path="selectedYear" cssClass="form-control"
							multiple="false">
							<form:option value="NONE" label="ALL YEAR" />
							<form:options items="${productYear}" itemLabel="productYearName"
								itemValue="productYearId" />
						</form:select>
					</div>

					<div class="col-md-2"></div>

					<div class="col-md-2"></div>

					<div class="col-md-3">&nbsp;</div>

				</div>
			</form:form>
		</div>
		<div class="row">&nbsp;</div>

		<!-- Show table -->
		<div class="row">
			<c:choose>
				<c:when test="${empty products }">
					<h3>Not found any product.</h3>
				</c:when>

				<c:otherwise>
					<c:forEach items="${ products }" var="product">
						<!-- Product -->
						<div class="col-md-2 product">
							<a href="#"> <img alt="${ product.name }"
								src='<c:url value="${ product.pictureMedium }" />' /> <span
								style="text-align: center;">${ product.model.name }</span>
							</a>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>