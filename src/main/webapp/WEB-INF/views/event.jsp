<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--
  Created by IntelliJ IDEA.
  User: Thanakit Jumparuang
  Date: 1/22/2016
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
<c:if test="${side eq 'front'}">
	<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</c:if>
<c:if test="${side eq 'back'}">
	<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</c:if>
</head>
<body>
	<c:if test="${side eq 'front'}">
		<%@include
			file="/WEB-INF/views/pages-front/include/common_header.jspf"%>
	</c:if>
	<c:if test="${side eq 'back'}">
		<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
	</c:if>
	<div class="container">
		<div class="col-md-12">
			<div class="row">
				<div class="col-sm-12 bg_color showline2">
					<c:forEach items="${resultPage.result}" var="event">
						<div class="row-header header2">${event.title}</div>
						<div style="text-align: right; font-size: 12px;">Event time: ${event.timeEvent}</div>
						<div style="text-align: right; font-size: 12px;">Create Date: ${event.timeCreate}</div>
						<hr />
						<div style="text-indent: 20px; min-height: 200px;">${event.content}</div>
						
					</c:forEach>
				</div>
			</div>
		</div>
		
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>
