<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
		<div class="row row-header2 header2 txtupper">print</div>
		
		<c:set var="orderId" value="${ order.orderId }" />
		<%@include file="/WEB-INF/views/include/export_report.jspf" %>
		
		<div class="row">
	       <%@include file="orderSummary.jspf" %>
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