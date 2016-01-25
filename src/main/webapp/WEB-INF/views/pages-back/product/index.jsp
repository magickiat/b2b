<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>

	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<h2>Products</h2>
			</div>
		</div>


		<div class="row">
			<div class="col-sm-12 bg_color text-right">
				<form id="uploadForm" action='<c:url value="/backend/product/upload" />' method="get">
					<input type="hidden" id="csrftoken_" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type="submit" value="Upload Product" />
				</form>
			</div>
		</div>

		<div class="row">&nbsp;</div>

		<div class="row bg_color">
			<form:form id="searchForm" modelAttribute="searchForm"
				servletRelativeAction="/backend/product/search" method="get">

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
							<form:select path="selectedBrand" cssClass="form-control" multiple="false"
								onchange="loadBuyerGroup(this)">
								<form:option value="" label="ALL BRAND" />
								<form:options items="${productType}" itemLabel="productTypeName" itemValue="productTypeId" />
							</form:select>
						</div>
					</div>

					<div class="col-md-2">
						<div class="form-group">
							<form:select path="selectedBuyerGroup" cssClass="form-control" multiple="false">
								<form:option value="" label="ALL CATEGORY" />
								<form:options items="${productBuyerGroup}" itemLabel="productBuyerGroupName"
									itemValue="productBuyerGroupId" />
							</form:select>
						</div>
					</div>

					<div class="col-md-2">
						<div class="form-group">
							<form:select path="selectedModel" cssClass="form-control" multiple="false">
								<form:option value="" label="ALL MODEL" />
								<form:options items="${productModel}" itemLabel="productModelName"
									itemValue="productModelId" />
							</form:select>
						</div>
					</div>

					<div class="col-md-3">
						<button type="button" class="btn btn-success" onclick="searchPage(1)">Submit</button>
						<button type="button" class="btn" onclick="resetSearch()">Reset</button>
					</div>

				</div>
				<!-- ROW 2 -->
				<div class="row">
					<div class="col-md-3">&nbsp;</div>
					<div class="col-md-2">
						<div class="form-group">
							<form:select path="selectedYear" cssClass="form-control" multiple="false">
								<form:option value="" label="ALL YEAR" />
								<form:options items="${productYear}" itemLabel="productYearName" itemValue="productYearId" />
							</form:select>
						</div>
					</div>

					<div class="col-md-2">
						<div class="form-group">
							<form:select path="selectedTechnology" cssClass="form-control" multiple="false">
								<form:option value="" label="ALL TECHNOLOGY" />
								<form:options items="${productTechnology}" itemLabel="productTechnologyName"
									itemValue="productTechnologyId" />
							</form:select>
						</div>
					</div>

					<div class="col-md-2"></div>
					<div class="col-md-3"></div>

				</div>
			</form:form>
		</div>

		<div class="row">&nbsp;</div>

		<!-- Base URL for pagination -->
		<c:set var="baseUrl" value="/backend/product/search" />

		<%-- Upper Paging --%>
		<div class="row">
			<%@include file="/WEB-INF/views/include/paging_submit.jspf"%>
		</div>

		<div class="row">
			<div class="col-sm-12 bg_color showline2">
				<c:choose>
					<c:when test="${empty resultPage.result }">
						<h3>Not found any product.</h3>
					</c:when>

					<c:otherwise>

						<table class="table table-hover table-list">
							<thead>
								<tr>
									<th>No</th>
									<th>Image</th>
									<th>Product Code</th>
									<th>Product Name</th>
									<th>Active</th>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="rowBegin" value="${ (( resultPage.current - 1) * resultPage.pageSize) }"></c:set>

								<c:forEach items="${ resultPage.result }" var="product" varStatus="rowNum">
									<td>${ rowBegin + (rowNum.index + 1) }</td>
									<td>image</td>
									<td>${ product.productCode }</td>
									<td>${ product.productNameEn }</td>
									<td>
										<c:choose>
											<c:when test="${ product.isActive == '1' }">Yes</c:when>
											<c:otherwise>No</c:otherwise>
										</c:choose>
									</td>
									<td></td>
								</c:forEach>
							</tbody>
						</table>

					</c:otherwise>
				</c:choose>
			</div>
		</div>

		<%-- Lower Paging --%>
		<div class="row">
			<%@include file="/WEB-INF/views/include/paging_submit.jspf"%>
		</div>

	</div>

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>

	<c:if test="${ not empty msg }">

		<script type="text/javascript">
			var msg = '${msg}';
			showDialogAutoClose(msg);
		</script>
	</c:if>
	
	<script type="text/javascript">
		function searchPage(page) {
			$('#page').val(page);
			$('#searchForm').submit();
		}

		function resetSearch() {
			window.open('<c:url value="${baseUrl}" />?brand_id=${searchProductForm.brandId}', '_self');
		}
		
		function loadBuyerGroup(brandId){
			$('#searchProductModelForm').submit();
		}

	</script>
</body>
</html>
