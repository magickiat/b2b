<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Starboard Windsurfing</title>
	<link rel="stylesheet" href="<c:url value="/scripts/assets/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/scripts/assets/font-awesome/css/font-awesome.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/scripts/assets/css/form-elements.css"/>">
    <link rel="stylesheet" href="<c:url value="/scripts/assets/css/style.css"/>">
    <link rel="stylesheet" href="<c:url value="/scripts/assets/css/main.css"/>" >
    <link rel="stylesheet" href="<c:url value="/scripts/assets/css/icomoon.css"/>">
    <link rel="stylesheet" href="<c:url value="/scripts/assets/css/animate-custom.css"/>">
    <link rel="stylesheet" href="<c:url value="/scripts/assets/css/common_css.css"/>">
</head>
<body>
	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>

	<div id="headerwrap">
	     <header class="clearfix">
	         <h1><span class="icon icon-cart-checkout"></span></h1>
	         <p>Starboard Windsurfing</p>
	     </header>
	 </div>
	 
	 <div id="greywrap">
        <div class="row">
            <div class="col-lg-6 callout">
                <span class="icon icon-stack"></span>
                <h2>บทวิเคราะห์ ไมโครซอฟท์ยุคใหม่ กับยุทธศาสตร์ 3 ขา "สามเหลี่ยมเขยื้อนภูเขา"</h2>
                <p>
                	หลังจากที่ผมเขียนบทความ แอปเปิล vs กูเกิล -
					ความแตกต่างที่ลงลึกตั้งแต่ปรัชญารากฐานของบริษัท ไปเมื่อประมาณ 2
					สัปดาห์ก่อน มีหลายคอมเมนต์ที่ถามว่า "แล้วไมโครซอฟท์ล่ะเป็นอย่างไร"
					ตอบตามตรงคือผมก็ยังมองไม่ค่อยออกนักว่าที่ทางของไมโครซอฟท์อยู่ตรงไหนในโลกไอทียุคใหม่
					ตัวไมโครซอฟท์เองก็อยู่ระหว่างการเปลี่ยนผ่านครั้งใหญ่ อย่างไรก็ตาม
					ประจวบเหมาะกับที่ผมได้รับเชิญไปงานของไมโครซอฟท์ที่สิงคโปร์
					ผู้บริหารของไมโครซอฟท์พูดเรื่องนี้ให้ฟังพอดี
					ผมคิดว่าเห็นภาพของไมโครซอฟท์ชัดเจนขึ้น เลยมาสรุปให้อ่านกันครับ
                </p>
            </div>

            <div class="col-lg-6 callout">
                <span class="icon icon-eye"></span>
                <h2>พัฒนาการการเปิดเสรีอินเทอร์เน็ตไทย</h2>
                <p>
                	ประเทศไทยมีประวัติการเชื่อมต่ออินเทอร์เน็ตมายาวนานเป็นประเทศแรกๆ
					ในภูมิภาคเอเชียตะวันออกเฉียงใต้ตั้งแต่ยุคบุกเบิกโดยมหาวิทยาลัยต่างๆ
					จนกระทั่งมีการเชื่อมต่อโครงข่ายเป็นการถาวรและเป็นกิจลักษณะ
					โดยมีบริษัท เค เอส ซี คอมเมอร์เชียล อินเทอร์เน็ต จำกัด (KSC)
					เป็นผู้ให้บริการเชิงพาณิชย์รายแรกในไทยในปี พ.ศ. 2537
                </p>
            </div>
        </div>
    </div>
	
	<!-- 
	<div class="container">
		<div class="row">
			<div class="col-sm-7">
				<div class="row">
					<div>บทวิเคราะห์ ไมโครซอฟท์ยุคใหม่ กับยุทธศาสตร์ 3 ขา "สามเหลี่ยมเขยื้อนภูเขา"</div>
					<div>27/09/15 22:45</div>
					<div>
						หลังจากที่ผมเขียนบทความ แอปเปิล vs กูเกิล -
						ความแตกต่างที่ลงลึกตั้งแต่ปรัชญารากฐานของบริษัท ไปเมื่อประมาณ 2
						สัปดาห์ก่อน มีหลายคอมเมนต์ที่ถามว่า "แล้วไมโครซอฟท์ล่ะเป็นอย่างไร"
						ตอบตามตรงคือผมก็ยังมองไม่ค่อยออกนักว่าที่ทางของไมโครซอฟท์อยู่ตรงไหนในโลกไอทียุคใหม่
						ตัวไมโครซอฟท์เองก็อยู่ระหว่างการเปลี่ยนผ่านครั้งใหญ่ อย่างไรก็ตาม
						ประจวบเหมาะกับที่ผมได้รับเชิญไปงานของไมโครซอฟท์ที่สิงคโปร์
						ผู้บริหารของไมโครซอฟท์พูดเรื่องนี้ให้ฟังพอดี
						ผมคิดว่าเห็นภาพของไมโครซอฟท์ชัดเจนขึ้น เลยมาสรุปให้อ่านกันครับ
					</div>
				</div>
				<hr>
				<div class="row">
					<div>พัฒนาการการเปิดเสรีอินเทอร์เน็ตไทย</div>
					<div>25/09/15 20:15</div>
					<div>
						ประเทศไทยมีประวัติการเชื่อมต่ออินเทอร์เน็ตมายาวนานเป็นประเทศแรกๆ
						ในภูมิภาคเอเชียตะวันออกเฉียงใต้ตั้งแต่ยุคบุกเบิกโดยมหาวิทยาลัยต่างๆ
						จนกระทั่งมีการเชื่อมต่อโครงข่ายเป็นการถาวรและเป็นกิจลักษณะ
						โดยมีบริษัท เค เอส ซี คอมเมอร์เชียล อินเทอร์เน็ต จำกัด (KSC)
						เป็นผู้ให้บริการเชิงพาณิชย์รายแรกในไทยในปี พ.ศ. 2537
					</div>
				</div>
				<hr>
			</div>
			<div class="col-sm-5"><h3>Calendar</h3></div>
		</div>

	</div>
	 -->
	<script src="<c:url value="/scripts/assets/js/jquery-1.11.1.min.js"/>"></script>
    <script src="<c:url value="/scripts/assets/bootstrap/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/scripts/assets/js/jquery.backstretch.min.js"/>"></script>
    <script src="<c:url value="/scripts/assets/js/scripts.js"/>"></script>
    <!--[if lt IE 10]>
        <script src="<c:url value="/scripts/assets/js/placeholder.js"/>"></script>
    <![endif]-->
	<script>
		jQuery(document).ready(function() {
		 	$.backstretch("<c:url value="/scripts/assets/img/backgrounds/starboardbglogin.png"/>");
		 	$('#headerwrap').backstretch(["<c:url value="/scripts/assets/img/backgrounds/severne_windsurf_banner.jpg"/>"
					     	               , "<c:url value="/scripts/assets/img/backgrounds/2014_AIRUSH_BANNER.jpg"/>"
					     	               , "<c:url value="/scripts/assets/img/backgrounds/sup_banner.jpg"/>"
					     	               , "<c:url value="/scripts/assets/img/backgrounds/surf_banner.jpg"/>"
					     	               , "<c:url value="/scripts/assets/img/backgrounds/windsurf_banner.jpg"/>"
					     	               , "<c:url value="/scripts/assets/img/backgrounds/starboardbglogin.jpg"/>"
					     	               ], {duration: 4000, fade: 750});
		});
	</script>
</body>
</html>