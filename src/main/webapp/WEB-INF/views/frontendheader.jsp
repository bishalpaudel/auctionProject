<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!----container---->
<div class="container">
	<!----top-header---->
	<div class="top-header">
		<div class="logo">
			<a href="${pageContext.request.contextPath}/home"><img src="${pageContext.request.contextPath}/resource/frontend/images/logo.png"
				title="barndlogo" /></a>
		</div>
		<div class="top-header-info">
			<div class="top-contact-info">
				<ul class="unstyled-list list-inline">
					<li><span class="phone"> </span>090 - 223 44 66</li>
					<li><span class="mail"> </span><a href="#">help@trendd.com</a></li>
					<div class="clearfix"></div>
				</ul>
			</div>
			<div class="cart-details">
				<div class="add-to-cart">
					<ul class="unstyled-list list-inline">
						<!-- <li><span class="cart"></span><a href=''></a></li> -->
						<a href="?language=en" >English</a>  |  <a href="?language=ne_NP" >Nepali</a>
					</ul>
				</div>
				<div class="login-rigister">
					

						<%-- <security:authorize access="isAuthenticated()">
						 		Welcome  <security:authentication property="principal.username" />
						</security:authorize> --%>

						<%--<security:authorize access="hasRole('supervisor')">--%>

								<%--This content will only be visible to users who have--%>
								<%--the "supervisor" authority in their list of <tt>GrantedAuthority</tt>s.--%>

						<%--</security:authorize>--%>

						<%-- <c:if test="${pageContext.request.userPrincipal.name != null}">
							<h2>
								Welcome : ${pageContext.request.userPrincipal.name} |
								<li>Welcome : ${pageContext.request.userPrincipal.name}</li>
								<li><a class="rigister"
									href='<c:url value="logout"></c:url>'>Logout</a></li>
							</h2>
						</c:if> --%>


					


						<c:choose>
							<c:when test="${pageContext.request.userPrincipal.name != null}">
							
							<%-- <ul class="unstyled-list">
								<li class="login"> <a  href="#"> Welcome : ${pageContext.request.userPrincipal.name}</a></li>
								<li><a class="login"
									href='<c:url value="logout"></c:url>'>Logout</a></li>
									</ul> --%>
									
									
								<ul class="unstyled-list list-inline">
									<li><a class="login" href='<c:url value="#"></c:url>'>Welcome : ${pageContext.request.userPrincipal.name}</a></li>
									<li><a class="btn btn-danger" href='<c:url value=""></c:url>'>Logout</a></li>
								</ul>
							
							
							</c:when>
							
							<c:otherwise> 
								<sec:authorize access="isFullyAuthenticated()">
									<ul class="unstyled-list list-inline">
									<li><a class="btn btn-success" href='<c:url value="getlogin"></c:url>'>Login</a></li>
									<li><a class="btn btn-info"
										href='<c:url value=""></c:url>'>REGISTER <span>
										</span>
									</a></li>
								</ul>
						</sec:authorize>
							</c:otherwise>
						</c:choose>
						




<%-- 
						<security:authorize access="isAnonymous()">
							<li><a class="rigister"
								href='<c:url value="logout"></c:url>'>Logout</a></li>
						</security:authorize>

						<security:authorize access="isAuthenticated()">

						</security:authorize>
 --%>						<!--  -->



						<!--  -->

						<div class="clearfix"></div>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<!----//top-header---->
	<!---top-header-nav---->
	<div class="top-header-nav">
		<!----start-top-nav---->
		<nav class="top-nav main-menu">
			<ul class="top-nav">
				<li><a href="${pageContext.request.contextPath}/home">Home </a><span> </span></li>
				<li><a href="${pageContext.request.contextPath}/myproduct">My
						Product</a><span> </span></li>
				<li><a href="${pageContext.request.contextPath}/wonList">My Bid</a><span> </span></li>
				<li><a href="myproduct">My Product</a></li>				
			</ul>
			<a href="#" id="pull"><img src="images/nav-icon.png" title="menu" /></a>
		</nav>
		<!----End-top-nav---->
		<!---top-header-search-box--->
		<div class="top-header-search-box">
			<form name="search" action="searchItem" method="POST">
				<input type="text" placeholder="Search" name="search"
					required maxlength="22"/> <input type="submit" value="" />
			</form>
		</div>
		<!---top-header-search-box--->
		<div class="clearfix"></div>
	</div>
</div>
<!--//top-header-nav---->