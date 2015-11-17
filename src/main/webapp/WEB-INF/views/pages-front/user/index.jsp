<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Starboard Windsurfing - Profile</title>
    <%@include file="/WEB-INF/views/include/common_css.jspf" %>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12 bg_color showline">
				<div class="row row-header header1">Profile</div>
			    <div>
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
		</div>
	</div>
	
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script src="<c:url value="/scripts/assets/js/jquery-1.11.1.min.js"/>"></script>
	<script src="<c:url value="/scripts/assets/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/scripts/assets/js/jquery.backstretch.min.js"/>"></script>
	<script>
		jQuery(document).ready(function() {
		 	$.backstretch("<c:url value="/scripts/assets/img/backgrounds/starboardbglogin.png"/>");
		});
	</script>
</body>
</html>