<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<!-- Tag's -->
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<%@ taglib prefix="my" tagdir="/WEB-INF/tags/customtags/"%>
	
	<!-- Localization -->
	<fmt:setLocale value="${language_page}" />
	<fmt:setBundle basename="ua.nure.tarianyk.SummaryTask4.localization.text" />

<html>

<head>

<title>E-Shop | <fmt:message key="title.contact" /></title>
<link rel="shortcut icon" href="/SummaryTask4/resources/images/site/logo/title.png" type="image/png">

	<!-- CSS styles	 -->
	<link href="/SummaryTask4/resources/css/bootstrap.css" rel="stylesheet">
	<link id="switcher" href="/SummaryTask4/resources/css/theme-color/lite-blue-theme.css" rel="stylesheet">
	<link href="/SummaryTask4/resources/css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">
	<link href="/SummaryTask4/resources/css/style.css" rel="stylesheet">
	
	<!-- reCaptcha library -->
	<script src='https://www.google.com/recaptcha/api.js?hl=en'></script>

	<script type="text/javascript">
			var test = '<%=session.getAttribute("error")%>';			
			if (test != 'null') { 
			    alert(test);
			}		
			'<%session.setAttribute("error", null);%>';
	</script>

</head>

<body>

	<%--=========================================================================== 
	This is the HEADER, containing a top menu.
	header.jsp contains all necessary functionality for it.
	Just include it in this JSP document.
	===========================================================================--%> 
	<my:header/>

	<%--=========================================================================== 
	This is the MENU, containing a navigation menu.
	menu.jsp contains all necessary functionality for it.
	Just include it in this JSP document.
	===========================================================================--%> 
	<my:menu/>

	<%--=========================================================================== 
	This is the CONTENT, containing the main part of the page.
	===========================================================================--%> 
	<div id="aa-contact">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="aa-contact-area">

					<!-- contact map -->
					<div class="aa-contact-map">
						<iframe	src="https://www.google.com/maps/embed/v1/place?q=place_id:ChIJiw-rY5-gJ0ERCr6kGmgYTC0&key=AIzaSyDegkD6QNp_7V20gVoPmGKEAeoM1yK7fKY"	width="100%" height="450" frameborder="0" style="border: 0"	allowfullscreen></iframe>
					</div>
					<!-- Contact address -->
					
					<div class="aa-contact-address">
						<div class="row">
							<div class="col-md-16">
								<div class="aa-contact-address-left">

									<form class="comments-form contact-form" action="/SummaryTask4/contact"	method="post">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<input type="text" placeholder="<fmt:message key="contact.name" />" class="form-control" name="name" required>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<input type="email" placeholder="<fmt:message key="contact.email" />"	class="form-control" name="email" required>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<input type="text" placeholder="<fmt:message key="contact.subject" />" class="form-control" name="subject" required>
												</div>
											</div>
										</div>

										<div class="form-group">
											<textarea class="form-control" rows="3" placeholder="<fmt:message key="contact.message" />" name="message" required></textarea>
										</div>
										<button class="aa-secondary-btn"><fmt:message key="contact.send" /></button>
									</form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>

	<%--=================================================================================
	This is the FOOTER, containing a part of navigation menu and information about owner.
	footer.jsp contains all necessary functionality for it.
	Just include it in this JSP document.
	=================================================================================--%> 
	<my:footer/>

	<%--============================================================================== 
	This is the MODAL LOGIN, containing modal window for logging.
	login.jsp contains all necessary functionality for it.
	Just include it in this JSP document.
	==============================================================================--%> 
	<!-- start login -->
	<my:login />
	<!-- end login -->

		<!-- jQuery library -->
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="/SummaryTask4/resources/js/bootstrap.js"></script>
	<script src="/SummaryTask4/resources/js/jquery.smartmenus.js" type="text/javascript"></script>
	<script src="/SummaryTask4/resources/js/jquery.smartmenus.bootstrap.js" type="text/javascript"></script>
	<script src="/SummaryTask4/resources/js/sequence.js"></script>
	<script src="/SummaryTask4/resources/js/sequence-theme.modern-slide-in.js"></script>
	<script src="/SummaryTask4/resources/js/cartbox.js"></script>

</body>

</html>