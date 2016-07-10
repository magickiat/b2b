<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/common_meta.jspf"%>
<title><spring:message code="page.header"></spring:message></title>
<%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
</head>
<body>
	<%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
	<div class="container">

		<div class="col-md-12">

			<div class="row showline2">
				<div class="col-md-12">
					<div class="row row-header2 header2">Email Settings</div>
					<c:choose>
						<c:when test="${ empty listProductEmail }">
							<!-- 						<div class="col-sm-12">not found any product</div> -->
						</c:when>
						<c:otherwise>
							<div class="col-sm-12">
								<table class="table" style="width: 99%;">
									<thead>
										<tr>
											<th style="width: 20%;">Product Type</th>
											<th>&nbsp;</th>
										</tr>
									</thead>
									<c:forEach items="${ listProductEmail }" var="entry">
										<tr>
											<td rowspan="2">${entry.value.productType.productTypeName }</td>
											<td>
												<input type="button" id="btnAddTo" class="btn btn-success btn-sm"
													value="Add Mail TO"
													onclick="popupAddEmail(${ entry.value.productType.brandGroupId }, '${entry.value.productType.productTypeName }', 'TO')" />
												<input type="button" id="btnAddCC" class="btn btn-success btn-sm"
													value="Add Mail CC"
													onclick="popupAddEmail(${ entry.value.productType.brandGroupId }, '${entry.value.productType.productTypeName }', 'CC')" />
											</td>
										</tr>

										<tr>
											<td>
												<form id="${entry.value.productType.brandGroupId }">
													<table
														id="product-type-id-${entry.value.productType.brandGroupId }"
														class="table" style="width: 100%;">
														<thead>
															<tr>
																<th>Email</th>
																<th>Type</th>
																<th>&nbsp;</th>
															</tr>
														</thead>
														<tbody>
															<c:choose>

																<c:when test="${ empty entry.value.emails }">
																	<tr id="noEmail-${entry.value.emails }">
																		<td colspan="3">
																			<h4>No email</h4>
																		</td>
																	</tr>
																</c:when>

																<c:otherwise>

																	<c:forEach items="${ entry.value.emails }" var="e"
																		varStatus="rowNum">

																		<c:set var="maxRow" value="${ rowNum.index + 1 }" />

																		<tr id="email-${ e.id }">
																			<td>${ e.email }</td>
																			<td>${ e.emailType }</td>
																			<td style="width: 20%; text-align: right;">


																				<img title="Remove"
																					style="cursor: pointer; margin-left: 10px;"
																					onclick="confirmDelete(${ e.id })"
																					src='<c:url value="/images/pages-front/icon/btn_remove.png" />' />


																			</td>
																		</tr>
																	</c:forEach>
																</c:otherwise>
															</c:choose>
														</tbody>
													</table>

													<input type="hidden"
														id="max-row-${entry.value.productType.brandGroupId }"
														value="${ maxRow }" />
												</form>
											</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</c:otherwise>
					</c:choose>
				</div>

			</div>
		</div>

	</div>

	<div id="dialog-email" title="Add email" style="display: none;">
		<form>
			<label for="inputEmail">Email</label>
			<input type="text" class="form-control" id="inputEmail" placeholder="Email">
			<input type="submit" tabindex="-1"
				style="position: absolute; top: -1000px" />
		</form>
	</div>
 
	<!-- comment by nui on 2016-07-09 change to bootstrap modal
	<form id="delete-email" method="post"
		action='<c:url value="/backend/email/delete" />'>
		<input type="hidden" id="deleteEmailId" name="deleteEmailId" />
		<input type="hidden" id="csrftoken_" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	-->

	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>
	
	<div id="div_dialog_email" class="modal fade" tabindex="-1" role="dialog" 
		aria-labelledby="myLargeModalLabel01" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h5 class="modal-title"></h5>
				</div>
				<div class="modal-body">
					<div class="form-horizontal">
						 <div class="form-group">
						    <label for="txtEmail" class="col-sm-2 control-label">Email: </label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="txtEmail" placeholder="Email">
						    </div>
						 </div>
  					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-success">Save</button>
				</div>
			</div>
		</div>
	</div>
	
	<div id="div_dialog_email_confirm_delete" class="modal fade" tabindex="-1" role="dialog" 
		aria-labelledby="myLargeModalLabel01" style="display: none;">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h5 class="modal-title">Confirm?</h5>
				</div>
				<div class="modal-body">
					Are you sure?
					<form id="delete-email" method="post" action='<c:url value="/backend/email/delete" />'>
						<input type="hidden" id="deleteEmailId" name="deleteEmailId" />
						<input type="hidden" id="csrftoken_" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-danger">Delete</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	$('#div_dialog_email').on('hide.bs.modal',function(){
		$('#txtEmail').val('');
	}).on('shown.bs.modal',function(){
		$('#txtEmail').select();
	});

	$('#div_dialog_email .btn-success').on('click',function(){
		var param={'${_csrf.parameterName}' : '${_csrf.token}'};
		var email = $('#txtEmail').val();
		if(email){
			//<input type="hidden" id="csrftoken_" name="${_csrf.parameterName}" value="${_csrf.token}" />
			
			param.email = email;
			param.brandGroupId = $('#div_dialog_email .btn-success').attr('brandGroupId');
			param.emailType = $('#div_dialog_email .btn-success').attr('emailType');

			console.log(JSON.stringify(param));

			$.post('<c:url value="/backend/email/save.json"/>',param).done(function(response) {
				console.log('Success: ' + JSON.stringify(response));
				$('#div_dialog_email').modal('hide');
				showDialog('Save complete');
				window.location.href = '<c:url value="/backend/email/" />';
			}).fail(function(result) {
				console.log('Error: ' + result.responseText);
				showDialog(result.responseText);
			}); 
		}else{
			$('#txtEmail').select();
		}
	});

	$('#div_dialog_email_confirm_delete .btn-danger').on('click',function(){
		$('#delete-email').submit();
	});
	
	function popupAddEmail(brandGroupId, productTypeName, emailType){
		console.log('brandGroupId = ' + brandGroupId);
		var maxRow = $('#max-row-'+brandGroupId);
		if(maxRow){
			console.log('Not found email');
			//$('#noEmail-'+brandGroupId).remove();
		}
		
		$('#div_dialog_email .modal-title').html('Add email for ' + productTypeName);
		$('#div_dialog_email .btn-success').attr('brandGroupId',brandGroupId);
		$('#div_dialog_email .btn-success').attr('emailType',emailType);
		$('#div_dialog_email').modal();

		//comment by nui on 2016-07-09 change to new modal boosstrap
		/* var dialog = $('#dialog-email').dialog({
			autoOpen: false,
			title : 'Add email for ' + productTypeName,
			height: 200,
			width: 400,
			modal: true,
			buttons: {
				"Save" : function(){
					var email = $('#inputEmail').val();
					console.log('save email ' + email);
					
					if(email){
						console.log('emailType = ' + emailType);
						console.log('ajax save');
						
						var param = {
							'brandGroupId' : brandGroupId,
							'email' : email,
							'emailType': emailType
						};
	
	
						$.post('<c:url value="/backend/email/save.json"/>', param).done(function(response) {
							console.log('Success: ' + JSON.stringify(response));
							showDialog('Save complete');
							window.location.href = '<c:url value="/backend/email/" />';
						}).fail(function(result) {
							console.log('Error: ' + result.responseText);
							showDialog(result.responseText);
						});
						
						
					}
					
					  $(this).dialog("close");
				},
				 "Cancel": function () {
		              console.log('Do nothing.');
		              $('#inputEmail').val('');
		              $(this).dialog("close");
		          }
			},
		      close: function (event, ui) {
		    	  $('#inputEmail').val('');
		    	  $(this).dialog("close");
		      }
		}); 
		
		dialog.dialog('open');
		 */
		
	}
	
	function confirmDelete(id){

		$('#deleteEmailId').val(id);
		$('#div_dialog_email_confirm_delete').modal();
		
		//commemt by nui on 2016-07-09 change modal bootstrp
		/* $("#dialog-confirm")
		.dialog(
				{
					resizable : false,
					height : 140,
					modal : true,
					buttons : {
						"Delete" : function() {
							console.log('confirm delete email id: ' + id);
							$('#deleteEmailId').val(id);
							$('#delete-email').submit();
							$(this).dialog("close");
						},
						"Cancel" : function() {
							$(this).dialog("close");
						}
					}
				}); */
	}
	
	function save(){
		var emails = [];
		$('input[name=email]').each(function(index, obj) {
			var val = $(obj).val();
			var clazz = $(obj).attr('class').split(' ')[0];
// 			console.log(clazz +'\tvalue = ' + val);
			emails[clazz].push(val);
		});
		
		console.log(emails);
	}
	</script>

</body>
</html>
