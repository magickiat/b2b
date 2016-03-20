<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<div class="col-md-12 bg_color">
					<div class="row row-header2 header2">User</div>

					<div>&nbsp;</div>

					<div class="row">
						<div class="col-md-3">

							<form:form id="searchForm" modelAttribute="searchForm"
								servletRelativeAction="/backend/order/search-action"
								method="get">
								<form:hidden path="page" />
								<div class="form-group">
									<label class="col-sm-3 control-label">SEARCH:</label>
									<div class="col-sm-9">
										<form:input path="keyword" cssClass="form-control" />
									</div>
								</div>
							</form:form>
						</div>

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
			<div class="row bg_color showline2">
				<div class="col-sm-12">
					<table class="table table-hover" id="list_user">
						<thead>
							<tr>
								<th>User Name</th>
								<th>Active</th>
								<th>Staff</th>
								<th>Company</th>
								<th>Active Timle</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${users.result }" var="user">
								<tr id="${user.id }" style="cursor: pointer;"
									onclick="editUser('${ user.customer.custId}', ${user.id })">
									<td>${user.name }</td>
									<td><c:choose>
											<c:when test="${user.enabled }">Yes</c:when>
											<c:otherwise>No</c:otherwise>
										</c:choose></td>
									<td><c:choose>
											<c:when test="${empty user.customer }">Yes</c:when>
											<c:otherwise>No</c:otherwise>
										</c:choose></td>
									<td><c:if test="${not empty user.customer }">
										${ user.customer.nameEn }
										</c:if></td>
									<td><fmt:formatDate pattern="dd-MM-yyyy HH:mm"
											value="${user.lastActive }" /></td>
								</tr>
							</c:forEach>
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
			if (custId) {
				window.location.href = '<c:url value="/backend/customer/edituser" />?userId='
						+ userId;
			}else{
				showDialog('Not implement yet for Staff');
			}
		}
	</script>
</body>
</html>
