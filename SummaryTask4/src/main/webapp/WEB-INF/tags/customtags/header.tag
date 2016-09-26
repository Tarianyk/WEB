<%@ tag language="java" pageEncoding="UTF-8"%>

	<!-- Tag's -->
	<%@ tag body-content="empty" dynamic-attributes="ccc"%>
	<%@ attribute name="caption" type="java.util.Collection"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="my" uri="http://www.tomcat-demo.com/total"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="my_tag" tagdir="/WEB-INF/tags/customtags/"%>
	
	<!-- Localization -->
	<fmt:setLocale value="${language_page}" />
	<fmt:setBundle basename="ua.nure.tarianyk.SummaryTask4.localization.text" />

	<!-- Start header section -->
	<div id="aa-header">
	<div class="aa-header-top">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-header-top-area">

						<div class="aa-header-top-left">

							<!-- start language -->
							<my_tag:language />
							<!-- / language -->

							<!-- start cellphone -->
							<div class="cellphone hidden-xs">
								<p>
									<span class="fa fa-phone"></span>097-98-21-944
								</p>
							</div>
							<!-- end cellphone -->
							
						</div>

						<div class="aa-header-top-right">
							<ul class="aa-head-top-nav-right">
								<c:if test="${user != null}">
										<li class="hidden-xs">
											<fmt:message key="nav_menu.greeting" /> ${user.firstName}
										</li>
									</c:if>
								<li class="hidden-xs"><a href="/SummaryTask4/views/public/shoppingcart.jsp"><fmt:message key="nav_menu.cart" /></a></li>

								<c:choose>
									<c:when test="${user.role == null}">
										<li><a href="" data-toggle="modal" data-target="#login-modal"><fmt:message key="nav_menu.login" /></a></li>
									</c:when>
									<c:otherwise>
										<c:if test="${user.role == 'ADMIN'}">
										   <li><a href="/SummaryTask4/admin?param=forward"><fmt:message key="nav_menu.admin" /></a></li>
										</c:if>
										<li><a href="/SummaryTask4/personalarea"><fmt:message key="nav_menu.personal" /></a></li>
										<li><a href="/SummaryTask4/exit?param=true"><fmt:message key="nav_menu.exit" /></a></li>
									</c:otherwise>
								</c:choose>

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

		<div class="aa-header-bottom">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="aa-header-bottom-area">
						
							<!-- start logo  -->
							<div class="aa-logo">
								<a href="/SummaryTask4/"> <p> E-<strong>Shop</strong> </p> </a>						
							</div>
							<!-- end logo  -->
	
							<!-- cart box -->
							<my_tag:modalcart caption="${backet}" />
							<!-- end box -->
	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- / header section -->
