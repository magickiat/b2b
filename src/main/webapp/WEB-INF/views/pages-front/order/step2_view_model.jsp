<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Starboard Windsurfing</title>
	<%@include file="/WEB-INF/views/include/common_css.jspf"%>
	
</head>
<body class="pd-bottom">
	
	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>
	
	<%-- Use when change technology  --%>
	<input type="hidden" id="withnoseFlag" value="0" />

	<div class="container">
		<div class="row">
			<img alt="step 1"
				src='<c:url value="/images/pages-front/icon/step2.png" />'>
		</div>
		<div class="row">&nbsp;</div>
		<div class="row">
			<div class="col-md-12 bg_color" style="padding-bottom: 50px;">
				<div class="row-header2 header2 txtupper">product</div>
				<div class="col-sm-8 text-center product-img-big-view">
					<%-- Product Model Picture --%>
					<%@include file="step2_include/view_image.jspf"%>
				</div>
				<div class="col-sm-4">
					<%-- Technology --%>
					<div class="row product-img-big-view">
						<%@include file="step2_include/technology.jspf"%>
					</div>
	
					<%-- SIZE (Product length) --%>
					<div class="row product-img-big-view">
						<%@include file="step2_include/size.jspf"%>
					</div>
	
					<%-- Withnose board --%>
					<div class="row product-img-big-view">
						<%@include file="step2_include/withnose_board.jspf"%>
					</div>
	
					<%-- Quantity --%>
					<div class="row product-img-big-view">
						<%@include file="step2_include/quantity.jspf"%>
					</div>
	
					<%-- Button --%>
					<div class="row product-img-big-view">
						<%@include file="step2_include/button.jspf"%>
					</div>
				</div>
			</div>
		</div>

		<%@include file="step2_include/add_multiple.jspf"%>
		
	</div>
	
	<%-- Message dialog --%>
	<div id="dialog" style="display:none;"></div>
	
	<%@include file="/WEB-INF/views/include/common_footer.jspf" %>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script src='<c:url value="/scripts/zoom/jquery.elevateZoom-3.0.8.min.js" />'></script>
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

			var quantity = $('#quantity').val();
			console.log('quantity: ' + quantity);
			if (isValidNumber(quantity)) {
				if (quantity <= 0) {
					alert('Quantity must greater than zero');
					return;
				}

				var productId = $('#currentProduct').val();
				var param = {
					'productId' : productId,
					'quantity' : quantity
				};

				console.log('productId = ' + productId);

				console.log("calling url: ${addToCartUrl}");

				$.post('${addToCartUrl}', param).done(function(response) {
					console.log(JSON.stringify(response));
					renderToCart(response);
					
					<%-- http://stackoverflow.com/questions/10179040/jquery-dialog-open-and-automatically-close-after-3-seconds --%>
					/* console.log('begin animate'); */
					$('#dialog').html('Added to cart');
					$('#dialog').dialog({
						dialogClass: 'style1',
					    autoOpen: true,
					    show: "blind",
					    hide: "fadeOut",
					    modal: true,
					    open: function(event, ui) {
					        setTimeout(function(){
					            $('#dialog').dialog('close');                
					        }, 3000);
					    }
					});
					
					//clear txt qty
					$('#quantity').val('0')
					
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