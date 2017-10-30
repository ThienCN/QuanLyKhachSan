$(document).ready(function () {
    $("#btn-tra-cuu-khach-thue").click(function (e) {
        e.preventDefault();
        var maKH = $("#maKhachHang").val();
        if (maKH == "KH1") {
            $(".co-ket-qua").css("display", "block");
            $(".khong-co-ket-qua").css("display", "none");
        }
        if (maKH != "KH1") {
            $(".khong-co-ket-qua").css("display", "block");
            $(".co-ket-qua").css("display", "none");
        }
    });
});