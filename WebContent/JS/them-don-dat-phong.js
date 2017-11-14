$(document).ready(function () {
	var sum = 0;
	$(".sumtien").css("display","none");
	var maKhachDat = null;
	
	/*Sự kiện click nút Lưu thông tin cá nhân khách hàng*/
	$("#luu-thong-tin-KD").click(function(e){
		var hoten = $("#hotenKD").val().trim();
        var cmnd = $("#CMND").val().trim();
        var sdt = $("#SDT").val().trim();
        var quoctich = $("#quoctich").val().trim();
        var diachi = $("#diachi").val().trim();

        //Nếu thông tin khách hàng chưa nhập đầy đủ và chưa chọn một phòng thuê nào thì thông báo lỗi
        if (hoten.length <= 0 || cmnd.length <= 0 || sdt.length <= 0 || quoctich.length <= 0 || diachi.length <= 0)
        {
            confirm("Mời bạn nhập đầy đủ thông tin cá nhân của khách hàng!!");
        }//Thông tin đầy đủ thì lưu
        else{          	
        	
    		$.ajax({
                type: "GET",
                url: "Them_CapNhat_KhachDat",
                data: {
                	hoTenKD: hoten,
                	CMND: cmnd,
                	SDT: sdt,
                	QuocTich: quoctich,
                	DiaChi: diachi
                },
                dataType: "text",
                success: function (result) {
                	if(result == "No"){
                		alert("Không thể thêm mới khách đặt!");  
                	}
                	else
            		{
                		$("#maKD").val(result);
                		$("#luu-thong-tin-KD").prop("disabled", true);
                		$("#huy-giao-dich-dat-phong").prop("disabled", false);
                		$("#xac-nhan-giao-dich-dat-phong").prop("disabled", false);
            		}                	
                },
                error: function(jqXHR, exception) {
                	if (jqXHR.status == 500)
                		alert("Khách đặt đã tồn tại trong lịch sử! Mời bạn tra cứu thông tin khách đặt và chọn đặt phòng!");  
                }
            });
        }
           
	});
	
	
	/*Sự kiện click vào nút Thay đổi ngày tìm phòng*/
    $("#thay-doi-ngay-tim-phong").click(function (e) {
        $("#tim-phong").prop("disabled", false);
        $("#ngayTraPhong").attr("readonly", false);
        $("#ngayNhanPhong").attr("readonly", false);
        $("#thay-doi-ngay-tim-phong").prop("disabled", true);
        $("#phongDon").prop("disabled", true);
        $("#phongDoi").prop("disabled", true);
        $("#phongTapThe").prop("disabled", true);
        $("#btn-chon-phong").prop("disabled", true);
        
    });

    /*Sự kiện click vào nút Tìm phòng*/
    $("#tim-phong").click(function (e) { 
    	var maKD = $("#maKD").val().trim().length;
    	if(maKD<=0)
		{
    		alert("Mời bạn nhập và lưu thông tin cá nhân của khách hàng trước khi chọn phòng đặt!!!");
		}
    	else if(maKD>0)
		{
    		var ngayHienTai = new Date();
            dayHienTai = ngayHienTai.getDate();
            monthHienTai = ngayHienTai.getMonth() + 1;
            yearHienTai = ngayHienTai.getFullYear();
            var ngayhientai=[dayHienTai, monthHienTai, yearHienTai].join('/');
            
            var ngayNhan = new Date($("#ngayNhanPhong").val());
            var ngayTra = new Date($("#ngayTraPhong").val());
            
            dayNhan = ngayNhan.getDate();
            monthNhan = ngayNhan.getMonth() + 1;
            yearNhan = ngayNhan.getFullYear();
            
            dayTra = ngayTra.getDate();
            monthTra = ngayTra.getMonth() + 1;
            yearTra = ngayTra.getFullYear();
            
            var ngaynhanphong=[dayNhan, monthNhan, yearNhan].join('/');
            var ngaytraphong=[dayTra, monthTra, yearTra].join('/');
            
            if (ngaynhanphong == "NaN/NaN/NaN" || ngaytraphong == "NaN/NaN/NaN")
                alert("Nhập đầy đủ ngày nhận phòng và ngày trả phòng!!!");
            else if (ngaynhanphong >= ngaytraphong)
                alert("Ngày nhận phòng và ngày trả phòng không hợp lệ!!!");
            else if (ngayhientai >= ngaynhanphong)
                alert("Ngày nhận phòng phải lớn hơn ngày hiện tại!!!");
            else
            {
            	var ngayNhan = $("#ngayNhanPhong").val();
                var ngayTra = $("#ngayTraPhong").val();
                $.ajax({
                    type: "GET", //method
                    url: "NV_TimPhong", //Tên servlet
                    data: {
                        ngayNhanPhong: ngayNhan, 
                        ngayTraPhong: ngayTra
                    },
                    dataType: "json",
                    success: function (result) {
                    	if (result.check == "fail") {
                            return;
                        }
                        //Lấy size của list phòng trống được trả về
                        var n = Object.keys(result).length;
                        //Xóa dữ liệu phòng trống cũ
                        $("#phongDon option").remove();
                        $("#phongDoi option").remove();
                        $("#phongTapThe option").remove();

                        if (n > 0)
                        {
                            for (i = 0; i < n; i++)
                            {
                                if (result[i].loaiPhong == "Phòng đơn")
                            	{
                                	$("#phongDon").append("<option>" + result[i].maPhong + "</option");
                                	$("#phiThuePhongDon").text(result[i].tienPhong);
                                	$("#giaPhongDon").css("display","inline-block");
                            	}                            	
                                else if (result[i].loaiPhong == "Phòng đôi")
                            	{
                                	$("#phongDoi").append("<option>" + result[i].maPhong + "</option");
                                	$("#phiThuePhongDoi").text(result[i].tienPhong);
                                	$("#giaPhongDoi").css("display","inline-block");
                            	}                            	
                                else if (result[i].loaiPhong == "Phòng tập thể")
                            	{
                                	$("#phongTapThe").append("<option>" + result[i].maPhong + "</option");
                            		$("#phiThuePhongTapThe").text(result[i].tienPhong);
                            		$("#giaPhongTapThe").css("display","inline-block");
                            	}
                                    
                            }                        
                		}
                    },
                    error: function(jqXHR, exception) {
                    	if (jqXHR.status == 500)
                    		alert("Tìm phòng không thành công!");  
                    }
                });
                
                $("#thay-doi-ngay-tim-phong").prop("disabled", false);
                $("#phongDon").prop("disabled", false);
                $("#ngayTraPhong").attr("readonly", true);
                $("#ngayNhanPhong").attr("readonly", true);
                $("#tim-phong").prop("disabled", true);
                $("#btn-chon-phong").prop("disabled", false);
            }  
		}
    });

    /*SỰ kiện click vào danh sách Phòng đơn*/
    $("#ds-phong-don").click(function (e) {
        $("#phongDon").prop("disabled", false);
        $("#phongDoi").prop("disabled", true);
        $("#phongTapThe").prop("disabled", true);
    });
    
    /*Sự kiện click vào danh sách Phòng đôi*/
    $("#ds-phong-doi").click(function (e) {
        $("#phongDon").prop("disabled", true);
        $("#phongDoi").prop("disabled", false);
        $("#phongTapThe").prop("disabled", true);
    });
    
    /*Sự kiện Click vào danh sách Phòng tập thể*/
    $("#ds-phong-tap-the").click(function (e) {
        $("#phongDon").prop("disabled", true);
        $("#phongDoi").prop("disabled", true);
        $("#phongTapThe").prop("disabled", false);
    });


    /*Sự kiện Click vào nút Chọn phòng*/
    $("#btn-chon-phong").click(function () {
        var loaiPhong, maPhong, phiThue;
        var tinhTrang = 1;
        if (document.getElementById("phongDon").disabled == false)
        {
            loaiPhong = "Phòng đơn";
            maPhong = $("select#phongDon").val();            
            phiThue = $("#phiThuePhongDon").text();
            sum += parseFloat(phiThue);
            $("#phongDon option:selected").remove();
        }            
        if (document.getElementById("phongDoi").disabled == false)
        {
            loaiPhong = "Phòng đôi";
            maPhong = $("select#phongDoi").val();
            phiThue = $("#phiThuePhongDoi").text();
            sum += parseFloat(phiThue);
            $("#phongDoi option:selected").remove();
        }            
        if (document.getElementById("phongTapThe").disabled == false)
        {
            loaiPhong = "Phòng tập thể";
            maPhong = $("select#phongTapThe").val();
            phiThue = $("#phiThuePhongTapThe").text();
            sum += parseFloat(phiThue);
            $("#phongTapThe option:selected").remove();
        }
        var ngayNhanPhong = $("#ngayNhanPhong").val();
        var ngayTraPhong = $("#ngayTraPhong").val();

        if (loaiPhong == null || maPhong == null || phiThue == null || ngayNhanPhong == null || ngayTraPhong == null) {
        	alert("Mời bạn tìm phòng hoặc chọn phòng khác!");
        }
        else
        {
        	
        	//Thêm thông tin phòng chọn vào ds Thông tin thuê phòng dự trữ
        	var maKD=$("#maKD").val();
        	maKhachDat = maKD;
        	$.ajax({
                type: "GET",
                url: "NV_CapNhatChiTietDatPhong",
                data: {
                	maKD: maKD,
                	loaiPhong:loaiPhong,
                    maPhong: maPhong,
                    ngayNhanPhong: ngayNhanPhong,
                    ngayTraPhong: ngayTraPhong,
                    tienPhong:phiThue
                },
                dataType: "json",
                success: function (result) {
                	if (result.check == "fail") {
                		alert("Thêm phòng đặt không thành công!"); 
                        return;
                	}
                },
                error: function(jqXHR, exception) {
                	if (jqXHR.status == 500)
                		alert("Thêm phòng đặt không thành công!");  
                }
            }); 

        	//Thêm dòng thông tin đặt phòng vào bảng Chi tiết phòng đặt
        	$("#table-thong-tin-dat-phong > tbody").append(
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
                            $('<a>').text('Xóa').css('cursor', 'pointer')
                                .click(function (e) {
                                    e.preventDefault();
                                    if (confirm('Bạn có chắc chắn muốn hủy đặt phòng này không?')) {
                                    	
                                    	//Lấy mã phòng và loại phòng mà khách vừa hủy
                                        var loaiPhongPhucHoi = $(this).closest('tr').find('td:nth-child(1)').text();
                                        var maPhongPhucHoi = $(this).closest('tr').find('td:nth-child(2)').text();
                                        //Bỏ lại vào combobox mã phòng trống tương ứng
                                        if (loaiPhongPhucHoi == "Phòng đơn")
                                            $('#phongDon').append("<option>" + maPhongPhucHoi + "</option>");
                                        else if (loaiPhongPhucHoi == "Phòng đôi")
                                            $('#phongDoi').append("<option>" + maPhongPhucHoi + "</option>");
                                        else if (loaiPhongPhucHoi == "Phòng tập thể")
                                            $('#phongTapThe').append("<option>" + maPhongPhucHoi + "</option>");
                                        
                                        //Lấy ngày nhận ngày trả để xóa thông tin thuê phòng này trong dsThongTinPhongThue
                                        var maKD=$("#maKD").val();
                                        var ngayNhanP = $(this).closest('tr').find('td:nth-child(3)').text();
                                        var tienPhong = $(this).closest('tr').find('td:nth-child(5)').text();
                                        
                                        $.ajax({
                                            type: "DELETE",
                                            url: "NV_CapNhatChiTietDatPhong?maPhong="+maPhongPhucHoi+"&ngayNhanPhong="+ngayNhanP+"&maKD="+maKD,
                                            dataType: "json",
                                            success: function (result) {
                                            	if (result.check == "fail") {
                                            		alert("Xóa phòng đặt không thành công!\n Ngày xóa không hợp lệ!"); 
                                                    return;
                                            	}
                                            },
                                            error: function(jqXHR, exception) {
                                            	if (jqXHR.status == 500)
                                            		alert("Xóa phòng đặt không thành công!\n Ngày xóa không hợp lệ!");  
                                            }
                                        }); 
                                        
                                        $(this).closest('tr').remove();
                                        sum -= parseFloat(tienPhong);
                                        if(sum == 0){
                                        	$(".sumtien").css("display","none");
                                        }
                                        $(".tongtien").text(": " + sum);
                                        $(".tiencoc").text("Tiền cọc (USD): " + (sum*0.1));
                                    }
                                })
                        	)
                        )
                	);
        }
        
        if(sum > 0){
        	$(".sumtien").css("display","block");
            $(".tongtien").text(": " + sum);
            $(".tiencoc").text("Tiền cọc (USD): " + (sum*0.1));
        }
    });
    
    /*Sự kiện Click vào nút Xác nhận giao dịch đặt phòng*/
    $("#xac-nhan-giao-dich-dat-phong").click(function (e) {
    	e.preventDefault();
        var n = $("#table-thong-tin-dat-phong > tbody").find("> tr:first").length;

        //Nếu chưa đăng ký phòng đặt thì không được xác nhận thành công
        if (n <= 0)
        {
            alert("Mời bạn chọn phòng cho giao dịch đặt phòng!!!");
        }//Thông tin đầy đủ thì lưu
        else{
        	alert("Giao dịch thành công!\nMã code đặt phòng của bạn là: " + maKhachDat);
        	window.location.assign("nhan-vien.jsp");
        }
    });
    
    /*Sự kiện hủy giao dịch đặt phòng*/
    $("#huy-giao-dich-dat-phong").click(function (e){
    	if(confirm("Bạn có chắc chắn muốn hủy hoàn toàn giao dịch đặt này hay không?")){
    		var maKD=$("#maKD").val();		
    		$.ajax({
                type: "POST",
                url: "NV_CapNhatChiTietDatPhong?maKD="+maKD,
                dataType:"text",
                success: function (result){
                	if(result == "Yes")
            		{
                		alert("Hủy giao dịch thành công!");
                		window.location.assign("nhan-vien.jsp");
            		}
                	else if(result == "No")
                		alert("Hủy giao dịch không thành công!"); 
                },
                error: function(jqXHR, exception) {
                	if (jqXHR.status == 500)
                		alert("Hủy giao dịch không thành công!");  
                }
            }); 
    	}
    });
});