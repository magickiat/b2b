<%--
  Created by IntelliJ IDEA.
  User: Thanakit Jumparuang
  Date: 11/22/2015
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Starboard Windsurfing</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/WEB-INF/views/include/common_css.jspf" %>
</head>

<body>
<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf" %>

	<div class="container">
	    <div class="row">
	    	<div class="col-md-12 bg_color">
	    		<div class="row row-header2 header2 txtupper">order report</div>
	    		<c:set var="orderId" value="${ orderReport.orderId }"/>
				<%@include file="/WEB-INF/views/include/export_report.jspf" %>
				<div class="row">&nbsp;</div>
	    	</div>
	    </div>
	    <div class="row">&nbsp;</div>
	    <div class="row">
	    	<div class="col-md-12 bg_color showline2">
	    		<%@include file="orderSummary.jspf" %>
	    	</div>
	    </div>
    </div>
    
    <%@include file="/WEB-INF/views/include/common_footer.jspf" %>
	<%@include file="/WEB-INF/views/include/common_js.jspf" %>
	
</body>
</html>
