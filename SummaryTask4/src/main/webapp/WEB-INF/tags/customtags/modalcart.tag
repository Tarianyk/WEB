<%@ tag language="java" pageEncoding="UTF-8"%>

	<!-- Tag's -->
	<%@ tag body-content="empty" dynamic-attributes="ccc"%>
	<%@ attribute name="caption" type="java.util.Collection"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="my" uri="http://www.tomcat-demo.com/totalproduct"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	
	<!-- Localization -->
	<fmt:setLocale value="${language_page}" />
	<fmt:setBundle basename="ua.nure.tarianyk.SummaryTask4.localization.text" />

<div class="aa-cartbox">
	<a class="aa-cart-link" href="#">
		<span class="fa fa-shopping-basket"></span>
		<span class="aa-cart-title"><fmt:message key="modalcart_tag.title" /> : <b style="color: red;"><my:total_product /></b></span>
	</a>
	<div class="aa-cartbox-summary">
		<ul>
			<c:forEach items="${caption}" var="post">
				<li>
					<a class="aa-cartbox-img" href="#"><img	src="${post.path}" alt="img"></a>
					
					<div class="aa-cartbox-info">
						<h4>
							<a href="#">${post.article}</a>
						</h4>
						<p>${post.count}x${post.price}</p>
					</div>
				</li>
			</c:forEach>
		</ul>
		<a class="aa-cartbox-checkout aa-primary-btn" href="/SummaryTask4/views/public/shoppingcart.jsp"><fmt:message key="modalcart_tag.forward" /></a>
	</div>
</div>