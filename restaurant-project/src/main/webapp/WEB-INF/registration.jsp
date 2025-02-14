<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
  <title>Register to AMBROSIA</title>
  <link rel="stylesheet" type="text/css" href="/css/register.css">
</head>
<body>
<div class="content">
  <h1>Welcome to AMBROSIA!</h1>
  <form:form action="/register" method="Post" modelAttribute="newUser">
    <div>
      <form:label path="name">Name:</form:label>
      <form:errors path="name"/>
      <form:input path="name"/>
    </div>
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
    <div>
      <form:label path="confirmPassword">Confirm password:</form:label>
      <form:errors path="confirmPassword"/>
      <form:input type="password" path="confirmPassword"/>
    </div>
    <div class="checkbox-container">
      <form:checkbox path="acceptTerms" id="terms"/>
      <label for="terms">I accept the <span>Terms of Use</span> & <span>Privacy Policy</span></label>
    </div>
    <form:errors path="acceptTerms"/>
    <input type="submit" value="Register"/>
  </form:form>
  <p>Have an existing account?<a href="/">Login!</a></p>
</div>
</body>
</html>