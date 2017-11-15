$(document).ready(function (e){	
	
	$("#btn-thong-ke").click(function (e){
		$("#ket-qua-thong-ke").css("display","none"); 
		$("#khong-co-ket-qua").css("display","none");
		
		var ngayBatDau = new Date($("#ngayBatDau").val());
		var ngayKetThuc = new Date($("#ngayKetThuc").val());
		
		if (ngayBatDau == "Invalid Date" || ngayKetThuc == "Invalid Date")
            alert("Nhập đầy đủ ngày nhận phòng và ngày trả phòng!!!");
        else if (ngayBatDau >= ngayKetThuc)
            alert("Ngày bắt đầu và ngày kết thúc không hợp lệ!!!");
        else
    	{
        	ngayBatDau=$("#ngayBatDau").val();
        	ngayKetThuc=$("#ngayKetThuc").val();
        	$.ajax({
        		type:"GET",
        		url:"NV_ThongKeDatPhong",
        		data:{
        			ngayBatDau:ngayBatDau,
        			ngayKetThuc:ngayKetThuc
        		},
        		dataType:"json",
        		success: function(result){
        			if (result.check == "fail") {
        				$("#khong-co-ket-qua").text("Không có giao dịch đặt phòng trong thời gian này!");
        				$("#khong-co-ket-qua").css("display","block");
                        return;
                    }
        			else{
        				var listSize=Object.keys(result).length;
        				if(listSize != 0){
        					$("#table-thong-ke-dat-phong > tbody").children().remove();
        					for(i=0; i<listSize; i++)
    						{
        						$("#table-thong-ke-dat-phong > tbody").append(
            							$("<tr>").append(
            								$('<td>').text(result[i].maKhachDat)
            								).append(
            								$('<td>').text(result[i].hoTenKhachDat)		
            								).append(
            								$('<td>').text(result[i].soPhongDon)	
            								).append(
            								$('<td>').text(result[i].soPhongDoi)		
            								).append(
            								$('<td>').text(result[i].soPhongTapThe)		
            								).append(
            								$('<td>').append(
            									$('<a>').text("Chi tiết")
            											.click(function(e){
            												e.preventDefault();
            												var maKhachDat = $(this).closest('tr').find('td:nth-child(1)').text();
            												$.ajax({
            													type:"POST",
            													url:"NV_ThongKeDatPhong?maKhachDat="+maKhachDat,
            													dataType:"json",
            													success:function(result){
            														if (result.check == "ok") {
            									        				window.location.assign("chi-tiet-thong-ke-dat-phong.jsp");
            									                    }
            														else if (result.check == "fail") {
            															alert("Server hiện đang bận!\nMời bạn xem khi khác!"); 
            									                    }
            													},
            									                error: function(jqXHR, exception) {
            									                	if (jqXHR.status == 500)
            									                		alert("Server hiện đang bận!\nMời bạn xem khi khác!");  
            									                }
            												});
            											})
            									)		
            								)
            					);
    						}
        					$("#ket-qua-thong-ke").css("display","block"); 
        				}
        			}
        		},
                error: function(jqXHR, exception) {
                	if (jqXHR.status == 500)
                		alert("Thống kê danh sách thuê phòng không thành công!");  
                }
        	});
    	}
	});
});