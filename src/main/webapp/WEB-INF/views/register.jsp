<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!----content---->
<div class="content">
	<div class="container">
		<style type="text/css">
.main-center {
	margin-top: 30px;
	margin: 0 auto;
	max-width: 400px;
	padding: 10px 40px;
	background: #009edf;
	color: #444444;
	text-shadow: none;
	-webkit-box-shadow: 0px 3px 5px 0px rgba(0, 0, 0, 0.31);
	-moz-box-shadow: 0px 3px 5px 0px rgba(0, 0, 0, 0.31);
	box-shadow: 0px 3px 5px 0px rgba(0, 0, 0, 0.31);
	text-shadow: none;
}

.main-login {
	background-color: #fff;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	-moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	-webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.form-error-new {
	background-color: #asd;
	color: #FF0000;
}
</style>
		<!---top-row--->
		<div class="main-login main-center">
			<h4>
				<spring:message code="register.form.title" />
			</h4>
			<form:form modelAttribute="registerNewUser" method="post"
				enctype="multipart/form-data">

				<div class="form-group">
					<form:errors path="*" class="form-error-new" />
				</div>

				<div class="form-group">
					<label for="name" class="cols-sm-2 control-label"><spring:message
							code="register.form.fullName" /></label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
								aria-hidden="true"></i></span>
							<form:input path="fullName" class="form-control" id="fullname"
								placeholder="Enter your Full Name" type="text" />
						</div>
						<form:errors path="fullName" class="form-error-new" />
					</div>
				</div>

				<div class="form-group">
					<label for="email" class="cols-sm-2 control-label"><spring:message
							code="register.form.email" /></label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-envelope fa" aria-hidden="true"></i></span>
							<form:input path="email" class="form-control" id="email"
								placeholder="Enter your Email" type="text" />
						</div>
						<form:errors path="email" class="form-error-new" />
					</div>
				</div>

				<div class="form-group">
					<label for="username" class="cols-sm-2 control-label"><spring:message
							code="register.form.userName" /></label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-user-circle" aria-hidden="true"></i></span>
							<form:input path="userCredential.userName" class="form-control"
								id="username" placeholder="Enter your Username" type="text" />
						</div>
						<form:errors path="userCredential.userName" class="form-error-new" />
					</div>
				</div>

				<div class="form-group">
					<label for="password" class="cols-sm-2 control-label"><spring:message
							code="register.form.password" /></label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
							<form:input path="userCredential.password" class="form-control"
								id="password" placeholder="Enter your Password" type="password" />
						</div>
						<form:errors path="userCredential.password" class="form-error-new" />
					</div>
				</div>

				<div class="form-group">
					<form:input path="userCredential.role" class="form-control"
						id="role" value="ROLE_USER" type="hidden" />
				</div>

				<div class="form-group">
					<label for="phone" class="cols-sm-2 control-label"><spring:message
							code="register.form.phone" /></label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
							<form:input path="phone" class="form-control" id="phone"
								placeholder="Enter your Phone" type="text" />
							<%-- <form:errors path="phone" class="form-error-new"> --%>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="street" class="cols-sm-2 control-label"><spring:message
							code="register.form.street" /></label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
							<form:input path="street" class="form-control" id="street"
								placeholder="Enter your Street" type="text" />

						</div>
						<form:errors path="street" class="form-error-new" />
					</div>
				</div>

				<div class="form-group">
					<label for="city" class="cols-sm-2 control-label"><spring:message
							code="register.form.city" /></label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
							<form:input path="city" class="form-control" id="city"
								placeholder="Enter your City" type="text" />
							<%-- <form:errors path="state" class="form-error-new"> --%>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="state" class="cols-sm-2 control-label"><spring:message
							code="register.form.state" /></label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
							<form:input path="state" class="form-control" id="state"
								placeholder="Enter your State" type="text" />
							<%-- <form:errors path="state" class="form-error-new"> --%>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="zip" class="cols-sm-2 control-label"><spring:message
							code="register.form.zip" /></label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
							<form:input path="zip" class="form-control" id="zip"
								placeholder="Enter your Zip" type="text" />
						</div>
						<form:errors path="zip" class="form-error-new" />
					</div>
				</div>

				<div class="form-group">
					<label for="country" class="cols-sm-2 control-label"><spring:message
							code="register.form.country" /></label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
							<form:input path="country" class="form-control" id="country"
								placeholder="Enter your Country" type="text" />
							<%-- <form:errors path="country" class="form-error-new"> --%>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="status" class="cols-sm-2 control-label"><spring:message
							code="register.form.profile" /></label>
					<div class="cols-md-10">
						<div class="input-group">
							<input type="file" name="picture" id="picture" accept="image/*" />
							<%-- 	<form:errors path="status" class="form-error-new" /> --%>
						</div>
					</div>
				</div>

				<div class="form-group ">
					<input type="submit" name="register"
						value="<spring:message code="register.form.register"/>"
						class="btn btn-primary btn-lg btn-block login-button">
					<!-- <a href="http://deepak646.blogspot.in" target="_blank" type="button"
						id="button" class="btn btn-primary btn-lg btn-block login-button">Register</a> -->
				</div>
			</form:form>
		</div>

	</div>
	<!---//speical-products---->
</div>
<!----content---->