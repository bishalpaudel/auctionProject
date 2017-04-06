<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<%-- TODO: Get all the placeholders from message--%>
<!----content---->
<div class="content">
    <div class="container">
        <div class="main-login main-center">
            <h4>
                <spring:message code="register.form.title" />
            </h4>
            <form:form modelAttribute="product" method="POST">
                <%--&lt;%&ndash;enctype="multipart/form-data">&ndash;%&gt;--%>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <div class="form-group">
                    <form:errors path="*" class="form-error-new" />
                </div>

                <div class="form-group">
                    <label class="cols-sm-2 control-label"><spring:message
                            code="productCreate.form.category" /></label>
                    <div class="cols-sm-10">
                        <div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
                                                               aria-hidden="true"></i></span>
                            <%-- TODO: Support selection for nested categories --%>
                            <form:select path="category.id" placeholder="Enter Category" class="form-control">
                                <form:options items="${categories}"/>
                            </form:select>
                        </div>
                        <form:errors path="category" class="form-error-new" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="title" class="cols-sm-2 control-label"><spring:message
                            code="productCreate.form.title" /></label>
                    <div class="cols-sm-10">
                        <div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
                                                               aria-hidden="true"></i></span>
                            <form:input path="title" class="form-control" id="title"
                                        placeholder="Enter Title" type="text" />
                        </div>
                        <form:errors path="title" class="form-error-new" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="model" class="cols-sm-2 control-label"><spring:message
                            code="productCreate.form.model" /></label>
                    <div class="cols-sm-10">
                        <div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
                                                               aria-hidden="true"></i></span>
                            <form:input path="model" class="form-control" id="model"
                                        placeholder="Enter Model" type="text" />
                        </div>
                        <form:errors path="model" class="form-error-new" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="brand" class="cols-sm-2 control-label"><spring:message
                            code="productCreate.form.brand" /></label>
                    <div class="cols-sm-10">
                        <div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
                                                               aria-hidden="true"></i></span>
                            <form:input path="brand" class="form-control" id="brand"
                                        placeholder="Enter Brand" type="text" />
                        </div>
                        <form:errors path="brand" class="form-error-new" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="description" class="cols-sm-2 control-label"><spring:message
                            code="productCreate.form.description" /></label>
                    <div class="cols-sm-10">
                        <div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
                                                               aria-hidden="true"></i></span>
                            <form:input path="description" class="form-control" id="description"
                                        placeholder="Enter Description" type="text" />
                        </div>
                        <form:errors path="description" class="form-error-new" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="directBuyPrice" class="cols-sm-2 control-label"><spring:message
                            code="productCreate.form.buy_price" /></label>
                    <div class="cols-sm-10">
                        <div class="input-group">
							<span class="input-group-addon">
                                <i class="fa fa-user fa" aria-hidden="true"></i>
                            </span>
                            <form:input path="directBuyPrice" class="form-control" id="directBuyPrice"
                                        placeholder="Enter Direct Buy amount" type="text" />
                        </div>
                        <form:errors path="directBuyPrice" class="form-error-new" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="initialBidAmount" class="cols-sm-2 control-label"><spring:message
                            code="productCreate.form.bid_start_price" /></label>
                    <div class="cols-sm-10">
                        <div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
                                                               aria-hidden="true"></i></span>
                            <form:input path="initialBidAmount" class="form-control" id="initialBidAmount"
                                        placeholder="Enter Bid Starting Amount" type="text" />
                        </div>
                        <form:errors path="initialBidAmount" class="form-error-new" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="minBidIncrementAmount" class="cols-sm-2 control-label"><spring:message
                            code="productCreate.form.bid_increment_amount" /></label>
                    <div class="cols-sm-10">
                        <div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
                                                               aria-hidden="true"></i></span>
                            <form:input path="minBidIncrementAmount" class="form-control" id="minBidIncrementAmount"
                                        placeholder="Enter Bid Increment Amount" type="text" />
                        </div>
                        <form:errors path="minBidIncrementAmount" class="form-error-new" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="auctionStartDate" class="cols-sm-2 control-label"><spring:message
                            code="productCreate.form.auction_start_date" /></label>
                    <div class="cols-sm-10">
                        <div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
                                                               aria-hidden="true"></i></span>
                            <form:input path="auctionStartDate" class="form-control" id="auctionStartDate"
                                        placeholder="Enter Auction Starting Day" type="text" />
                        </div>
                        <form:errors path="auctionStartDate" class="form-error-new" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="auctionEndDate" class="cols-sm-2 control-label"><spring:message
                            code="productCreate.form.auctionEndDate" /></label>
                    <div class="cols-sm-10">
                        <div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
                                                               aria-hidden="true"></i></span>
                            <form:input path="auctionEndDate" class="form-control" id="auctionEndDate"
                                        placeholder="Auction End Date" type="text" />
                        </div>
                        <form:errors path="auctionEndDate" class="form-error-new" />
                    </div>
                </div>

                <%-- TODO: Add Picture/Video --%>


                <div class="form-group ">
                    <input type="submit" name="register"
                           value="<spring:message code="productCreate.form.submit"/>"
                           class="btn btn-primary btn-lg btn-block login-button">
                </div>
            </form:form>
        </div>

    </div>
</div>
