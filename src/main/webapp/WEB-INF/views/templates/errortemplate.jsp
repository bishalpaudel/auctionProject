<%--
  Created by IntelliJ IDEA.
  User: ravindra
  Date: 3/30/17
  Time: 11:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
    <tiles:insertAttribute name="resources"></tiles:insertAttribute>
</head>
<body>
<tiles:insertAttribute name="content"></tiles:insertAttribute>
</body>
</html>