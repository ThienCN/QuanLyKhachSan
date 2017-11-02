$(document).ready(function () {
    /*VALIDATE nhập thông tin người dùng*/
    $("#thay-doi-ngay-tim-phong").click(function (e) {
        $("#tim-phong").prop("disabled", false);
        $("#ngayNhanPhong").attr("readonly", false);
        $("#ngayTraPhong").attr("readonly", false);
        $("#thay-doi-ngay-tim-phong").prop("disabled", true);
    });

    $("#tim-phong").click(function (e) {
        e.preventDefault();
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
            $("#phongDon").prop("disabled", false);
            $("#ngayNhanPhong").attr("readonly", true);
            $("#ngayTraPhong").attr("readonly", true);
            $("#tim-phong").prop("disabled", true);
            $("#btn-chon-phong").prop("disabled", false);
        }    

      

    });


    $("#ds-phong-don").click(function (e) {
        $("#phongDon").prop("disabled", false);
        $("#phongDoi").prop("disabled", true);
        $("#phongTapThe").prop("disabled", true);
    });
    $("#ds-phong-doi").click(function (e) {
        $("#phongDon").prop("disabled", true);
        $("#phongDoi").prop("disabled", false);
        $("#phongTapThe").prop("disabled", true);
    });
    $("#ds-phong-tap-the").click(function (e) {
        $("#phongDon").prop("disabled", true);
        $("#phongDoi").prop("disabled", true);
        $("#phongTapThe").prop("disabled", false);
    });



    $("#btn-chon-phong").click(function () {
        var loaiPhong, maPhong, phiThue;
        if (document.getElementById("phongDon").disabled == false)
        {
            loaiPhong = "Phòng đơn";
            maPhong = $("select#phongDon").val();
            phiThue = $("#phiThuePhongDon").text();
            $("#phongDon option:selected").remove();
        }            
        if (document.getElementById("phongDoi").disabled == false)
        {
            loaiPhong = "Phòng đôi";
            maPhong = $("select#phongDoi").val();
            phiThue = $("#phiThuePhongDoi").text();
            $("#phongDoi option:selected").remove();
        }            
        if (document.getElementById("phongTapThe").disabled == false)
        {
            loaiPhong = "Phòng tập thể";
            maPhong = $("select#phongTapThe").val();
            phiThue = $("#phiThuePhongTapThe").text();
            $("#phongTapThe option:selected").remove();
        }
        var ngayNhanPhong = $("#ngayNhanPhong").val();
        var ngayTraPhong = $("#ngayTraPhong").val();

        if (loaiPhong == null || maPhong == null || phiThue == null || ngayNhanPhong == null || ngayTraPhong == null) {
            alert("Mời bàn tìm phòng trước khi chọn phòng!");
        }
        else
        {
            $("#table-thong-tin-thue-phong > tbody").append(
                $('<tr>').append(
                    $('<td>').text(loaiPhong)
                ).append(
                    $('<td>').text(maPhong)
                    ).append(
                    $('<td>').text(ngayNhanPhong)
                    ).append(
                    $('<td>').text(ngayTraPhong)
                    ).append(
                    $('<td>').text(phiThue)
                    ).append(
                    $('<td>').append(
                        $('<a>').text('Hủy').css('cursor', 'pointer')
                            .click(function (e) {
                                e.preventDefault();
                                if (confirm('Bạn có chắc chắn muốn hủy thuê phòng này không?')) {
                                    $(this).closest('tr').remove();
                                }
                        })
                    )
               )
            );
        }

       
    });
});