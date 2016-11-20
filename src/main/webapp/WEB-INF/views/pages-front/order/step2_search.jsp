<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>

<style type="text/css">
.nav-tabs {
	border-bottom: 1px solid #DDDDDD;
}

.nav-tabs>li {
	float: left;
	margin-bottom: -1px;
}

.nav-tabs>li>a {
	border: 1px solid rgba(0, 0, 0, 0);
	border-radius: 4px 4px 0 0;
	line-height: 1.42857;
	margin-right: 2px;
}

.nav-tabs>li>a:hover {
	border-color: #EEEEEE #EEEEEE #DDDDDD;
}

.nav-tabs>li.active>a, .nav-tabs>li.active>a:hover, .nav-tabs>li.active>a:focus
	{
	-moz-border-bottom-colors: none;
	-moz-border-left-colors: none;
	-moz-border-right-colors: none;
	-moz-border-top-colors: none;
	background-color: #FFFFFF;
	border-color: #DDDDDD #DDDDDD rgba(0, 0, 0, 0);
	border-image: none;
	border-style: solid;
	border-width: 1px;
	color: #555555;
	cursor: default;
}

.nav-tabs.nav-justified {
	border-bottom: 0 none;
	width: 100%;
}

.nav-tabs.nav-justified>li {
	float: none;
}

.nav-tabs.nav-justified>li>a {
	margin-bottom: 5px;
	text-align: center;
}

.nav-tabs.nav-justified>.dropdown .dropdown-menu {
	left: auto;
	top: auto;
}
</style>
<body>

	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>

	<div class="container">

		<div class="col-md-12">

			<div class="row">
				<img src='<c:url value="/images/pages-front/icon/step2.png" />'>
			</div>
			<div class="row">&nbsp;</div>


			<div class="row">
				<div class="col-md-12 bg_color showline2">
					<div class="row row-header2 header2 txtupper">Search</div>
					<!-- Search condition -->
					<div class="">
						<form:form id="searchProductModelForm"
							modelAttribute="searchProductForm"
							servletRelativeAction="/frontend/order/step2/search-action"
							method="get">

							<form:hidden path="brandId" />
							<form:hidden path="page" />
							<!-- ROW 1 -->
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label class="col-sm-3 control-label">SEARCH:</label>
										<div class="col-sm-9">
											<form:input path="keyword" class="form-control" />
										</div>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<form:select path="selectedBrand" cssClass="form-control"
											multiple="false" onchange="loadBuyerGroup(this)">
											<form:option value="" label="ALL BRAND" />
											<form:options items="${productType}"
												itemLabel="productTypeName" itemValue="productTypeId" />
										</form:select>
									</div>
								</div>

<!-- 								<div class="col-md-2"> -->
<!-- 									<div class="form-group"> -->
<%-- 										<form:select path="selectedBuyerGroup" cssClass="form-control" --%>
<%-- 											multiple="false"> --%>
<%-- 											<form:option value="" label="ALL CATEGORY" /> --%>
<%-- 											<form:options items="${productBuyerGroup}" --%>
<%-- 												itemLabel="productBuyerGroupName" --%>
<%-- 												itemValue="productBuyerGroupId" /> --%>
<%-- 										</form:select> --%>
<!-- 									</div> -->
<!-- 								</div> -->

<!-- 								<div class="col-md-2"> -->
<!-- 									<div class="form-group"> -->
<%-- 										<form:select path="selectedModel" cssClass="form-control" --%>
<%-- 											multiple="false"> --%>
<%-- 											<form:option value="" label="ALL MODEL" /> --%>
<%-- 											<form:options items="${productModel}" --%>
<%-- 												itemLabel="productModelName" itemValue="productModelId" /> --%>
<%-- 										</form:select> --%>
<!-- 									</div> -->
<!-- 								</div> -->

								<div class="col-md-3">
									<button type="button" class="btn btn-success"
										onclick="searchPage(1)">Submit</button>
									<button type="button" class="btn" onclick="resetSearch()">Reset</button>
								</div>

							</div>
							<!-- ROW 2 -->
							<div class="row">
								<div class="col-md-3">&nbsp;</div>
								<div class="col-md-2">
									<%-- <div class="form-group">
										<form:select path="selectedYear" cssClass="form-control" multiple="false">
											<form:option value="" label="ALL YEAR" />
											<form:options items="${productYear}" itemLabel="productYearName" itemValue="productYearId" />
										</form:select>
									</div> --%>
								</div>

								<div class="col-md-2">
									<%-- <div class="form-group">
										<form:select path="selectedTechnology" cssClass="form-control" multiple="false">
											<form:option value="" label="ALL TECHNOLOGY" />
											<form:options items="${productTechnology}" itemLabel="productTechnologyName"
												itemValue="productTechnologyId" />
										</form:select>
									</div> --%>
								</div>

								<div class="col-md-2"></div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="radio-inline"><form:radiobutton
												path="showType" value="image" onclick="searchPage(1)" />Images
										</label> <label class="radio-inline"><form:radiobutton
												path="showType" value="list" onclick="searchPage(1)" />List</label>
									</div>
								</div>

							</div>
						</form:form>
					</div>
					<div class="row">&nbsp;</div>
				</div>
			</div>



			<div class="row">&nbsp;</div>

			<div class="row">

				<div class="col-md-12 bg_color showline2">
					<div>&nbsp;</div>
					<c:choose>
						<c:when test="${empty groupSheetProducts }">
							<h3>Not found any product.</h3>
						</c:when>

						<c:otherwise>




							<ul class="nav nav-tabs" id="myTab">

								<c:forEach var="sheet" items="${groupSheetProducts}"
									varStatus="rowIndex">
									<li <c:if test="${ rowIndex.index == 0 }">class="active"</c:if>>
										<a href='#tab${ rowIndex.index }'>${sheet.key }</a>
									</li>
								</c:forEach>



							</ul>


							<div id='content' class="tab-content">
								<c:forEach var="sheet" items="${groupSheetProducts}"
									varStatus="rowIndex">
									<div
										class="tab-pane <c:if test="${ rowIndex.index == 0 }">active</c:if>  "
										id="tab${ rowIndex.index }">
										<table class="table">
											<thead>
												<tr>
													<th>Product Name</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="product" items="${sheet.value}"
													varStatus="productIndex">
													<tr>
														<td>${ product.productNameEn }</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</c:forEach>

							</div>



						</c:otherwise>
					</c:choose>
					<div>&nbsp;</div>
				</div>
			</div>

		</div>

	</div>


	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>


	<script type="text/javascript">
		$('#myTab a').click(function(e) {
			e.preventDefault()
			$(this).tab('show')
		})

		function searchPage(page) {
			$('#page').val(page);
			$('#searchProductModelForm').submit();
		}

		function resetSearch() {
			window
					.open(
							'<c:url value="/frontend/order/step2/search" />?brand_id=${searchProductForm.brandId}',
							'_self');
		}

		function loadBuyerGroup(brandId) {
			$('#searchProductModelForm').submit();
		}
	</script>

</body>
</html>
