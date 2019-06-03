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

    <title>Room page</title>

    <style>
        #customers {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #customers tr:hover {
            background-color: #ddd;
        }

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }
    </style>

</head>
<page:template>
    <jsp:body>
        <div class="nav-side-menu">
            <div class="brand">Rooms</div>
            <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>


            <a href="#"><i class="fa fa-gift fa-lg"></i> Some text here<span
                    class="arrow"></span></a>
            <table id="customers">
                <tr>
                    <td><c:out value="Room Number"/></td>
                    <td><c:out value="Bed Amount"/></td>
                    <td><c:out value="Free Beds Amount"/></td>
                    <td><c:out value="Price per Month"/></td>
                    <td><c:out value="Floor"/></td>
                </tr>
                <c:forEach items="${rooms}" var="room">
                    <tr>
                        <td><c:out value="${room.roomNumber}"/></td>
                        <td><c:out value="${room.bedAmount}"/></td>
                        <td><c:out value="${room.freeBedsAmount}"/></td>
                        <td><c:out value="${room.pricePermONT}"/></td>
                        <td><c:out value="${room.floor}"/></td>
                    </tr>
                </c:forEach>
            </table>
                <%--<div class="menu-list">--%>

            <ul id="menu-content" class="menu-content collapse out">
                <li>
                    <a href="#">
                        <i class="fa fa-dashboard fa-lg"></i> Dashboard
                    </a>
                </li>


                <li data-toggle="collapse" data-target="#products" class="collapsed active">
                    <a href="#"><i class="fa fa-gift fa-lg"></i> Some text here<span
                            class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="products">
                    <c:forEach items="${rooms}" var="room">
                        <li class="active"><a href="/room/${room.id}"><spring:message
                                code="form.rooms.num"/>${room.roomNumber}</a></li>
                    </c:forEach>
                </ul>


                <li data-toggle="collapse" data-target="#service" class="collapsed">
                    <a href="#"><i class="fa fa-globe fa-lg"></i> <spring:message code="form.rooms.num"/>
                        <span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="service">
                    <c:forEach items="${rooms}" var="room">
                        <li><a href="/room/${room.id}"><spring:message code="form.rooms.num"/>${room.id} </a>
                        </li>
                    </c:forEach>
                </ul>

            </ul>
        </div>

    </jsp:body>
</page:template>
