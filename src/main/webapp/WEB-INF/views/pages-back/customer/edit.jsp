<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>


	<div class="container">

		<div class="row">

			<div class="col-sm-12 bg_color">
				<div class="row row-header2 header2 txtupper">customer detail</div>


				<form:form servletRelativeAction="/backend/customer/update"
					class="form-horizontal" modelAttribute="customerForm" method="post">

					<form:errors path="*" cssClass="alert alert-danger" element="div" />

					<div class="form-group">
						<label class="control-label col-sm-2" for="code">Code:</label>
						<div class="col-sm-9">
							<form:input path="custCode" class="form-control"
								placeholder="Enter Code" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="name">Name:</label>
						<div class="col-sm-9">
							<form:input path="nameEn" class="form-control"
								placeholder="Enter Name" />
						</div>
						<form:hidden path="custId" />
					</div>

					<div class="form-group">
						<div class="col-sm-11"></div>
						<div class="col-sm-1">
							<button type="submit" class="btn btn-default pull-right">Save</button>
						</div>
					</div>

				</form:form>
			</div>
		</div>

		<hr />

		<div class="row">
			<div class="col-sm-12 bg_color">
				<div class="row">
					<div class=" col-sm-11">
						<div class="row row-header2 header2 txtupper">Login Account</div>
					</div>
					<div class="col-sm-1" style="margin-top: 10px;">
						<form:form servletRelativeAction="/backend/customer/createuser"
							class="form-horizontal" modelAttribute="customerForm"
							method="get">
							<form:hidden path="custId" />
							<button type="submit" class="btn btn-default pull-right">Add</button>
						</form:form>
					</div>
				</div>

				<div class="">
					<div class="bg_color">
						<table class="table table-hover" id="list_user">
							<thead>
								<tr>
									<th>No.</th>
									<th>User Name</th>
									<th>Email</th>
									<th>Active</th>
									<th>Active Time</th>
									<th>Function</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${users }" var="user" varStatus="rowNum">
									<tr style="cursor: pointer;"
										onclick="javascript:createUser('${user.id }');">
										<td>${ rowNum.index + 1 }</td>
										<td>${user.name }</td>
										<td>${ user.email }</td>
										<td>${user.enabled }</td>
										<td>${user.lastActive }</td>
										<td></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<hr />

		<%-- List Address --%>
		<div class="row">
			<div class="col-sm-12 bg_color">
				<div class="row">
					<div class=" col-sm-9">
						<div class="row row-header2 header2 txtupper">Address</div>
					</div>
					<div class="col-sm-3" style="margin-top: 10px;">
						<c:url var="addAddressUrl"
							value="/backend/customer/add_address?cusId=${ customerForm.custId }" />
						<button type="button" class="btn btn-default pull-right"
							onclick="javascript:window.location.href = '${addAddressUrl}'">Add
							Address</button>
					</div>
				</div>

				<div class="">
					<div class="bg_color">
						<c:forEach items="${listAddr }" var="addr">
							<%@include file="list_address.jspf"%>
						</c:forEach>
						<div class="col-sm-12">&nbsp;</div>
					</div>
				</div>
			</div>

		</div>

		<hr />
		<%-- List Contact --%>
		<div class="row">
			<div class="col-sm-12 bg_color">
				<div class="row">
					<div class=" col-sm-9">
						<div class="row row-header2 header2 txtupper">Contact</div>
					</div>
					<div class="col-sm-3" style="margin-top: 10px;">
						<c:url var="addContactUrl"
							value="/backend/customer/add_contact?cusId=${ customerForm.custId }" />
						<button type="button" class="btn btn-default pull-right"
							onclick="javascript:window.location.href = '${addContactUrl}'">Add
							Contact</button>
					</div>
				</div>
				<div class="bg_color">
					<c:forEach items="${listContact }" var="contact">
						<%@include file="list_contact.jspf"%>
					</c:forEach>
				</div>
				<div class="col-sm-12">&nbsp;</div>
			</div>

		</div>
		<hr />

		<%-- Product Brand --%>
		<div class="row">
			<div class="col-sm-12 bg_color">
				<div class="row">
					<div class=" col-sm-9">
						<div class="row row-header2 header2 txtupper">Product Brand</div>
					</div>
					<div class="col-sm-3" style="margin-top: 10px;">
						<form:form servletRelativeAction="/backend/customer/add_brand"
							method="get">
							<input type="hidden" name="id" value="${customerForm.custId}" />
							<input type="submit" value="Add Product Brand"
								class="btn btn-default pull-right" />
						</form:form>
					</div>
				</div>

				<div class="">
					<div class="col-sm-12 bg_color">
						<table class="table table-hover" id="list_brand">
							<thead>
								<tr>
									<th>No</th>
									<th>Product</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${ selectedBrand }" var="brand" varStatus="no">
									<tr>
										<td>${no.index + 1}</td>
										<td>${brand.productTypeName }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</div>

		</div>

	</div>

	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<script type="text/javascript"
		src='<c:url value="/scripts/js_back_end/customer/edit.js" />'></script>
</body>
</html>
