<%--
  Created by IntelliJ IDEA.
  User: Thanakit Jumparuang
  Date: 1/22/2016
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <c:forEach items="${resultPage.result}" var="event">
                <div class="row-header header1">${event.title}</div>
                <div>Event time: ${event.timeEvent}</div>
                <div>${event.timeCreate}</div>
                <hr/>
                <div>${event.content}</div>
            </c:forEach>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/include/common_js.jspf" %>
</body>
</html>
