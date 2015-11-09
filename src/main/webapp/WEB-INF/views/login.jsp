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
                       		<c:if test="${param.error != null}">
								<div class="alert alert-danger">Invalid UserName and Password.</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success">You have been logged out.</div>
							</c:if>
                        	<form:form servletRelativeAction="/login" class="login-form"
								modelAttribute="loginForm" method="post">
		                   
			                   		<div class="form-group">
				                   		<label class="sr-only" for="username">Username</label>
				                       	<form:input path="username" class="form-username form-control"
												placeholder="Enter Username" />
			                       	</div>
			                        <div class="form-group">
			                       	 	<label class="sr-only" for="password">Password</label>
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
	     	//$.backstretch("<c:url value="/scripts/assets/img/backgrounds/2014_AIRUSH_BANNER.jpg"/>");
	     	$.backstretch(["<c:url value="/scripts/assets/img/backgrounds/severne_windsurf_banner.jpg"/>"
	     	               , "<c:url value="/scripts/assets/img/backgrounds/2014_AIRUSH_BANNER.jpg"/>"
	     	               , "<c:url value="/scripts/assets/img/backgrounds/sup_banner.jpg"/>"
	     	               , "<c:url value="/scripts/assets/img/backgrounds/surf_banner.jpg"/>"
	     	               , "<c:url value="/scripts/assets/img/backgrounds/windsurf_banner.jpg"/>"
	     	               ], {duration: 8000, fade: 750});
	     	$.backstretch("resize");
	     });
     </script>
</body>
</html>