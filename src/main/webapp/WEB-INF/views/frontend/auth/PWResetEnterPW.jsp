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
    <form:form modelAttribute="dto" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <div class="form-group">
            <form:errors path="*" class="form-error-new" />
        </div>
        <div class="form-group">
            <div class="form-group">
                <label for="password" class="cols-sm-2 control-label"><spring:message
                        code="register.form.password" /></label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="fa fa-lock fa-lg" aria-hidden="true"></i>
                        </span>
                        <form:input path="password" class="form-control"
                                    id="password" placeholder="Enter your Password" type="password" />
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="repeatPassword" class="cols-sm-2 control-label"><spring:message
                        code="register.form.repeatPassword" /></label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i
                                class="fa fa-lock fa-lg" aria-hidden="true"></i>
                        </span>
                        <form:input path="repeatPassword" class="form-control"
                                    id="repeatPassword" placeholder="Enter your Password again" type="password" />
                    </div>
                    <form:errors path="repeatPassword" class="form-error-new" />
                </div>
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