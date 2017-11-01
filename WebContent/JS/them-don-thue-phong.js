$(document).ready(function () {
	
	$("#thay-doi-ngay-tim-phong").click(function (e) {
        $("#tim-phong").prop("disabled", false);
        $("#ngayNhanPhong").attr("readonly", false);
        $("#ngayTraPhong").attr("readonly", false);
        $("#thay-doi-ngay-tim-phong").prop("disabled", true);
    });

    $("#tim-phong").click(function (e) {
        var ngayNhanPhong = new Date($("#ngayNhanPhong").val());
        var ngayTraPhong = new Date($("#ngayTraPhong").val());

        var d = new Date();
        var ngayHienTai = new Date(d.getFullYear(), d.getMonth(), d.getDate());
        
        if (ngayNhanPhong == "Invalid Date" || ngayTraPhong == "Invalid Date")
            alert("Nhập đầy đủ ngày nhận phòng và ngày trả phòng!!!");
        else if (ngayNhanPhong >= ngayTraPhong)
            alert("Ngày nhận phòng và ngày trả phòng không hợp lệ!!!");
        else if (ngayNhanPhong < ngayHienTai)
            alert("Ngày nhận phòng phải lớn hơn hoặc bằng ngày hiện tại!!!");
        else
        {
            $("#thay-doi-ngay-tim-phong").prop("disabled", false);
            $("#ngayNhanPhong").attr("readonly", true);
            $("#ngayTraPhong").attr("readonly", true);
            $("#tim-phong").prop("disabled", true);
        }
    });
    
    $("#btn-chon-phong").click(function () {
        var loaiPhong = "<td>"+ $("select#loaiPhong").val() + "</td>";
        var maPhong = "<td>" + $("select#maPhong").val() + "</td>";
        var ngayNhanPhong = "<td>" + $("input#ngayNhanPhong").val() + "</td>";
        var ngayTraPhong = "<td>" + $("input#ngayTraPhong").val() + "</td>";
        var xoaPhong = "<td> <a> Xóa </a> </td>";
        $("table#table-thong-tin-thue-phong").append("<tr>" + loaiPhong + maPhong + ngayNhanPhong + ngayTraPhong + xoaPhong +"</tr>"); 
    });
});