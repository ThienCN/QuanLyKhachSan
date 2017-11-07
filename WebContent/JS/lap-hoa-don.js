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