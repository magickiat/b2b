<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
				<div class="col-md-12 bg_color showline2">
					<div class="row col-md-6 row-header2 header2 txtupper">User</div>
					<div class="" style="margin-top:10px;">
						<a class="btn btn-default pull-right" href='<c:url value="/backend/user/create-staff" />'>
							Create Staff User
						</a>
					</div>
					<div class="col-sm-12">&nbsp;</div>
					
					<div class="row col-sm-12">

						<form:form id="searchForm" modelAttribute="searchForm" cssClass="form form-horizontal"
							servletRelativeAction="/backend/user/search-action" method="get">
							<form:hidden path="page" />
							
							<div class="col-md-6">
								<div class="form-group">
									<label class="col-sm-2 control-label">SEARCH:</label>
									<div class="col-sm-10">
										<form:input path="keyword" cssClass="form-control" />
									</div>
								</div>
							</div>
							
							<div class="col-md-6">
								<input type="submit" class="btn btn-success pull-right" value="Search" />
							</div>
							
						</form:form>
						
					</div>
				
				</div>
				<%-- <div class="col-sm-2">
					<form:form servletRelativeAction="/backend/customer/create"
						method="get">
						<input type="submit" value="Add Customer"
							class="btn btn-default pull-right" />
					</form:form>
				</div> --%>
			</div>
			<div class="row">&nbsp;</div>

			<!-- Base URL for pagination -->
			<c:set var="baseUrl" value="/backend/user/search-action" />
			<div class="row">
				<%@include file="/WEB-INF/views/include/paging.jspf"%>
			</div>

			<div class="row bg_color showline2">
				<div class="col-sm-12">
					<table class="table table-hover" id="list_user">
						<thead>
							<tr>
								<th width="5%">No.</th>
								<th width="10%">Account</th>
								<th width="15%">User Name</th>
								<th width="20%">Email</th>
								<th width="5%">Active</th>
								<th width="5%">Staff</th>
								<th width="25%">Company</th>
								<th width="15%">Active Time</th>
							</tr>
						</thead>
						<tbody>

							<c:choose>
								<c:when test="${ empty resultPage.result }">
									<tr>
										<td colspan="5">User not found</td>
									</tr>
								</c:when>
								<c:otherwise>

									<c:set var="rowBegin" value="${ (( resultPage.current - 1) * resultPage.pageSize) }"></c:set>


									<c:forEach items="${ resultPage.result }" var="user" varStatus="rowNum">
										<tr id="${user.id }" style="cursor: pointer;"
											onclick="editUser('${ user.customer.custId}', ${user.id })">
											<td nowrap="nowrap">${ rowBegin + (rowNum.index + 1) }</td>
											<td nowrap="nowrap">${ user.username }
											<td nowrap="nowrap">${ user.name }</td>
											<td nowrap="nowrap">${ user.email }</td>
											<td nowrap="nowrap">
												<c:choose>
													<c:when test="${user.enabled }">Yes</c:when>
													<c:otherwise>No</c:otherwise>
												</c:choose>
											</td>
											<td nowrap="nowrap">
												<c:choose>
													<c:when test="${empty user.customer }">Yes</c:when>
													<c:otherwise>No</c:otherwise>
												</c:choose>
											</td>
											<td nowrap="nowrap">
												<c:if test="${not empty user.customer }">${ user.customer.nameEn }</c:if>
											</td>
											<td nowrap="nowrap">
												<fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${user.lastActive }" />
											</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>


						</tbody>
					</table>
				</div>
			</div>

		</div>

	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>

	<script type="text/javascript">
		function editUser(custId, userId) {
			var baseUrl = '<c:url value="/backend/customer/edituser" />';
			
			if (!custId) {
				baseUrl = '<c:url value="/backend/user/edit-staff" />';
			}
			
			window.location.href = baseUrl + '?userId=' + userId;
		}
	</script>
</body>
</html>
