<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Find best Restaurant -Steak Oasis</title>
    <link rel="stylesheet" type="text/css" href="/css/homePage.css">
    <link rel="stylesheet" type="text/css" href="/css/slideshow.css">
    <link rel="stylesheet" type="text/css" href="/css/book-table.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">
    <script type="text/javascript" src="/js/homePage.js"></script>

    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
    <%--    <script type="text/javascript" src="/js/slideshow.js"></script>--%>
    <%--    <link rel="stylesheet" type="text/css" href="/css/slideshow.css">--%>

</head>
<body>
<!--<h1>Welcome Page <c:out value="${currentUser.username}"></c:out></h1>-->

<div class="container">
    <header>
        <ul class="ribbon">
            <li><a href="/menu">Menu</a></li>
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
    <div class="slideshow-container">
        <img class="slides" src="images\plate2.jpg" alt="Meat" width="100%">
        <img class="slides" src="images\restaurant.jpg" alt="Restaurant View" width="100%">
        <img class="slides" src="images\plate.jpg" alt="plate" width="100%">
    </div>
    <style>
        .slides {
            display: none;
            width: 100%;
        }
    </style>
    <script>
        let currentIndex = 0;
        const slides = document.querySelectorAll('.slides');

        function showSlide(index) {
            slides.forEach((slide, i) => {
                slide.style.display = (i === index) ? 'block' : 'none'; // Show current slide, hide others
            });
        }

        function nextSlide() {
            currentIndex = (currentIndex + 1) % slides.length; // Loop back to the first slide
            showSlide(currentIndex);
        }

        window.onload = function() {
            showSlide(currentIndex); // Show the first slide
            setInterval(nextSlide, 5000); // Change slide every 5 seconds
        };
    </script>
    <div class="content">
        <div class="main-menu-two">
            <div class="swiper-container">
                <div class="swiper-wrapper">
                    <div class="swiper-slide">
                        <img src="slideshow/restaurant-inside.jpg" alt="Image 1">
                    </div>
                    <div class="swiper-slide">
                        <img src="slideshow/different-plates.jpg" alt="Image 2">
                    </div>
                    <div class="swiper-slide">
                        <img src="slideshow/chefs.jpg" alt="Image 3">
                    </div>
                    <div class="swiper-slide">
                        <img src="slideshow/restaurant-inside2.jpg" alt="Image 4">
                    </div>
                    <div class="swiper-slide">
                        <img src="slideshow/desert.jpg" alt="Image 5">
                    </div>
                </div>
                <div class="swiper-pagination"></div>
                <div class="swiper-button-next"></div>
            </div>
        </div>
        <div class="menu-main">
            <h1>In a few words</h1>
            <p>The AMBROSIA  restaurant immerses you in an ambiance of refined elegance and modern charm,
                nestled in the heart of the city. Throughout the day, it transforms into the perfect
                spot to unwind, connect, and savor exceptional cuisine as the vibrant energy of the neighborhood unfolds.
                As evening descends, it offers a serene
                retreat, inviting guests to indulge in an intimate dining experience or a cherished romantic evening.</p>
            <button><a href="/menu">MENU</a></button>
        </div>
    </div>
    <div class="book">
        <div class="contact-info">
            <h1>Contact us</h1>
            <p>Via Florida 23, 00186 Rome Italy</p>
            <p>+355 69 23 24 851</p>
            <p>restorant@ambrosia.com</p>

            <h2>A Time for Every Flavor</h2>
            <p>Monday to Saturday :</p>
            <p>12pm - 11pm</p>
            <button><a href="/reservation/create">Book a table</a></button>
        </div>
        <div class="image-container">
            <img src="\images\book.jpg" alt="book-table" class="book-image">
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
</div>



<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script type="text/javascript" src="/js/slideshow.js"></script>
</body>
</html>