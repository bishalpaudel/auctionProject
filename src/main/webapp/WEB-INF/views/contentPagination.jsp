<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!----content---->
<div class="content">
	<div class="container">
		<!---top-row--->
		<div class="top-row">
			<div class="col-xs-4">
				<div class="top-row-col1 text-center">
					<h2>Hot List</h2>
					<img class="r-img text-center"
						src="resource/frontend/images/img-w.jpg" title="name" /> <span><img
						src="resource/frontend/images/obj1.png" title="name" /></span>
					<h4>TOTAL</h4>
					<label>357 PRODUCTS</label> <a class="r-list-w"
						href="single-page.html"><img
						src="resource/frontend/images/list-icon.png" title="list" /></a>
				</div>
			</div>
			<div class="col-xs-4">
				<div class="top-row-col1 text-center">
					<h2>Finished Auction</h2>
					<img class="r-img text-center"
						src="resource/frontend/images/man-r-img.jpg" title="name" /> <span><img
						src="resource/frontend/images/obj2.png" title="name" /></span>
					<h4>TOTAL</h4>
					<label>357 PRODUCTS</label> <a class="r-list-w"
						href="single-page.html"><img
						src="resource/frontend/images/list-icon.png" title="list" /></a>
				</div>
			</div>
			<div class="col-xs-4">
				<div class="top-row-col1 text-center">
					<h2>Comming Soon</h2>
					<img class="r-img text-center"
						src="resource/frontend/images/kid-r-img.jpg" title="name" /> <span><img
						src="resource/frontend/images/obj3.png" title="name" /></span>
					<h4>TOTAL</h4>
					<label>357 PRODUCTS</label> <a class="r-list-w"
						href="single-page.html"><img
						src="resource/frontend/images/list-icon.png" title="list" /></a>
				</div>
			</div>
			<vdi class="clearfix">
		</div>
	</div>
	<!---top-row--->

	<!---top-row--->
	<div class="container">
	
	
		<c:url var="firstUrl" value="/pages/1" />
		<c:url var="lastUrl" value="/pages/${deploymentLog.totalPages}" />
		<c:url var="prevUrl" value="/pages/${currentIndex - 1}" />
		<c:url var="nextUrl" value="/pages/${currentIndex + 1}" />
		<div class="special-products-grids">
				<c:forEach items="${deploymentLog.getContent()}" var="asset">
					<div class="col-md-3 special-products-grid text-center">
						<a class="brand-name" href='<c:url value="productDetail?productid=${asset.assetId}"></c:url>'> <!-- <img src="resource/frontend/images/b1.jpg" title="name" /> -->
						</a> <a class="product-here" href="single-page.html"> <!-- <img src="resource/frontend/images/p1.jpg" title="product-name" /> -->
								<c:if test="${not empty asset.getProductImage()}">
	   								<img src="${pageContext.request.contextPath}/resource/img/assets/${asset.getProductImage().get(0).getProductName()}" title="${asset.name}"/>
								</c:if>	
							</a>							
						<h4>
							<a href="single-page.html"> ${asset.name}</a>
						</h4>
						<!-- 	<h4><a href="single-page.html">Current Bid :$ 50.00</a></h4> -->
						<a class="product-btn"
							href="${pageContext.request.contextPath}/productDetail?productid=${asset.assetId}"><span>${asset.minimumBidAmount}$</span><small>Bid
						</small><label> </label></a>
					</div>
				</c:forEach>
				<div class="clearfix"></div>
			</div>
		<p>Showing <c:out value="${deploymentLog.getNumberOfElements()}"></c:out> Content From <c:out value="${beginIndex}"></c:out> to <c:out value="${endIndex}"></c:out> of <c:out value="${total}"></c:out> Item</p>
		<div class="pagination">
			<ul>
				<c:choose>
					<c:when test="${currentIndex == 1}">						
					</c:when>
					<c:otherwise>
						<li><a href="${firstUrl}">&lt;&lt;</a></li>
						<li><a href="${prevUrl}">&lt;</a></li>
					</c:otherwise>
				</c:choose>
				<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
					<c:url var="pageUrl" value="/pages/${i}" />
					<c:choose>
						<c:when test="${i == currentIndex}">
							<li class="active"><a href="${pageUrl}"><c:out
										value="${i}" /></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${currentIndex == deploymentLog.totalPages}">						
					</c:when>
					<c:otherwise>
						<li><a href="${nextUrl}">&gt;</a></li>
						<li><a href="${lastUrl}">&gt;&gt;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>

	</div>
	<!----content---->