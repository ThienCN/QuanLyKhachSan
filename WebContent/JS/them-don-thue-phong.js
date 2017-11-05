$(document).ready(function () {
	/*Sự kiện click nút Lưu thông tin cá nhân khách hàng*/
	$("#luu-thong-tin-KH").click(function(e){
		var hoten = $("#hotenKH").val().trim();
        var cmnd = $("#CMND").val().trim();
        var sdt = $("#SDT").val().trim();
        var quoctich = $("#QuocTich").val().trim();
        var diachi = $("#DiaChi").val().trim();

        //Nếu thông tin khách hàng chưa nhập đầy đủ và chưa chọn một phòng thuê nào thì thông báo lỗi
        if (hoten.length <= 0 || cmnd.length <= 0 || sdt.length <= 0 || quoctich.length <= 0 || diachi.length <= 0)
        {
            confirm("Mời bạn nhập đầy đủ thông tin cá nhân của khách hàng!!");
        }//Thông tin đầy đủ thì lưu
        else{          	
        	
    		$.ajax({
                type: "GET",
                url: "Them_CapNhat_KhachHang",
                data: {
                	hoten: hoten,
                	cmnd: cmnd,
                	sdt: sdt,
                	quoctich: quoctich,
                	diachi: diachi
                },
                dataType: "text",
                success: function (result) {
                	if(result == "No"){
                		alert("Khách hàng đã tồn tại trong lịch sử! Mời bạn tra cứu thông tin khách hàng và chọn thuê phòng!");  
                	}
                	else
            		{
                		$("#maKH").val(result);
                		$("#luu-thong-tin-KH").prop("disabled", true);
                		$("#huy-giao-dich-thue-phong").prop("disabled", false);
                		$("#xac-nhan-giao-dich-thue-phong").prop("disabled", false);
            		}                	
                },
                error: function(jqXHR, exception) {
                	if (jqXHR.status == 500)
                		alert("Khách hàng đã tồn tại trong lịch sử! Mời bạn tra cứu thông tin khách hàng và chọn thuê phòng!");  
                }
            });
        }
           
	});
	
	
	/*Sự kiện click vào nút Thay đổi ngày tìm phòng*/
    $("#thay-doi-ngay-tim-phong").click(function (e) {
        $("#tim-phong").prop("disabled", false);
        $("#ngayTraPhong").attr("readonly", false);
        $("#thay-doi-ngay-tim-phong").prop("disabled", true);
        $("#phongDon").prop("disabled", true);
        $("#phongDoi").prop("disabled", true);
        $("#phongTapThe").prop("disabled", true);
        $("#btn-chon-phong").prop("disabled", true);
        
    });

    /*Sự kiện click vào nút Tìm phòng*/
    $("#tim-phong").click(function (e) { 
    	var maKH = $("#maKH").val().trim().length;
    	if(maKH<=0)
		{
    		alert("Mời bạn nhập và lưu thông tin cá nhân của khách hàng trước khi chọn phòng thuê!!!");
		}
    	else if(maKH>0)
		{
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
            	var ngayNhan = $("#ngayNhanPhong").val();
                var ngayTra = $("#ngayTraPhong").val();
                $.ajax({
                    type: "GET", //method
                    url: "NV_TimPhongThue_Dat", //Tên servlet
                    data: {
                        ngayNhan: ngayNhan, 
                        ngayTra: ngayTra
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
        	alert("Mời bạn tìm phòng hoặc chọn phòng khác!");
        }
        else
        {
        	//Thêm thông tin phòng chọn vào ds Thông tin thuê phòng dự trữ
        	var maKH=$("#maKH").val();
        	$.ajax({
                type: "GET",
                url: "NV_CapNhatChiTietThue",
                data: {
                	maKH: maKH,
                	loaiPhong:loaiPhong,
                    maPhong: maPhong,
                    ngayNhanPhong: ngayNhanPhong,
                    ngayTraPhong: ngayTraPhong,
                    tienPhong:phiThue
                },
                dataType: "json",
                success: function (result) {
                	if (result.check == "fail") {
                		alert("Thêm phòng thuê không thành công!"); 
                        return;
                	}
                },
                error: function(jqXHR, exception) {
                	if (jqXHR.status == 500)
                		alert("Thêm phòng thuê không thành công!");  
                }
            }); 

        	//Thêm dòng thông tin thuê phòng vào bảng Chi tiết phòng thuê
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
                            $('<a>').text('Xóa').css('cursor', 'pointer')
                                .click(function (e) {
                                    e.preventDefault();
                                    if (confirm('Bạn có chắc chắn muốn hủy thuê phòng này không?')) {
                                    	
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
                                        var maKH=$("#maKH").val();
                                        var ngayNhanP = $(this).closest('tr').find('td:nth-child(3)').text();
                                        
                                        $.ajax({
                                            type: "DELETE",
                                            url: "NV_CapNhatChiTietThue?maPhong="+maPhongPhucHoi+"&ngayNhanPhong="+ngayNhanP+"&maKhachHang="+maKH,
                                            dataType: "json",
                                            success: function (result) {
                                            	if (result.check == "fail") {
                                            		alert("Xóa phòng thuê không thành công!\n Ngày xóa không hợp lệ!"); 
                                                    return;
                                            	}
                                            },
                                            error: function(jqXHR, exception) {
                                            	if (jqXHR.status == 500)
                                            		alert("Xóa phòng thuê không thành công!\n Ngày xóa không hợp lệ!");  
                                            }
                                        }); 
                                        
                                        $(this).closest('tr').remove();
                                    }
                                })
                        	)
                        )
                	);
        }
    });
    
    /*Sự kiện Click vào nút Xác nhận giao dịch thuê phòng*/
    $("#xac-nhan-giao-dich-thue-phong").click(function (e) {

        var n = $("#table-thong-tin-thue-phong > tbody").find("> tr:first").length;

        //Nếu chưa đăng ký phòng thuê thì không được xác nhận thành công
        if (n <= 0)
        {
            confirm("Mời bạn chọn phòng cho giao dịch thuê phòng!!!");
        }//Thông tin đầy đủ thì lưu
        else{
        	alert("Giao dịch thành công!");
        	window.location.assign("nhan-vien.jsp");
        }
    });
    
    /*Sự kiện hủy giao dịch thuê phòng*/
    $("#huy-giao-dich-thue-phong").click(function (e){
    	if(confirm("Bạn có chắc chắn muốn hủy hoàn toàn giao dịch thuê này hay không?")){
    		var maKH=$("#maKH").val();
    		var ngayNhanP=$("#ngayNhanPhong").val();    		
    		$.ajax({
                type: "POST",
                url: "NV_CapNhatChiTietThue?maKH="+maKH+"&ngayNhanPhong="+ngayNhanP,
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