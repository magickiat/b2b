<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/include/common_meta.jspf" %>
	<title>Starboard Windsurfing</title>
    <%@include file="/WEB-INF/views/include/common_cssbackend.jspf" %>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
	<div class="container">
		<div class="row">
			<div class="col-md-12 bg_color" style="min-height: 400px;">
				<div class="row row-header2 header2">Welcome Admin page</div>
				<div>
					<a href='<c:url value="/backend/admin/file/list" />'>Upload image</a>
				</div>	
			</div>
		</div>
	</div>
	
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>
