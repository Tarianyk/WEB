<!-- Tag's -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- Localization -->
<fmt:setLocale value="${language_page}" />
<fmt:setBundle basename="ua.nure.tarianyk.SummaryTask4.localization.text" />
	
<div class="aa-language">

	<c:choose>
		<c:when test="${language_page == 'en'}">
			<img src="/SummaryTask4/resources/images/site/flag/english.jpg" width="25px"	height="25px" alt="english">
			<font size="2"><fmt:message key="language_tag.eng" /></font>
		</c:when>
		<c:otherwise>
			<img src="/SummaryTask4/resources/images/site/flag/russian.png" width="25px"	height="25px" alt="russian">
			<font size="2"><fmt:message key="language_tag.rus" /></font>
		</c:otherwise>
	</c:choose>

</div>