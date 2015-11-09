<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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
				src='<c:url value="/images/pages-front/icon/step3.png" />'
				width="100%">
		</div>
		<div class="row">&nbsp;</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="row">
					<div class="col-sm-12">
						<h4>INVOICE TO</h4>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">Address</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="row">
					<div class="col-sm-4">
						<h4>DISPATCH TO</h4>
					</div>
					<div class="col-sm-8">

						<c:if test="${ not empty dispatchToAddress }">
							<select id="dispatchTo" name="dispatchTo" class="form-control">
								<c:forEach var="dispatchTo" items="${ dispatchToAddress }"
									varStatus="rowCount">

									<option value="${ dispatchTo.addrId }"
										label="${ dispatchTo.address }" />

								</c:forEach>
							</select>
						</c:if>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">Address</div>
				</div>
			</div>
		</div>
		<div class="row">&nbsp;</div>
		<div class="row">
			<div class="col-sm-10 text-right">
				<input type="button" id="btn-add" class="btn btn-success"
					value="ADD" />
			</div>
			<div class="col-sm-2">
				<input type="button" id="btn-upload" class="btn btn-success"
					value="UPLOAD" />
			</div>
			<div class="row">&nbsp;</div>
			<div class="row">
				<c:choose>
					<c:when test="${empty cart }">
						<h3>Not found any product to checkout.</h3>
					</c:when>
					<c:otherwise>
						<table class="table">
							<thead>
								<tr>
									<th>No.</th>
									<th>Product Code</th>
									<th>Description</th>
									<th>Qty</th>
									<th>UOM</th>
									<th>Unit Price</th>
									<th>Amount</th>
									<th>Currency</th>
									<th class="text-center">Remove</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${ products }" var="p" varStatus="rowCount">
									<c:set var="product" value="${ p.product }" />
									<tr>
										<td>${rowCount.index + 1 }</td>
										<td>${ product.productCode }</td>
										<td>${ product.productNameEn }</td>
										<td><input type="text" id="quantity-${ rowCount.index }"
											name="quantity" class="form-control numberOnly"
											value="${ product.productQuantity }" onblur="reCalAmount()" />
											<c:set var="totalQuantity"
												value="${ totalQuantity +  product.productQuantity }" /></td>

										<td>${ product.productUnitId }</td>

										<td><c:choose>
												<c:when test="${ empty p.price }">
												TBA
											</c:when>
												<c:otherwise>
													<span id="amount-${ rowCount.index }"><fmt:formatNumber
															pattern="#,###" maxIntegerDigits="12"
															value="${ p.price.amount }">
														</fmt:formatNumber></span>
												</c:otherwise>
											</c:choose></td>


										<td><c:choose>
												<c:when test="${ empty p.price }">TBA</c:when>
												<c:otherwise>
													<span id="total-amount-${ rowCount.index }"> <fmt:formatNumber
															pattern="#,###" maxIntegerDigits="12"
															value="${ product.productQuantity * p.price.amount }"
															minIntegerDigits="1">
														</fmt:formatNumber>
													</span>
													<input type="hidden" name="totalProductAmount"
														value="${ totalAmount + (product.productQuantity * p.price.amount) }" />
												</c:otherwise>
											</c:choose></td>
										<td>${ product.productCurrency }</td>
										<td class="text-center">
											<form id="remove-${ product.productId }"
												action='<c:url value="/frontend/order/step3/remove" />'
												method="post">
												<input type="hidden" name="productId"
													value="${ product.productId }" />
											</form> <img class="img-btn-cursor"
											src='<c:url value="/images/pages-front/icon/btn_remove.png" />'
											onclick="confirmRemove(${product.productId}, '${ product.productCode }')">
										</td>
									</tr>
								</c:forEach>

								<tr>
									<td colspan="3" class="text-right">TOTAL</td>
									<td><span id="totalQty"></span></td>
									<td></td>
									<td></td>
									<td><span id="totalAmount"></span></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td colspan="9"></td>
								</tr>
								<tr>
									<td colspan="3">Customer Remark</td>
									<td colspan="6">Shipping and Service Fee</td>
								</tr>
								<tr>
									<td colspan="3"><textarea rows="4" cols="50"
											class="form-control"></textarea></td>
									<td colspan="6"><label for="shippingType">Shipping
											type</label> <select id="shippingType" name="shippingType"
										class="form-control">
											<c:forEach var="shippingType" items="${ shippingTypeList }">
												<option label="${shippingType.shippingTypeName }"
													value="${ shippingType.shippingTypeId }" />
											</c:forEach>
									</select></td>
								</tr>
								<tr>
									<td class="text-center" colspan="9"><input type="button"
										id="confirm" name="confirm" class="btn btn-success"
										value="CONFIRM" onclick="return confirmOrder();" /></td>
								</tr>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>

	<script type="text/javascript">
		$(document).ready(function() {
			reCalAmount();
		});

		function reCalAmount() {
			summaryQuantity();
			summaryAmount();
		}

		function summaryQuantity() {
			var quantity = 0;
			console.log('Summar quantity');
			$('input[name=quantity]').each(function(index, value) {
				var val = $(value).val();
				console.log('index = ' + index + '\tvalue = ' + val);
				quantity = (+quantity) + (+val);
			});
			console.log('Total Quantity = ' + quantity);
			$('#totalQty').text(formatNumber(quantity));
		}

		function summaryAmount() {
			var amount = 0;

			$('input[name=totalProductAmount]').each(function(index, value) {
				var quantity = $('#quantity-' + index).val();
				console.log('quantity = ' + quantity);
				var val = $(value).val();
				val = (+val) * (+quantity);

				console.log('index = ' + index + '\tvalue = ' + val);
				amount = (+amount) + (+val);
				$('#total-amount-' + index).text(val);
			});
			console.log('Total Amount = ' + amount);
			$('#totalAmount').text(formatNumber(amount));
		}
		
		function confirmRemove(productId, productCode){
			console.log('product_id = ' + productId + '\tproductCode = ' + productCode);
			
			<%-- http://stackoverflow.com/questions/12617084/jquery-confirm-dialog --%>
			$('<div></div>').appendTo('body')
			  .html('<div><h6>Do you want to delete order product code ' + productCode + '?</h6></div>')
			  .dialog({
			      modal: true, title: 'message', zIndex: 10000, autoOpen: true,
			      width: 'auto', resizable: false,
			      buttons: {
			          Yes: function () {
			             // doFunctionForYes();
			             console.log('Do Yes.');
			             removeFromCart(productId);
			              $(this).dialog("close");
			          },
			          No: function () {
			              //doFunctionForNo();
			              console.log('Do No.');
			              $(this).dialog("close");
			          }
			      },
			      close: function (event, ui) {
			          $(this).remove();
			      }
			});
		}
		
		function removeFromCart(productId){
			$('#remove-'+productId).submit();
		}
		
		function confirmOrder(){
			summaryQuantity();
			var qty = $('#totalQty').text();
			console.log('qty = ' + qty);
			if(qty == 0){
				alert('Not found any product to confirm');
			}else{
				console.log('go to RO page');
			}
		}
		</script>
</body>
</html>