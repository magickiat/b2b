<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Starboard Windsurfing</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>

	<div class="container">

		<div class="row">
			<div class="col-md-12 bg_color showline">
				<div class="row row-header header1 txtupper">contact us</div>
				<div style="min-height: 300px;">
					<div class="row" style="margin-top: 20px;">
						<div class="col-lg-8">
		                    <p></p>
		                    <form role="form">
		                        <div class="row">
		                            <div class="form-group col-lg-4">
		                                <label>Name</label>
		                                <input type="text" class="form-control">
		                            </div>
		                            <div class="form-group col-lg-4">
		                                <label>Email Address</label>
		                                <input type="email" class="form-control">
		                            </div>
		                            <div class="form-group col-lg-4">
		                                <label>Phone Number</label>
		                                <input type="tel" class="form-control">
		                            </div>
		                            <div class="clearfix"></div>
		                            <div class="form-group col-lg-12">
		                                <label>Message</label>
		                                <textarea class="form-control" rows="6"></textarea>
		                            </div>
		                            <div class="form-group col-lg-12">
		                                <input type="hidden" name="save" value="contact">
		                                <button type="submit" class="btn btn-default">Submit</button>
		                            </div>
		                        </div>
		                    </form>
		                </div>
		                <div class="col-lg-4">
		                	<!-- <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d208595.2734848326!2d100.5794077158579!3d13.719411456968443!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sth!4v1448981580126" width="350" height="450" frameborder="0" style="border:0" allowfullscreen></iframe> -->
		                </div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	
</body>
</html>