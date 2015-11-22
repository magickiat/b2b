<%--
  Created by IntelliJ IDEA.
  User: Ken
  Date: 9/30/2015
  Time: 12:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Backend</title>
    <%@include file="/WEB-INF/views/include/common_css.jspf" %>
</head>
<body>
<div class="container">
    <%@include
            file="/WEB-INF/views/pages-back/include/common_header.jspf" %>

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
								<td>${content.title }</td>
								<td>${content.content }</td>
								<td>${content.timeCreate }</td>
								 </tr>
						</c:forEach>
                    
               
                </tbody>
            </table>
        </div>
    </div>
		<!-- Base URL for pagination -->
		<c:set var="baseUrl" value="/backend/feed-contents" />
		<%@include file="/WEB-INF/views/include/paging.jspf" %>
</div>
<%@include file="/WEB-INF/views/include/common_js.jspf" %>
<script type="text/javascript">
    $(document).ready(function () {
        /*$('.nav li a').click(function (e) {

            $('.nav li').removeClass('active');

            var $parent = $(this).parent();
            if (!$parent.hasClass('active')) {
                $parent.addClass('active');
            }
            e.preventDefault();
        });*/
    });
</script>
</body>
</html>