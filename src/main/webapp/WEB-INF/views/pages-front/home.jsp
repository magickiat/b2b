<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Starboard Windsurfing</title>
    <%@include file="/WEB-INF/views/include/common_css.jspf" %>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf" %>
	
	<div class="container">
		
		<div class="row">
			<div class="col-md-8 bg_color showline">
				<div class="row row-header header1">พัฒนาการการเปิดเสรีอินเทอร์เน็ตไทย</div>
				    <p class="">
				        <div>25/09/15 20:15</div>
				        <div>
						            ประเทศไทยมีประวัติการเชื่อมต่ออินเทอร์เน็ตมายาวนานเป็นประเทศแรกๆ
						            ในภูมิภาคเอเชียตะวันออกเฉียงใต้ตั้งแต่ยุคบุกเบิกโดยมหาวิทยาลัยต่างๆ
						            จนกระทั่งมีการเชื่อมต่อโครงข่ายเป็นการถาวรและเป็นกิจลักษณะ โดยมีบริษัท เค เอส ซี คอมเมอร์เชียล อินเทอร์เน็ต
						            จำกัด (KSC) เป็นผู้ให้บริการเชิงพาณิชย์รายแรกในไทยในปี พ.ศ. 2537
				        </div>
				    </p>
				<hr>
				<div class="row row-header header1">บทวิเคราะห์ ไมโครซอฟท์ยุคใหม่ กับยุทธศาสตร์ 3 ขา "สามเหลี่ยมเขยื้อนภูเขา"</div>
				<p class="">
			        <div>27/09/15 22:45</div>
			        <div>
					            หลังจากที่ผมเขียนบทความ แอปเปิล vs กูเกิล - ความแตกต่างที่ลงลึกตั้งแต่ปรัชญารากฐานของบริษัท ไปเมื่อประมาณ 2
					            สัปดาห์ก่อน มีหลายคอมเมนต์ที่ถามว่า "แล้วไมโครซอฟท์ล่ะเป็นอย่างไร"
					            ตอบตามตรงคือผมก็ยังมองไม่ค่อยออกนักว่าที่ทางของไมโครซอฟท์อยู่ตรงไหนในโลกไอทียุคใหม่
					            ตัวไมโครซอฟท์เองก็อยู่ระหว่างการเปลี่ยนผ่านครั้งใหญ่ อย่างไรก็ตาม
					            ประจวบเหมาะกับที่ผมได้รับเชิญไปงานของไมโครซอฟท์ที่สิงคโปร์ ผู้บริหารของไมโครซอฟท์พูดเรื่องนี้ให้ฟังพอดี
					            ผมคิดว่าเห็นภาพของไมโครซอฟท์ชัดเจนขึ้น เลยมาสรุปให้อ่านกันครับ
			        </div>
			    </p>
			    <hr>
			</div>
			<div class="col-md-4 bg_color showline">
				<div class="row row-header header1">CALENDAR</div>
				<div style="min-height: 300px;">
				</div>
			</div>
		</div>
	</div>
	
	
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