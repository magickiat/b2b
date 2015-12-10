<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Customer</title>
	<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
	
	<div class="container">
		<div class="row">
			<div class="col-sm-10">
				<h2>Customer</h2>
			</div>
			<div class="col-sm-2">
				<form:form servletRelativeAction="/backend/customer/create"
					method="get">
					<input type="submit" value="Add Customer"
						class="btn btn-default pull-right" />
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-hover table-striped" id="list_customer">
					<thead>
						<tr>
							<th>Code</th>
							<th>Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${resultPage.result }" var="customer">
							<c:url var="createUserUrl"
								value="/backend/customer/update?id=${ customer.custId }" />
							<tr style="cursor: pointer;"
								onclick="javascript:window.location.href = '${createUserUrl}'">
								<td>${customer.custCode }</td>
								<td>${customer.nameEn }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<!-- Base URL for pagination -->
		<c:set var="baseUrl" value="/backend/customer" />
		<%@include file="/WEB-INF/views/include/paging.jspf" %>

	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script type="text/javascript"
		src='<c:url value="/scripts/js_back_end/customer/search.js" />'></script>
</body>
</html>