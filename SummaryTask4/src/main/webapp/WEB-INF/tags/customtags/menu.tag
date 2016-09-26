<%@ tag language="java" pageEncoding="UTF-8"%>

	<!-- Tag's -->
	<%@ tag body-content="empty" dynamic-attributes="ccc"%>
	<%@ attribute name="caption" type="java.util.Collection"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="my" uri="http://www.tomcat-demo.com/total"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	
	<!-- Localization -->
	<fmt:setLocale value="${language_page}" />
	<fmt:setBundle basename="ua.nure.tarianyk.SummaryTask4.localization.text" />

<!-- menu -->
	<div id="menu">
		<div class="container">
			<div class="menu-area">
				<!-- Navbar -->
				<div class="navbar navbar-default" role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div>
					<div class="navbar-collapse collapse">
	
						<ul class="nav navbar-nav">
							<li><a href="/SummaryTask4/"><fmt:message key="nav_panel.home" /></a></li>
							<li>
								<a href="#"><fmt:message key="nav_panel.computer" /> <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="/SummaryTask4/catalog?param=cpu"><fmt:message key="nav_panel.cpu" /></a></li>
									<li><a href="/SummaryTask4/catalog?param=sound"><fmt:message key="nav_panel.sound" /></a></li>
									<li><a href="/SummaryTask4/catalog?param=drive"><fmt:message key="nav_panel.hdd" /></a></li>
								</ul>
							</li>
							<li>
								<a href="#"><fmt:message key="nav_panel.photo" /> <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="/SummaryTask4/catalog?param=camera"><fmt:message key="nav_panel.camera" /></a></li>
									<li><a href="/SummaryTask4/catalog?param=flash"><fmt:message key="nav_panel.flash" /></a></li>
								</ul>
							</li>
							<li><a href="/SummaryTask4/views/public/contact.jsp"><fmt:message key="nav_panel.contact" /></a></li>
						</ul>
					
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- / menu -->
