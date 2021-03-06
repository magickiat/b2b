<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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


		<div class="col-md-12">

			<div class="row">
				<div class="col-md-12 bg_color showline2">
					<div class="row row-header2 header2 txtupper">Search Customer</div>
					<div class="row"></div>
					<%-- Search condition --%>
					<div class="" style="margin-top: 10px;">

						<%-- form name must be "searchForm" --%>
						<form:form name="searchForm"
							servletRelativeAction="/backend/customer/search"
							modelAttribute="searchForm" cssClass="form-horizontal"
							method="GET">

							<form:errors path="*" cssClass="alert alert-danger" element="div" />

							<%-- for paging --%>
							<form:hidden path="page" />

							<div class="col-md-3">
								<div class="form-group">
									<label class="col-sm-3 control-label">SEARCH:</label>
									<div class="col-sm-9">
										<form:input path="keyword" cssClass="form-control" />
									</div>
								</div>
							</div>

							<div class="col-md-3">
								<div class="">
									<form:select path="selectedBrand" cssClass="form-control"
										multiple="false">
										<form:option value="" label="ALL BRAND GROUP" />
										<form:options items="${searchForm.productTypeList}"
											itemLabel="productTypeName" itemValue="brandGroupId" />
									</form:select>
								</div>
							</div>

							<div class="col-md-3">
								<div class="">
									<form:select path="selectedCountry" cssClass="form-control"
										multiple="false">
										<form:option value="" label="ALL COUNTRY" />
										<form:options items="${searchForm.countryList}"
											itemLabel="countryName" itemValue="countryCode" />
									</form:select>
								</div>
							</div>

							<div class="col-md-3">
								<button class="btn btn-success pull-right"
									onclick="submitForm()" style="width: 100px;">Search</button>

								<button class="btn btn-default pull-right"
									onclick="exportExcel()"
									style="width: 100px; margin-right: 10px;">Excel</button>
							</div>

						</form:form>

					</div>
				</div>
			</div>

			<!-- Base URL for pagination -->
			<c:set var="baseUrl" value="/backend/customer" />
			<div class="row">
				<%@include file="/WEB-INF/views/include/paging_submit.jspf"%>
			</div>

			<div class="row bg_color showline2">
				<div class="col-sm-12">
					<table class="table table-hover" id="list_customer">
						<thead>
							<tr>
								<th width="5%">No.</th>
								<th width="8%">Code</th>
								<th width="22%">Name</th>
								<th width="10%">Country</th>
								<th width="10%">Telephone</th>
								<th width="15%">Email</th>
								<th width="20%">Address</th>
							</tr>
						</thead>
						<tbody>

							<c:set var="rowBegin"
								value="${ (( resultPage.current - 1) * resultPage.pageSize) }"></c:set>

							<c:forEach items="${resultPage.result }" var="customer"
								varStatus="rowNum">
								<c:url var="createUserUrl"
									value="/backend/customer/update?id=${ customer.custId }" />
								<tr style="cursor: pointer;"
									onclick="javascript:window.location.href = '${createUserUrl}'">
									<td>${ rowBegin + (rowNum.index + 1) }</td>
									<td nowrap="nowrap"><c:set var="code"
											value="${ fn:split(customer.custCode, '-') }"></c:set>
										${code[0]}-${code[1]}</td>
									<td nowrap="nowrap">${customer.companyName }</td>
									<td nowrap="nowrap">${ customer.countryName }</td>
									<td nowrap="nowrap">${ customer.tel }</td>
									<td nowrap="nowrap"><c:if
											test="${ not empty customer.address }">${ customer.email }</c:if>
									</td>
									<td nowrap="nowrap"><c:if
											test="${ not empty customer.address}">
											<c:choose>

												<c:when test="${ fn:length(customer.address) gt 25 }">
													<span title="${ customer.address }">${ fn:substring( customer.address, 0, 25 ) }...</span>
												</c:when>
												<c:otherwise>
													${ customer.address }
												</c:otherwise>
											</c:choose>

										</c:if></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<%-- Under list pageing --%>
			<div class="row">
				<%@include file="/WEB-INF/views/include/paging_submit.jspf"%>
			</div>

		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script type="text/javascript"
		src='<c:url value="/scripts/js_back_end/customer/search.js" />'></script>

	<script type="text/javascript">
		function submitForm() {
			var action = '<c:url value="/backend/customer/search" />';
			$('#searchForm').attr('action', action);
			$('#searchForm').submit();
		}

		function exportExcel() {
			var action = '<c:url value="/report/customer/excel" />';
			$('#searchForm').attr('action', action);
			$('#searchForm').submit();
		}
	</script>
</body>
</html>
