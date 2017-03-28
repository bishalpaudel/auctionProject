<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><tiles:insertAttribute name="title" ignore="true" /></title>

    <!-- tiles -->
    <tiles:insertAttribute name="pagecss"></tiles:insertAttribute>

</head>

<body>

<div id="wrapper">

    <tiles:insertAttribute name="header"></tiles:insertAttribute>

    <!-- begin SIDE NAVIGATION -->
    <tiles:insertAttribute name="sidebar"></tiles:insertAttribute>
    <!-- /.navbar-side -->
    <!-- end SIDE NAVIGATION -->

    <!-- begin MAIN PAGE CONTENT -->
    <div id="page-wrapper">

        <!-- content tiles -->
        <tiles:insertAttribute name="content"></tiles:insertAttribute>

    </div>
    <!-- /#page-wrapper -->
    <!-- end MAIN PAGE CONTENT -->

</div>
<!-- /#wrapper -->
<!-- Logout Notification Box -->
<div id="logout">
    <div class="logout-message">
        <img class="img-circle img-logout" src="${pageContext.request.contextPath}/resource/img/profile-pic.jpg" alt="">
        <h3>
            <i class="fa fa-sign-out text-green"></i> Ready to go?
        </h3>
        <p>Select "Logout" below if you are ready<br> to end your current session.</p>
        <ul class="list-inline">
            <li>
                <a href="login.html" class="btn btn-green">
                    <strong>Logout</strong>
                </a>
            </li>
            <li>
                <button class="logout_close btn btn-green">Cancel</button>
            </li>
        </ul>
    </div>
</div>
<!-- /#logout -->
<!-- Logout Notification jQuery -->

<!-- tiles -->
<tiles:insertAttribute name="pagescript"></tiles:insertAttribute>

</body>
</html>
