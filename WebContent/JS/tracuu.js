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
    $("#btn-tra-cuu-khach-dat").click(function (e) {
    	$("#thong-tin-khach-dat").css("display","none"); 
    	$("#khong-co-ket-qua").css("display","none");
    	var maTimKiemKDlength = $("#maTimKiemKD").val().trim().length;
    	if(maTimKiemKDlength < 1)
    	{
        	alert("Mời bạn nhập thông tin tra cứu!");
    	}
        else{
        	var maTimKiemKD = $("#maTimKiemKD").val().trim();        	
        	$.ajax({
                type: "GET",
                url: "NV_TraCuuKhachDat",
                data: {
                	maTimKiemKD: maTimKiemKD
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
                    	$("#table-thong-tin-khach-dat > tbody").children().remove(); //Xóa dữ liệu trên bảng
                    	
                    	$("#table-thong-tin-khach-dat > tbody").append(
                            $('<tr>').append(
                                $('<td>').text(result[0].maKD)
                                ).append(
                                $('<td>').text(result[0].hoTenKD)
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
                    	$("#thong-tin-khach-dat").css("display","block");
                    }
                },
                error: function (jqXHR, exception) {
                    if (jqXHR.status == 500)
                        alert("Tìm kiếm khách đặt không thành công!");
                }
            });
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
                	console.log(result.check);
                	
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
                                ).append(
                                $('<td>').text(result[i].maCodeDatPhong)
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
    
    /*TRA CỨU THÔNG TIN THUÊ PHÒNG HIỆN TẠI CỦA KHÁCH HÀNG TRONG TRA CỨU KHÁCH THUÊ*/
    $("#tra-cuu-thong-tin-dat-phong-hien-tai").click(function (e) {
    	var maKD = $("#table-thong-tin-khach-dat > tbody").find("> tr:first").find('td:nth-child(1)').text();
    	
    	var tinhTrang=null;
  
    	$("#thong-tin-dat-phong").css("display","none"); 
    	$("#khong-co-ket-qua").css("display","none");
    	$.ajax({
            type: "POST",
            url: "NV_TraCuuKhachDat?maKD="+maKD,
            dataType: "json",
            success: function (result) { 
                if (result.check == "fail") {
                	$("#khong-co-ket-qua").text("Khách hàng hiện tại không có thông tin đặt phòng");
                	$("#khong-co-ket-qua").css("display","inline-block");
                    return;
                }
                
                var ngayHienTai = new Date();
                dayHienTai = ngayHienTai.getDate();
                monthHienTai = ngayHienTai.getMonth() + 1;
                yearHienTai = ngayHienTai.getFullYear();
                
                var ngayhientai=[dayHienTai, monthHienTai, yearHienTai].join('/');
        		
                //Lấy size của list này
                var listSize = Object.keys(result).length;
                if (listSize > 0) {
                	$("#table-thong-tin-dat-phong > tbody").children().remove(); //Xóa dữ liệu của bảng
                	for(i=0; i<listSize; i++){
                		
                		var ngayNhan = new Date(result[i].ngayNhanPhong);
                        dayNhan = ngayNhan.getDate();
                        monthNhan = ngayNhan.getMonth() + 1;
                        yearNhan = ngayNhan.getFullYear();
                        
                        var ngayTra = new Date(result[i].ngayTraPhong);
                        dayTra = ngayTra.getDate();
                        monthTra = ngayTra.getMonth() + 1;
                        yearTra = ngayTra.getFullYear();
                        
                        var ngaynhanphong=[dayNhan, monthNhan, yearNhan].join('/');
                        ngaytraphong=[dayTra, monthTra, yearTra].join('/');
                        
                        if(ngaynhanphong>ngayhientai){
                        	alert("Perfect");
                        }
                        else{
                        	alert("no");
                        }
                		
                		if(result[i].tinhTrang == 1){
                			tinhTrang="Chưa nhận phòng"
                		}
                    	$("#table-thong-tin-dat-phong > tbody").append(
                            $('<tr>').append(
                            	$('<td>').text(result[i].loaiPhong)
                            	).append(
                            	$('<td>').text(result[i].maPhong)
                                ).append(
                                $('<td>').text(result[i].ngayNhanPhong)
                                ).append(
                                $('<td>').text(result[i].ngayTraPhong)
                                ).append(
                                $('<td>').text(result[i].tienPhong)
                                ).append(
                                $('<td>').text(result[i].tinhTrang)
                                )
                        );
                	}
                	$("#thong-tin-dat-phong").css("display","block");
                }
            },
            error: function (jqXHR, exception) {
                if (jqXHR.status == 500)
                    alert("Tìm kiếm thông tin đặt phòng của khách hàng không thành công!");
            }
        });
    });
    
    			/*CHO KHÁCH HÀNG THUÊ THÊM PHÒNG TRONG TRA CỨU KHÁCH THUÊ*/
    $("#thue-them-phong").click(function (e) {
    	window.location.assign("them-don-thue-phong.jsp");
    });
    
    /*CHO KHÁCH HÀNG ĐẶT THÊM PHÒNG TRONG TRA CỨU KHÁCH THUÊ*/
    $("#dat-them-phong").click(function (e) {
    	window.location.assign("them-don-dat-phong.jsp");
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