<%@ page import="java.time.LocalDate" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Form application view</title>
  <link rel="stylesheet" type="text/css" href="/css/career-form.css">
</head>
<body>
<h1>Your Chef Job Application</h1>
<div>
<c:forEach items="${allCareer}" var="career">
  <h2>You can change or delete you application <a href="/careers/${career.id}">Here</a></h2>
  <strong>First Name:</strong> ${career.firstName}<br>
  <strong>Last Name:</strong> ${career.lastName}<br>
  <strong>Email:</strong> ${career.email}<br>
 <strong>Phone:</strong>${career.phone}<br>
  <strong>Address:</strong> ${career.address}<br>
</div>
<div>
  <strong>Years of Experience:</strong> ${career.experience}<br>
</div>
<div>
  <strong>Has Culinary Degree:</strong>
  <c:choose>
    <c:when test="${career.degree}">Yes</c:when>
    <c:otherwise>No</c:otherwise>
  </c:choose><br>
</div>
<div>
  <strong>Cover Letter:</strong><br>
  <p>${career.cover}</p>
</div>
<div>
  <strong>Preferred Work Type:</strong> ${career.workType}<br>
</div>

<div>
  <strong>Uploaded Image:</strong><br>
  <c:if test="${not empty career.cvFilePath}">
  <img src="/download?file=${career.cvFilePath}" alt="Uploaded Image" style="max-width: 300px;">
  </c:if>
</c:forEach>
<div>
  <a href="/home">Back to Home</a><br>
  <a href="/career">Back to job</a>

</div>
</body>
</html>
