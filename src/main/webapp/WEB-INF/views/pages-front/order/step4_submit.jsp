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
<body>

	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>

	<div class="container">
		
		<div class="row">
			<img alt="step 1" src='<c:url value="/images/pages-front/icon/step4.png" />'>
		</div>
		<div class="row">&nbsp;</div>
		<div class="row">
			<div class="col-md-12 bg_color">
				<div class="row row-header2 header2 txtupper">print</div>
				<div class="col-sm-3"></div>
				<div class="col-sm-6 text-center" style="padding-bottom: 5px; padding-top: 5px;">
					<input type="button" class="btn btn-default" id="btnExcel" value="EXCEL" />
					<input type="button" class="btn btn-default" id="btnPdf" value="PDF" />
					<input type="button" class="btn btn-default" id="btnPrint" value="PRINT" />
					<input type="button" class="btn btn-default" id="btnFinish" value="FINISH" onclick="gotoOrderSummary();" />
				</div>
				<div class="col-sm-3"></div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_footer.jspf" %>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script src="<c:url value="/scripts/assets/js/jquery-1.11.1.min.js"/>"></script>
	<script src="<c:url value="/scripts/assets/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/scripts/assets/js/jquery.backstretch.min.js"/>"></script>
	<script>
		jQuery(document).ready(function() {
		 	$.backstretch("<c:url value="/scripts/assets/img/backgrounds/starboardbglogin.png"/>");
		});
		
		function gotoOrderSummary(){
			window.location.href = '<c:url value="/frontend/order/summary" />';
		}
	</script>
</body>
</html>