$(document).ready(function () {
    $("button#btn-xac-nhan-thong-tin-phong").click(function (e) {
    	e.preventDefault();
    	var maPhong = "<td>" + $("input#maPhong").val() + "</td>";
        var loaiPhong = "<td>"+ $("select#loaiPhong").val() + "</td>";
        var tinhTrang = "<td>"+ $("select#tinhTrang").val() + "</td>";
        $("table#table-thong-tin-phong").append("<tr>" + maPhong + loaiPhong + tinhTrang +"</tr>"); 
    });
});