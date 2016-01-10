<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title>Starboard Windsurfing</title>
<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>

	<div class="container">

		<div class="row">
			<div class="col-sm-12">
				<h2>Contact us</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-12 text-right">
				<form action='<c:url value="/backend/contactus/add" />'>
					<input type="submit" class="btn btn-default" value="ADD" />
				</form>
			</div>
		</div>


		<div class="row">
			<div class="col-sm-12">&nbsp;</div>
		</div>


		<div class="row bg_color">

			<form:form name="searchForm"
				servletRelativeAction="/backend/contactus/search"
				modelAttribute="searchForm" cssClass="form-horizontal" method="GET">

				<%-- for paging --%>
				<form:hidden path="page" />


				<div class="col-sm-12">
					<div class="col-sm-1">Search:</div>
					<div class="col-sm-5">
						<input type="text" id="keyword" name="keyword"
							class="form-control" />
					</div>

					<div class="col-sm-6">
						<input type="button" class="btn btn-success" value="SEARCH" />
					</div>
				</div>

			</form:form>
		</div>


		<!-- Base URL for pagination -->
		<c:set var="baseUrl" value="/backend/contactus/search" />
		<div class="row">
			<%@include file="/WEB-INF/views/include/paging_submit.jspf"%>
		</div>

		<div class="row bg_color">

			<c:set var="rowBegin"
				value="${ (( resultPage.current - 1) * resultPage.pageSize) }"></c:set>


			<div class="col-sm-12">
				<c:choose>
					<c:when test="${ not empty resultPage.result }">

						<table class="table">
							<thead>

								<tr>
									<th>No.</th>
									<th>Title</th>
									<th>Name</th>
									<th>Email</th>
									<th>Detail</th>
									<th>Tel</th>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody>


								<c:forEach items="${ resultPage.result }" var="contact"
									varStatus="rowNum">

									<tr>
										<td>${ rowBegin + (rowNum.index + 1) }</td>
										<td>${ contact.contactTitle }</td>
										<td>${ contact.contactName }</td>
										<td>${ contact.contactEmail }</td>
										<td>${ contact.contactDetail }</td>
										<td>${ contact.contactTel }</td>
										<td>
											<form></form>
										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>


					</c:when>
					<c:otherwise>
						Not found contact us
					</c:otherwise>
				</c:choose>


			</div>
		</div>

	</div>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
</body>
</html>
