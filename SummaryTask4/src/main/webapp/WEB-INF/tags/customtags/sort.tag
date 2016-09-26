<%@ tag language="java" pageEncoding="UTF-8"%>

	<!-- Tag's -->
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
	<!-- Localization -->
	<fmt:setLocale value="${language_page}" />
	<fmt:setBundle basename="ua.nure.tarianyk.SummaryTask4.localization.text" />

<div class="col-lg-3 col-md-3 col-sm-4 col-md-pull-9">
	<aside class="aa-sidebar">
		<!-- single sidebar -->
		<div class="aa-sidebar-widget">
			<h3>
				<fmt:message key="sort_tag.sort_interval" />
			</h3>
			
			<!-- start price range -->
			<div class="aa-sidebar-price-range">
				<form action="/SummaryTask4/sort?direct=interval&kind=${kind}" method="post" class="sort">
					<input type="number" value="0" size="10" name="from" required> -
					<input type="number" value="100000" size="10" name="to" required> :
					<input type="submit" size="10" value="Ok"> ${from_p}
				</form>
			</div>
			<!-- end price range -->
			
		</div>
		<!-- single sidebar -->
		<div class="aa-sidebar-widget">
			<h3>
				<fmt:message key="sort_tag.sort_name" />
			</h3>
			
			<!-- start az range -->
			<div class="aa-sidebar-price-range">
				<a href="/SummaryTask4/sort?direct=az&kind=${kind}"><img src="/SummaryTask4/resources/images/site/arrows/arrowdown.png" height="25px"	width="25px" /></a>
				<a href="/SummaryTask4/sort?direct=za&kind=${kind}"><img src="/SummaryTask4/resources/images/site/arrows/arrowup.png" height="25px" width="25px/"></a>
			</div>
			<!-- end az range -->
			
		</div>
		<!-- single sidebar -->
		<div class="aa-sidebar-widget">
			<h3>
				<fmt:message key="sort_tag.sort_price" />
			</h3>

			<!-- start price range -->
			<div class="aa-sidebar-price-range">
				<a href="/SummaryTask4/sort?direct=from&kind=${kind}"><img src="/SummaryTask4/resources/images/site/arrows/arrowdown.png" height="25px" width="25px" /></a> &nbsp;
				<a href="/SummaryTask4/sort?direct=to&kind=${kind}"><img	src="/SummaryTask4/resources/images/site/arrows/arrowup.png" height="25px" width="25px/"></a>
			</div>
			<!-- end price range -->
			
		</div>
		<!-- single sidebar -->
		<div class="aa-sidebar-widget">
			<h3>
				<fmt:message key="sort_tag.sort_novelty" />
			</h3>
			
			<!-- start novelty range -->
			<div class="aa-sidebar-price-range">
				<a href="/SummaryTask4/sort?direct=novelty&kind=${kind}"><fmt:message key="sort_tag.sort_novelty" /></a>
			</div>
			<!-- end novelty range -->
		</div>
		
		<!-- single sidebar -->
		<div class="aa-sidebar-widget">
			<h3>
				<fmt:message key="sort_tag.reset_sort" />
			</h3>
			
			<!-- start clear -->
			<div class="aa-sidebar-price-range">
				<a href="/SummaryTask4/catalog?param=${fn:toLowerCase(kind)}"><fmt:message key="sort_tag.reset_link" /></a>
			</div>
			<!-- end clear -->
			
		</div>
	</aside>
</div>