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

<!-- Cart view section -->
<div id="cart-view">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="cart-view-area">
					<div class="cart-view-table">
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th></th>
										<th><fmt:message key="cart_tag.article" /></th>
										<th><fmt:message key="cart_tag.amount" /></th>
										<th><fmt:message key="cart_tag.price" /></th>
										<th><fmt:message key="cart_tag.delete" /></th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${caption}" var="post">
										<tr>
											<th><img src="${post.path}" width="150" height="150"></th>
											<th>${post.article}</th>
											<th>${post.count}</th>
											<th>${post.totalAmount}</th>
											<th>
												<div>
												
													<!-- start delete form -->
													<form action="/SummaryTask4/delete?article=${post.article}" method="post">
														<input type="image"	src="/SummaryTask4/resources/images/site/delete.png" height="25px" width="25px">
													</form>
													<!-- end delete form -->
													
												</div>
											</th>
										</tr>
									</c:forEach>

									<td colspan="6" class="aa-cart-view-bottom">
										<div class="aa-cart-coupon">
											<c:if test="${user.role != null && backet != null}">
											
												<!-- start buy form -->
												<form action="/SummaryTask4/buything?param=true" method="post">
													<input type="image" src="/SummaryTask4/resources/images/site/buy.png">
												</form>
												<!-- end buy form -->
												
											</c:if>
										</div>
									</td>
									
									<!-- Cart Total view -->
									<div class="cart-view-total">
										<h4>
											<fmt:message key="cart_tag.cart_total" />
										</h4>
										<table class="aa-totals-table">
											<tbody>
												<tr>
													<th><fmt:message key="cart_tag.total" /></th>
													<td><my:total /></td>
												</tr>

											</tbody>
										</table>
									</div>
								</tbody>
							</table>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- / Cart view section -->
