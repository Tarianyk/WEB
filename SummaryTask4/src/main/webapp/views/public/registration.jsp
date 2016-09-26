<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

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

<title>E-Shop | <fmt:message key="title.registartion" /></title>
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
	<!-- Cart view section -->
	<div id="aa-myaccount">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-myaccount-area">
						<div class="row">
							<div class="col-md-6">
								<div class="aa-myaccount-register">
									<h4>
										<fmt:message key="registration.regist_header" />
									</h4>
									
									<!-- start form registration -->
									<form action="/SummaryTask4/registration?param=true" method="post" class="aa-login-form">

										<label for=""><fmt:message key="registration.f_name" /><span>*</span></label>
										<input type="text" placeholder="<fmt:message key="registration.placeholder.f_name" />"	name="fname" required>
										<label for=""><fmt:message key="registration.l_name" /><span>*</span></label>
										<input type="text" placeholder="<fmt:message key="registration.placeholder.l_name" />" name="lname" required>
										<label for=""><fmt:message key="registration.email" /><span>*</span></label>
										<input type="email" placeholder="<fmt:message key="registration.placeholder.email" />" name="email" required>
										<label for=""><fmt:message	key="registration.f_pass" /><span>*</span></label>
										<input type="password" placeholder="<fmt:message key="registration.placeholder.f_pass" />" name="fpass" required>
										<label for=""><fmt:message key="registration.l_pass" /><span>*</span></label>
										<input type="password" placeholder="<fmt:message key="registration.placeholder.l_pass" />" name="lpass" required>

										<select name="lang">
											<option value="1"><fmt:message key="registration.eng" /></option>
											<option value="2"><fmt:message key="registration.rus" /></option>
										</select>

										<button type="submit">
											<fmt:message key="registration.registrate" />
										</button>
										
										<button type="reset">
											<fmt:message key="adminarea.reset" />
										</button>
																				
									</form>
									<!-- end form registration -->
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- / Cart view section -->

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