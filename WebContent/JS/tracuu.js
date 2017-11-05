$(document).ready(function () {
                    /*TÌM PHÒNG*/
    //Sự kiện Click vào button Tìm trong TÌM PHÒNG	
    $("#btn-tim-phong").click(function (e) {
    	
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
    $("#btn-tra-cuu-khach-thue").click(function (e) {
    	$("#thong-tin-khach-hang").css("display","none"); 
    	$("#khong-co-ket-qua").css("display","none");
        var maTimKiemKHlength = $("#maTimKiemKH").val().trim().length;
        if(maTimKiemKHlength < 1)
    	{
        	alert("Mời bạn nhập thông tin tra cứu!");
    	}
        else{
        	var maTimKiemKH = $("#maTimKiemKH").val().trim();        	
        	$.ajax({
                type: "GET",
                url: "NV_TraCuuKhachHang",
                data: {
                	maTimKiemKH: maTimKiemKH
                },
                dataType: "json",
                success: function (result) { 
                    if (result.check == "fail") {
                    	$("#khong-co-ket-qua").text("Không tìm thấy kết quả");
                    	$("#khong-co-ket-qua").css("display","inline-block");
                        return;
                    }
                    //Lấy size của list này
                    var listSize = Object.keys(result).length;
                    if (listSize > 0) {
                    	$("#table-thong-tin-khach-hang > tbody").children().remove();
                    	
                    	$("#table-thong-tin-khach-hang > tbody").append(
                            $('<tr>').append(
                                $('<td>').text(result[0].maKH)
                                ).append(
                                $('<td>').text(result[0].hoTenKH)
                                ).append(
                                $('<td>').text(result[0].CMND)
                                ).append(
                                $('<td>').text(result[0].DiaChi)
                                ).append(
                                $('<td>').text(result[0].QuocTich)
                                ).append(
                                $('<td>').text(result[0].SDT)
                                )
                        );
                    	$("#thong-tin-khach-hang").css("display","block");
                    }
                },
                error: function (jqXHR, exception) {
                    if (jqXHR.status == 500)
                        alert("Tìm kiếm khách hàng không thành công!");
                }
            });
        }
    });

    				/*TRA CỨU THÔNG TIN THUÊ PHÒNG HIỆN TẠI CỦA KHÁCH HÀNG TRONG TRA CỨU KHÁCH THUÊ*/
    $("#tra-cuu-thong-tin-thue-phong-hien-tai").click(function (e) {
    	var maKH = $("#table-thong-tin-khach-hang > tbody").find("> tr:first").find('td:nth-child(1)').text();
    	$("#thong-tin-thue-phong").css("display","none"); 
    	$("#khong-co-ket-qua").css("display","none");
    	$.ajax({
            type: "POST",
            url: "NV_TraCuuKhachHang?maKH="+maKH,
            dataType: "json",
            success: function (result) { 
                if (result.check == "fail") {
                	$("#khong-co-ket-qua").text("Khách hàng hiện tại không có thông tin thuê phòng");
                	$("#khong-co-ket-qua").css("display","inline-block");
                    return;
                }
                //Lấy size của list này
                var listSize = Object.keys(result).length;
                if (listSize > 0) {
                	$("#table-thong-tin-thue-phong > tbody").children().remove();
                	for(i=0; i<listSize; i++){
                    	$("#table-thong-tin-thue-phong > tbody").append(
                            $('<tr>').append(
                                $('<td>').text(result[i].maPhong)
                                ).append(
                                $('<td>').text(result[i].ngayNhanPhong)
                                ).append(
                                $('<td>').text(result[i].ngayTraPhong)
                                ).append(
                                $('<td>').text(result[i].tienPhong)
                                )
                        );
                	}
                	$("#thong-tin-thue-phong").css("display","block");
                }
            },
            error: function (jqXHR, exception) {
                if (jqXHR.status == 500)
                    alert("Tìm kiếm thông tin thuê phòng của khách hàng không thành công!");
            }
        });
    });
    
    			/*CHO KHÁCH HÀNG THUÊ THÊM PHÒNG TRONG TRA CỨU KHÁCH THUÊ*/
    $("#thue-them-phong").click(function (e) {
    	window.location.assign("them-don-thue-phong.jsp");
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