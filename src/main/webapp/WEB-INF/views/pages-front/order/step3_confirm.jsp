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
										<td><input type="hidden"
											id="quantity-${ rowCount.index }"
											value="${ product.productQuantity }" /> <input type="text"
											name="quantity" class="form-control numberOnly" value="${ product.productQuantity }" /> <c:set
												var="totalQuantity"
												value="${ totalQuantity +  product.productQuantity }" /></td>

										<td>${ product.productUnitId }</td>

										<td><c:choose>
												<c:when test="${ empty p.price }">
												TBA
											</c:when>
												<c:otherwise>
													<fmt:formatNumber pattern="#,###" maxIntegerDigits="12"
														value="${ p.price.amount }">
													</fmt:formatNumber>
												</c:otherwise>
											</c:choose></td>


										<td><c:choose>
												<c:when test="${ empty p.price }">TBA</c:when>
												<c:otherwise>
													<fmt:formatNumber pattern="#,###" maxIntegerDigits="12"
														value="${ product.productQuantity * p.price.amount }"
														minIntegerDigits="1">
													</fmt:formatNumber>

													<input type="hidden" name="totalProductAmount"
														value="${ totalAmount + (product.productQuantity * p.price.amount) }" />
												</c:otherwise>
											</c:choose></td>
										<td>${ product.productCurrency }</td>
										<td class="text-center"><img class="img-btn-cursor"
											src='<c:url value="/images/pages-front/icon/btn_remove.png" />'>
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
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<%@include file="/WEB-INF/views/include/common_js.jspf"%>

		<script type="text/javascript">
			$(document).ready(function() {
				// Summary quantity
				summaryQuantity();
				summaryAmount();
			});

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

				$('input[name=totalProductAmount]').each(
						function(index, value) {
							var val = $(value).val();
							console
									.log('index = ' + index + '\tvalue = '
											+ val);
							amount = (+amount) + (+val);
						});
				console.log('Total Amount = ' + amount);
				$('#totalAmount').text(formatNumber(amount));
			}
		</script>
</body>
</html>