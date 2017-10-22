$(document).ready(function () {    
    //Sự kiện add header, menu-left và footer vào page
    $.get('header.html', function (res) {
        $('#header').html(res);
    });
    $.get('menu.html', function (res) {
        $('#menu').html(res); 
        
        //Sự kiện khi click vào các sub-menu
        $("li#submenu2").click(function () {
            $("ul#sub-menu1").toggle();
        });
        $("li#submenu3").click(function () {
            $("ul#sub-menu2").toggle();
        });
        $("li#submenu4").click(function () {
            $("ul#sub-menu3").toggle();
        });
        $("li#submenu5").click(function () {
            $("ul#sub-menu4").toggle();
        });
        $("li#submenu6").click(function () {
            $("ul#sub-menu5").toggle();
        });
        $("li#submenu7").click(function () {
            $("ul#sub-menu6").toggle();
        });
        $("li#submenu8").click(function () {
            $("ul#sub-menu7").toggle();

        });

        //Sự kiện active menu
        var path = document.location.pathname;
        var namepage = '';
        var namefile = '';
        if (path.lastIndexOf('nhan-vien.jsp') >= 0) {
            namepage = 'TRANG CỦA BẠN';
            namefile = 'nhan-vien.jsp';
            $("li#submenu1").css("background-color", "#0d875c");
            $("li#submenu1 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('tra-cuu-khach-dat.jsp') >= 0) {
            namepage = 'TRA CỨU > TRA CỨU KHÁCH ĐẶT';
            namefile = 'tra-cuu-khach-dat.jsp';
            $("li#submenu2").css("background-color", "#0d875c");
            $("li#submenu2 a:first").attr("style", "color: white !important");
        }

        $('#page-trich-dan').attr("href", namefile);
        $('#page-trich-dan').text(namepage);
    });
});