<%@ tag language="java" pageEncoding="UTF-8"%>

	<!-- Tag's -->
	<%@ tag body-content="empty" dynamic-attributes="ccc"%>
	<%@ attribute name="caption" type="java.util.Collection"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	
	<!-- Localization -->
	<fmt:setLocale value="${language_page}" />
	<fmt:setBundle basename="ua.nure.tarianyk.SummaryTask4.localization.text" />


<table border="1">
	<tr>
		<th><fmt:message key="orders_tag.number" /></th>
		<th><fmt:message key="orders_tag.article" /></th>
		<th><fmt:message key="orders_tag.price" /></th>
		<th><fmt:message key="orders_tag.status" /></th>
	</tr>
	<c:forEach items="${caption}" var="post">
		<tr>
			<th>${post.id}</th>
			<th>${post.article}</th>
			<th>${post.totalPrice}</th>
			<th>${post.status}</th>
		</tr>
	</c:forEach>
</table>

