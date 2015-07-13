<%@	page contentType="text/html"%>
<%@	page pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:choose>
<c:when test="${param['lang'] != null}" >
	<fmt:setLocale value="${param['lang']}" scope="session"/>
</c:when>
<c:otherwise>
	
</c:otherwise>
</c:choose>

