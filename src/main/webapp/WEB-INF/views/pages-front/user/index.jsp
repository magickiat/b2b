<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>

	<div class="container">
		<div class="col-sm-12">
			<form:form id="userForm" onsubmit="return saveUser()" servletRelativeAction="/frontend/user/edit"
				class="form-horizontal" commandName="userForm" method="post">

				<form:hidden path="id" class="form-control" value="${ userForm.id }" />
				<form:hidden path="custId" value="${ userForm.custId }" />

				<div class="row">
					<div class="col-md-12 bg_color showline2">
						<div class="row row-header2 header2 txtupper">Profile</div>

						<div class="col-md-8">

							<div class="form-group">
								<label class="col-sm-3 control-label" for="name">Full Name</label>
								<div class="col-sm-9">
									<form:input path="name" class="form-control" value="${ userForm.name }" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label" for="username">User Name</label>
								<div class="col-sm-9">
									<form:input path="username" class="form-control" value="${ userForm.username }" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label" for="password">Password</label>
								<div class="col-sm-9">
									<form:password path="password" class="form-control" value="${ userForm.password }" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label" for="confirmPassword">Confirm Password</label>
								<div class="col-sm-9">
									<form:password path="confirmPassword" class="form-control"
										value="${ userForm.confirmPassword }" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label" for="userEmail">Email</label>
								<div class="col-sm-9">
									<form:input id="userEmail" path="email" class="form-control" value="${ userForm.email }" />
								</div>
							</div>

							<!-- 
				          <div class="form-group">
				          	<label class="col-sm-4 control-label" for="userEmail">Active Time</label>
				            <div class="col-sm-8"></div>
				          </div>
				           -->

							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-9">
									<div class="pull-right">
										<button type="button" class="btn btn-success" onclick="saveUser()">Save</button>
									</div>
								</div>
							</div>

						</div>
						<div class="col-md-4"></div>
					</div>
				</div>
				<div class="row">&nbsp;</div>
				<div class="row">
					<div class="col-md-12 bg_color showline2">
						<div class="row row-header2 header2 txtupper">Address</div>

						<c:forEach items="${ userForm.addresses }" var="address" varStatus="row">
							<form:hidden class="form-control" id="addressId${row.index}"
								path="addresses[${row.index}].addrId" value="${ address.addrId }" />

							<div class="col-md-12">
								<div style="height: 1px; border-bottom: solid 1px #ccc;"></div>
							</div>
							<div class="col-md-12">&nbsp;</div>
							<div class="col-md-8">
								<div class="form-group">
									<label class="col-sm-3 control-label" for="addresses[${row.index}].address">Address
										:</label>
									<div class="col-sm-9">
										<textarea id="address${row.index}" name="addresses[${row.index}].address" rows="4"
											cols="50" class="form-control">${ address.address }</textarea>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label" for="addresses[${row.index}].regionCountryId">Country
										:</label>
									<div class="col-sm-3">
										<select id="country${row.index}" name="addresses[${row.index}].regionCountryId"
											class="form-control">
											<option value="" disabled="disabled">---please select---</option>
											<c:forEach items="${ countries }" var="country">
												<option value="${ country.key }"
													${country.key==address.regionCountryId?'selected="selected"':''}>${ country.value }</option>
											</c:forEach>
										</select>
									</div>

									<label class="col-sm-3 control-label" for="addresses[${row.index}].tel1">Telephone
										:</label>
									<div class="col-sm-3">
										<form:input id="tel1${row.index}" path="addresses[${row.index}].tel1" class="form-control"
											value="${ address.tel1 }" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label" for="addresses[${row.index}].postCode">PostCode
										:</label>
									<div class="col-sm-3">
										<form:input id="postcode${row.index}" path="addresses[${row.index}].postCode"
											maxlength="5" class="form-control" value="${ address.postCode }" />
									</div>

									<label class="col-sm-3 control-label" for="addresses[${row.index}].email">Email :</label>
									<div class="col-sm-3">
										<form:input id="addressEmail${row.index}" path="addresses[${row.index}].email"
											class="form-control" value="${ address.email }" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label" for="addresses[${row.index}].type">Address
										Type :</label>
									<div class="col-sm-3">
										<select id="addressType${row.index}" name="addresses[${row.index}].type"
											class="form-control">
											<option value="" disabled="disabled">---please select---</option>
											<c:forEach items="${ addressTypes }" var="addressType">
												<option value="${ addressType.key }"
													${addressType.key==address.type?'selected="selected"':''}>${ addressType.value }</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<div class="pull-right">
											<button type="button" class="btn btn-success" onclick="saveAddress(${row.index})">SAVE</button>
											<button type="button" class="btn btn-default"
												onclick="cancel(${ row.index }, '${ address.address}', '${ address.regionCountryId}', '${ address.tel1 }', 
												'${ address.postCode }', '${ address.fax }', '${ address.email }', '${ address.type }', '${ address}')">CANCEL</button>
										</div>
									</div>
								</div>

							</div>
							<div class="col-md-4"></div>
						</c:forEach>


					</div>
				</div>
			</form:form>
		</div>
	</div>

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	<script>
		
	 	function saveAddress(row){
	 		var addressId 		= $("#addressId"+row).val();
	 		var isUpdateSuccess = false;
	 		
	 		if($("#addressEmail"+row).val() && !validateEmail($("#addressEmail"+row).val()) ){
	 			showDialog("<div style='color: red;'>Address email is invalid! Please try again.</div>");
	 			$("#addressEmail"+row).focus();
	 			return false;	
	 		}
	 		
	 		$.ajax({
 				//async: false,
	            type: "POST",
	            url: "<c:url value="/frontend/user/address/edit"/>",
	            data: $("#userForm").serialize() + "&addressId=" + addressId,
	            dataType: "text",
	            success: function(data) {		           
	                //var obj = jQuery.parseJSON(data); //if the dataType is not specified as json uncomment this
	                // do what ever you want with the server response
					console.log("save complete");
					if(data == "true"){
						//$('<div></div>').appendTo('body')
						//  .html('<div><h6>Address has been updated successfully.</h6></div>')
						//  .dialog({
						//      modal: true, title: 'message', zIndex: 10000, autoOpen: true,
						//      width: '300', resizable: false,
						//      buttons: {
						//          Ok: function () {
						//              $(this).dialog("close");
						//          },
						//      },
						//      close: function (event, ui) {
						//          $(this).remove();
						//      }
						//});
						$('#div_commond_modal .modal-body').html('<div><h6>Address has been updated successfully.</h6></div>');
			 			$('#div_commond_modal .modal-footer .btn-danger').hide();
			 			$('#div_commond_modal').modal();
						
					}else{
						/* $('<div></div>').appendTo('body')
						  .html('<div><h6>Address updated has been failed.</h6></div>')
						  .dialog({
						      modal: true, title: 'message', zIndex: 10000, autoOpen: true,
						      width: '300', resizable: false,
						      buttons: {
						          Ok: function () {
						              $(this).dialog("close");
						          },
						      },
						      close: function (event, ui) {
						          $(this).remove();
						      }
						}); */
						$('#div_commond_modal .modal-body').html('<div style="color: red;"><h6>Address updated has been failed.</h6></div>');
			 			$('#div_commond_modal .modal-footer .btn-danger').hide();
			 			$('#div_commond_modal').modal();
					}
					
					
	            }
	        });	
	 	}
	 	
	 	function saveUser(){
	 		
	 		if($('#name').val() == null || $('#name').val() == ''){
	 			//showDialog('Name is required');

	 			$('#div_commond_modal .modal-body').html('<div style="color: red;">Name is required</div>');
	 			$('#div_commond_modal .modal-footer .btn-danger').hide();
	 			$('#div_commond_modal').modal();
	 			$('#name').focus();
	 			
	 			return false;
	 		}
	 		/* 
	 		if($('#password').val() == null || $('#password').val() == ''){
	 			showDialog('Password is required');
	 			$('#password').focus();
	 			return false;
	 		}
	 		
	 		if($('#confirmPassword').val() == null || $('#confirmPassword').val() == ''){
	 			showDialog('Confirm Password is required');
	 			$('#confirmPassword').focus();
	 			return false;
	 		} */
	 		
	 		var password = $('#password').val();
	 		var confirmPassword = $('#confirmPassword').val();
	 		if(password && confirmPassword){
		 		if(password != confirmPassword){
		 			showDialog("<div style='color: red;'>Password not match with Confirm password</div>");
		 			$('#password').focus();
		 			return false;
		 		}
	 		}
	 		
	 		var email = $("#userEmail").val();
	 		if(email && !validateEmail(email)){
	 			showDialog("<div style='color: red;'>User's email is invalid! Please try again.</div>");
	 			$("#userEmail").focus();
	 			return false;
	 		}

			$.ajax({
	            type: "POST",
	            url: "<c:url value="/frontend/user/edit"/>",
	            data: $("#userForm").serialize(),
	            dataType: "text",
	            success: function(data) {
	                //var obj = jQuery.parseJSON(data); //if the dataType is not specified as json uncomment this
	                // do what ever you want with the server response
	            	console.log("save complete");
					if(data == "true"){
						/* $('<div></div>').appendTo('body')
						  .html('<div><h6>User has been updated successfully<br/>Please logout and login again.</h6></div>')
						  .dialog({
						      modal: true, title: 'message', zIndex: 10000, autoOpen: true,
						      width: '300', resizable: false,
						      buttons: {
						          Ok: function () {
						              $(this).dialog("close");
						          },
						      },
						      close: function (event, ui) {
						          $(this).remove();
						      }
						}); */
						$('#div_commond_modal .modal-body').html('<div><h6>User has been updated successfully<br/>Please logout and login again.</h6></div>');
			 			$('#div_commond_modal .modal-footer .btn-danger').hide();
			 			$('#div_commond_modal').modal();
					}else{
						/* $('<div></div>').appendTo('body')
						  .html('<div><h6>User updated has been failed.</h6></div>')
						  .dialog({
						      modal: true, title: 'message', zIndex: 10000, autoOpen: true,
						      width: '300', resizable: false,
						      buttons: {
						          Ok: function () {
						              $(this).dialog("close");
						          },
						      },
						      close: function (event, ui) {
						          $(this).remove();
						      }
						}); */
						$('#div_commond_modal .modal-body').html('<div style="color: red;"><h6>User updated has been failed.</h6></div>');
			 			$('#div_commond_modal .modal-footer .btn-danger').hide();
			 			$('#div_commond_modal').modal();
					}
	            }
	        });	
	 	}
	 	
	 	function cancel(row, address, country, telephone, postCode, fax, email, addressType, addressObj){
			$("#address"+row).val(address);
			$("#country"+row).val(country);
			$("#tel1"+row).val(telephone);
			$("#postcode"+row).val(postCode);
			$("#fax"+row).val(fax);
			$("#addressEmail"+row).val(email);	 
			$("#addressType"+row).val(addressType);
	 	}
	 	
	 	function validateEmail(email) {
	 		// check email format and allow null
	 		return !email || /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,})+$/.test(email);
	 	}
	 	
	 	function validateTelephone(telephone){
	 		// check telephone format and allow null
	 		return !telephone || /^[+]*[(]{0,1}[0-9]{1,3}[)]{0,1}[-\s\./0-9]*$/g.test(telephone);
	 	}

	</script>
</body>
</html>
