<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reservations</title>
    <link rel="stylesheet" type="text/css" href="/css/view-reservation.css">
</head>
<body>
<div class="header">
    <a class="home" href="/home">Home</a>
    <a class="logout" href="#" onclick="document.getElementById('logout-form').submit();">Log out</a>
</div>

<form id="logout-form" action="/logout" method="post" style="display:none;">
    <input type="submit" value="Log out"/>
</form>
<div class="container">
    <h1>Reservations for <span class="username"><c:out value="${loggedInUser.name}"/></span></h1>
    <div class="reservation-list">
        <c:forEach items="${allReservation}" var="reservation">
            <div class="reservation-card">
                <div class="card-header">
                    <h2><a href="/reservation/${reservation.id}">Reservation</a></h2>
                </div>
                <div class="card-body">
                    <p><strong>Number of People:</strong> ${reservation.person}</p>
                    <p><strong>Date:</strong> ${reservation.date}</p>
                    <p><strong>Time:</strong> ${reservation.time}</p>
                </div>
            </div>
        </c:forEach>
</body>
</html>