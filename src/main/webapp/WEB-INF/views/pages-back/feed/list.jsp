<%--
  Created by IntelliJ IDEA.
  User: Ken
  Date: 9/30/2015
  Time: 12:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="/WEB-INF/views/include/common_meta.jspf" %>
		<title>Backend-List Feed Content</title>
		<%@include file="/WEB-INF/views/include/common_cssbackend.jspf" %>
	</head>
	<body>
		<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf" %>
		<!-- Base URL for pagination -->
		<c:set var="baseUrl" value="/backend/feed-contents"/>
		<div class="container">

			<div class="row">
				<div class="col-sm-10">
					<h2>Feed Content</h2>
				</div>
				<div class="col-sm-2">
					<form:form servletRelativeAction="/backend/feed-contents/create" method="get">
						<input type="submit" value="Add Feed Content"
						       class="btn btn-default pull-right"/>
					</form:form>
				</div>
				<%-- Upper Paging --%>
				<div class="row">
					<%@include file="/WEB-INF/views/include/paging.jspf" %>
				</div>
				<div class="row col-sm-12">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Subject</th>
								<th>Content</th>
								<th>Create Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${resultPage.result}" var="content">
								<tr>
									<td><a href="<c:url value="/news"/>?feedId=${content.id}&side=back">${content.title}</a></td>
									<td>
										<div class="clear-block">
											<div>${content.content}</div>
											<c:if test="${content.isMore}">
												<div class="feed-footer">
													<span class="read_more"><a href="<c:url value="/news"/>?feedId=${content.id}&side=back">Read more</a></span>
												</div>
											</c:if>
										</div>
									</td>
									<td>${content.timeCreate}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<%-- Lower Paging --%>
				<div class="row">
					<%@include file="/WEB-INF/views/include/paging.jspf" %>
				</div>
			</div>
		</div>
		<%@include file="/WEB-INF/views/include/common_js.jspf" %>
	</body>
</html>
