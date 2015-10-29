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
				servletRelativeAction="/frontend/order/step2/search-action"
				method="get">

				<form:hidden path="brandId" />
				<form:hidden path="page" />
				<!-- ROW 1 -->
				<div class="row">
					<div class="col-md-3">
						SEARCH:
						<form:input path="keyword" />
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<form:select path="selectedBrand" cssClass="form-control"
								multiple="false" onchange="loadBuyerGroup(this)">
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
						<button type="button" class="btn btn-success"
							onclick="searchPage(1)">Submit</button>
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

		<%-- Upper Paging --%>
		<div class="row">
			<%@include file="step2/search_product_paging.jspf"%>
		</div>

		<%-- List product model --%>
		<c:choose>
			<c:when test="${ searchProductForm.showType == 'image' }">
				<%@include file="step2/product_image.jspf"%>
			</c:when>
			<c:otherwise>
				<%@include file="step2/product_list.jspf"%>
			</c:otherwise>
		</c:choose>



		<%-- Lower Paging --%>
		<div class="row">
			<%@include file="step2/search_product_paging.jspf"%>
		</div>

	</div>



	<%@include file="/WEB-INF/views/include/common_js.jspf"%>

	<script type="text/javascript">
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
		
		
		$("#drop").change(function () {
			
		});
		function loadBuyerGroup(brandId){
			$('#searchProductModelForm').submit();
		}

		$('input[name=product-order-number]').keypress(function(e) {
			return e.charCode === 0 || /\d/.test(String.fromCharCode(e.charCode));
		}).on("cut copy paste", function(e) {
			e.preventDefault();
		});
	</script>

</body>
</html>