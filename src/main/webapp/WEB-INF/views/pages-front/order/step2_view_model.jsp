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
				<div class="row product-img-big-view"><%@include file="step2/technology.jspf"%></div>

				<%-- SIZE (Product length) --%>
				<div class="row product-img-big-view"><%@include file="step2/size.jspf"%></div>

				<%-- Withnose board --%>
				<div class="row product-img-big-view"><%@include file="step2/withnose_board.jspf"%></div>
				
				<%-- Quantity --%>
				<div class="row product-img-big-view"><%@include file="step2/quantity.jspf"%></div>
				
				<%-- Button --%>
				<div class="row product-img-big-view"><%@include file="step2/button.jspf"%></div>
			</div>
		</div>

		<div class="row">Add multiple</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script
		src='<c:url value="/scripts/zoom/jquery.elevateZoom-3.0.8.min.js" />'></script>


	<script type="text/javascript">
		$(document).ready(function() {
			$('#zoomImg').elevateZoom({
				scrollZoom : true
			});

			showLogCurrentProduct();
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

			showLogCurrentProduct();
		}

		function disableAllWithnoseTechnology(techId) {
			resetActiveProductSize();

			$('.withnose0-tech').hide();
			$('.withnose1-tech').hide();

			//Clear zoom
			$(".zoomContainer").remove();
			$(".zoomLens").remove();
		}

		function changeCurrentSize(productId, currentButton) {
			console.log('changeCurrentSize');

			resetActiveProductSize();

			$('#currentProduct').val(productId);
			$(currentButton).removeClass('btn-primary').addClass('btn-success');

			var currentTechId = $('#currentTechId').val();
			var withnoseFlag = $('#withnoseFlag').val();
			var currentWithnoseKey = 'withnose' + withnoseFlag;

			var itemKey = currentWithnoseKey + '-' + currentTechId + '-item';
			$('.' + itemKey).hide();

			var showItemKey = itemKey + '-' + productId;
			$('.' + showItemKey).show();

			showLogCurrentProduct();
		}

		function resetActiveProductSize() {
			$('.btn-product-size').removeClass('btn-success').addClass(
					'btn-primary');
		}

		function showLogCurrentProduct() {
			console.log(' [currentProduct = ' + $('#currentProduct').val()
					+ ']\t[currentTechId = ' + $('#currentTechId').val() + ']');
		}
	</script>
</body>
</html>