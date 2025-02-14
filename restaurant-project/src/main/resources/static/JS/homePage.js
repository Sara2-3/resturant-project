window.addEventListener("scroll", function () {
    var header = document.querySelector("header");
    var images = document.querySelectorAll(".image-container img");

    if (window.scrollY > 50) {
        header.classList.add("scrolled");

        images.forEach(img => {
            img.classList.add("image-fade");
        });

    } else {
        header.classList.remove("scrolled");

        images.forEach(img => {
            img.classList.remove("image-fade");
        });
    }
});
