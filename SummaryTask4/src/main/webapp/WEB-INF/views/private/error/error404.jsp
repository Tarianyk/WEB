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

<title>E-Shop | <fmt:message key="title.error404" /></title>
<link rel="shortcut icon" href="/SummaryTask4/resources/images/site/logo/title.png" type="image/png">

	<!-- CSS styles	 -->
	<link href="/SummaryTask4/resources/css/bootstrap.css" rel="stylesheet">
	<link id="switcher" href="/SummaryTask4/resources/css/theme-color/lite-blue-theme.css" rel="stylesheet">
	<link href="/SummaryTask4/resources/css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">
	<link href="/SummaryTask4/resources/css/style.css" rel="stylesheet">
</head>

<body>

	<!-- 404 error section -->
	<div id="aa-error">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-error-area">
						<h2>404</h2>
						<span><fmt:message key="error404.body" /></span>
						<a href="/SummaryTask4"><fmt:message key="error404.link" /></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- / 404 error section -->

</body>
</html>