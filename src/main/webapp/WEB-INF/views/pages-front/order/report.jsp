<%--
  Created by IntelliJ IDEA.
  User: Thanakit Jumparuang
  Date: 11/22/2015
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Order Report</title>
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
        <!-- Header -->
        <div class="col-md-12 bg_color">
            <span>${orderDetails.orderCode}</span> <span>${orderDetails.orderStatus}</span><br/>
            <fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${orderDetails.orderDate}" />
        </div>
        <!-- Order info -->
        <div class="col-md-12 bg_color">
            <table class="table table-hover table-list">
                <thead>
                <tr>
                    <td>Order Number</td>
                    <td>Payment Method</td>
                    <td>Shipping Type</td>
                    <td>Order Status</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${orderDetails.orderCode}</td>
                    <td>${orderDetails.paymentMethod}</td>
                    <td>${orderDetails.shippingType}</td>
                    <td>${orderDetails.orderStatus}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <!-- Order Address detail -->
        <div class="col-md-12 bg_color">
            <table class="table table-hover table-list">
                <tr>
                    <td>
                        Dispatch to:
                        <span>${orderDetails.dispatchToAddress.orderAddr} <br/>Tel: ${orderDetails.dispatchToAddress.orderTel}  Fax: ${orderDetails.dispatchToAddress.fax}</span>
                    </td>
                    <td>
                        Invoice to:
                        <span>${orderDetails.invoiceToAddress.orderAddr} <br/>Tel: ${orderDetails.invoiceToAddress.orderTel}  Fax: ${orderDetails.invoiceToAddress.fax}</span>
                    </td>
                </tr>
            </table>
        </div>
        <!-- Order detail -->
        <div class="col-md-12 bg_color">
            <table class="table table-hover table-list">
                <thead>
                <tr>
                    <th>No</th>
                    <th>Product Code</th>
                    <th>Description</th>
                    <th>Qty</th>
                    <th>UOM</th>
                    <th>Unit Price</th>
                    <th>Amount</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ orderDetails.orderDetails }" var="ordDetail" varStatus="rowNum">

                    <tr>
                        <td>${ rowNum.index + 1 }</td>
                        <td>${ ordDetail.productCode }</td>
                        <td>${ ordDetail.productName }</td>
                        <td>${ ordDetail.amount }</td>
                        <td>${ ordDetail.productUnit }</td>
                        <td>
                            <fmt:formatNumber
                                pattern="#,###" maxIntegerDigits="12"
                                value="${ ordDetail.unitPrice }">
                            </fmt:formatNumber>
                        </td>
                        <td>
                            <fmt:formatNumber
                                    pattern="#,###" maxIntegerDigits="12"
                                    value="${ ordDetail.amount * ordDetail.unitPrice }">
                            </fmt:formatNumber>
                        </td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- Customer remark -->
        <div class="col-md-12 bg_color">
        </div>
    </div>
    </div>
    
    <%@include file="/WEB-INF/views/include/common_footer.jspf" %>
	<%@include file="/WEB-INF/views/include/common_js.jspf" %>
	<script src="<c:url value="/scripts/assets/js/jquery-1.11.1.min.js"/>"></script>
	<script src="<c:url value="/scripts/assets/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/scripts/assets/js/jquery.backstretch.min.js"/>"></script>
	<script>
		jQuery(document).ready(function() {
		 	$.backstretch("<c:url value="/scripts/assets/img/backgrounds/starboardbglogin.png"/>");
		});
	</script>
</body>
</html>
