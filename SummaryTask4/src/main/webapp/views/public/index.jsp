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

	<title>E-Shop | <fmt:message key="title.index" /></title>
	<link rel="shortcut icon" href="/SummaryTask4/resources/images/site/logo/title.png" type="image/png">

	<!-- CSS styles	 -->
	<link href="/SummaryTask4/resources/css/bootstrap.css" rel="stylesheet">
	<link id="switcher" href="/SummaryTask4/resources/css/theme-color/lite-blue-theme.css" rel="stylesheet">
	<link href="/SummaryTask4/resources/css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">
	<link href="/SummaryTask4/resources/css/style.css" rel="stylesheet">
	
	<!-- reCaptcha library -->
	<script src='https://www.google.com/recaptcha/api.js?hl=en'></script>
	
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
	<!-- start slider -->
	<my:slider />
	<!-- end slider -->	           
<div id="aa-slider" style="margin-top: 5%;">
<!-- Tab panes -->
                  <div class="tab-content" >
                    <!-- Start men product category -->
                    <div class="tab-pane fade in active"  id="men">
                      <ul class="aa-product-catg" >
                        <!-- start single product item -->
                        <li>
                          <figure>
                            <a class="aa-product-img" href="/SummaryTask4/catalog?param=camera"><img src="/SummaryTask4/resources/images/site/index/camera.jpg" width="200px"; height="200px"; alt="CAMERA"></a>
                              <figcaption>
                              <h4 class="aa-product-title"><a href="#"><fmt:message key="nav_panel.camera" /></a></h4>
                            </figcaption>
                          </figure>                        
                        </li>
                        <!-- start single product item -->
                        <li>
                          <figure>
                            <a class="aa-product-img" href="/SummaryTask4/catalog?param=cpu"><img src="/SummaryTask4/resources/images/site/index/cpu.jpg" width="200px"; height="200px"; alt="CPU"></a>
                             <figcaption>
                              <h4 class="aa-product-title"><a href="#"><fmt:message key="nav_panel.cpu" /></a></h4>
                            </figcaption>
                          </figure>                         
                        </li>
                        <!-- start single product item -->
                        <li>
                          <figure>
                            <a class="aa-product-img" href="/SummaryTask4/catalog?param=flash"><img src="/SummaryTask4/resources/images/site/index/flash.jpg" width="200px"; height="200px"; alt="FLASH"></a>
                             <figcaption>
                              <h4 class="aa-product-title"><a href="#"><fmt:message key="nav_panel.flash" /></a></h4>
                            </figcaption>
                          </figure>                         
                        </li>
                        <li>
                          <figure>
                            <a class="aa-product-img" href="/SummaryTask4/catalog?param=drive"><img src="/SummaryTask4/resources/images/site/index/hard.jpg" width="200px"; height="200px"; alt="HARD_DRIVE"></a>
                              <figcaption>
                              <h4 class="aa-product-title"><a href="#"><fmt:message key="nav_panel.hdd" /></a></h4>
                            </figcaption>
                          </figure>                        
                        </li>
                      </ul>
                    </div>
                    <!-- / electronic product category -->
                  </div>
</div>

<div>
&nbsp; <fmt:message key="index.body" />

<!-- Интернет магазин E-Shop™

Вас интересует бытовая техника, компьютеры, софт или товары для активного отдыха? Все это вы можете купить прямо сейчас, сэкономив уйму времени! Интернет-магазин E-Shop™ с радостью поможет вам избежать необходимости посещать десятки магазинов. Вы можете заказать любой товар, не вставая со своего кресла, а наш курьер вовремя доставит покупку по указанному адресу. Интернет магазин (Украина) E-Shop™ действует на территории всей страны. Жители любых городов могут без лишних хлопот посетить наш интернет-магазин (Харьков, Киев, Донецк и другие города).

Вне зависимости от того, где вы находитесь на данный момент, вы сможете заказать товар, что, согласитесь, очень удобно. Какие же преимущества предлагает наш интернет-магазин электроники, телефонов и прочих товаров? Наиболее существенный факт – наличие тысяч позиций, которые гарантированно имеются на складе. Вы сможете посетить наш интернет магазин и купить любые товары по невысокой цене. Вам необходим холодильник, стиральная машина или микроволновая печь?

Интернет магазин бытовой техники (Киев, Харьков, Донецк) поможет вам. Наличие множества решений позволит подобрать устройство с требуемыми характеристиками и стоимостью. Интернет-магазин техники (Харьков, Днепропетровск, Донецк) E-Shop – это многообразие предложений на любой вкус. Чтобы заказать товар, вам не придется никуда ехать или идти, т.к. все операции совершаются в виртуальном режиме. Именно поэтому E-Shop – это интернет-магазин телевизоров, холодильников и иной техники, покупать в котором выгодно и приятно. -->
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