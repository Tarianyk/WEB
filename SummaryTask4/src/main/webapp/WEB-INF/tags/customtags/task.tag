<%@ tag language="java" pageEncoding="UTF-8"%>

<!-- Tag's -->
<%@ tag body-content="empty" dynamic-attributes="ccc"%>
<%@ attribute name="caption" type="java.util.Collection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Localization -->
<fmt:setLocale value="${language_page}" />
<fmt:setBundle
	basename="ua.nure.tarianyk.SummaryTask4.localization.text" />


<table border="1">
	<tr>
		<th>Order ID</th>
		<th>Catalog Title</th>
		<th>Language</th>
	</tr>
	<c:forEach items="${task}" var="post">
		<tr>
			<th>${post.ordersID}</th>
			<th>${post.catalogTitle}</th>
			<th>${post.language}</th>
		</tr>
	</c:forEach>
</table>

