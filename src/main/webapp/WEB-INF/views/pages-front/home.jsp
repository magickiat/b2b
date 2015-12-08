<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


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
	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf" %>
	
	<div class="container">
		
		<div class="row">
			<div class="col-md-8 bg_color showline">
				<c:forEach items="${resultPage.result}" var="content">
					<div class="row row-header header1">${content.title }</div>
			    	<p class="">
			        	<div>${content.timeCreate }</div>
			        	<div>${content.content }</div>
			    	</p>
					<hr>
				</c:forEach>
				<!-- Base URL for pagination -->
				<c:set var="baseUrl" value="/backend/feed-contents" />
				<%@include file="/WEB-INF/views/include/paging.jspf" %>
			</div>
			<div class="col-md-4 bg_color showline">
				<div class="row row-header header1">CALENDAR</div>
				<div style="min-height: 300px;">
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="/WEB-INF/views/include/common_footer.jspf" %>
	<%@include file="/WEB-INF/views/include/common_js.jspf" %>
</body>
</html>