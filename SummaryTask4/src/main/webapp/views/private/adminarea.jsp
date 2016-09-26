<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

<title>E-Shop | <fmt:message key="title.adminarea" /></title>
<link rel="shortcut icon" href="/SummaryTask4/resources/images/site/logo/title.png" type="image/png">

	<!-- CSS styles	 -->
	<link href="/SummaryTask4/resources/css/bootstrap.css" rel="stylesheet">
	<link id="switcher" href="/SummaryTask4/resources/css/theme-color/lite-blue-theme.css" rel="stylesheet">
	<link href="/SummaryTask4/resources/css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">
	<link href="/SummaryTask4/resources/css/style.css" rel="stylesheet">
	
	<!-- reCaptcha library -->
	<script src='https://www.google.com/recaptcha/api.js?hl=en'></script>

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
	<div id="aa-myaccount">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-myaccount-area">
						<div class="row">
							<div class="col-md-6">
								<div class="aa-myaccount-register">								
								
									<!-- start admin panel -->
										<h4>
											<fmt:message key="adminarea.ban" />
										</h4>
										<div>
										
											<!-- start ban panel -->
											<form action="/SummaryTask4/admin?param=ban" method="post" class="aa-login-form">
												<fmt:message key="adminarea.email" />
												<input type="email" name="email" required>
												<select name="ban">
													<option value="1"><fmt:message key="adminarea.ban_case" /></option>
													<option value="2"><fmt:message key="adminarea.unban_case" /></option>
												</select> &nbsp;
												
												<input type="submit" value="<fmt:message key="adminarea.button" />">
											</form>	
											<!-- end ban panel -->										
											
										</div>
										<br />

										<h4>
											<fmt:message key="adminarea.thing" />
										</h4>

										<div>
											<!-- start add panel -->
											<form action="/SummaryTask4/admin?param=add" method="post" class="aa-login-form">
												<fmt:message key="adminarea.title" />
												<input type="text" name="title" required> <br />
												<fmt:message key="adminarea.article" />
												<input type="text" name="article" required> <br />
												<fmt:message key="adminarea.desc1" />
												<input type="text" name="desc1" required> <br />
												
												<select	name="desc2">
													<option value="CPU"><fmt:message key="adminarea.cpu_case" /></option>
													<option value="SOUND"><fmt:message key="adminarea.sound_case" /></option>
													<option value="DRIVE"><fmt:message key="adminarea.drive_case" /></option>
													<option value="CAMERA"><fmt:message key="adminarea.camera_case" /></option>
													<option value="FLASH"><fmt:message key="adminarea.flash_case" /></option>
												</select> <br />
												
												<fmt:message key="adminarea.price" />
												<input type="number" name="price" required> <br />

												<table>
													<tr>
														<td><fmt:message key="adminarea.path" />
														<input type="file" name="path" required></td>
														<td>
															<select name="lang">
																<option value="1"><fmt:message	key="adminarea.eng_case" /></option>
																<option value="2"><fmt:message key="adminarea.rus_case" /></option>
															</select>
														</td>
													</tr>
												</table>

												<fmt:message key="adminarea.amount" />
												<input type="number" name="amount" required> <br />
												<input type="submit" value="<fmt:message key="adminarea.button" />">
												<input type="reset" value="<fmt:message key="adminarea.reset" />">
											</form>
											<!-- end add panel -->
											
										</div>
										<br />

										<h4>
											<fmt:message key="adminarea.delete_thing" />
										</h4>
										
										<div>
										
											<!-- start remove panel -->
											<form action="/SummaryTask4/admin?param=remove" method="post" class="aa-login-form">
												<fmt:message key="adminarea.article" />
												<input type="text" name="article" required>
												<input type="submit" value="<fmt:message key="adminarea.button" />">
											</form>
											<!-- end remove panel -->
											
										</div>
										<br />

										<h4>
											<fmt:message key="adminarea.change_status" />
										</h4>
										<div>
										
											<!-- start status panel -->
											<form action="/SummaryTask4/admin?param=status" method="post" class="aa-login-form">
												<fmt:message key="adminarea.article_status" />
												<input type="text" name="article" required>
												<fmt:message key="adminarea.status_email" />
												<input type="text" name="email" required>
												
												<select	name="status">
													<option value="paid"><fmt:message key="adminarea.paid_case" /></option>
													<option value="cancelled"><fmt:message key="adminarea.cancelled_case" /></option>
												</select> <br />
												
												<input type="submit" value="<fmt:message key="adminarea.button" />">
											</form>
											<!-- end status panel -->
										</div>
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
	<script src="/SummaryTask4/resources/js/showContent.js"></script>

</body>

</html>