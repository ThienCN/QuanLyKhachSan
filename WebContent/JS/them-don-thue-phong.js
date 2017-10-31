$(document).ready(function () {
    $("#btn-chon-phong").click(function () {
        var loaiPhong = "<td>"+ $("select#loaiPhong").val() + "</td>";
        var maPhong = "<td>" + $("select#maPhong").val() + "</td>";
        var ngayNhanPhong = "<td>" + $("input#ngayNhanPhong").val() + "</td>";
        var ngayTraPhong = "<td>" + $("input#ngayTraPhong").val() + "</td>";
        var xoaPhong = "<td> <a> Xóa </a> </td>";
        $("table#table-thong-tin-thue-phong").append("<tr>" + loaiPhong + maPhong + ngayNhanPhong + ngayTraPhong + xoaPhong +"</tr>"); 
    });
});