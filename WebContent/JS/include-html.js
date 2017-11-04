$(document).ready(function () {    
    //Sự kiện add header, menu-left và footer vào page
    $.get('header-NV.html', function (res) {
        $('#header').html(res);
    });
    $.get('menu-NV.html', function (res) {
        $('#menu').html(res); 
        
        //Sự kiện khi click vào các sub-menu
        $("li#submenu3").click(function () {
            $("ul#sub-menu3").toggle();
        });
        $("li#submenu4").click(function () {
            $("ul#sub-menu4").toggle();
        });
        $("li#submenu5").click(function () {
            $("ul#sub-menu5").toggle();
        });
        $("li#submenu6").click(function () {
            $("ul#sub-menu6").toggle();
        });
        $("li#submenu7").click(function () {
            $("ul#sub-menu7").toggle();
        });
        $("li#submenu8").click(function () {
            $("ul#sub-menu8").toggle();
        });
        $("li#submenu9").click(function () {
            $("ul#sub-menu9").toggle();

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
        if (path.lastIndexOf('tim-phong.jsp') >= 0) {
            namepage = 'TÌM PHÒNG';
            namefile = 'tim-phong.jsp';
            $("li#submenu2").css("background-color", "#0d875c");
            $("li#submenu2 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('tra-cuu-khach-dat.jsp') >= 0) {
            namepage = 'TRA CỨU > TRA CỨU KHÁCH ĐẶT';
            namefile = 'tra-cuu-khach-dat.jsp';
            $("li#submenu3").css("background-color", "#0d875c");
            $("li#submenu3 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('tra-cuu-khach-hang.jsp') >= 0) {
            namepage = 'TRA CỨU > TRA CỨU KHÁCH HÀNG';
            namefile = 'tra-cuu-khach-hang.jsp';
            $("li#submenu3").css("background-color", "#0d875c");
            $("li#submenu3 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('tra-cuu-phong.jsp') >= 0) {
            namepage = 'TRA CỨU > TRA CỨU PHÒNG';
            namefile = 'tra-cuu-phong.jsp';
            $("li#submenu3").css("background-color", "#0d875c");
            $("li#submenu3 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('tra-cuu-dich-vu.jsp') >= 0) {
            namepage = 'TRA CỨU > TRA CỨU DỊCH VỤ';
            namefile = 'tra-cuu-dich-vu.jsp';
            $("li#submenu3").css("background-color", "#0d875c");
            $("li#submenu3 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('tra-cuu-dich-vu-KH-da-su-dung.jsp') >= 0) {
            namepage = 'TRA CỨU > TRA CỨU DỊCH VỤ KHÁCH HÀNG ĐÃ SỬ DỤNG';
            namefile = 'tra-cuu-dich-vu-KH-da-su-dung.jsp';
            $("li#submenu3").css("background-color", "#0d875c");
            $("li#submenu3 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('them-don-thue-phong.jsp') >= 0) {
            namepage = 'QUẢN LÝ THUÊ PHÒNG > THÊM GIAO DỊCH THUÊ PHÒNG';
            namefile = 'them-don-thue-phong.jsp';
            $("li#submenu5").css("background-color", "#0d875c");
            $("li#submenu5 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('chinh-sua-don-thue-phong.jsp') >= 0) {
            namepage = 'QUẢN LÝ THUÊ PHÒNG > CHỈNH SỬA GIAO DỊCH THUÊ PHÒNG';
            namefile = 'chinh-sua-don-thue-phong.jsp';
            $("li#submenu5").css("background-color", "#0d875c");
            $("li#submenu5 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('thong-ke-don-thue-phong.jsp') >= 0) {
            namepage = 'QUẢN LÝ THUÊ PHÒNG > THỐNG KÊ GIAO DỊCH THUÊ PHÒNG';
            namefile = 'thong-ke-don-thue-phong.jsp';
            $("li#submenu5").css("background-color", "#0d875c");
            $("li#submenu5 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('huy-don-thue-phong.jsp') >= 0) {
            namepage = 'QUẢN LÝ THUÊ PHÒNG > HỦY GIAO DỊCH THUÊ PHÒNG';
            namefile = 'huy-don-thue-phong.jsp';
            $("li#submenu5").css("background-color", "#0d875c");
            $("li#submenu5 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('chi-tiet-thong-ke-thue-phong.jsp') >= 0) {
            namepage = 'QUẢN LÝ THUÊ PHÒNG > THỐNG KÊ ĐƠN THUÊ PHÒNG > CHI TIẾT';
            namefile = 'chi-tiet-thong-ke-thue-phong.jsp';
            $("li#submenu5").css("background-color", "#0d875c");
            $("li#submenu5 a:first").attr("style", "color: white !important");
        }

        $('#page-trich-dan').attr("href", namefile);
        $('#page-trich-dan').text(namepage);
    });
});