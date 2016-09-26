<%@ tag language="java" pageEncoding="UTF-8"%>

	<!-- Tag's -->
	<%@ tag body-content="empty" dynamic-attributes="ccc"%>
	<%@ attribute name="caption" type="java.util.Collection"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- Localization -->
	<fmt:setLocale value="${language_page}" />
	<fmt:setBundle basename="ua.nure.tarianyk.SummaryTask4.localization.text" />

<!-- Products section -->
<div id="aa-product">
	<div class="container">
		<div class="col-md-12">
			<div class="tab-pane fade in active">
				<ul class="aa-product-catg">

					<c:forEach items="${caption}" var="post">

						<!-- start single product item -->
						<li>
							<figure>
								<a class="aa-product-img" href="/SummaryTask4/detail?article=${post.article}&desc_2=${post.desc_2}&path=${post.path}&price=${post.price}&param=${post.desc_2}"><img	src="${post.path}" alt="polo shirt img"></a>
								<a class="aa-add-card-btn" href="/SummaryTask4/addshopcart?article=${post.article}&desc_2=${post.desc_2}&path=${post.path}&price=${post.price}"><span class="fa fa-shopping-cart"></span><fmt:message key="list.add" /></a>
								<figcaption>
									<h4 class="aa-product-title">
										<a href="#">${post.title}</a>
									</h4>
									<span class="aa-product-price">${post.price}</span>
								</figcaption>
							</figure>
						</li>
					</c:forEach>

				</ul>
			</div>
		</div>
	</div>
</div>
<!-- / Products section -->