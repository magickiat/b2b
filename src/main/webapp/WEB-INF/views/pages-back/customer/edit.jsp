<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Customer</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>
	<div class="container">
	<%@include
			file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
		<div class="row">
			<form:form servletRelativeAction="/backend/customer/update" class="form-horizontal"
				commandName="customerForm" method="post">
	
				<div class="form-group">
					<label class="control-label col-sm-2" for="code">Code:</label>
					<div class="col-sm-4">
						<form:input path="code" class="form-control"
							placeholder="Enter Code" />
					</div>
					<label class="control-label col-sm-2" for="name">Name:</label>
					<div class="col-sm-4">
						<form:input path="name" class="form-control"
							placeholder="Enter Name" />
					</div>
					<form:hidden path="id" id="cusId"/>
				</div>
				<div class="form-group">
					<div class="col-sm-11">
					</div>
					<div class="col-sm-1">
						<button type="submit" class="btn btn-default">Save</button>
					</div>
				</div>
			</form:form>
			<hr>
		</div>
		<div class="row">
			<div class="form-group" style="background-color: blue;">
				<label class="control-label col-sm-11">Login Account</label>
				<div class="col-sm-1">
						<button type="buuton" class="btn btn-default" onclick="javascript:createUser('${customer.id }');">Add</button>
				</div>
			</div>
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
							<td>${user.name }</td>
							<td>${user.name }</td>
							<td>${user.name }</td>
							<td>${user.name }</td>
							<td>${user.name }</td>
							<td>${user.name }</td>
							<td>${user.name }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script type="text/javascript"
		src='<c:url value="/scripts/js_back_end/customer/edit.js" />'></script>
</body>
</html>