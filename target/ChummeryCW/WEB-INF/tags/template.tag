<!DOCTYPE html>
<%@tag description="Template Site tag" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="headerTemplate" tagdir="/WEB-INF/tags" %>

<%@attribute name="title" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<html>
<head>
    <title><jsp:invoke fragment="title"/></title>

    <!-- Bootstrap Core CSS -->
    <base href="${pageContext.request.contextPath}">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />

    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/modern-business.css" />

    <!-- Custom Fonts -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" />

    <!-- Bootstrap Core JavaScript -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" />

    <!-- jQuery -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/jquery-2.1.4.min.js" />


    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/myTable.css" />


</head>

<body>


<headerTemplate:header-template/>

<jsp:doBody/>

</body>

</html>