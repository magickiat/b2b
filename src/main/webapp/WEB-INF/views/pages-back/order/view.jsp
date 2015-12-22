<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Backend-Starboard Windsurfing</title>
<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>

	<div class="container">


		<form:form modelAttribute="form"
			servletRelativeAction="/backend/order/approve-reject">


			<!-- Header -->
			<div class="row bg_color">
				<div class="col-sm-6">
					<h1>${form.orderReport.orderCode}</h1>
				</div>
				<div class="col-sm-6 text-right">
					<h1>${form.orderReport.orderStatus}</h1>
				</div>

				<!-- Order info -->
				<div class="col-sm-10">
					<table class="table">
						<thead>
							<tr>
								<td>Order Date</td>
								<td>Expected Shipping Date</td>
								<td>Payment Term</td>
								<td>Payment Method</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<fmt:formatDate pattern="dd-MM-yyyy"
										value="${form.orderReport.orderDate}" />
								</td>
								<td></td>
								<td>
									<form:select path="paymentTermId" cssClass="form-control">
										<form:options items="${ form.paymentTermList }"
											itemLabel="paymentTermName" itemValue="paymentTermId" />
									</form:select>
								</td>
								<td>
									<form:select path="paymentMethodId" cssClass="form-control">
										<form:options items="${ form.paymentMethodList }"
											itemLabel="paymentMethodName" itemValue="paymentMethodId" />
									</form:select>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="col-sm-2 text-center">
					<input type="button" id="btn-approve" class="btn btn-default" onclick="approve(${ ordDetail.orderDetailId })" value="Approve" />
					<input type="button" id="btn-reject" class="btn btn-default" onclick="reject(${ ordDetail.orderDetailId })" value="Reject" />
				</div>
				<!-- Order Address detail -->
				<div class="col-sm-6">
					<div class="col-sm-12">Dispatch to:</div>
					<div class="col-sm-12">
						${form.orderReport.dispatchToAddress.orderAddr}</div>
					<div class="col-sm-12">Tel:
						${form.orderReport.dispatchToAddress.orderTel} Fax:
						${form.orderReport.dispatchToAddress.fax}</div>
				</div>
				<div class="col-sm-6">
					<div class="col-sm-12">Invoice to:</div>
					<div class="col-sm-12">
						${form.orderReport.invoiceToAddress.orderAddr}</div>
					<div class="col-sm-12">Tel:
						${form.orderReport.invoiceToAddress.orderTel} Fax:
						${form.orderReport.invoiceToAddress.fax}</div>

				</div>
				<!-- Order detail -->
				<%@include file="order_detail.jspf"%>

				<!-- Customer remark -->
				<div class="col-sm-6">
					<div class="row">Customer Remark</div>
					<div class="row">
						<textarea rows="5" cols="50">${ form.orderReport.remarkCustomer }</textarea>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="row">Shipping Type</div>
					<div class="row">
						<textarea rows="5" cols="50">${ form.orderReport.shippingType }</textarea>
					</div>
				</div>
			</div>
		</form:form>

	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>

	<script type="text/javascript">
		$(document).ready(function() {
			
			var isEditMode = '${form.editMode}';
			console.log('is edit mode: ' + isEditMode);
			
			if (isEditMode == 'true') {
				$('#paymentMethodId').prop("disabled", false);
				$('#paymentTermId').prop("disabled", false);
				$('input[name=product-price-group]').prop("disabled", false);
				$('button[name=btn-remove]').prop("disabled", false);
				$('button[name=btn-split]').prop("disabled", false);
				$('#btn-approve').prop("disabled", false);
				$('#btn-reject').prop("disabled", false);
			} else {
				$('#paymentMethodId').prop("disabled", true);
				$('#paymentTermId').prop("disabled", true);
				$('select[name=product-price-group]').prop("disabled", true);
				$('button[name=btn-remove]').prop("disabled", true);
				$('button[name=btn-split]').prop("disabled", true);
				$('#btn-approve').prop("disabled", true);
				$('#btn-reject').prop("disabled", true);
			}
		});
		
		function approve(orderId){
		}
		
		function reject(orderId){
		}
	</script>
</body>
</html>