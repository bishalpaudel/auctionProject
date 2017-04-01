<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

        <!---top-row--->
        <div class="main-login main-center">
            <h4>
                <spring:message code="register.form.title" />
            </h4>
            <form:form modelAttribute="PWResetEmailDTO" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                <div class="form-group">
                    <label for="email" class="cols-sm-2 control-label"><spring:message
                            code="register.form.email" /></label>
                    <div class="cols-sm-10">
                        <div class="input-group">
							<span class="input-group-addon">
                                <i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <form:input path="email" class="form-control" id="email"
                                        placeholder="Enter your Email" type="text" />
                        </div>
                        <form:errors path="email" class="form-error-new" />
                    </div>
                </div>

                <div class="form-group ">
                    <input type="submit" name="register"
                           value="<spring:message code="register.form.register"/>"
                           class="btn btn-primary btn-lg btn-block login-button" />
                </div>
            </form:form>
        </div>

    </div>
</div>
<!----content---->