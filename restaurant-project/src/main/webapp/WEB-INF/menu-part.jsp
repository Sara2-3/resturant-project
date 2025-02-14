<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" type="text/css" href="/css/homePage.css">
    <link rel="stylesheet" type="text/css" href="/css/menu-part.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- For responsiveness -->
</head>
<body>

<div class="container">
    <header>
        <ul class="ribbon">
            <li><a href="/home">Home</a></li>
            <li><a href="/reservation/create">Reservation</a></li>
            <li></li>
            <li></li>
            <li><a href="#">Ambrosia</a></li>
            <li></li>
            <li></li>
            <li><a href="/career">Career</a></li>
            <li>
                <a href="#" onclick="document.getElementById('logout-form').submit();">Log out</a>
                <form id="logout-form" action="/logout" method="post" style="display:none;">
                    <input type="submit" value="Log out"/>
                </form>
        </ul>
    </header>
</div>
    <script>
        window.addEventListener('scroll', function() {
            const header = document.querySelector('header');
            if (window.scrollY > 50) {
                header.classList.add('scrolled');
            } else {
                header.classList.remove('scrolled');
            }
        });
    </script>

    <div class="middle">
        <div class="menus">
            <div class="menu-item">
                <div class="Starters">
                    <h1>Starters</h1>
                    <p>Smoked Salmon Tartare, preserved lemon zest in olive oil, black sesame crisps     21€</p>
                    <p>Pumpkin ravioli with sage butter, roasted hazelnuts and crispy pancetta           24€</p>
                    <p>Celeriac and smoked eel soup, crème fraîche with Sichuan pepper                   27€</p>
                </div>
                <img src="/images/starter.jpg" alt="starter-menu">
            </div>
        </div>

        <div class="menus">
            <div class="menu-item">
                <div class="Starters">
                    <h1>Main Courses</h1>
                    <p>Beef tenderloin, truffle-infused mashed potatoes, béarnaise sauce, wild herb       40€</p>
                    <p>Pork loin from Toulouse, creamy mashed potatoes, apple cider reduction             45€</p>
                    <p>Pan-seared scallops with sumac, sautéed spinach and chanterelles, velvety chicken  54€</p>
                </div>
                <img src="/images/main-course.jpg" alt="main-course-menu">
            </div>
        </div>

        <div class="menus">
            <div class="menu-item">
                <div class="Starters">
                    <h1>Desserts</h1>
                    <p>Panna cotta, caramelized pear, lavender honey sauce, and rosemary sorbet          40€</p>
                    <p>Choux pastry, hazelnut ice cream, and bourbon vanilla caramel sauce               45€</p>
                    <p>Rich chocolate mousse from Madagascar, paired with creamy bourbon vanilla ice cream  54€</p>
                </div>
                <img src="/images/dessert.jpg" alt="dessert-menu">
            </div>
        </div>
        <div class="menus">
            <div class="menu-item">
                <div class="Starters">
                    <h1>Drinks</h1>
                    <p>Discovery one glass      20€</p>
                    <p>Evasion one glass        40€ </p>
                    <p>Prestige one glass       60€</p>
                </div>
                <img src="/images/wines.jpg" alt="drinks">
            </div>
        </div>
    </div>
    </div>


<div class="footer">
    <h2>AMBROSIA</h2>
    <div class="last-link">
        <a href="reservation/create">Reservation</a>
        <a href="/career">Careers</a>
        <p>Contact</p>
        <p>|</p>
        <img src="\images\instagram-icone.png" alt="instagram icone">
        <img src="\images\tiktok-icone.png" alt="instagram icone">
    </div>
    <p>©2025. All rights reserved</p>
</div>


</body>
</html>