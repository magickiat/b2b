<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>


<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
<link rel="stylesheet"
	href="<c:url value="/scripts/assets/datepicker/bootstrap-datetimepicker.css"/>" media="screen">
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>

	<div class="container">
	
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-12 bg_color showline2">
					<div class="row row-header2 header2 txtupper">search order</div>
					<!-- Search section -->
					<div style="">
						<form:form id="searchForm" modelAttribute="searchOrderForm"
							servletRelativeAction="/backend/order/search-action" method="get">
							<form:hidden path="page" />
							<%-- Search criteria row 1--%>
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label class="col-sm-3 control-label">SEARCH:</label>
										<div class="col-sm-9">
											<form:input path="keyword" cssClass="form-control" />
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<form:select path="selectedBrand" cssClass="form-control" multiple="false"
											onchange="submitForm()">
											<form:option value="" label="ALL BRAND" />
											<form:options items="${productType}" itemLabel="productTypeName"
												itemValue="productTypeId" />
										</form:select>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<form:select path="selectedStatus" cssClass="form-control" multiple="false">
											<form:option value="" label="ALL STATUS" />
											<form:options items="${orderStatus}" itemLabel="orderStatusName"
												itemValue="orderStatusId" />
										</form:select>
									</div>
								</div>
								<div class="col-md-3">
									<button class="btn btn-default" onclick="exportExcel()" style="width: 100px;">Excel</button>
									<button class="btn btn-success" onclick="submitForm()" style="width: 100px;">Search</button>
								</div>
							</div>
							<%-- Search criteria row 2--%>
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label class="col-sm-3 control-label" for="dateFromPicker">FROM/TO:</label>
										<div class="col-sm-9">
											<div id="dateFromPicker" class="input-group date">
												<form:input path="dateFrom" cssClass="form-control" />
												<span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-2">
									<div id="dateToPicker" class="input-group date">
										<form:input path="dateTo" cssClass="form-control" />
										<span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span> 
										</span>
									</div>
								</div>
								<div class="col-md-7">&nbsp;</div>
								<div class="col-md-12">&nbsp;</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>

			<c:choose>
				<c:when test="${empty resultPage.result }">
					
					<div class="row">
						<%@include file="/WEB-INF/views/include/paging_submit.jspf"%>
					</div>
					
					<div class="row">
						<div class="col-md-12 bg_color showline2">

							<h3>Not found any order.</h3>

						</div>
					</div>

				</c:when>

				<c:otherwise>

					<div class="row">
						<%@include file="/WEB-INF/views/include/paging_submit.jspf"%>
					</div>

					<div class="row">
						<div class="col-md-12 bg_color showline2">

							<table class="table table-hover table-list">
								<thead>
									<tr>
										<th>Request ID</th>
										<th>Customer</th>
										<th>Brand</th>
										<th>Order Date</th>
										<th>Status</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${ resultPage.result }" var="order" varStatus="rowNum">

										<tr>
											<td>
												<input type="hidden" id="orderId-${ order.orderId }" name="orderId"
													value="${ order.orderId }" />
												<a href="<c:url value="/backend/order/view?orderId=${order.orderId}&from=search"/>">${ order.orderCode }</a>
											</td>

											<td>${ order.customerName }</td>
											<td>${ order.productTypeName }</td>
											<td>
												<fmt:formatDate pattern="dd-MM-yyyy" value="${ order.orderDate }" />
											</td>
											<td>${ order.orderStatus }</td>
										</tr>

									</c:forEach>
								</tbody>
							</table>


						</div>
					</div>
					
					<div class="row">
						<%@include file="/WEB-INF/views/include/paging_submit.jspf"%>
					</div>

				</c:otherwise>
			</c:choose>
		</div>
		
	</div>

	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	
	<script src="<c:url value="/scripts/assets/datepicker/moment-with-locales.js"/>"></script>
	<script src="<c:url value="/scripts/assets/datepicker/bootstrap-datetimepicker.js"/>"></script>


	<script type="text/javascript">
		$(document).ready(function() {
			// datepicker
			var dateFromPicker = $('#dateFromPicker');
			var dateToPicker = $('#dateToPicker');
			dateFromPicker.datetimepicker({
				locale : 'en',
				format : 'YYYY-MM-DD'
			});
			dateToPicker.datetimepicker({
				locale : 'en',
				format : 'YYYY-MM-DD',
				useCurrent : false
			});
			dateFromPicker.on("dp.change", function(e) {
				$('#dateToPicker').data("DateTimePicker").minDate(e.date);
			});
			dateToPicker.on("dp.change", function(e) {
				$('#dateFromPicker').data("DateTimePicker").maxDate(e.date);
			});
		});
	</script>
</body>
</html>
