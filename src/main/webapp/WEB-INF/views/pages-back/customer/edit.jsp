<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Edit Customer</title>
	<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
	
	
	<div class="container">
		
		<div class="row">
			<form:form servletRelativeAction="/backend/customer/update"
				class="form-horizontal" modelAttribute="customerForm" method="post">
				<form:errors path="*" cssClass="alert alert-danger" element="div" />
				<div>${msg }</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="code">Code:</label>
					<div class="col-sm-4">
						<form:input path="custCode" class="form-control"
							placeholder="Enter Code" />
					</div>
					<label class="control-label col-sm-2" for="name">Name:</label>
					<div class="col-sm-4">
						<form:input path="nameEn" class="form-control"
							placeholder="Enter Name" />
					</div>
					<form:hidden path="custId" />
				</div>
				<div class="form-group">
					<div class="col-sm-11"></div>
					<div class="col-sm-1">
						<button type="submit" class="btn btn-default">Save</button>
					</div>
				</div>
			</form:form>
		</div>

		<hr />

		<div class="row">
			<div class="form-group" style="background-color: blue;">
				<label class="control-label col-sm-11">Login Account</label>
				<div class="col-sm-1">
					<form:form servletRelativeAction="/backend/customer/createuser"
						class="form-horizontal" modelAttribute="customerForm" method="get">
						<form:hidden path="custId" />
						<button type="submit" class="btn btn-default">Add</button>
					</form:form>
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
						<th>Active Time</th>
						<th>Function</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users }" var="user">
						<tr style="cursor: pointer;"
							onclick="javascript:createUser('${user.id }');">
							<td>${user.name }</td>
							<td>${user.password }</td>
							<td>${user.password }</td>
							<td>${user.enabled }</td>
							<td></td>
							<td>${user.timeCreate }</td>
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<hr />
		<%-- List Address --%>
		<div class="row">
			<div class="col-sm-10">
				<b>Address</b>
			</div>
			
		</div>
		<div class="row">
			<c:forEach items="${listAddr }" var="addr">
				<%@include file="list_address.jspf"%>
			</c:forEach>
			<div>
				<c:url var="addAddressUrl" value="/backend/customer/add_address?cusId=${ customerForm.custId }" />
				<button type="button" onclick="javascript:window.location.href = '${addAddressUrl}'">Add Address</button>
			</div>
		</div>
		
		<hr/>
		<%-- List Contact --%>
		<div class="row">
			<div class="col-sm-10">
				<b>Contact</b>
			</div>
			
		</div>
		<div class="row">
			<c:forEach items="${listContact }" var="contact">
				<%@include file="list_contact.jspf"%>
			</c:forEach>
			<div>
				<c:url var="addContactUrl" value="/backend/customer/add_contact?cusId=${ customerForm.custId }" />
				<button type="button" onclick="javascript:window.location.href = '${addContactUrl}'">Add Contact</button>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-10">
				<b>Product Brand</b>
			</div>
			<div class="col-sm-2">
				<form:form servletRelativeAction="/backend/customer/add_brand"
					method="get">
					<input type="hidden" name="id" value="${customerForm.custId}" />
					<input type="submit" value="Add Product Brand"
						class="btn btn-default pull-right" />
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-hover" id="list_user">
					<thead>
						<tr>
							<th>No</th>
							<th>Password</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ selectedBrand }" var="brand" varStatus="no">
							<tr>
								<td>${no.index + 1}</td>
								<td>${brand.name }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script type="text/javascript"
		src='<c:url value="/scripts/js_back_end/customer/edit.js" />'></script>
</body>
</html>
