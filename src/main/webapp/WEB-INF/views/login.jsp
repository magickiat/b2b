<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/include/common_meta.jspf" %>
	<title><spring:message code="page.header"></spring:message></title>
	<link rel="stylesheet" href="<c:url value="/scripts/assets/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/scripts/assets/font-awesome/css/font-awesome.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/scripts/assets/font-awesome/css/francoisone.css"/>">
	<link rel="stylesheet" href="<c:url value="/scripts/assets/css/form-elements.css"/>">
    <link rel="stylesheet" href="<c:url value="/scripts/assets/css/style.css"/>">
</head>
<body>

	<div class="top-content">
	
        <div class="inner-bg">
            <div class="container">
                
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 form-box">
                    	<div class="form-top">
                    		<div class="form-top-left">
                    			<h3>Login to Starboard Windsurfing</h3>
                        		<p>Enter your username and password to log on:</p>
                    		</div>
                    		<div class="form-top-right">
                    			<i class="fa fa-lock"></i>
                    		</div>
                        </div>
                        <div class="form-bottom">
                        
                        	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
							      <div class="alert alert-danger">
							        	<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
							      </div>
							</c:if>
                       		
                        	<form:form servletRelativeAction="/login" class="login-form"
								modelAttribute="loginForm" method="post">
		                   
			                   		<div class="form-group">
				                   		<label class="sr-only font_francois" for="username">Username</label>
				                       	<form:input path="username" class="form-username form-control"
												placeholder="Enter Username" />
			                       	</div>
			                        <div class="form-group">
			                       	 	<label class="sr-only font_francois" for="password">Password</label>
				                       	<form:password class="form-password form-control" path="password"
											placeholder="Enter password" />
			                        </div>
			                        <div class="form-group">
				                       	<div class="checkbox">
											<label style="color: #fff;"><form:checkbox path="rememberMe" /> Remember me</label>
										</div>			                        
									</div>
			                        <button type="submit" class="btn">LOGIN</button>
		                   </form:form>
	                  </div>
                    </div>
                </div>
                
            </div>
        </div>
        
    </div>
	
     <script src="<c:url value="/scripts/assets/js/jquery-1.11.1.min.js"/>"></script>
     <script src="<c:url value="/scripts/assets/bootstrap/js/bootstrap.min.js"/>"></script>
     <script src="<c:url value="/scripts/assets/js/jquery.backstretch.min.js"/>"></script>
     <script src="<c:url value="/scripts/assets/js/scripts.js"/>"></script>
     <!--[if lt IE 10]>
         <script src="<c:url value="/scripts/assets/js/placeholder.js"/>"></script>
     <![endif]-->
     <script>
	     jQuery(document).ready(function() {
	     	$.backstretch(["<c:url value="/scripts/assets/img/backgrounds/severne_windsurf_banner.jpg"/>"
	     	               , "<c:url value="/scripts/assets/img/backgrounds/2014_AIRUSH_BANNER.jpg"/>"
	     	               , "<c:url value="/scripts/assets/img/backgrounds/sup_banner.jpg"/>"
	     	               , "<c:url value="/scripts/assets/img/backgrounds/surf_banner.jpg"/>"
	     	               , "<c:url value="/scripts/assets/img/backgrounds/windsurf_banner.jpg"/>"
	     	               , "<c:url value="/scripts/assets/img/backgrounds/starboardbglogin.jpg"/>"
	     	               ], {duration: 4000, fade: 750});
	     	$.backstretch("resize");
	     });
     </script>
</body>
</html>
