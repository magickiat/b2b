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
			<div class="col-sm-12">
				<form:form name="searchForm"
					servletRelativeAction="/backend/contactus/search"
					modelAttribute="searchForm" cssClass="form form-horizontal"
					method="GET">

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
		</div>


		<c:choose>
			<c:when test="${ not empty resultPage.result }">


				<!-- Base URL for pagination -->
				<c:set var="baseUrl" value="/backend/contactus/search" />
				<div class="row">
					<%@include file="/WEB-INF/views/include/paging_submit.jspf"%>
				</div>

				<div class="row bg_color">

					<c:set var="rowBegin"
						value="${ (( resultPage.current - 1) * resultPage.pageSize) }"></c:set>


					<table class="table table-hover">
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
										<form id="${ contact.contactId }"
											action='<c:url value="/backend/contactus/delete" />'
											method="post">
											<input type="hidden" id="csrftoken_"
												name="${_csrf.parameterName}" value="${_csrf.token}" />

											<input type="hidden" name="id" value="${ contact.contactId }" />
											<input type="button" value="Delete"
												onclick="return confirm(${ contact.contactId });">


										</form>
									</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</c:when>
			<c:otherwise>
				<div class="rol">&nbsp;</div>
				<div class="row bg_color">
					<div class="col-sm-12">Not found contact us</div>
				</div>
			</c:otherwise>
		</c:choose>


	</div>

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>

	<script type="text/javascript">
		function confirm(id) {
			$('<div></div>').appendTo('body')
			  .html('<div><h6>Do you want to delete contact?</h6></div>')
			  .dialog({
				dialogClass : 'style1',
				modal : true,
				title : 'message',
				zIndex : 10000,
				autoOpen : true,
				width : 'auto',
				resizable : false,
				buttons : {
					Yes : function() {
						$('#' + id).submit();
						$(this).dialog("close");
					},
					No : function() {
						$(this).dialog("close");
					}
				},
				close : function(event, ui) {
					$(this).remove();
				}
			});
		}
	</script>
</body>
</html>
