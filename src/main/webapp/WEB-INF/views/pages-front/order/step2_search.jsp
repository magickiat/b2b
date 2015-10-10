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
			<form:form id="searchProductModelForm"
				modelAttribute="searchProductForm"
				servletRelativeAction="/frontend/order/step2/searchaction"
				method="get">

				<form:hidden path="brandId" />
				<form:hidden path="page" />
				<!-- ROW 1 -->
				<div class="row">
					<div class="col-md-3">SEARCH: <form:input path="keyword" /> </div>
					<div class="col-md-2">
						<div class="form-group">
							<form:select path="selectedBrand" cssClass="form-control"
								multiple="false">
								<form:option value="" label="ALL BRAND" />
								<form:options items="${productType}" itemLabel="productTypeName"
									itemValue="productTypeId" />
							</form:select>
						</div>
					</div>

					<div class="col-md-2">
						<div class="form-group">
							<form:select path="selectedBuyerGroup" cssClass="form-control"
								multiple="false">
								<form:option value="" label="ALL CATEGORY" />
								<form:options items="${productBuyerGroup}"
									itemLabel="productBuyerGroupName"
									itemValue="productBuyerGroupId" />
							</form:select>
						</div>
					</div>

					<div class="col-md-2">
						<div class="form-group">
							<form:select path="selectedModel" cssClass="form-control"
								multiple="false">
								<form:option value="" label="ALL MODEL" />
								<form:options items="${productModel}"
									itemLabel="productModelName" itemValue="productModelId" />
							</form:select>
						</div>
					</div>

					<div class="col-md-3">
						<button type="button" class="btn btn-success" onclick="searchPage(1)">Submit</button>
						<button type="button" class="btn" onclick="resetSearch()">Reset</button>
					</div>

				</div>

				<div class="row">&nbsp;</div>

				<!-- ROW 2 -->
				<div class="row">
					<div class="col-md-3">&nbsp;</div>
					<div class="col-md-2">
						<div class="form-group">
							<form:select path="selectedYear" cssClass="form-control"
								multiple="false">
								<form:option value="" label="ALL YEAR" />
								<form:options items="${productYear}" itemLabel="productYearName"
									itemValue="productYearId" />
							</form:select>
						</div>
					</div>

					<div class="col-md-2">
						<div class="form-group">
							<form:select path="selectedTechnology" cssClass="form-control"
								multiple="false">
								<form:option value="" label="ALL TECHNOLOGY" />
								<form:options items="${productTechnology}"
									itemLabel="productTechnologyName"
									itemValue="productTechnologyId" />
							</form:select>
						</div>
					</div>

					<div class="col-md-2"></div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="radio-inline"> <form:radiobutton
									path="showType" value="image" />Images
							</label> <label class="radio-inline"><form:radiobutton
									path="showType" value="list" />List</label>
						</div>
					</div>

				</div>
			</form:form>
		</div>
		<div class="row">&nbsp;</div>

		<div class="row">

			<!-- Paging -->
			<div class="row pull-right">
				<div class="col-sm-12">
					<c:choose>
						<c:when test="${!empty resultPage.total and resultPage.total > 0}">
							<c:url var="firstUrl" value="searchPage('1')" />
							<c:url var="lastUrl"
								value="searchPage('${resultPage.totalPage}')" />
							<c:url var="prevUrl"
								value="searchPage('${resultPage.current - 1}')" />
							<c:url var="nextUrl"
								value="searchPage('${resultPage.current + 1}')" />

							<ul class="pagination">
								<!-- Previous 5 page -->
								<c:choose>
									<c:when test="${resultPage.current == 1}">
										<li class="disabled"><a href="#">&lt;&lt;</a></li>
										<li class="disabled"><a href="#">&lt;</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="#" onclick="${firstUrl}">&lt;&lt;</a></li>
										<li><a href="#" onclick="${prevUrl}">&lt;</a></li>
									</c:otherwise>
								</c:choose>

								<c:forEach var="i" begin="${resultPage.beginPage }"
									end="${ resultPage.endPage }">
									<li
										<c:if test="${ i == resultPage.current }">class="active"</c:if>><a
										href="#" onclick="searchPage('${ i }')">${ i }</a></li>

								</c:forEach>

								<c:choose>
									<c:when test="${resultPage.current == resultPage.totalPage}">
										<li class="disabled"><a href="#">&gt;</a></li>
										<li class="disabled"><a href="#">&gt;&gt;</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="#" onclick="${nextUrl}">&gt;</a></li>
										<li><a href="#" onclick="${lastUrl}">&gt;&gt;</a></li>
									</c:otherwise>
								</c:choose>

							</ul>

						</c:when>

					</c:choose>
				</div>

			</div>
		</div>
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
							<a href="#"> <img class="product-img"
								alt="${ product.productModelName }" src="${ productUrl }" /> <span
								style="text-align: center;">${ product.productModelName }</span>
							</a>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>




	<%@include file="/WEB-INF/views/include/common_js.jspf"%>

	<script type="text/javascript">
		function searchPage(page) {
			$('#page').val(page);
			$('#searchProductModelForm').submit();
		}
		
		function resetSearch(){
			window.open('<c:url value="/frontend/order/step2/search" />?brand_id=${searchProductForm.brandId}', '_self');
		}
	</script>

</body>
</html>