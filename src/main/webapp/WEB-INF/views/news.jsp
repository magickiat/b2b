<%--
  Created by IntelliJ IDEA.
  User: Thanakit Jumparuang
  Date: 27/12/2558
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="/WEB-INF/views/include/common_meta.jspf" %>
		<title>Feed Content</title>
		<%@include file="/WEB-INF/views/include/common_css.jspf" %>
	</head>
	<body>
		<c:if test="${side eq 'front'}">
			<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf" %>
		</c:if>
		<c:if test="${side eq 'back'}">
			<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf" %>
		</c:if>
		<div class="container">
			<div class="row">
				<div class="col-sm-12 bg_color showline">
					<c:forEach items="${resultPage.result}" var="content">
						<div class="row-header header1">${content.title}</div>
						<div>${content.timeCreate}</div>
						<hr/>
						<div>${content.content}</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<%@include file="/WEB-INF/views/include/common_js.jspf" %>
	</body>
</html>
