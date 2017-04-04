<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!----content---->
<div class="content">
    <div class="container">
        <div class="special-products-grids">
            <c:forEach items="${products.content}" var="asset">
                <div class="col-md-3 special-products-grid text-center">
                    <a class="brand-name" href='<c:url value="${asset.id}"></c:url>'></a>
                        <img src="" title="${asset.title}"/>
                    </a>
                    <h4>
                        <a href="#"> ${asset.title}</a>
                    </h4>
                    <a class="product-btn" href="${asset.id}">
                        <span>${asset.minBidIncrementAmount}$</span>
                        <small>Bid</small>
                        <label> </label>
                    </a>
                </div>
            </c:forEach>
            <div class="clearfix"></div>
        </div>
        <%-- TODO: Implement Pagination taglib (WEB-INF/util/pagination.tag) --%>
    </div>
</div>