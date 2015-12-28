<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/include/common_meta.jspf" %>
	<title>Starboard Windsurfing</title>
	<%@include file="/WEB-INF/views/include/common_css.jspf"%>
<link rel="stylesheet"
	href="<c:url value="/scripts/assets/datepicker/bootstrap-datetimepicker.css"/>"
	media="screen">
</head>
<body>
	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>

	<div class="container">

		<div class="row">
			<div class="col-md-12 bg_color">
				<div class="row row-header2 header2 txtupper">Order Summary</div>
				<!-- Search section -->
				<div>
					<form:form id="searchForm" modelAttribute="orderSummaryForm"
						servletRelativeAction="/frontend/order/summary/search-action"
						method="get">
						<form:hidden path="custId" value="${orderSummaryForm.custId}" />
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
									<form:select path="selectedBrand" cssClass="form-control"
										multiple="false" onchange="submitForm()">
										<form:option value="" label="ALL BRAND" />
										<form:options items="${productType}"
											itemLabel="productTypeName" itemValue="productTypeId" />
									</form:select>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<form:select path="selectedStatus" cssClass="form-control"
										multiple="false">
										<form:option value="" label="ALL STATUS" />
										<form:options items="${orderStatus}"
											itemLabel="orderStatusName" itemValue="orderStatusId" />
									</form:select>
								</div>
							</div>
							<div class="col-md-3">
								<button class="btn btn-success" onclick="submitForm()"
									style="width: 100px;">Search</button>
								<button class="btn btn-default" onclick="exportExcel()"
									style="width: 100px;">Excel</button>
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
											<span class="input-group-addon"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-2">
								<div id="dateToPicker" class="input-group date">
									<form:input path="dateTo" cssClass="form-control" />
									<span class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
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
		<div class="row">&nbsp;</div>
		<%-- Order detail section --%>

		<%-- Upper Paging --%>
		<div class="row">
		<%@include file="/WEB-INF/views/include/paging_submit.jspf"%>
		</div>

		<%-- List order model --%>
		<div class="row">
			<div class="col-md-12 bg_color showline2">
				<%@include file="step2_include/order_summary_list.jspf"%>
			</div>
		</div>

		<%-- Lower Paging --%>
		<div class="row">
		<%@include file="/WEB-INF/views/include/paging_submit.jspf"%>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal modal-message modal-danger fade" id="alertModal"
		role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Alert!</h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>

	<script
		src="<c:url value="/scripts/assets/datepicker/moment-with-locales.js"/>"></script>
	<script
		src="<c:url value="/scripts/assets/datepicker/bootstrap-datetimepicker.js"/>"></script>

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

		/**
		 * Submit form order
		 **/
		function submitForm() {
			var action = '<c:url value="/frontend/order/summary/search-action" />';
			$('#searchForm').attr('action', action);
			$('#searchForm').submit();
		}

		function exportExcel() {
			var action = '<c:url value="/report/ordersummary/excel" />';
			$('#searchForm').attr('action', action);
			$('#searchForm').submit();
		}

		function exportPdf(so) {
			if (so.value != 0) {
				$
						.get(
								'<c:url value="/report/so/detail/count"/>',
								{
									soId : so.value
								},
								function(data) {
									if (data != null && data != '0') {
										window.location.href = '<c:url value="/report/so/pdf"/>?soId='
												+ so.value;
									} else {
										var alertMsg = "Could not found detail for so id "
												+ so.value;
										var alertModal = $('#alertModal');
										alertModal.find(
												'.modal-header > .modal-title')
												.html('Not found SO detail!');
										alertModal.find('.modal-body').html(
												alertMsg);
										alertModal.modal();
									}
								});
			}
		}
	</script>
</body>
</html>
