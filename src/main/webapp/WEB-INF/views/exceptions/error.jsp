<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	response.setStatus(403);
%>


	<center>

		<img
			src="<spring:url value="resource/images/error_page.png" htmlEscape="true" />"
			alt="Page not found  JSP!!!" />

		<%-- <H2>${requestScope['javax.servlet.error.message']}</H2> --%>

		<p>
			
			<%-- <br/> Exception Type: ${exception} --%>
			<%--<br /> Exception Type:${errorcode} ${exceptionClassSimpleName} --%>
			<c:forEach items="${exception.stackTrace}" var="ste"> ${ste} 
    </c:forEach>
		</p>


		
	</center>
	<div class="row">
		<div class="col-lg-6 col-lg-offset-3">
			<h1 class="error-title">${errorcode}</h1>
			<h4 class="error-msg">
				<i class="fa fa-warning text-red"></i> ${exceptionClassSimpleName}
			</h4>
			<p class="lead">The web server encountered an unexpected
				condition that prevented it from fulfilling your request. Please try
				again!!!</p>
				<p class="lead">Failed URL: ${url}</p>
			
			<p>
			<a class="btn btn-default" href="${pageContext.request.contextPath}/">Back to Home Page</a>
		</p>
			
		</div>
		<!-- /.col-lg-6 -->
	</div>
