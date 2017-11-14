$(document).ready(function () {
	var color =null;
	var sum=0;
	$.ajax({
        type: "GET",
        url: "KD_XacNhanNhanPhong",
        dataType: "json",
        success: function (result) { 
            if (result.check == "fail") {
                	alert("Không thể load thông tin đặt phòng")
            }
            
            var ngayHienTai = new Date();
            dayHienTai = ngayHienTai.getDate();
            monthHienTai = ngayHienTai.getMonth() + 1;
            yearHienTai = ngayHienTai.getFullYear();
            
            var ngayhientai=[dayHienTai, monthHienTai, yearHienTai].join('/');
            
            var listSize = Object.keys(result).length;
            if (listSize > 0) {
            	$("#table-thong-tin-dat-phong > tbody").children().remove();
            	for(i=0; i<listSize; i++){
            		
            		sum = sum +(result[i].tienPhong);
            		
            		var ngayNhan = new Date(result[i].ngayNhanPhong);
                    dayNhan = ngayNhan.getDate();
                    monthNhan = ngayNhan.getMonth() + 1;
                    yearNhan = ngayNhan.getFullYear();
                    
                    var ngayTra = new Date(result[i].ngayTraPhong);
                    dayTra = ngayTra.getDate();
                    monthTra = ngayTra.getMonth() + 1;
                    yearTra = ngayTra.getFullYear();
                    
                    var ngaynhanphong=[dayNhan, monthNhan, yearNhan].join('/');
                    var ngaytraphong=[dayTra, monthTra, yearTra].join('/');
                    
                    if(ngayhientai == ngaynhanphong){
                    	color="blue";
                    }
                    else{
                    	color="black";
                    }
                    
                	$("#table-thong-tin-dat-phong > tbody").append(
                        $('<tr>').append(
                            $('<td>').text(result[i].loaiPhong)
                            ).append(
                            $('<td>').text(result[i].maPhong)
                            ).append(
                            $('<td style="color:'+color+'">').text(ngaynhanphong)
                            ).append(
                            $('<td style="color:'+color+'">').text(ngaytraphong)
                            ).append(
                            $('<td>').text(result[i].tienPhong)
                            )
                   );
            	
            	$("#table-xac-nhan-thue-phong > tbody").children().remove();
            		if(ngayhientai == ngaynhanphong){
	                	$("#table-xac-nhan-thue-phong > tbody").append(
	                        $('<tr>').append(
	                            $('<td>').text(result[i].loaiPhong)
	                            ).append(
	                            $('<td>').text(result[i].maPhong)
	                            ).append(
	                            $('<td style="color:'+color+'">').text(ngaynhanphong)
	                            ).append(
	                            $('<td style="color:'+color+'">').text(ngaytraphong)
	                            ).append(
	                            $('<td>').text(result[i].tienPhong)
	                            )
	                   );
            		}
            	}
            	
            	var n = $("#table-thong-tin-thue-phong > tbody").find("> tr:first").length;
            	if(n<=0){
            		$("#chap-nhan-thue-phong").prop("disabled", true);
            	}
            }
        },
        error: function (jqXHR, exception) {
            if (jqXHR.status == 500)
                alert("Load thông tin đặt phòng không thành công!");
        }
	});
	
	$(".tongtien").text(": "+sum);
	
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
                	hoTenKH: hoten,
                	CMND: cmnd,
                	SDT: sdt,
                	QuocTich: quoctich,
                	DiaChi: diachi
                },
                dataType: "json",
                success: function (result) {
                	if(result.check == "fail"){
                		alert("Thêm khách hàng không thành công!");  
                	}
                	else if(result.MaKH != null)
            		{
                		$("#maKH").val(result.MaKH);
                		$("#luu-thong-tin-KH").prop("disabled", true);
                		$("#huy-giao-dich-thue-phong").prop("disabled", false);
                		$("#xac-nhan-giao-dich-thue-phong").prop("disabled", false);
            		}  
                },
                error: function(jqXHR, exception) {
                	if (jqXHR.status == 500)
                		alert("Thêm khách hàng không thành công!");  
                }
            });
        }
           
	});
	
	/*Sự kiện click nút Xác nhận thuê phòng*/
	$("#chap-nhan-thue-phong").click(function(e){
		var maKH = $("#maKH").val().trim().length;
		if(maKH<0){
			alert("Mời bạn lưu thông tin khách hàng");
		}
		else{
			$.ajax({
		        type: "POST",
		        url: "KD_XacNhanNhanPhong?maKH="+maKH+"&",
		        dataType: "json",
		        success: function (result) { 
		            
		        },
		        error: function (jqXHR, exception) {
		            if (jqXHR.status == 500)
		                alert("Load thông tin đặt phòng không thành công!");
		        }
			});
		}
	});
});