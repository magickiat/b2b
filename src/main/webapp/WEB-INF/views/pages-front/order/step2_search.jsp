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
				src='<c:url value="/images/pages-front/icon/step2.png" />'
				width="100%">
		</div>
		<div class="row">&nbsp;</div>


		<!-- Search condition -->
		<div class="row">
			<form:form modelAttribute="searchProductForm"
				servletRelativeAction="/frontend/order/step2/search_action"
				method="get">

				<form:hidden path="brandId" />
				<!-- ROW 1 -->
				<div class="row">
					<div class="col-md-3">&nbsp;</div>
					<div class="col-md-2">
						<form:select path="selectedBrand" cssClass="form-control"
							multiple="false">
							<form:option value="NONE" label="ALL BRAND" />
							<form:options items="${produtType}" itemLabel="productTypeName"
								itemValue="productTypeId" />
						</form:select>
					</div>

					<div class="col-md-2">
						<form:select path="selectedBuyerGroup" cssClass="form-control"
							multiple="false">
							<form:option value="NONE" label="ALL CATEGORY" />
							<form:options items="${productBuyerGroup}"
								itemLabel="productBuyerGroupName"
								itemValue="productBuyerGroupId" />
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

					<div class="col-md-3">
						<button type="submit" class="btn btn-success">Submit</button>
					</div>

				</div>

				<div class="row">&nbsp;</div>

				<!-- ROW 2 -->
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

					<div class="col-md-2">
						<form:select path="selectedTechnology" cssClass="form-control"
							multiple="false">
							<form:option value="NONE" label="ALL TECHNOLOGY" />
							<form:options items="${productTechnology}"
								itemLabel="productTechnologyName"
								itemValue="productTechnologyId" />
						</form:select>
					</div>

					<div class="col-md-2"></div>

					<div class="col-md-3">
						<label class="radio-inline"> <form:radiobutton
								path="showType" value="image" />Images
						</label> <label class="radio-inline"><form:radiobutton
								path="showType" value="list" />List</label>
					</div>

				</div>
			</form:form>
		</div>
		<div class="row">&nbsp;</div>

		<!-- Show table -->
		<div class="row">
			<c:choose>
				<c:when test="${empty resultPage.result }">
					<h3>Not found any product.</h3>
				</c:when>

				<c:otherwise>
					<c:forEach items="${ resultPage.result }" var="product">

						<c:choose>
							<c:when test="${empty product.productPictureMedium }">
								<c:set var="imageUrl" value="/images/b2b/default_image.jpg" />
							</c:when>
							<c:otherwise>
								<c:set var="imageUrl" value="${ product.productPictureMedium }" />
							</c:otherwise>
						</c:choose>
						<c:url var="productUrl" value="${ imageUrl }" />
						<!-- Product -->
						<div class="col-md-2 product">
							<a href="#"> <img class="product-img" alt="${ product.productModelName }"
								src="${ productUrl }" /> <span style="text-align: center;">${ product.productModelName }</span>
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