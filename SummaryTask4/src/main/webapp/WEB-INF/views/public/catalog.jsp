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

<title>E-Shop | <fmt:message key="title.catalog" /></title>
<link rel="shortcut icon" href="/SummaryTask4/resources/images/site/logo/title.png" type="image/png">

	<!-- CSS styles	 -->
	<link href="/SummaryTask4/resources/css/bootstrap.css" rel="stylesheet">
	<link id="switcher" href="/SummaryTask4/resources/css/theme-color/lite-blue-theme.css" rel="stylesheet">
	<link href="/SummaryTask4/resources/css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">
	<link href="/SummaryTask4/resources/css/style.css" rel="stylesheet">

	<script type="text/javascript">
		var test = '<%= session.getAttribute("error") %>';		
		if (test != 'null') { 
		    alert(test);
		}		
		'<% session.setAttribute("error", null); %>';
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
	<!-- product category -->
	<div id="aa-product-category">
	<div class="container">
		<div class="row">
			<div class="col-lg-9 col-md-9 col-sm-8 col-md-push-3">
				<div class="aa-product-catg-content">

					<div class="aa-product-catg-body">
						<my:catalog caption="${kind}" />
					</div>
					
					<div class="aa-product-catg-pagination">
						<nav>
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
						</ul>
						</nav>
					</div>
				</div>
			</div>
			<my:sort />
		</div>
	</div>
	</div>
	<!-- / product category -->

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