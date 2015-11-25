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
                        	<div class="form-group">
							    <label class="col-sm-3 control-label">SEARCH:</label>
							    <div class="col-sm-9">
							      <form:input path="keyword" cssClass="form-control"/>
							    </div>
							</div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <form:select path="selectedBrand" cssClass="form-control" multiple="false" onchange="loadBuyerGroup()">
                                    <form:option value="" label="ALL BRAND"/>
                                    <form:options items="${productType}" itemLabel="productTypeName" itemValue="productTypeId"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <form:select path="selectedStatus" cssClass="form-control" multiple="false">
                                    <form:option value="" label="ALL STATUS"/>
                                    <form:options items="${orderStatus}" itemLabel="orderStatusName" itemValue="orderStatusId"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <button class="btn btn-success" onclick="searchOrder()" style="width: 100px;">Search</button>
                            <button class="btn btn-default" style="width: 100px;">Excel</button>
                        </div>
                    </div>
                    <%-- Search criteria row 2--%>
                    <div class="row">
                        <div class="col-md-3">
                            <div class="form-group">
							    <label class="col-sm-3 control-label" for="dateFromPicker">FROM/TO:</label>
							    <div class="col-sm-9">
							      	<div id="dateFromPicker" class="input-group date">
		                                <form:input path="dateFrom" cssClass="form-control" />
		                               	<span class="input-group-addon">
		                                    <span class="glyphicon glyphicon-calendar"></span>
		                                </span>
		                            </div>
							    </div>
							</div>
                        </div>
                        <div class="col-md-2">
                            <div id="dateToPicker" class="input-group date">
                                <form:input path="dateTo" cssClass="form-control" />
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                        <div class="col-md-7">&nbsp;</div>
                    </div>
                    <hr>
                </form:form>
            </div>
        </div>
    </div>
    <div class="row">&nbsp;</div>
    <%-- Order detail section --%>
    <div class="row">
        <div class="col-md-12 bg_color showline2">
            <%-- Upper Paging --%>
            <div class="">
                <%@include file="step2_include/search_product_paging.jspf" %>
            </div>
            <%-- List order model --%>
                <%@include file="step2_include/order_summary_list.jspf"%>
            <%-- Lower Paging --%>
            <div class="">
                <%@include file="step2_include/search_product_paging.jspf" %>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/include/common_footer.jspf" %>
<%@include file="/WEB-INF/views/include/common_js.jspf" %>

<script src="<c:url value="/scripts/assets/js/jquery.backstretch.min.js"/>"></script>
<script src="<c:url value="/scripts/assets/datepicker/moment-with-locales.js"/>"></script>
<script src="<c:url value="/scripts/assets/datepicker/bootstrap-datetimepicker.js"/>"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $.backstretch("<c:url value="/scripts/assets/img/backgrounds/starboardbglogin.png"/>");
        var dateFromPicker = $('#dateFromPicker');
        var dateToPicker = $('#dateToPicker');
        dateFromPicker.datetimepicker({locale: 'th', format: 'YYYY-MM-DD'});
        dateToPicker.datetimepicker({locale: 'th', format: 'YYYY-MM-DD', useCurrent: false});
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

    function loadBuyerGroup(){
        $('#orderSummaryForm').submit();
    }
</script>
</body>
</html>
