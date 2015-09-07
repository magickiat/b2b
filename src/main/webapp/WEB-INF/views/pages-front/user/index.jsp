<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Backend</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>
	<div class="container">
		<%@include
			file="/WEB-INF/views/pages-front/include/common_header.jspf"%>
		<div class="row">
			<h2>Profile</h2>
			${ userForm.id }
			${ userForm.username }
		</div>
		<div class="row">
			<form:form servletRelativeAction="/frontend/user/edit" class="form-horizontal"
				commandName="userForm" method="post">
				<form:hidden path="id" class="form-control" value="${ userForm.id }"/>
				<form:input path="username"  class="form-control" value="${ userForm.username }"/>
				<form:password path="password"  class="form-control" value="${ userForm.password }"/>
				<form:password path="confirmPassword"  class="form-control" value="${ userForm.confirmPassword }"/>
				<form:input path="email"  class="form-control" value="${ userForm.email }"/>
				<button type="submit" class="btn btn-default">Submit</button>
			</form:form>
		</div>
		
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>