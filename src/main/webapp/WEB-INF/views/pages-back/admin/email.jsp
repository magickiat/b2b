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
			<div class="row">

				<c:choose>
					<c:when test="${ empty listProductEmail }">
						<!-- 						<div class="col-sm-12">not found any product</div> -->
					</c:when>
					<c:otherwise>
						<div class="col-sm-12">
							<input type="button" class="btn btn-default" value="Save"
								onclick="save()" />
						</div>
						<div class="col-sm-12">
							<table class="table" style="width: 75%;">
								<thead>
									<tr>
										<th style="width: 20%;">Product Type</th>
										<th>Email</th>
									</tr>
								</thead>
								<c:forEach items="${ listProductEmail }" var="entry">
									<tr>
										<td rowspan="2">${entry.value.productType.productTypeName }</td>
										<td>
											<img title="Add" style="cursor: pointer;"
												onclick="popupAddEmail(${ entry.value.productType.productTypeId }, '${entry.value.productType.productTypeName }')"
												src='<c:url value="/images/pages-front/icon/btn_add.png" />' />
										</td>
									</tr>

									<tr>
										<td>
											<form id="${entry.value.productType.productTypeId }">

												<table
													id="product-type-id-${entry.value.productType.productTypeId }"
													style="width: 100%;">
													<tbody>
														<c:choose>
															<c:when test="${ empty entry.value.emails }">
																<tr
																	id="noEmail-${entry.value.productType.productTypeId }">
																	<td colspan="2">&nbsp;</td>
																</tr>
															</c:when>

															<c:otherwise>

																<c:forEach items="${ entry.value.emails }" var="e"
																	varStatus="rowNum">

																	<c:set var="maxRow" value="${ rowNum.index + 1 }" />

																	<tr id="email-${ e.id }">
																		<td>
																			<input type="text" id="${ e.id }"
																				class="form-control email-${ e.id }"
																				value="${ e.email }" />
																		</td>
																		<td style="width: 20%;">
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
													id="max-row-${entry.value.productType.productTypeId }"
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

	<div id="dialog-email" title="Add email" style="display: none;">
		<form>
			<label for="inputEmail">Email</label>
			<input type="text" id="inputEmail" name="inputEmail"
				class="form-control" />
			<input type="submit" tabindex="-1"
				style="position: absolute; top: -1000px" />
		</form>
	</div>
	<%@include file="/WEB-INF/views/include/common_footer.jspf"%>
	<%@include file="/WEB-INF/views/include/common_js.jspf"%>


	<script type="text/javascript">
	function popupAddEmail(productTypeId, productTypeName){
		console.log('productTypeId = ' + productTypeId);
		var maxRow = $('#max-row-'+productTypeId);
		if(maxRow){
			console.log('Not found email');
// 			$('#noEmail-'+productTypeId).remove();
		}
		
		var dialog = $('#dialog-email').dialog({
			autoOpen: false,
			title : 'Add email for ' + productTypeName,
			height: 200,
			width: 400,
			modal: true,
			buttons: {
				"Save" : function(){
					var email = $('#inputEmail').val();
					console.log('save email' + email);
					
					if(email){

						console.log('ajax save');
						
						var param = {
							'productTypeId' : productTypeId,
							'email' : email
						};
	
	
						$.post('<c:url value="/backend/email/save.json"/>', param).done(function(response) {
							console.log('Success: ' + JSON.stringify(response));
						}).fail(function(result) {
							console.log('Result: ' + result);
							console.log('Error: ' + result.responseText);
							alert(result.responseText);
						});
						
						
					}else{
						
					}
					
					
					  $(this).dialog("close");
				},
				 "Cancel": function () {
		              console.log('Do nothing.');
		              $(this).dialog("close");
		          }
			},
		      close: function (event, ui) {
		    	  $(this).dialog("close");
		      }
		});
		
		dialog.dialog('open');
// 		var inputId = (new Date).getTime();
// 		var deleteImage = '<c:url value="/images/pages-front/icon/btn_remove.png" />';
// 		var deleteButton = '<img title="Remove" style="cursor: pointer;  margin-left: 10px;"';
// 		deleteButton += 'onclick="confirmDelete('+inputId+')"';
// 		deleteButton += 'src="'+deleteImage+'" />';
// 		$('#product-type-id-'+productTypeId + ' > tbody:first').append('<tr id="email-'+inputId+'"><td><input type="text" id="'+inputId+'" name="email" class="product-'+productTypeId+' form-control" /></td><td>'+deleteButton+'</td></tr>');
		
	}
	
	function confirmDelete(id){
		
		$("#dialog-confirm")
		.dialog(
				{
					resizable : false,
					height : 140,
					modal : true,
					buttons : {
						"Delete" : function() {
							console.log('confirm delete');
							$('#email-'+id).remove();
							$(this).dialog("close");
						},
						"Cancel" : function() {
							$(this).dialog("close");
						}
					}
				});
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
