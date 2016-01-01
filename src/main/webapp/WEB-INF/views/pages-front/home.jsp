<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="/WEB-INF/views/include/common_meta.jspf" %>
		<title>Starboard Windsurfing</title>
		<%@include file="/WEB-INF/views/include/common_css.jspf" %>
	</head>
	<body>
		<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf" %>
		<!-- Base URL for pagination -->
		<c:set var="baseUrl" value="/frontend"/>
		<div class="container">
			<div class="row">
				<div class="col-md-8 bg_color showline">
					<c:choose>
						<c:when test="${fn:length(resultPage.result) gt 1}">
							<%-- Upper Paging --%>
							<%@include file="/WEB-INF/views/include/paging.jspf" %>
							<div class="row">
								<c:forEach items="${resultPage.result}" var="content">
									<div class="clear-block">
										<div class="row-header header1"><a href="<c:url value="/news"/>?feedId=${content.id}">${content.title}</a></div>
										<div>${content.timeCreate}</div>
										<div>${content.content}</div>
										<hr>
										<c:if test="${content.isMore}">
											<div class="feed-footer">
												<span class="read_more"><a href="<c:url value="/news"/>?feedId=${content.id}&side=back">Read more</a></span>
											</div>
										</c:if>
									</div>
								</c:forEach>
							</div>
							<%-- Lower Paging --%>
							<%@include file="/WEB-INF/views/include/paging.jspf" %>
						</c:when>
						<c:otherwise>
							<div class="row">
								<div class="row-header header1">There is no available news.</div>
								<div style="min-height: 250px;"></div>
							</div>
						</c:otherwise>
					</c:choose>

				</div>
				<div class="col-md-4 bg_color showline">
					<div class="row row-header header1">CALENDAR</div>
					<div style="min-height: 300px;"></div>
				</div>
			</div>
		</div>
		<%@include file="/WEB-INF/views/include/common_footer.jspf" %>
		<%@include file="/WEB-INF/views/include/common_js.jspf" %>
	</body>
</html>
