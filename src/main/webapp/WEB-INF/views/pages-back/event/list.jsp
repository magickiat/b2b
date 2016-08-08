<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--
  Created by IntelliJ IDEA.
  User: Thanakit Jumparuang
  Date: 1/24/2016
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
	<!-- Base URL for pagination -->
	<c:set var="baseUrl" value="/backend/event" />

	<div class="container">

		<div class="col-md-12">
			<div class="row">
				<div class="">
					<div class="col-sm-12 bg_color showline2">
						<div class="row">
							<div class=" col-sm-9">
								<div class="row row-header2 header2 txtupper">Event</div>
							</div>
							<div class="col-sm-3" style="margin-top: 10px;">
								<form:form servletRelativeAction="/backend/event/create"
									method="get">
									<input type="submit" value="Add Event"
										class="btn btn-default pull-right" />
								</form:form>
							</div>
						</div>
					</div>
					
					<div class="">
						<div class="col-sm-12">
							<div class="row pull-right">
								<%-- Upper Paging --%>	
								<%@include file="/WEB-INF/views/include/paging.jspf"%>
							</div>
						</div>
					</div>
				
					<div class="col-sm-12 bg_color showline2">
						<div class="row">
							<div class="">
								
								<div class="col-sm-12">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>Subject</th>
												<th>Content</th>
												<th>Event Date</th>
												<th>Create Date</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${resultPage.result}" var="event">
												<tr>
													<td><a
														href="<c:url value="/event"/>?eventId=${event.id}&side=back">${event.title}</a></td>
													<td>
														<div class="clear-block">
															<div>${event.content}</div>
															<c:if test="${event.isMore}">
																<div class="feed-footer">
																	<span class="read_more">Read more</span> <span
																		class="read_more"><a
																		href="<c:url value="/event"/>?eventId=${event.id}&side=back">Read
																			more</a></span>
																</div>
															</c:if>
														</div>
													</td>
													<td>${event.timeEvent}</td>
													<td>${event.timeCreate}</td>
													<td style="width: 100px;">
														<div class="btn-group pull-right">
															<a type="button" class="btn btn-warning btn-xs"
																name="editBtn"
																href="<c:url value="/backend/event/edit/${event.id}"/>?currentPage=${resultPage.current}">Edit</a>
															<a type="button" class="btn btn-danger btn-xs"
																name="removeBtn"
																data-href="<c:url value="/backend/event/delete/${event.id}"/>?currentPage=${resultPage.current}"
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
					
					<div class="">
						<div class="col-sm-12">
							<div class="row pull-right">
								<%-- Upper Paging --%>	
								<%@include file="/WEB-INF/views/include/paging.jspf"%>
							</div>
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
				<div class="modal-body">Are you sure to delete this event?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<a class="btn btn-danger btn-ok">Delete</a>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<script type="text/javascript">
		$('#confirm-delete').on(
				'show.bs.modal',
				function(e) {
					$(this).find('.btn-ok').attr('href',
							$(e.relatedTarget).data('href'));
				});
	</script>
</body>
</html>

