<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
  <head>
    <title>Login to Ambrosia</title>
    <link rel="stylesheet" type="text/css" href="/css/login.css">
  </head>
  <body>
  <div class="content">
  <h1>Welcome to Ambrosia!</h1>
  <h3>Good to see you again!</h3><br>
  <form:form action="/login" method="post" modelAttribute="newLogin">

    <div>
      <form:label path="email">Email:</form:label>
      <form:errors path="email"/>
      <form:input path="email"/>
    </div>
    <div>
      <form:label path="password">Password:</form:label>
      <form:errors path="password"/>
      <form:input type="password" path="password"/>
    </div>
    <input type="submit" value="LOGIN"/>
  </form:form>
  <p>Don't have an account?<a href="/register">Register</a></p>
  </div>
  </body>
</html>
