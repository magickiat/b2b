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
	<input type="hidden" id="currentTechId" value="" />
	<input type="hidden" id="currentProductSize" value="" />


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
			<div class="col-sm-8 text-center">
				<%-- Product Model Picture --%>
				<%@include file="step2/view_image.jspf"%>

			</div>
			<div class="col-sm-4">
				<%-- Technology --%>
				<div class="row"><%@include file="step2/technology.jspf"%></div>

				<%-- SIZE (Product length) --%>
				<div class="row"><%@include file="step2/size.jspf"%></div>
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

		});

		function changeProductTechnology(techId) {
			console.log('Technology id: ' + techId);

			//Hide all
			disableAllWithnoseTechnology(techId);

			//show only techId
			var withnoseFlag = $('#withnoseFlag').val();
			$('.withnose' + withnoseFlag + '_' + techId).show();

			// Set active product size first index
			resetActiveProductSize();
			$('.size0').removeClass('btn-primary').addClass('btn-success');

			//Enable zoom
			$(".product").elevateZoom({
				scrollZoom : true
			});
		}

		function disableAllWithnoseTechnology(techId) {
			resetActiveProductSize();
			
			$('.withnose0_tech').hide();
			$('.withnose1_tech').hide();

			//Clear zoom
			$(".zoomContainer").remove();
			$(".zoomLens").remove();
		}

		function changeCurrentSize(productCode, currentButton) {
			resetActiveProductSize();
			$(currentButton).removeClass('btn-primary').addClass('btn-success');

			var withnoseFlag = $('#withnoseFlag').val();
			var currentTechId = $('#currentTechId').val();
		}

		function resetActiveProductSize() {
			$('.btn-product-size').removeClass('btn-success').addClass(
					'btn-primary');
		}
	</script>
</body>
</html>