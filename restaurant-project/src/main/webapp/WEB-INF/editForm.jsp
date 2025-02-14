<%@ page import="java.time.LocalDate" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Form of Application</title>
    <link rel="stylesheet" type="text/css" href="/css/career.css">
</head>
<body>
<h1>Chef Job Application Form</h1>
<form:form action="/careers/${careerToEdit.id}/update" method="post" modelAttribute="careerToEdit" enctype="multipart/form-data">
    <input type="hidden" name="_method" value="put">
    <div class="form-group">
        <form:label path="firstName">First Name</form:label>
        <form:input path="firstName" class="form-control" />
        <form:errors path="firstName" class="error-message" />
    </div>
    <div class="form-group">
        <form:label path="lastName">Last Name</form:label>
        <form:input path="lastName" class="form-control" />
        <form:errors path="lastName" class="error-message" />
    </div>
    <div class="form-group">
        <form:label path="email">Email</form:label>
        <form:input path="email" class="form-control" />
        <form:errors path="email" class="error-message" />
    </div>
    <div class="form-group">
        <form:label path="phone">Phone Number (Albania)</form:label>
        <form:input type="text" path="phone" class="form-control" pattern="^\+355\d{8,9}$" placeholder="+355XXXXXXXXX" />
        <form:errors path="phone" class="error-message" />
    </div>
    <div class="form-group">
        <form:label path="address">Address</form:label>
        <form:input path="address" class="form-control" />
        <form:errors path="address" class="error-message" />
    </div>

    <!-- Experience -->
    <div class="form-group">
        <form:label path="experience">Years of Experience</form:label>
        <form:input type="number" path="experience" class="form-control" />
        <form:errors path="experience" class="error-message" />
    </div>
    <div class="form-group">
        <form:label path="degree">Do you have a culinary degree?</form:label><br>
        <div class="radio-group">
            <form:radiobutton path="degree" value="true" /> Yes
            <form:radiobutton path="degree" value="false" /> No
        </div>
        <form:errors path="degree" class="error-message" />
    </div>
    <div class="form-group">
        <form:label path="cover">Cover Letter</form:label>
        <form:textarea path="cover" rows="5" class="form-control" />
        <form:errors path="cover" class="error-message" />
    </div>
    <div class="form-group">
        <form:label path="workType">Preferred Work Type</form:label>
        <form:select path="workType" class="form-control">
            <form:option value="FULL_TIME">Full-Time</form:option>
            <form:option value="PART_TIME">Part-Time</form:option>
            <form:option value="FLEXIBILITY">Flexibility</form:option>
        </form:select>
        <form:errors path="workType" class="error-message" />
    </div>
    <div class="form-group">
        <label for="cvFile">Upload Image (JPEG, PNG):</label>
        <input type="file" id="cvFile" name="cvFile" accept="image/jpeg, image/png" required />
        <span class="error-message">${cvFileError}</span>
    </div>
    <div class="form-group">
        <button type="submit">Submit Application</button>
    </div>
</form:form>
</body>
</html>