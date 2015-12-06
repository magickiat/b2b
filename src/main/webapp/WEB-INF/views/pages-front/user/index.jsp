<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Starboard Windsurfing - Profile</title>
<%@include file="/WEB-INF/views/include/common_css.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-front/include/common_header.jspf"%>

	<div class="container">
		<div class="row">
			<div class="col-md-12 bg_color showline2">
				<div class="row row-header header1">Profile</div>
				<div>
					<form:form id="userForm" onsubmit="return saveUser()"
						servletRelativeAction="/frontend/user/edit"
						class="form-horizontal" commandName="userForm" method="post">
						<form:hidden path="id" class="form-control"
							value="${ userForm.id }" />
						<form:hidden path="custId" value="${ userForm.custId }" />
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Username</th>
									<th>Password</th>
									<th>Confirm Password</th>
									<th>Email</th>
									<th>Active Time</th>
									<th>Function</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><form:input path="username" class="form-control" value="${ userForm.username }" /></td>
									<td><form:password path="password" class="form-control" value="${ userForm.password }" /></td>
									<td><form:password path="confirmPassword" class="form-control" value="${ userForm.confirmPassword }" />
									</td>
									<td><form:input id="userEmail" path="email" class="form-control" value="${ userForm.email }" /></td>
									<td>
										<%-- FIXME: we don't have active time yet.
										<form:input path="activeTime"  class="form-control" value=""/> --%>
									</td>
									<td>
										<button type="button" class="btn btn-success" onclick="saveUser()">Save</button>
									</td>
								</tr>
						</table>

						<table class="table table-hover">
							<thead>
								<tr>
									<th>Address</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${ userForm.addresses }" var="address" varStatus="row">
									<form:hidden class="form-control" id="addressId${row.index}" path="addresses[${row.index}].addrId" value="${ address.addrId }" />
									<tr>
										<td>
											<div>
												<table>
													<tr>
														<td rowspan="4" valign="top"  style="padding: 0 5px;">Address :</td>
														<td rowspan="4" valign="top"  style="padding: 0 5px;">
															<textarea id="address${row.index}" name="addresses[${row.index}].address" rows="4" cols="50">${ address.address }</textarea>
														</td>
														<td style="padding: 0 5px;">Country :</td>
														<td>
															<select id="country${row.index}"
																name="addresses[${row.index}].regionCountryId">
																	<option value="" disabled="disabled">---please select---</option>
																	<c:forEach items="${ countries }" var="country">
																		<option value="${ country.key }" ${country.key==address.regionCountryId?'selected="selected"':''}>${ country.value }</option>
																	</c:forEach>
															</select>
														</td>
														<td  style="padding: 0 5px;">Telephone :</td>
														<td>
															<form:input id="tel1${row.index}" path="addresses[${row.index}].tel1" class="form-control" value="${ address.tel1 }" />
														</td>
													</tr>
													<tr>
														<td  style="padding: 0 5px;">PostCode :</td>
														<td>
															<form:input id="postcode${row.index}" path="addresses[${row.index}].postCode" class="form-control" maxlength="5" value="${ address.postCode }" />
														</td>
														<td  style="padding: 0 5px;">Fax :</td>
														<td>
															<form:input id="fax${row.index}" path="addresses[${row.index}].fax" class="form-control" value="${ address.fax }" />
														</td>
													</tr>
													<tr>
														<td  style="padding: 0 5px;">Email :</td>
														<td>
															<form:input id="addressEmail${row.index}" path="addresses[${row.index}].email" class="form-control" value="${ address.email }" />
														</td>
														<td  style="padding: 0 5px;">Address Type :</td>
														<td>
															<select id="addressType${row.index}" name="addresses[${row.index}].type">
																	<option value="" disabled="disabled">---please select---</option>
																	<c:forEach items="${ addressTypes }" var="addressType">
																		<option value="${ addressType.key }"${addressType.key==address.type?'selected="selected"':''}>${ addressType.value }</option>
																	</c:forEach>
															</select>
													</tr>
													<tr>
														<td colspan="6" align="right">
															<button type="button" class="btn btn-success" onclick="saveAddress(${row.index})">SAVE</button>
															<button type="button" class="btn btn-default" 
															onclick="cancel(${ row.index }, '${ address.address}', '${ address.regionCountryId}', '${ address.tel1 }', 
 															'${ address.postCode }', '${ address.fax }', '${ address.email }', '${ address.type }', '${ address}')">CANCEL</button>
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<script src="<c:url value="/scripts/assets/js/jquery-1.11.1.min.js"/>"></script>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>	
	<script src="<c:url value="/scripts/assets/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/scripts/assets/js/jquery.backstretch.min.js"/>"></script>
	<script>
		jQuery(document).ready(function() {
		 	$.backstretch("<c:url value="/scripts/assets/img/backgrounds/starboardbglogin.png"/>");
		});
		
	 	function saveAddress(row){
	 		var addressId 		= $("#addressId"+row).val();
	 		var isUpdateSuccess = false;
	 		
	 		if(!validateTelephone($("#tel1"+row).val())){
	 			alert("Telephone is invalid! Please try again.");
	 			$("#tel1"+row).focus();
	 			return false;	 			
	 		}
	 		
	 		if(!validateTelephone($("#fax"+row).val())){
	 			alert("Fax is invalid! Please try again.");
	 			$("#fax"+row).focus();
	 			return false;	 			
	 		}
	 		
	 		if(!validateEmail($("#addressEmail"+row).val())){
	 			alert("Email is invalid! Please try again.");
	 			$("#addressEmail"+row).focus();
	 			return false;
	 		}
	 		
	 		if(validateEmail($("#addressEmail"+row).val()) ){
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
							$('<div></div>').appendTo('body')
							  .html('<div><h6>Address has been updated successfully.</h6></div>')
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
							});
						}else{
							$('<div></div>').appendTo('body')
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
							});
						}
						
						
		            }
		        });	
	 		}
	 	}
	 	
	 	function saveUser(){
	 		if(!validateEmail($("#userEmail").val())){
	 			alert("User's email is invalid! Please try again.");
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
						$('<div></div>').appendTo('body')
						  .html('<div><h6>User has been updated successfully.</h6></div>')
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
						});
					}else{
						$('<div></div>').appendTo('body')
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
						});
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
