<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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


		<div class="col-md-12">

			<div class="row">

				<div class="col-sm-12 bg_color showline2">
					<div class="row row-header2 header2 txtupper">customer detail</div>


					<form:form servletRelativeAction="/backend/customer/update" class="form-horizontal"
						modelAttribute="customerForm" method="post">

						<form:errors path="*" cssClass="alert alert-danger" element="div" />

						<div class="form-group">
							<label class="control-label col-sm-2" for="code">Code:</label>
							<div class="col-sm-9">
								<c:set var="code" value="${ fn:split(customerForm.custCode, '-') }"></c:set>
								<input type="text" name="custCode" class="form-control" readonly="readonly" value="${code[0]}-${code[1]}" />
								<%-- <form:input path="custCode" class="form-control" placeholder="Enter Code" readonly="true" /> --%>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2" for="name">Name:</label>
							<div class="col-sm-9">
								<form:input path="nameEn" class="form-control" placeholder="Enter Name" readonly="true" />
							</div>
							<form:hidden path="custId" />
						</div>

						<div class="form-group">
							<div class="col-sm-11"></div>
							<div class="col-sm-1">
								<!-- <button type="submit" class="btn btn-default pull-right">Save</button> -->
							</div>
						</div>

					</form:form>
				</div>
			</div>

			<hr />

			<div class="row">
				<div class="col-sm-12 bg_color showline2">
					<div class="row">
						<div class=" col-sm-11">
							<div class="row row-header2 header2 txtupper">Login Account</div>
						</div>
						<div class="col-sm-1" style="margin-top: 10px;">
							<form:form servletRelativeAction="/backend/customer/createuser" class="form-horizontal"
								modelAttribute="customerForm" method="get">
								<form:hidden path="custId" />
								<button type="submit" class="btn btn-default pull-right">Add</button>
							</form:form>
						</div>
					</div>

					<div class="">
						<div class="">
							<table class="table table-hover" id="list_user">
								<thead>
									<tr>
										<th>No.</th>
										<th>Account</th>
										<th>User Name</th>
										<th>Email</th>
										<th>Active</th>
										<th>Active Time</th>
										<th style="text-align: right;"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${users }" var="user" varStatus="rowNum">
										<tr>
											<td>${ rowNum.index + 1 }</td>
											<td>${ user.username }
											<td>${ user.name }</td>
											<td>${ user.email }</td>
											<td>
												<c:choose>
													<c:when test="${user.enabled }">Yes</c:when>
													<c:otherwise>No</c:otherwise>
												</c:choose>
											</td>
											<td>${user.lastActive }</td>
											<td>
												<div class="btn-group pull-right">
													<a type="button" class="btn btn-warning btn-xs"
														href="<c:url value="/backend/customer/edituser?userId=${ user.id }" />">Edit</a>
													<a type="button" class="btn btn-danger btn-xs"
														data-href="<c:url value="/backend/customer/deleteuser?userId=${ user.id }"/>"
														data-toggle="modal" data-target="#confirm-delete">Delete</a>
												</div>
											</td>
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
				<div class="col-sm-12 bg_color showline2">
					<div class="row">
						<div class=" col-sm-9">
							<div class="row row-header2 header2 txtupper">Address</div>
						</div>
						<div class="col-sm-3" style="margin-top: 10px;">
							<c:url var="addAddressUrl"
								value="/backend/customer/add_address?cusId=${ customerForm.custId }" />
							<button type="button" class="btn btn-default pull-right"
								onclick="javascript:window.location.href = '${addAddressUrl}'">Add Address</button>
						</div>
					</div>

					<div class="">
						<div class="">
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
				<div class="col-sm-12 bg_color showline2">
					<div class="row">
						<div class=" col-sm-9">
							<div class="row row-header2 header2 txtupper">Contact</div>
						</div>
						<div class="col-sm-3" style="margin-top: 10px;">
							<c:url var="addContactUrl"
								value="/backend/customer/add_contact?cusId=${ customerForm.custId }" />
							<button type="button" class="btn btn-default pull-right"
								onclick="javascript:window.location.href = '${addContactUrl}'">Add Contact</button>
						</div>
					</div>
					<div class="">
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
				<div class="col-sm-12 bg_color showline2">
					<div class="row">
						<div class=" col-sm-9">
							<div class="row row-header2 header2 txtupper">Product Brand</div>
						</div>
						<div class="col-sm-3" style="margin-top: 10px;">
							<form:form servletRelativeAction="/backend/customer/add_brand" method="get">
								<input type="hidden" name="id" value="${customerForm.custId}" />
								<input type="submit" value="Add Product Brand" class="btn btn-default pull-right" />
							</form:form>
						</div>
					</div>

					<div class="">
						<div class="col-sm-12 ">
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

	</div>
	<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">Confirm delete?</div>
				<div class="modal-body">Are you sure to delete this user?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<a class="btn btn-danger btn-ok">Delete</a>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<script type="text/javascript" src='<c:url value="/scripts/js_back_end/customer/edit.js" />'></script>
	<script>
		$('#confirm-delete').on(
				'show.bs.modal',
				function(e) {
					$(this).find('.btn-ok').attr('href',
							$(e.relatedTarget).data('href'));
				});
		
		$('.date-picker').datetimepicker({
			locale : 'en',
			format : 'YYYY-MM-DD'
		});
	</script>
</body>
</html>
