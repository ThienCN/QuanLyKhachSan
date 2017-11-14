$(document).ready(function(e){
	$("#btn-lap-hoa-don").click(function(e){
		$("#thong-tin-khach-hang").css("display","none");
		$("#thong-tin-hoa-don").css("display","none");
		
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
						alert("Khách hàng không tồn tại trong dữ liệu!");
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
						var maKH = result[0].maKH;
						$.ajax({
				            type: "POST",
				            url: "NV_TraCuuKhachHang?maKH="+maKH,
				            dataType: "json",
				            success: function (result) { 
				                if (result.check == "fail") {
				                	alert("Khách hàng hiện không có thông tin thuê phòng!")
				                    return;
				                }
				                else{
				                	//Lấy mã KH đi kiểm tra ngày xuất hóa đơn có hợp lệ không
									$.ajax({
										type:"GET",
										url:"NV_LapHoaDon",
										data:{
											maKH: maKH
										},
										dataType:"json",
										success: function(result){
											if(result.check != "ok"){
												alert("Ngày hôm nay không phải là ngày thanh toán!\rNgày thanh toán là ngày "+ result);
												return;
											}
											else if(result.check == "ok"){
												//Lấy thông tin hóa đơn hiển thị ra bảng THÔNG TIN HÓA ĐƠN									
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
															
															$("#thong-tin-khach-hang").css("display","block");
															$("#thong-tin-hoa-don").css("display","block");
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
							             		alert("Không tìm thấy thông tin hóa đơn!");  
							            }
									});
				                }
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
	
	
	
	$("#btn-thanh-toan").click(function (e){
		var tongTienPhong = $("#tongTienThuePhong").val();
		var tongTienSuDungDichVu =  $("#tongTienSuDungDichVu").val();
		var tienDenBu = $("#tongTienDenBu").val();
		var tienDatCoc = $("#tienCoc").val();							
		var tongTienCanThanhToan = $("#tongTienCanThanhToan").val();
		
		var maKH = $("#maKH").val();
		
		$.ajax({
			type: "PUT",
			url: "NV_LapHoaDon?tongTienPhong=" + tongTienPhong
						+ "&tongTienSuDungDichVu=" + tongTienSuDungDichVu
						+ "&tienDenBu=" + tienDenBu
						+ "&tienDatCoc=" + tienDatCoc
						+ "&tongTienCanThanhToan=" + tongTienCanThanhToan
						+ "&maKH=" + maKH,
			dataType:"json",
			success: function(result){
				if(result.check == "ok"){
					alert("Thanh toán hóa đơn thành công!");					
					window.location.assign("nhan-vien.jsp");
					return;
				}
			},
        	error: function(jqXHR, exception) {
             	if (jqXHR.status == 500)
             		alert("Xuất hóa đơn không thành công!");  
            }
		});
		
				
		
	});
});