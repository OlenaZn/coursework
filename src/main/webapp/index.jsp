<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring Security</title>

    <!-- Bootstrap core CSS -->
    <%--<spring:url value="/resources/css/bootstrap.css" var="bootstrap" />--%>
    <%--<spring:url value="/resources/css/signin.css" var="signin" />--%>
    <%--<link href="${bootstrap}" rel="stylesheet" />--%>
    <%--<link href="${signin}" rel="stylesheet" />--%>
    <base href="${pageContext.request.contextPath}">
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="resources/css/signin.css">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <div class="jumbotron" style="margin-top: 20px;">
        <h1>Гуртожиток</h1>
        <p class="lead">
            Облік студентів
        </p>
        <%--<sec:authorize access="!isAuthenticated()">--%>
            <p><a class="btn btn-lg btn-success" href="<c:url value="/login.jsp" />" role="button">Увійти</a></p>
        <%--</sec:authorize>--%>
        <%--<sec:authorize access="isAuthenticated()">--%>
            <%--<p>Ваш логін: <sec:authentication property="principal.username" /></p>--%>

        <%--</sec:authorize>--%>
    </div>

    <div class="footer">
        <p>© Олена Знак КН-310</p>
    </div>

</div>
</body>
</html>