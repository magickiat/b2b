<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/include/common_meta.jspf" %>
	<title><spring:message code="page.header"></spring:message></title>
	<%@include file="/WEB-INF/views/include/common_css.jspf"%>
	
</head>
<body class="pd-bottom">
	
	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>
	
	<%-- Use when change technology  --%>
	<input type="hidden" id="withnoseFlag" value="0" />

	<div class="container">
	
		<div class="col-md-12">
		
			<div class="row">
				<img
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
	
	
		
		
	</div>
	
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

					
					$('input[type=radio][name=withnose]').change(
							function() {
								console.log('event changed ' + this.value);
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
					checkHasNoseProtectorOnly();
				});

		function checkHasNoseProtectorOnly(){
			var numOfProductListNoWithnose = ${productListNoWithnose.size()};
			var numOfProductListWithnose = ${productListWithnose.size()};
			
			// has only with nose protector
			if(numOfProductListNoWithnose == 0 && numOfProductListWithnose > 0){
				$('input[type=radio][name=withnose][value=0]').attr("disabled",true);
				$('input[type=radio][name=withnose][value=1]').click();
				
			}
		}
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
			
			$('.product-item').hide();
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
