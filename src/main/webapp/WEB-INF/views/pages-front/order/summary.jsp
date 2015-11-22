<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Starboard Windsurfing</title>
    <%@include file="/WEB-INF/views/include/common_css.jspf" %>
    <link rel="stylesheet" href="<c:url value="/scripts/assets/datepicker/bootstrap-datetimepicker.css"/>" media="screen">
</head>
<body>
<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf" %>

<div class="container">

    <div class="row">
        <div class="col-md-12 bg_color">
            <div class="row row-header2 header2 txtupper">Order Summary</div>
            <!-- Search section -->
            <div>
                <form:form id="orderSummaryForm"
                           modelAttribute="orderSummaryForm"
                           servletRelativeAction="/frontend/order/summary/search-action"
                           method="get">
                    <%-- Search criteria row 1--%>
                    <div class="row">
                        <div class="col-md-3">
                            SEARCH:
                            <form:input path="keyword"/>
                        </div>
                        <div class="col-md-2">
                            <div class="form-group">
                                <form:select path="selectedBrand" cssClass="form-control" multiple="false">
                                    <form:option value="" label="ALL BRAND"/>
                                    <form:options items="${productType}" itemLabel="productTypeName" itemValue="productTypeId"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="form-group">
                                <form:select path="selectedStatus" cssClass="form-control" multiple="false">
                                    <form:option value="" label="ALL STATUS"/>
                                    <form:options items="${orderStatus}" itemLabel="orderStatusName" itemValue="orderStatusId"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <button class="btn btn-success" onclick="searchOrder()">Search</button>
                            <button class="btn btn-success">Excel</button>
                        </div>
                        <div class="col-md-2">&nbsp;</div>
                    </div>
                    <%-- Search criteria row 2--%>
                    <div class="row">
                        <div class="col-md-3">
                            <label for="dateFromPicker">FROM:</label>
                            <div id="dateFromPicker" class="input-group date">
                                <form:input path="dateFrom" cssClass="form-control"/>
                               <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label for="dateToPicker">TO:</label>
                            <div id="dateToPicker" class="input-group date">
                                <form:input path="dateTo" cssClass="form-control"/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                        <div class="col-md-6">&nbsp;</div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    <div class="row">&nbsp;</div>
    <%-- Order detail section --%>
    <div class="row">
        <div class="col-md-12 bg_color">
            <%-- Upper Paging --%>
            <div class="">
                <%@include file="step2_include/search_product_paging.jspf" %>
            </div>
            <div class="row row-header2 header2 txtupper">Latest Features</div>
            <%-- List product model --%>
            <c:choose>
                <c:when test="${ searchProductForm.showType == 'image' }">
                    <%@include file="step2_include/product_image.jspf" %>
                </c:when>
                <c:otherwise>
                    <%@include file="step2_include/product_list.jspf" %>
                </c:otherwise>
            </c:choose>

            <%-- Lower Paging --%>
            <div class="">
                <%@include file="step2_include/search_product_paging.jspf" %>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/include/common_js.jspf" %>
<script src="<c:url value="/scripts/assets/js/jquery.backstretch.min.js"/>"></script>
<script src="<c:url value="/scripts/assets/datepicker/moment-with-locales.js"/>"></script>
<script src="<c:url value="/scripts/assets/datepicker/bootstrap-datetimepicker.js"/>"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $.backstretch("<c:url value="/scripts/assets/img/backgrounds/starboardbglogin.png"/>");
        var dateFromPicker = $('#dateFromPicker');
        var dateToPicker = $('#dateToPicker');
        dateFromPicker.datetimepicker({ locale: 'th', format: 'DD/MM/YYYY' });
        dateToPicker.datetimepicker({ locale: 'th', format: 'DD/MM/YYYY', useCurrent: false});
        dateFromPicker.on("dp.change", function (e) {
            $('#dateToPicker').data("DateTimePicker").minDate(e.date);
        });
        dateToPicker.on("dp.change", function (e) {
            $('#dateFromPicker').data("DateTimePicker").maxDate(e.date);
        });
    });

    /**
     * Search order
     **/
    function searchOrder() {
        $('#orderSummaryForm').submit();
    }
</script>
</body>
</html>
