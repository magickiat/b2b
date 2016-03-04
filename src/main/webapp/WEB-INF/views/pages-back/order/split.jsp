<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>


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
		<input type="hidden" id="orderDetailId" value="${orderDetail.orderDetailId }" />
		<input type="hidden" id="orderId" value="${orderDetail.orderId }" />
		<input type="hidden" id="amount" value="${orderDetail.amount }" />

		<div class="row bg_color">

			<div class="col-sm-12">
				<label for="splitNum">Split Product To :</label>
				<input type="text" id="splitNum" class="numberOnly" />
				<input type="button" id="btnSplit" value="Split" onclick="split()" />
			</div>

		</div>

		<div id="order-details">
			
		</div>


	</div>

	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>


	<script type="text/javascript">
		$(document).ready(function() {

		});
		
		function split(){
			var num = $('#splitNum').val();
			console.log('split to ' + num + ' line');
			
			var amount = $('#amount').val();
			console.log('amount = ' + amount);
			
			if(num > amount){
				showDialog('Split number must not over that ' + amount);
				return;
			}
			
			if(num < 1){
				showDialog('Split number must over than zero');
				return;
			}
			
			var splitArea = $('#order-details');
			splitArea.html('');
			
			var row = '<div class="row">';
			row += '<table>';
			
			for(var i = 0; i < num; i++){
				
				row += '<tr>';
				row += '</tr>';
				
			}
			
			row += '</table>';
			row += '</div>';
			splitArea.append('</div>');
		}
	</script>
</body>
</html>
