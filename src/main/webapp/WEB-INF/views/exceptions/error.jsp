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
                    <h3 class="panel-title">Application Error, please contact support.</h3>
                </div>
                <div class="panel-body">
                    <h3>Debug Information:</h3>

                    Requested URL= ${url}<br><br>

                    Exception= ${exception.message}<br><br>

                    <strong>Exception Stack Trace</strong><br>
                    <c:forEach items="${exception.stackTrace}" var="ste">
                        ${ste}
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>