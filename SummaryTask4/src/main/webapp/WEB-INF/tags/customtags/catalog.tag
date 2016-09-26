<%@ tag language="java" pageEncoding="UTF-8"%>

	<!-- Tag's -->
	<%@ tag body-content="empty" dynamic-attributes="ccc"%>
	<%@ attribute name="caption" type="java.lang.String"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="my" tagdir="/WEB-INF/tags/customtags/"%>

	<!-- Localization -->
	<fmt:setLocale value="${language_page}" />
	<fmt:setBundle basename="ua.nure.tarianyk.SummaryTask4.localization.text" />

<!-- Products section -->
<div id="aa-product">
	<div class="container">
		<div class="col-md-12">
			<div class="tab-pane fade in active">
				<ul class="aa-product-catg">
				
				<c:if test="${kind == 'CPU'}">
 					<my:list caption="${CPU}"/> 
				</c:if>
				<c:if test="${kind == 'SOUND'}">
					<my:list caption="${SOUND}"/>
				</c:if>
				<c:if test="${kind == 'DRIVE'}">
					<my:list caption="${DRIVE}"/>
				</c:if>
				<c:if test="${kind == 'CAMERA'}">
					<my:list caption="${CAMERA}"/>
				</c:if>
				<c:if test="${kind == 'FLASH'}">
					<my:list caption="${FLASH}"/>	
				</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- / Products section -->