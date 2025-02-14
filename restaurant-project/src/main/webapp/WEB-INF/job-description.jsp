<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Careers</title>
    <link rel="stylesheet" type="text/css" href="/css/job-description.css">
</head>
<body>
<c:if test="${not empty applyError}">
    <script>
        alert("${applyError}");
    </script>
</c:if>

<header>
    <ul class="ribbon">
        <li><a href="/home">Home</a></li>
        <li><a href="/menu">Menu</a></li>
        <li><a href="/reservation/create">Reservation</a></li>
        <li>
            <form action="logout" method="post">
                <input type="submit" value="Log out" style="background: none; border: none; color: #fff; font-weight: bold; cursor: pointer;"/>
            </form>
        </li>
    </ul>
</header>

<div class="content">
    <h1>Job Title: Head Chef</h1>
    <p><strong>Job Summary:</strong><br>
        We are looking for a talented and experienced Chef to lead our kitchen team. The ideal candidate will have a passion for culinary excellence, strong leadership skills, and the ability to create innovative and delicious dishes. The Chef will oversee food preparation, maintain quality standards, and ensure an efficient and well-organized kitchen operation.
    </p>

    <p><strong>Key Responsibilities:</strong></p>
    <ul>
        <li>Design and execute a diverse and high-quality menu.</li>
        <li>Supervise kitchen staff, providing training and leadership.</li>
        <li>Ensure all dishes are prepared and presented according to quality standards.</li>
        <li>Manage food inventory, ordering ingredients, and minimizing waste.</li>
        <li>Maintain strict hygiene, safety, and sanitation regulations in the kitchen.</li>
        <li>Monitor kitchen efficiency and workflow to ensure timely service.</li>
        <li>Develop new recipes and seasonal menu items.</li>
        <li>Work closely with restaurant management to improve customer satisfaction.</li>
    </ul>

    <p><strong>Requirements:</strong></p>
    <ul>
        <li>Previous experience as a Chef or Sous Chef in a restaurant or hotel.</li>
        <li>Culinary degree or relevant professional experience.</li>
        <li>Strong leadership and team management skills.</li>
        <li>Excellent knowledge of food preparation techniques and kitchen safety.</li>
        <li>Creativity in menu development and food presentation.</li>
        <li>Ability to work in a fast-paced environment and handle high-pressure situations.</li>
        <li>Flexible schedule, including evenings, weekends, and holidays.</li>
    </ul>
   <div>
       <c:if test="${empty appliedBefore}">
           <button><a href="/career/new">Apply</a></button>
       </c:if>
   </div>
    <button><a href="/careers/view">See My Application</a></button>
</div>
</body>
</html>