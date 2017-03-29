<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<!----content---->
<div class="content">
	<div class="container">
		<div class="col-md-4 col-md-offset-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Please sign in</h3>
				</div>
				<div class="panel-body">
                    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
						<div class="alert alert-danger">
							<spring:message code="Login.AbstractUserDetailsAuthenticationProvider.badCredentials" />
							<br />
						</div>
					</c:if>
					<form action="<spring:url value="/login"></spring:url>" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<fieldset>
							<div class="form-group">
								<input class="form-control form:input-large" placeholder="User Name"
									name='username' type="text">
							</div>
							<div class="form-group">
								<input class="form-control form:input-large" placeholder="Password"
									name='password' type="password" value="">
							</div>
							<div class="form-group">
								<input type='checkbox' name="keepMe" />Remember Me? <br />
							</div>
							<input class="btn btn-lg btn-success btn-mini" type="submit"
								value="Login">
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>