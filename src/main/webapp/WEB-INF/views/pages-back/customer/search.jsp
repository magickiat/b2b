<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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
			file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
		<div class="row">
			<div class="col-sm-11">
				<h2>Customer</h2>
			</div>
			<div class="col-sm-1">
				<form:form servletRelativeAction="/backend/customer/create" method="get">
					<input type="submit" value="Add Customer" class="btn btn-default"/>
				</form:form>
			</div>
		</div>
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Code</th>
						<th>Name</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${customers }" var="customer">
				<tr><td>${customer.code }</td><td>${customer.name }</td></tr>
				</c:forEach>
				</tbody>
			</table>
			
			
			
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>