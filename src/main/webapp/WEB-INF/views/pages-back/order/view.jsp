<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>


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


		<form:form id="approveForm" name="approveForm" modelAttribute="approveForm"
			servletRelativeAction="/backend/order/approve" method="POST">

			<form:hidden path="editMode" />
			<input type="hidden" name="orderId" value="${ approveForm.orderReport.orderId }" />
			<!-- Header -->
			<div class="row bg_color">

				<div class="col-sm-6 bg_color">
					<h1>${approveForm.orderReport.orderCode}</h1>
				</div>
				<div class="col-sm-6 text-right bg_color">
					<h1>${approveForm.orderReport.orderStatus}</h1>
				</div>


				<div class="col-sm-12 bg_color text-right" style="margin: 10px 0px;">
					<input type="button" id="btn-approve" class="btn btn-success"
						onclick="approve(${ ordDetail.orderDetailId })" value="Approve" />
					<input type="button" id="btn-reject" class="btn btn-danger"
						onclick="reject(${ ordDetail.orderDetailId })" value="Reject" />
				</div>

				<!-- Order info -->
				<div class="col-sm-12 bg_color">
					<table class="table">
						<thead>
							<tr>
								<td>Order Date</td>
								<td>Expected Shipping Date</td>
								<td>Payment Term</td>
								<td>Payment Method</td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<fmt:formatDate pattern="dd-MM-yyyy" value="${approveForm.orderReport.orderDate}" />
								</td>
								<td></td>
								<td>
									<form:select path="paymentTermId" cssClass="form-control">
										<form:options items="${ approveForm.paymentTermList }" itemLabel="paymentTermName"
											itemValue="paymentTermId" />
									</form:select>
								</td>
								<td colspan="2">
									<form:select path="paymentMethodId" cssClass="form-control">
										<form:options items="${ approveForm.paymentMethodList }" itemLabel="paymentMethodName"
											itemValue="paymentMethodId" />
									</form:select>
								</td>
							</tr>
						</tbody>
					</table>
				</div>


				<!-- Order Address detail -->
				<div class="col-sm-6 bg_color">
					<div class="col-sm-12">Dispatch to:</div>
					<div class="col-sm-12">${approveForm.orderReport.dispatchToAddress.orderAddr}</div>
					<div class="col-sm-12">Tel: ${approveForm.orderReport.dispatchToAddress.orderTel} Fax:
						${approveForm.orderReport.dispatchToAddress.fax}</div>
				</div>
				<div class="col-sm-6 bg_color">
					<div class="col-sm-12">Invoice to:</div>
					<div class="col-sm-12">${approveForm.orderReport.invoiceToAddress.orderAddr}</div>
					<div class="col-sm-12">Tel: ${approveForm.orderReport.invoiceToAddress.orderTel} Fax:
						${approveForm.orderReport.invoiceToAddress.fax}</div>
				</div>


				<!-- Order detail -->
				<%@include file="order_detail2.jspf"%>

				<!-- Customer remark -->
				<div class="col-sm-6 bg_color" style="padding-bottom: 10px;">
					<div class="">Customer Remark</div>
					<div class="">
						<textarea id="remarkCustomer" class="form-control" rows="5" cols="50">${ approveForm.remarkCustomer }</textarea>
					</div>
				</div>
				<div class="col-sm-6 bg_color">
					<div class="">Staff Remark</div>
					<div class="" style="padding-bottom: 10px;">
						<textarea id="remarkOrders" class="form-control" rows="5" cols="50">${ approveForm.remarkOrders }</textarea>
					</div>
				</div>



				<%-- Save, Cancel --%>
				<div class="col-sm-6 bg_color text-right">
					<input type="button" id="save" name="save" class="btn btn-default" value="Save" />
				</div>
				<div class="col-sm-6 bg_color">
					<input type="reset" id="cancel" name="cancel" class="btn btn-default" value="Cancel" />
				</div>
			</div>
		</form:form>

	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>

	<script type="text/javascript">
		$(document).ready(function() {
			
			var isEditMode = '${approveForm.editMode}';
			console.log('is edit mode: ' + isEditMode);
			
			disablePage(isEditMode);
		});
		
		function approve(orderId){
			/* disablePage(true); */
			$('#approveForm').submit();
		}
		
		function reject(orderId){
		}
		
		function disablePage(editMode){
			if (editMode == 'true') {
				$('#paymentMethodId').prop("disabled", false);
				$('#paymentTermId').prop("disabled", false);
				$('input[name=product-price-group]').prop("disabled", false);
				$('button[name=btn-remove]').prop("disabled", false);
				$('button[name=btn-split]').prop("disabled", false);
				$('#btn-approve').prop("disabled", false);
				$('#btn-reject').prop("disabled", false);
				$('#save').prop("disabled", false);
				$('#remarkCustomer').prop("disabled", false);
				$('#remarkOrders').prop("disabled", false);
				$('input[name=btn-remove]').prop("disabled", false);
				$('input[name=btn-split]').prop("disabled", false);
			} else {
				$('#paymentMethodId').prop("disabled", true);
				$('#paymentTermId').prop("disabled", true);
				$('select[name=product-price-group]').prop("disabled", true);
				$('button[name=btn-remove]').prop("disabled", true);
				$('button[name=btn-split]').prop("disabled", true);
				$('#btn-approve').prop("disabled", true);
				$('#btn-reject').prop("disabled", true);
				$('#save').prop("disabled", true);
				$('#remarkCustomer').prop("disabled", true);
				$('#remarkOrders').prop("disabled", true);
				$('input[name=btn-remove]').prop("disabled", true);
				$('input[name=btn-split]').prop("disabled", true);
			}
		}
	</script>
</body>
</html>
