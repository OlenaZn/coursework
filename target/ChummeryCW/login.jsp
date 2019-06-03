<%--<%@ page contentType="text/html; charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>
    <%--<title>Spring Security</title>--%>
    <%--<base href="${pageContext.request.contextPath}">--%>
    <%--<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="resources/css/signin.css">--%>
    <%----%>
    <%--<!-- Bootstrap core CSS -->--%>
    <%--&lt;%&ndash;<link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet" type="text/css">&ndash;%&gt;--%>

    <%--&lt;%&ndash;<!-- Custom styles for this template -->&ndash;%&gt;--%>
    <%--&lt;%&ndash;<link href="<c:url value="/css/signin.css" />" rel="stylesheet" type="text/css">&ndash;%&gt;--%>

    <%--<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->--%>
    <%--<!--[if lt IE 9]>--%>
    <%--<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>--%>
    <%--<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>--%>
    <%--<![endif]-->--%>
<%--</head>--%>

<%--<body>--%>

<%--<div class="container" style="width: 300px;">--%>
    <%--<c:url value="/j_spring_security_check" var="loginUrl" />--%>
    <%--<form action="${loginUrl}" method="post">--%>
        <%--<h2 class="form-signin-heading">Please sign in</h2>--%>
        <%--<input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus value="user">--%>
        <%--<input type="password" class="form-control" name="j_password" placeholder="Password" required value="1234">--%>
        <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Увійти</button>--%>
    <%--</form>--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>
<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Login Page</title>
    <base href="${pageContext.request.contextPath}">
    <%--<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="resources/css/signin.css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/signin.css" />


</head>
<body>
<c:url value="/j_spring_security_check" var="loginUrl" />
<form name="form" action="${loginUrl}" method="post" class="form-signin">
    <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_GUARD', 'ROLE_USER')" var="isUser"/>
    <font size="2" color="red">
        <c:if test="${not isUser}">
            <c:if test="${empty param.error}">
                <spring:message code="form.registration.authority.not.signed.title"/>
            </c:if>
        </c:if>
    </font>

    <font size="2" color="green">
        <c:if test="${isUser}"><spring:message code="form.registration.authority.title"/>
            <security:authentication property="principal.username"/>,
            <b><security:authentication property="principal.authorities"/></b>
        </c:if>
    </font>
    <br/>
    <c:if test="${not empty param.error}">
        <font size="2" color="red"><b><spring:message code="form.registration.wrong.credentials"/></b></font>
    </c:if>

    <h2 class="form-signin-heading"><spring:message code="form.please.login"/> </h2>

    <label for="inputEmail" class="sr-only"><spring:message code="form.email"/></label>
    <input id="inputEmail" class="form-control" name="j_username" value="admin1" required autofocus/>

    <label for="inputPassword" class="sr-only"><spring:message code="form.password" text="Password"/></label>
    <input type="password" id="inputPassword" class="form-control" name="j_password" value="12345" required/>

    <div class="checkbox">
        <label>
            <input type="checkbox" id="rememberme"  name="_spring_security_remember_me"/><spring:message code="form.rememberMe"/>
        </label>
    </div>
    <input type="submit" value="<spring:message code="form.login.title"/>" class="btn btn-lg btn-primary btn-block" >
    <br/>
    <a href="javascript:history.back()"><spring:message code="form.back"/></a>

    <br /><br />
    <p>Roles</p>

    <%--<b>ROLE_GUARD</b><br />--%>
    <%--Login: <span style="color: royalblue">guard1</span> Password: <span style="color: royalblue">12345</span> <br />--%>
    <%--<b>ROLE_ADMIN</b> <br />--%>
    <%--Login: <span style="color: royalblue">admin1</span> Password: <span style="color: royalblue">12345</span> <br />--%>
    <%--<b>ROLE_USER</b> <br />--%>
    <%--Login: <span style="color: royalblue">user1</span> Password: <span style="color: royalblue">12345</span>--%>
</form>
<div class="container">
    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <a href="<%=request.getContextPath()%>?languageVar=ua">UA</a>
                <a href="<%=request.getContextPath()%>?languageVar=en">EN</a>
                <p>Olena Znak © 2019</p>
            </div>
        </div>
    </footer>
</div>
</body>
</html>