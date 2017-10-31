<<<<<<< HEAD
﻿$(document).ready(function () {
    $("#loadbtn").click(function (e) {
        e.preventDefault;
        text = '<br><div class="row"><div class="col-lg-4 col-md-4 col-sm-4 col-xs-12" id="image7"><img src= "./Images/pic7.jpg" style= "width:100%;" alt= "Gym" ><div class="overlay"><div class="text"><h2>Gym</h2><p>Thân hình quyến rũ săn chắc hay chỉ đơn giản là chạy bộ tập thể dục</p></div></div></div>'
            + '<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12" id="image8"><img src="./Images/pic8.jpg" style="width:100%;" alt="Bar" ><div class="overlay"><div class="text"><h2>Bar</h2><p>Lắc lư theo những điệu nhạc sôi động cùng thưởng thức ly Whisky tuyệt vời</p></div></div></div>'
            + '<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12" id="image9"><img src= "./Images/pic9.jpg" style= "width:100%;" alt= "Sea" ><div class="overlay"><div class="text"><h2>Lặn biển</h2><p>Những rạn san hô tuyệt đẹp cùng nhiều loài cá đủ màu sắc sẽ khiến bạn mê say</p></div></div></div></div>'

        $("#portfolio").append(text);
        $("#loadbtn").hide();
    });});
=======
﻿function appendText() {
    text = '<br><br><br><br><br><br><div class="w3-row-padding w3-center" style="padding: 0 75px"><div class="w3-col m4 showimg"><img src="Images/pic7.jpg" style="width:100%; margin-bottom: -100px" class="w3-hover-opacity" alt="Gym"><div class="overlay"><div class="text"><h2>Gym</h2><p>Thân hình quyến rũ săn chắc hay chỉ đơn giản là chạy bộ tập thể dục</p></div></div></div>'
        + '<div class="w3-col m4 showimg"><img src="Images/pic8.jpg" style="width:100%; margin-bottom: -100px" class="w3-hover-opacity" alt="Bar"><div class="overlay"><div class="text"><h2>Bar</h2><p>Lắc lư theo những điệu nhạc sôi động cùng thưởng thức ly Whisky tuyệt vời</p></div></div></div>'
        + '<div class="w3-col m4 showimg"><img src="Images/pic9.jpg" style="width:100%; margin-bottom: -100px" class="w3-hover-opacity" alt="Sea"><div class="overlay"><div class="text"><h2>Lặn biển</h2><p>Những rạn san hô tuyệt đẹp cùng nhiều loài cá đủ màu sắc sẽ khiến bạn mê say</p></div></div></div></div><br><br><br><br><br>';

    $("#portfolio").append(text);
    $("#loadbtn").hide();
}

// Used to toggle the menu on small screens when clicking on the menu button
function toggleFunction() {
    var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else {
        x.className = x.className.replace(" w3-show", "");
    }
}

// Change style of navbar on scroll
window.onscroll = function () { myFunction() };
function myFunction() {
    var navbar = document.getElementById("myNavbar");
    if (document.body.scrollTop > 100 || document.documentElement.scrollTop > 100) {
        navbar.className = "w3-bar" + " w3-card-2" + " w3-animate-top" + " w3-white";
    } else {
        navbar.className = navbar.className.replace(" w3-card-2 w3-animate-top w3-white", "");
    }
}
>>>>>>> 35bf5f070fc3994142934b28446174fe5e4e990e
