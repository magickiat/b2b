<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/include/common_meta.jspf" %>
	<title><spring:message code="page.header"></spring:message></title>
	<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
	
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
	
	<div class="container">
		<div class="row">
			<div class="col-sm-10">
				<h2>User</h2>
			</div>
			<%-- <div class="col-sm-2">
				<form:form servletRelativeAction="/backend/customer/create"
					method="get">
					<input type="submit" value="Add Customer"
						class="btn btn-default pull-right" />
				</form:form>
			</div> --%>
		</div>
		<div class="row">
			<table class="table table-hover" id="list_user">
				<thead>
					<tr>
						<th>User Name</th>
						<th>Password</th>
						<th>Confirm Password</th>
						<th>Active</th>
						<th>Staff</th>
						<th>Active Timle</th>
						<th>Function</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users }" var="user">
						<tr style="cursor: pointer;"
							onclick="javascript:createUser('${user.id }');">
							<td>${user.code }</td>
							<td>${user.name }</td>
							<td>${user.code }</td>
							<td>${user.code }</td>
							<td>${user.code }</td>
							<td>${user.code }</td>
							<td>${user.code }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script type="text/javascript"
		src='<c:url value="/scripts/js_back_end/customer/search.js" />'></script>
</body>
</html>
