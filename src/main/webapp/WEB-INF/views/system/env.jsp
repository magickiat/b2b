<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Environment</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>
	<div class="container">
		<div>
			<h2>
				<small>Active Profile =</small> ${ evnData['spring.profiles.active'] }
			</h2>
		</div>

		<hr />
		<div>
			<table class="table table-bordered table-hover ">
				<thead>
					<tr>
						<th>ID</th>
						<th>User</th>
					</tr>
				</thead>
				<c:forEach items="${evnData['users']}" var="user">
					<tr>
						<td>${user.id }</td>
						<td>${user.name }
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>