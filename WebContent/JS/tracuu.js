$(document).ready(function () {
                    /*TÌM PHÒNG*/
    //Sự kiện Click vào button Tìm trong TÌM PHÒNG
    $("button#btn-tim-phong").click(function (e) {
        e.preventDefault();
        $(".ket-qua-tim-kiem #co-ket-qua").css("display", "block");
        $(".ket-qua-tim-kiem #khong-co-ket-qua").css("display", "none");
    });

                    /*TRA CỨU KHÁCH ĐẶT*/
    //Sự kiện click vào button TÌM trong TRA CỨU KHÁCH ĐẶT
    $("button#btn-tra-cuu-khach-dat").click(function (e) {
        e.preventDefault();
        var maKhachDat = $("#maKhachDat").val();
        if (maKhachDat == 'KD1')
        {
            $(".ket-qua-tim-kiem #co-ket-qua").css("display", "block");
            $(".ket-qua-tim-kiem #khong-co-ket-qua").css("display", "none");
        }
        if (maKhachDat != 'KD1')
        {
            $(".ket-qua-tim-kiem #co-ket-qua").css("display", "none");
            $(".ket-qua-tim-kiem #khong-co-ket-qua").css("display", "block");
        }           
    });


                   /*TRA CỨU KHÁCH THUÊ*/
    //Sự kiện click vào button TÌM trong TRA CỨU KHÁCH THUÊ
    $("button#btn-tra-cuu-khach-thue").click(function (e) {
        e.preventDefault();
        var maKhachDat = $("#maKhachHang").val();
        if (maKhachDat == 'KH1') {
            $(".ket-qua-tim-kiem #co-ket-qua").css("display", "block");
            $(".ket-qua-tim-kiem #khong-co-ket-qua").css("display", "none");
        }
        if (maKhachDat != 'KH1') {
            $(".ket-qua-tim-kiem #co-ket-qua").css("display", "none");
            $(".ket-qua-tim-kiem #khong-co-ket-qua").css("display", "block");
        }
    });


                   /*TRA CỨU DỊCH VỤ*/
    //Sự kiện click vào button TÌM trong TRA CỨU DỊCH VỤ
    $("button#btn-tra-cuu-dich-vu").click(function (e) {
        e.preventDefault();
        var maPhong = $("#ma-ten-dich-vu").val();
        if (maPhong == 'DV1') {
            $(".ket-qua-tim-kiem #co-ket-qua").css("display", "block");
            $(".ket-qua-tim-kiem #khong-co-ket-qua").css("display", "none");
        }
        if (maPhong != 'DV1') {
            $(".ket-qua-tim-kiem #co-ket-qua").css("display", "none");
            $(".ket-qua-tim-kiem #khong-co-ket-qua").css("display", "block");
        }
    });


                   /*TRA CỨU PHÒNG*/
    //Sự kiện click vào button TÌM trong TRA CỨU PHÒNG
    $("button#btn-tra-cuu-phong").click(function (e) {
        e.preventDefault();
        var maPhong = $("#maPhong").val();
        if (maPhong == 'A1') {
            $(".ket-qua-tim-kiem #co-ket-qua").css("display", "block");
            $(".ket-qua-tim-kiem #khong-co-ket-qua").css("display", "none");
        }
        if (maPhong != 'A1') {
            $(".ket-qua-tim-kiem #co-ket-qua").css("display", "none");
            $(".ket-qua-tim-kiem #khong-co-ket-qua").css("display", "block");
        }
    });


                /*TRA CỨU DỊCH VỤ KHÁCH HÀNG ĐÃ SỬ DỤNG*/
    //Sự kiện click vào button TÌM trong TRA CỨU DỊCH VỤ KHÁCH HÀNG ĐÃ SỬ DỤNG
    $("button#btn-tra-cuu-dich-vu-KH-da-su-dung").click(function (e) {
        e.preventDefault();
        var maPhong = $("#maKhachHang").val();
        if (maPhong == 'KH1') {
            $(".ket-qua-tim-kiem #co-ket-qua").css("display", "block");
            $(".ket-qua-tim-kiem #khong-co-ket-qua").css("display", "none");
        }
        if (maPhong != "KH1") {
            $(".ket-qua-tim-kiem #co-ket-qua").css("display", "none");
            $(".ket-qua-tim-kiem #khong-co-ket-qua").css("display", "block");
        }
    });


});