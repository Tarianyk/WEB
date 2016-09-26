<%@ tag language="java" pageEncoding="UTF-8"%>

	<!-- Tag's -->
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	
	<!-- reCAPTCHA Libary -->
	<script src='https://www.google.com/recaptcha/api.js?hl=en'></script>

	<!-- Localization -->
	<fmt:setLocale value="${language_page}" />
	<fmt:setBundle basename="ua.nure.tarianyk.SummaryTask4.localization.text" />

<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4>
					<fmt:message key="login_tag.authentication" />
				</h4>
				
				<!-- start login form -->
				<form action="/SummaryTask4/login?param=true" method="post" class="aa-login-form">
					<label for=""><fmt:message key="login_tag.login" /><span>*</span></label>
					<input type="email" placeholder="<fmt:message key="login_tag.login_placeholder" />"	name="login" required>
					<label for=""><fmt:message key="login_tag.password" /><span>*</span></label>
					<input type="password" placeholder="<fmt:message key="login_tag.password_place_holder" />" name="password" required>

					<!-- start reCAPTCHA block -->
					<div class="g-recaptcha" data-sitekey="6LdlBSgTAAAAAI5EDY-LgXiAgDeAdBmSJQhd53XG"></div>
					<!-- end reCAPTCHA block -->
					
					<button class="aa-browse-btn" type="submit">
						<fmt:message key="login_tag.button" />
					</button>			

					<div class="aa-register-now">
					
						<fmt:message key="login_tag.empty" />
						<a href="/SummaryTask4/views/public/registration.jsp"><fmt:message key="login_tag.registration" /></a>
					</div>
					
				</form>
				<!-- end login form -->
				
			</div>
		</div>
	</div>
</div>