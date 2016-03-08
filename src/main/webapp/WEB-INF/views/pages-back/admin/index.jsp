<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
	<div class="container">
		<div class="row">
			<div class="col-md-12 bg_color">
				<div class="row row-header2 header2">Welcome Admin page</div>
			</div>
		</div>
		<div class="row">&nbsp;</div>
		<div class="row bg_color showline2" style="min-height: 300px;">
			<div class="row">&nbsp;</div>
			<div class="col-sm-12">
				<a class="btn btn-primary pull-right " href='<c:url value="/backend/admin/file/list" />'>Upload image</a>
				<a class="btn btn-primary pull-right" style="margin-right:10px;" href='<c:url value="/backend/product/upload/product-price" />'>Upload Product Price</a>
			</div>
			
		</div>
	</div>

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>
