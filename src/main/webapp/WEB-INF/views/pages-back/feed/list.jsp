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
                <tr>
                    <td>บทวิเคราะห์ ไมโครซอฟท์ยุคใหม่ กับยุทธศาสตร์ 3 ขา "สามเหลี่ยมเขยื้อนภูเขา"</td>
                    <td>หลังจากที่ผมเขียนบทความ แอปเปิล vs กูเกิล - ความแตกต่างที่ลงลึกตั้งแต่ปรัชญารากฐานของบริษัท
                        ไปเมื่อประมาณ 2
                        สัปดาห์ก่อน มีหลายคอมเมนต์ที่ถามว่า "แล้วไมโครซอฟท์ล่ะเป็นอย่างไร"
                        ตอบตามตรงคือผมก็ยังมองไม่ค่อยออกนักว่าที่ทางของไมโครซอฟท์อยู่ตรงไหนในโลกไอทียุคใหม่
                        ตัวไมโครซอฟท์เองก็อยู่ระหว่างการเปลี่ยนผ่านครั้งใหญ่ อย่างไรก็ตาม
                        ประจวบเหมาะกับที่ผมได้รับเชิญไปงานของไมโครซอฟท์ที่สิงคโปร์
                        ผู้บริหารของไมโครซอฟท์พูดเรื่องนี้ให้ฟังพอดี
                        ผมคิดว่าเห็นภาพของไมโครซอฟท์ชัดเจนขึ้น เลยมาสรุปให้อ่านกันครับ
                    </td>
                    <td>27/09/15 22:45</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

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