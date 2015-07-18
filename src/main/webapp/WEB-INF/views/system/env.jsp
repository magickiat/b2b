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
<div>env = ${ evnData }</div>
	<div>Active Profile = ${ evnData['spring.profiles.active'] }</div>

	<hr />
	<div>
		<table>
			<thead>
				<tr>
					<th>User</th>
				</tr>
			</thead>
			<c:forEach items="${evnData['users']}" var="user">
				<tr>
					<td>${user.name }
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>