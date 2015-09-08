<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Starboard</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>
	<div class="container">
		<%@include
			file="/WEB-INF/views/pages-front/include/common_header.jspf"%>
		<div class="row">
			<form:form servletRelativeAction="/frontend/user/edit" class="form-horizontal"
				commandName="userForm" method="post">
				<form:hidden path="id" class="form-control" value="${ userForm.id }"/>
				<table class="table table-hover">
				<thead>
					<tr>
						<th>Username</th>
						<th>Password</th>
						<th>Confirm Password</th>
						<th>Email</th>
						<th>Active Time</th>
						<th>Function</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
						<form:input path="username"  class="form-control" value="${ userForm.username }"/>
						</td>
						<td>
						<form:password path="password"  class="form-control" value="${ userForm.password }"/>
						</td>
						<td>
						<form:password path="confirmPassword"  class="form-control" value="${ userForm.confirmPassword }"/>
						</td>
						<td>
						<form:input path="email"  class="form-control" value="${ userForm.email }"/>
						</td>
						<td>
						<%-- <form:input path="activeTime"  class="form-control" value=""/> --%>
						</td>
						<td>
						<button type="submit" class="btn btn-default">Submit</button>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
		
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>