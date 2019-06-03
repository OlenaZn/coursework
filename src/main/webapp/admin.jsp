<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin page</title>

</head>
<page:template>
    <jsp:body>
        <div class="nav-side-menu">
            <div class="brand">Choose action</div>
            <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>


            <a href="/rooms"><i class="fa fa-gift fa-lg"></i>Get all rooms<span
                    class="arrow"></span></a>

            <a href="/free-rooms"><i class="fa fa-gift fa-lg"></i>Get all free rooms<span
                    class="arrow"></span></a>

            <a href="/create-violation"><i class="fa fa-gift fa-lg"></i>Create violation<span
                class="arrow"></span></a>

            <a href="/violations"><i class="fa fa-gift fa-lg"></i>Get all violations<span
                    class="arrow"></span></a>

            <a href="/violations/{studentId}"><i class="fa fa-gift fa-lg"></i>Get all violation of specific student<span
                    class="arrow"></span></a>

            <a href="/students"><i class="fa fa-gift fa-lg"></i>Get all students<span
                    class="arrow"></span></a>

            <a href="/delete-student/{id}"><i class="fa fa-gift fa-lg"></i>Delete student<span
                    class="arrow"></span></a>

            <a href="/livings"><i class="fa fa-gift fa-lg"></i>Get all livings<span
                    class="arrow"></span></a>

            <a href="/students-by-hobby"><i class="fa fa-gift fa-lg"></i>Get all students by hobby<span
                    class="arrow"></span></a>

            <a href="/students-by-institution"><i class="fa fa-gift fa-lg"></i>Get all students by institution<span
                    class="arrow"></span></a>

        </div>

    </jsp:body>
</page:template>
