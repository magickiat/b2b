<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>

	<div class="container">
	
		<div class="col-md-12">
			
			<div class="row">
				<div class="col-sm-12 header2 txtupper bg_color showline2">Problem occured</div>
				<div class="col-sm-12 bg_color showline2">Please contact administrator
					with this message</div>
				<div class="col-sm-12 bg_color showline2" style="padding: 10px;">
				${exception.message}
				</div>
	
				<!-- PLEASE DON'T REMOVE THIS COMMENT
			    Failed URL: ${url}
			    Exception:  ${exception.message}
			        <c:forEach items="${exception.stackTrace}" var="ste">    ${ste} 
			    </c:forEach>
			    -->
			</div>
			
		</div>

		
	</div>

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>

</body>
</html>