<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%--
  Created by IntelliJ IDEA.
  User: Thanakit Jumparuang
  Date: 27/12/2558
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<c:if test="${side eq 'front'}">
	<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</c:if>
<c:if test="${side eq 'back'}">
	<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</c:if>
</head>
<body>
	<c:if test="${side eq 'front'}">
		<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>
	</c:if>
	<c:if test="${side eq 'back'}">
		<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
	</c:if>
	<div class="container">
		<div class="row showline2">
			<c:forEach items="${resultPage.result}" var="content">
				<div class="col-sm-12 row-header header1">
					<a href="<c:url value="/news"/>?feedId=${content.id}">${content.title}</a>
				</div>
				<div class="col-sm-12 bg_color text-right">
					<fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${content.timeCreate}" />
				</div>
				<div class="col-sm-12 bg_color">${content.content}</div>
			</c:forEach>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>
