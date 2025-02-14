<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" type="text/css" href="/css/reservation.css">
</head>
<body>
<a class="logout" href="#" onclick="document.getElementById('logout-form').submit();">Log out</a>
<form id="logout-form" action="/logout" method="post" style="display:none;">
    <input type="submit" value="Log out"/>
</form>
<div class="container">
    <p><a class="link" href="/reservation/view">Recent Reservations</a> </p>
    <h3>AMBROSIA</h3>
    <p>Thank you for choosing the <a href="/home">Ambrosia!</a> </p>
    <form:form action="/reservation/${reservationToEdit.id}/update"  method="post"  modelAttribute="reservationToEdit">
        <input type="hidden" name="_method" value="put">
       <div>
        <label for="person">Number of People:</label>
        <input type="number" id="person" name="person" min="1" max="10" required>
        <form:errors path="person" class="error-message" />
        <br><br>
       </div>

    <div>
        <label for="date">Date:</label>
        <input type="date" id="date" name="date" required>
        <form:errors path="person" class="error-message" />
        <br><br>
    </div>
    <div>
        <label for="time">Time:</label>
        <input type="time" id="time" name="time" min="12:00" max="22:00" required>
        <form:errors path="person" class="error-message" />
        <br><br>
    </div>
        <button type="submit">Book a Table</button>
        <p><a class="link" href="/reservation/view">Back</a></p>
    </form:form>
</div>
</body>
</html>
