<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/views/include/common_meta.jspf" %>
        <title>Starboard Windsurfing</title>
        <%@include file="/WEB-INF/views/include/common_css.jspf" %>
    </head>
    <body>

        <%@include
            file="/WEB-INF/views/pages-front/include/common_header.jspf"%>

            <div class="container">

                <div class="row">
                    <img alt="step 1"
                         src='<c:url value="/images/pages-front/icon/step2.png" />'>
                </div>

                <div class="row">

                    <div class="col-md-12 bg_color">
                        <div class="row row-header2 header2">ADD PRODUCT</div>
                        <div class="row">&nbsp;</div>
                        <div class="row">

                            <c:choose>
                                <c:when test="${empty brandId }">
                                    <h3>Not found Brand.</h3>
                                </c:when>

                                <c:otherwise>
                                    <!-- Quick Order -->
                                    <div class="col-md-2" style="margin-top: 30px;">
                                        <a href='<c:url value="/frontend/order/step2/search?brand_id=${ brandId }" />'> <img alt="Quick Order"
                                                                                                                             src='<c:url value="/images/pages-front/icon/quick_order.png" />' />
                                        </a>
                                    </div>

                                    <!-- Upload Order -->
                                    <div class="col-md-2" style="margin-top: 30px; cursor: pointer;" data-toggle="modal" data-target="#upload-form">
                                        <img alt="Upload Order" src='<c:url value="/images/pages-front/icon/upload_order.png" />' />
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>

                        <div class="row">&nbsp;</div>

                    </div>
                </div>



            </div>
            <!-- UPLOAD FORM BEGIN -->
            <div id="upload-form" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3>Upload Order</h3>
                        </div>
                        <div class="modal-body">
                            <form id="upload-orders" action="<c:url value="/frontend/order/upload-orders"/>" method="post" enctype="multipart/form-data" role="form">
                                <div class="form-group">
                                    <label for="file">Select Excel Order:</label>
                                    <input type="file" name="file">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <div class="col-sm-6 text-left" style="padding: 0px;">
                                <a href="<c:url value="/frontend/order/download-template?brand_id=${brandId}"/>" title="download excel order template" class="btn btn-default">Download Excel Order</a>
                            </div>
                            <div class="col-sm-6 text-right" style="padding: 0px;">
                                <button type="button" class="btn btn-primary" role="upload">Upload</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- UPLOAD FROM END-->
            <%@include file="/WEB-INF/views/include/common_footer.jspf" %>
            <%@include file="/WEB-INF/views/include/common_js.jspf"%>
            <script src="<c:url value="/scripts/frontend/order/order.upload.js"/>"></script>
            <script>
                jQuery(document).ready(function () {
                    $('#upload-form button[role="upload"]').on('click', function (event) {
                        app.order.upload();
                    });
                });
            </script>
        </body>
    </html>
