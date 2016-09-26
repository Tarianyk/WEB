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

	<title>E-Shop | <fmt:message key="title.detail" /></title>
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
		<!-- product category -->
	  <div id="aa-product-details">
	    <div class="container">
	      <div class="row">
	        <div class="col-md-12">
	          <div class="aa-product-details-area">
	            <div class="aa-product-details-content">
	              <div class="row">
	                <!-- Modal view slider -->
	                <div class="col-md-5 col-sm-5 col-xs-12">                              
	                  <div class="aa-product-view-slider">                                
	                    <div id="demo-1" class="simpleLens-gallery-container">
	
	                      <div class="simpleLens-thumbnails-container">
	                          <img src="${detail_product.path}">                                  
	                      </div>
	                    </div>
	                  </div>
	                </div>
	                <!-- Modal view content -->
	                <div class="col-md-7 col-sm-7 col-xs-12">
	                  <div class="aa-product-view-content">
	                  
	                    <h3>${detail_product.title}</h3>
	                    	
	                    <div class="aa-prod-view-bottom">
	                      <a class="aa-add-to-cart-btn" href="/SummaryTask4/addshopcart?article=${detail_product.article}&desc_2=${detail_product.desc_2}&path=${detail_product.path}&price=${detail_product.price}"><fmt:message key="detail.add" /></a>
	                    </div>
	                  </div>
	                </div>
	              </div>
	            </div>
	            <div class="aa-product-details-bottom">
	              <ul class="nav nav-tabs" id="myTab2">
	                <li><a href="#description" data-toggle="tab"><fmt:message key="detail.description" /></a></li>               
	              </ul>
	
	              <!-- Tab panes -->
	              <div class="tab-content">
	                <div class="tab-pane fade in active" id="description">
	                  <p>${detail_product.desc_1}</p>
	                </div>
	                <div class="tab-pane fade " id="review">
	                </div>            
	              </div>
	            </div>
	            
	              
	             
	            </div>  
	          </div>
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