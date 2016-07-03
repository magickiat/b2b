<%@page import="java.util.Enumeration"%>
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
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>

	<div class="container">
	
		<div class="col-md-12">
		
			<form:form id="splitOrderDetailForm" modelAttribute="splitForm"
				servletRelativeAction="/backend/order/split-action" cssClass="form-horizontal">
	
				<div class="row bg_color showline2">
					<div class="col-sm-12" style="padding-bottom: 10px; padding-top: 15px;">
					
						<div class="form-group">
							<label for="splitNum" class="control-label col-sm-2">Split Product To :</label>
							<div class="col-sm-2" style="width: 100px;">
								<form:input path="splitNum" cssClass="form-control numberOnly" />
							</div>
							<div class="col-sm-1" style="width: 50px;">
								<label for="splitNum" class="control-label">Line</label>
							</div>
							<div class="col-sm-2">
								<input type="submit" id="btnSplit" class="btn btn-default" value="Split" />
							</div>
						</div>
						
					</div>
				</div>
				<div class="row">&nbsp;</div>
				<div class="row bg_color showline2">
					<div class="col-sm-12">&nbsp;</div>
					<div class="col-sm-12">
						<!-- Save value for passed to controller -->
						<form:input type="hidden" path="orderDetail.orderDetailId" />
						<form:input type="hidden" path="orderDetail.orderId" />
						<form:input type="hidden" path="orderDetail.productCode" />
						<form:input type="hidden" path="orderDetail.productName" />
						<form:input type="hidden" path="orderDetail.amount" />
						<form:input type="hidden" path="orderDetail.shiped" />
						<form:input type="hidden" path="orderDetail.pending" />
						<form:input type="hidden" path="orderDetail.productUnit" />
						<form:input type="hidden" path="orderDetail.unitPrice" />
						<form:input type="hidden" path="orderDetail.productId" />
						<form:input type="hidden" path="orderDetail.status" />
						<form:input type="hidden" path="orderDetail.price" />
						<form:input type="hidden" path="orderDetail.productUnitId" />
						<form:input type="hidden" path="orderDetail.productCurrency" />
						<form:input type="hidden" path="orderDetail.productBuyerGroupId" />
	
						<table class="table table-hover table-list">
							<thead>
								<tr>
									<th>No</th>
									<th>Product Code</th>
									<th>Description</th>
									<th>Price</th>
									<th>Qty</th>
									<th>UOM</th>
									<th>Unit Price</th>
									<th>Amount</th>
									<th>Currency</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="ordDetail" varStatus="rowNum" items="${ splitForm.splitOrderDetails }">
									<tr id="row${ rowNum.index }">
										<!-- Save value for passed to controller -->
										<form:input type="hidden" path="splitOrderDetails[${ rowNum.index }].orderDetailId" />
										<form:input type="hidden" path="splitOrderDetails[${ rowNum.index }].orderId" />
										<form:input type="hidden" path="splitOrderDetails[${ rowNum.index }].productCode" />
										<form:input type="hidden" path="splitOrderDetails[${ rowNum.index }].productName" />
										<%-- <form:input type="hidden" path="splitOrderDetails[${ rowNum.index }].amount" /> --%>
										<%-- <form:input type="hidden" path="splitOrderDetails[${ rowNum.index }].shiped" /> --%>
										<%-- <form:input type="hidden" path="splitOrderDetails[${ rowNum.index }].pending" /> --%>
										<form:input type="hidden" path="splitOrderDetails[${ rowNum.index }].productUnit" />
										<form:input type="hidden" path="splitOrderDetails[${ rowNum.index }].unitPrice" />
										<form:input type="hidden" path="splitOrderDetails[${ rowNum.index }].productId" />
										<form:input type="hidden" path="splitOrderDetails[${ rowNum.index }].status" />
										<form:input type="hidden" path="splitOrderDetails[${ rowNum.index }].price" />
										<form:input type="hidden" path="splitOrderDetails[${ rowNum.index }].productUnitId" />
										<form:input type="hidden" path="splitOrderDetails[${ rowNum.index }].productCurrency" />
										<%-- <form:input type="hidden" path="splitOrderDetails[${ rowNum.index }].productBuyerGroupId" /> --%>
	
	
										<td>${ rowNum.index + 1 }</td>
										<td>${ ordDetail.productCode }</td>
										<td>${ ordDetail.productName }</td>
	
										<td>
											<select id="splitOrderDetails[${ rowNum.index }].productBuyerGroupId"
												name="splitOrderDetails[${ rowNum.index }].productBuyerGroupId" class="form-control"
												onchange="changePriceGroup(${ splitForm.splitOrderDetails[rowNum.index].orderDetailId }, this)">
												<option value=""></option>
												<c:forEach var="pg" varStatus="pgRow" items="${ orderDetailsForm.productPriceGroupList }">
													<c:set var="selected" value="" />
													<c:if
														test="${ pg.productPriceGroupId eq  splitForm.splitOrderDetails[rowNum.index].productBuyerGroupId}">
														<c:set var="selected" value="selected='selected'" />
													</c:if>
													<option value="${ pg.productPriceGroupId }" ${ selected }>${ pg.productPriceGroupName }</option>
												</c:forEach>
											</select>
										</td>
	
										<td>
											<form:input path="splitOrderDetails[${ rowNum.index }].amount"
												cssClass="form-control numberOnly splitqty" onblur="summarySplitQty()" />
										</td>
										<td>${ ordDetail.productUnit }</td>
	
										<td>
											<c:choose>
												<c:when test="${ ordDetail.unitPrice == null }">TBA</c:when>
												<c:otherwise>
													<fmt:formatNumber pattern="#,###" maxIntegerDigits="12" value="${ ordDetail.unitPrice }">
													</fmt:formatNumber>
												</c:otherwise>
											</c:choose>
										</td>
										<td>
											<div id="splitOrderDetails${ rowNum.index }.totalAmount">
												<c:choose>
													<c:when test="${ ordDetail.unitPrice == null }">TBA</c:when>
													<c:otherwise>
														<fmt:formatNumber pattern="#,###" maxIntegerDigits="12"
															value="${ ordDetail.amount * ordDetail.unitPrice }">
														</fmt:formatNumber>
													</c:otherwise>
												</c:choose>
											</div>
										</td>
										<td>
											<c:choose>
												<c:when test="${empty ordDetail.productCurrency }">TBA</c:when>
												<c:otherwise>
												${ ordDetail.productCurrency }
												</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</c:forEach>
								<%-- Summary row --%>
								<tr class="bg-info">
									<td colspan="4" align="right">
										<b>Total Qty:</b>
									</td>
									<td colspan="1">
										<form:hidden path="totalSplitQty" />
										<div id="totalQty"></div>
									</td>
									<td colspan="4" align="left">
										<b>Maximum Qty:</b> ${ splitForm.orderDetail.amount }
									</td>
								</tr>
							</tbody>
						</table>
					</div>
	
					<div class="col-sm-12">&nbsp;</div>
					<div class="col-sm-12 text-right">
						<input type="button" value="Confirm" onclick="confirmSplitOrder()" class="btn btn-success" />
						<input type="button" value="Cancel" onclick="back()" class="btn btn-default" />
					</div>
					<div class="col-sm-12">&nbsp;</div>
				</div>
	
			</form:form>
		
		</div>
	
		

	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>


	<script type="text/javascript">
		$(document).ready(function() {
			summarySplitQty();
		});
		
		function summarySplitQty(){
			console.log('Summary Split Qty');
			
			var total = 0;
			$('.splitqty').each(function() {
				if ($(this).val()) {
					total += parseInt($(this).val());
				}
			});
			
			$('#totalQty').text(formatNumber(total));
			$('#totalSplitQty').val(total);
			
			updateSplitAmount();
		}
		
		function updateSplitAmount(){
			console.log('Summary Split Amount');
			
			var row = -1;
			$('.splitqty').each(function() {
				row++;
				console.log('row ' + row);
				if ($(this).val()) {
					
					var objUnitPrice = $('#splitOrderDetails' + row + '\\.unitPrice');
					console.log('\tunitAmt ' + objUnitPrice.val());
					if(objUnitPrice && objUnitPrice.val() && objUnitPrice.val() != 'TBA'){
						var qty = parseInt($(this).val());
						var unitPrice = parseInt(objUnitPrice.val());
						$('#splitOrderDetails'+ row +'\\.totalAmount').text(formatNumber(qty * unitPrice));
					}
				}
			});
			
		}
		
		function changePriceGroup(id, objSelect){
			console.log(id + '\t' +$(objSelect).val());
			var form = $('#splitOrderDetailForm');
			form.attr('action', '<c:url value="/backend/order/change-price-group-for-split" />');
			form.submit();
		}
		
		function confirmSplitOrder(){
			// re-cal
			summarySplitQty();
			
			var totalQty = $('#totalSplitQty').val();
			var maxAmount = $('#orderDetail\\.amount').val();
			
			// validate maximum amount
			if(totalQty != maxAmount){
				showDialog('Total Qty must same as Maximum Qty');
				return;
			}
			
			// validate same qty but have empty or zero some order detail
			if(isQtyHaveNotValue()){
				showDialog("Some order details hasn't Qty");
				return;
			}
			
			// save split order
			console.log('save split order');
			var form = $('#splitOrderDetailForm');
			form.attr('action', '<c:url value="/backend/order/save-split-order" />');
			form.submit();
		}
		
		function isQtyHaveNotValue(){
			var found = false;
			$('.splitqty').each(function() {
				console.log("qty: " + $(this).val());
				if (!$(this).val()) {
					console.log('Not found value');
					found = true;
					return;
				}

				if (parseInt($(this).val()) <= 0) {
					console.log('value less than zero');
					found = true;
					return;
				}
			});
			
			return found;
		}
		
		function back(){
			window.location.href = '<c:url value="/backend/order/view?orderId=" />' + $('#orderDetail\\.orderId').val();
		}

	</script>
</body>
</html>
