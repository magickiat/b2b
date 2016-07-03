<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>

	<input type="hidden" id="currentProduct" value="${product.productId }" />

	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>

	<div class="container">
	
		<div class="col-md-12"> 
			
			<div class="row">
				<img src='<c:url value="/images/pages-front/icon/step2.png" />'>
			</div>
	
			<div class="row">&nbsp;</div>
			<div class="row">
	
				<div class="col-md-12 bg_color" style="padding-bottom: 50px;">
	
					<div class="col-sm-8 text-center product-img-big-view">
						<%-- Product Model Picture --%>
						<h3>
							<c:out value="${ product.productNameEn }"></c:out>
						</h3>
	
						<img class="product zoomImg"
							src='<c:url value="/upload/product_image/Big/${ product.productCode }.jpg" />'
							data-zoom-image='<c:url value="${ imageUrl }" />' style="width: 475px;"
							onerror="getDefaultFileImageName(this)" />
					</div>
					<div class="col-sm-4">
						<%-- Technology --%>
						<div class="row product-img-big-view">
							<h3>TECHNOLOGY</h3>
							<c:url var="jpgImgTechUrl"
								value="/upload/product_image/Thumbnail/${ product.productModelId }/${ product.productTechnologyId }.jpg" />
	
							<div>
								<img class="tech-img" src="${ jpgImgTechUrl }" onerror="getDefaultFileImageName(this)" />
	
								<div>
									<c:out value="${ product.productTechnologyId }"></c:out>
								</div>
							</div>
						</div>
	
						<%-- SIZE (Product length) --%>
						<div class="row product-img-big-view">
	
							<h3>SIZE</h3>
							<button type="button" class="btn product-size btn-success">
								<c:out value="${ product.productLength }"></c:out>
							</button>
						</div>
	
	
						<%-- Quantity --%>
						<div class="row product-img-big-view">
							<%@include file="step2_include/quantity.jspf"%>
						</div>
	
						<%-- Button --%>
						<div class="row product-img-big-view">
							<%@include file="step2_include/button.jspf"%>
						</div>
					</div>
				</div>
			</div>
			
			
								
		</div>

	</div>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>


	<script type="text/javascript">
		$(document).ready(function() {

		});
	</script>
</body>
</html>
