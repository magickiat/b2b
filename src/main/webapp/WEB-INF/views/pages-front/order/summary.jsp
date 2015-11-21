<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Starboard Windsurfing</title>
    <%@include file="/WEB-INF/views/include/common_css.jspf" %>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>
	
	<div class="container">
		
		<div class="row">
			<div class="col-md-12 bg_color showline2">
				<div class="row row-header header1">Order Summary</div>
				    <div>
				    </div>
				<hr>
			</div>
		</div>
	</div>
	
	<%@include file="/WEB-INF/views/include/common_footer.jspf" %>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script src="<c:url value="/scripts/assets/js/jquery.backstretch.min.js"/>"></script>
	<script>
		jQuery(document).ready(function() {
		 	$.backstretch("<c:url value="/scripts/assets/img/backgrounds/starboardbglogin.png"/>");
		});
	</script>
</body>
</html>