$(document).ready(function(e){
	$("#btn-lap-hoa-don").click(function(e){
		var maXuatHoaDon=$("#maXuatHoaDon").val().trim();
		if(maXuatHoaDon.length <= 0){
			alert("Mời bạn nhập thông tin để xuất hóa đơn!");
			return;
		}
		else{
			
			//Lấy thông tin khách hàng hiển thị ra bảng THÔNG TIN KHÁCH HÀNG
			$.ajax({
				type:"GET",
				url:"NV_TraCuuKhachHang",
				data:{
					maTimKiemKH:maXuatHoaDon
				},
				dataType:"json",
				success: function(result){
					if(result.check == "fail"){
						alert("Không tìm thấy thông tin khách hàng!");
						return;
					}
					else{
						var n = Object.keys(result).length;
						if(n > 0){
							$("#maKH").val(result[0].maKH);
							$("#hoTenKH").val(result[0].hoTenKH);
							$("#CMND").val(result[0].CMND);
							$("#DiaChi").val(result[0].DiaChi);
							$("#QuocTich").val(result[0].QuocTich);
							$("#SDT").val(result[0].SDT);
						}
						//Lấy thông tin hóa đơn hiển thị ra bảng THÔNG TIN HÓA ĐƠN
						var maKH = result[0].maKH;
						$.ajax({
							type:"POST",
							url:"NV_LapHoaDon?maKH="+maKH,
							dataType:"json",
							success: function(result){
								if(result.check == "fail"){
									alert("Không tìm thấy thông tin hóa đơn!");
									return;
								}
								else{
									var n = Object.keys(result).length;
									if(n > 0){
										$("#maHoaDon").val(result[0].maHD);
										$("#tongTienThuePhong").val(result[0].tienPhong);
										$("#tongTienSuDungDichVu").val(result[0].tienSuDungDichVu);
										$("#tongTienDenBu").val(result[0].tienDenBu);
										$("#tienCoc").val(result[0].tienCoc);
										var temp = result[0].tienPhong + 
													result[0].tienSuDungDichVu + 
													result[0].tienDenBu - 
													result[0].tienCoc;										
										$("#tongTienCanThanhToan").val(temp);
									}
								}
							},
				        	error: function(jqXHR, exception) {
				             	if (jqXHR.status == 500)
				             		alert("Không tìm thấy thông tin hóa đơn!");  
				            }
						});
					}
				},
	        	error: function(jqXHR, exception) {
	             	if (jqXHR.status == 500)
	             		alert("Tìm phòng không thành công!");  
	            }
			});			
		}
	});
});