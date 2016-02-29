<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>

	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>

	<div class="container">

		<div class="row">
			<img src='<c:url value="/images/pages-front/icon/step4.png" />'>
		</div>
		<div class="row">&nbsp;</div>

		<c:set var="orderId" value="${ order.orderId }" />
		<div class="row bg_color">
			<%@include file="/WEB-INF/views/include/export_report.jspf"%>
		</div>

		<div class="row bg_color showline2">
			<%@include file="orderSummary.jspf"%>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>

</body>
</html>
