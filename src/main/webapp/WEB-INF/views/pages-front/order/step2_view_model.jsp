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

	<%-- Use when change technology  --%>
	<input type="hidden" id="withnoseFlag" value="0" />

	<div class="container">
		<%@include
			file="/WEB-INF/views/pages-front/include/common_header.jspf"%>


		<div class="row">
			<img alt="step 1"
				src='<c:url value="/images/pages-front/icon/step2.png" />'
				width="100%">
		</div>

		<div class="row">&nbsp;</div>

		<div class="row">
			<div class="col-sm-8 text-center product-img-big-view">
				<%-- Product Model Picture --%>
				<%@include file="step2/view_image.jspf"%>

			</div>
			<div class="col-sm-4">
				<%-- Technology --%>
				<div class="row product-img-big-view"><%@include
						file="step2/technology.jspf"%></div>

				<%-- SIZE (Product length) --%>
				<div class="row product-img-big-view"><%@include
						file="step2/size.jspf"%></div>

				<%-- Withnose board --%>
				<div class="row product-img-big-view"><%@include
						file="step2/withnose_board.jspf"%></div>

				<%-- Quantity --%>
				<div class="row product-img-big-view"><%@include
						file="step2/quantity.jspf"%></div>

				<%-- Button --%>
				<div class="row product-img-big-view"><%@include
						file="step2/button.jspf"%></div>
			</div>
		</div>

		<div class="row">
			<%@include file="step2/add_multiple.jspf"%>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script
		src='<c:url value="/scripts/zoom/jquery.elevateZoom-3.0.8.min.js" />'></script>

	<c:url var="addToCartUrl" value="/frontend/order/add-to-cart" />
	<script type="text/javascript">
		$(document).ready(
				function() {

					showLogCurrentProduct();

					$('.zoomImg').elevateZoom({
						scrollZoom : true
					});

					$('#btn-previous').click(function() {
						window.history.back();
					});

					$('input[type=radio][name=withnose]').change(
							function() {
								console.log('withnose = ' + this.value);

								if (this.value == 0) {
									$('.withnose0').show();
									$('.withnose1').hide();
								} else if (this.value == 1) {
									$('.withnose0').hide();
									$('.withnose1').show();
								} else {
									console.log('not support this value: '
											+ this.value);
								}

								// Reset to first product
								$('#withnoseFlag').val(this.value);

								var product = $(
										'#firstSearchProduct-withnose'
												+ this.value).val();
								var techId = $('#currentTechId').val();
								/* var firstTech = $('#firstSearchTech-withnose' + this.value).val(); */

								changeProductTechnology(techId, product);

							});

				});

		function changeProductTechnology(techId, productId) {

			$('#currentTechId').val(techId);
			$('#currentProduct').val(productId);

			//Hide all
			disableAllWithnoseTechnology(techId);

			//show only techId
			var withnoseFlag = $('#withnoseFlag').val();
			var techIdKey = '.withnose' + withnoseFlag + '-' + techId;
			$(techIdKey).show();

			// Show first product of tech id
			var productKey = techIdKey + '-item-' + productId;
			$(productKey).show();

			// Set default product size to first index
			$('.size0').removeClass('btn-primary').addClass('btn-success');

			//Enable zoom
			$(".product").elevateZoom({
				scrollZoom : true
			});

			showPrice(productId);

			clearzoom();
			showLogCurrentProduct();
		}

		function disableAllWithnoseTechnology(techId) {
			resetActiveProductSize();

			$('.withnose0-tech').hide();
			$('.withnose1-tech').hide();
		}

		function changeCurrentSize(productId, currentButton) {
			console.log('changeCurrentSize');

			resetActiveProductSize();

			$('#currentProduct').val(productId);
			$(currentButton).removeClass('btn-primary').addClass('btn-success');

			var currentTechId = $('#currentTechId').val();
			var withnoseFlag = $('#withnoseFlag').val();
			var currentWithnoseKey = 'withnose' + withnoseFlag;

			// Hide all product
			var itemKey = currentWithnoseKey + '-' + currentTechId + '-item';
			$('.' + itemKey).hide();

			// Set current product to show
			var showItemKey = itemKey + '-' + productId;
			$('.' + showItemKey).show();

			showPrice(productId);

			clearzoom();
			showLogCurrentProduct();
		}

		function showPrice(productId) {
			$('.product-price').hide();
			$('.product-price-' + productId).show();
		}

		function resetActiveProductSize() {
			$('.btn-product-size').removeClass('btn-success').addClass(
					'btn-primary');
		}

		function showLogCurrentProduct() {
			console.log(' [currentProduct = ' + $('#currentProduct').val()
					+ ']\t[currentTechId = ' + $('#currentTechId').val() + ']');
		}

		function addToCart() {
			console.log('begin animate');
			//TODO add animation to shopping cart

			var quantity = $('#quantity').val();
			console.log('quantity: ' + quantity);
			if (isValidNumber(quantity)) {
				if (quantity <= 0) {
					alert('Quantity must greater than zero');
					return;
				}
				//TODO save product code to shopping cart with quantity
				var productId = $('#currentProduct').val();
				var param = {
					'productId' : productId,
					'quantity' : quantity
				};

				console.log('productId = ' + productId);

				console.log("calling url: ${addToCartUrl}");

				$.post('${addToCartUrl}', param).done(function(response) {
					console.log(response);
					renderToCart(response);
				}).fail(function(result) {
					alert(result.responseText);
				});

			} else {
				alert('Please check Quantity.');
			}

		}

		function clearzoom() {
			$(".zoomContainer").remove();
			$(".zoomLens").remove();

			$('.zoomImg').elevateZoom({
				scrollZoom : true
			});
		}
	</script>
</body>
</html>