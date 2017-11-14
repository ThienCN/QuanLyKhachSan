$(document).ready(function (e){
	$("#btn-tim-phong").click(function (e){
		$("#ket-qua-tim-phong").css("display","none");
		$("#khong-co-ket-qua").css("display","none");
		
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
        	ngayNhanPhong = $("#ngayNhanPhong").val();
            ngayTraPhong = $("#ngayTraPhong").val();
            $.ajax({
            	type:"GET",
            	url:"NV_TimPhong",
            	data:{
            		ngayNhanPhong: ngayNhanPhong,
            		ngayTraPhong: ngayTraPhong
            	},
            	dataType:"json",
            	success: function(result){
            		if(result.check == "fail")
        			{
            			$("#khong-co-ket-qua").css("display","block");
            			$("#khong-co-ket-qua").text("Không còn phòng trống trong thời gian này!");
            			alert("Tìm phòng không thành công!!");
            			return;
        			}
            		else
        			{
            			var n = Object.keys(result).length;
            			if(n > 0)
        				{
            				$("#table-ket-qua-tim-phong > tbody").children().remove();
            				for(i=0; i<n ;i++){
                				$("#table-ket-qua-tim-phong > tbody").append(
                						$('<tr>').append(
            								$('<td>').text(result[i].loaiPhong)
                							).append(
                							$('<td>').text(result[i].maPhong)	
                							).append(
                							$('<td>').text(result[i].tienPhong)		
                							)
                				)
                			}
            				$("#ket-qua-tim-phong").css("display","block");
        				}
        			}
            	},
	        	error: function(jqXHR, exception) {
	             	if (jqXHR.status == 500)
	             		alert("Tìm phòng không thành công!");  
	            }
            });
            
            
            $.ajax({
            	type:"POST",
            	url:"NV_TimPhong",
            	data:{
            		ngaynhanphong: ngayNhanPhong,
            		ngaytraphong: ngayTraPhong
            	},
            	dataType: "json",
            	success:function(result){
            		if(result.check == "fail"){
            			$("#khong-co-ket-qua").css("display","block");
            			$("#khong-co-ket-qua").text("Không còn phòng trống trong thời gian này!");
            			alert("Tìm phòng không thành công!!");
            			return;
        			}
            		else{
            			var n = Object.keys(result).length;
            			for(i=0; i<n; i++){
            				if(result[i].tenLoaiPhong == "Phòng đơn")
            					$("#soPhongDonTrong").text(result[i].soPhongTrong);
        					if(result[i].tenLoaiPhong == "Phòng đôi")
        						$("#soPhongDoiTrong").text(result[i].soPhongTrong);
        					if(result[i].tenLoaiPhong == "Phòng tập thể")
        						$("#soPhongTapTheTrong").text(result[i].soPhongTrong);
        					
            			}            			
            		}
            	}
            });
        }
	});
});