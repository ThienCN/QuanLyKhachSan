$(document).ready(function () {
    $("#tim-thong-tin-khach-hang").click(function (e) {
    	
       $("#thong-tin-khach-hang").css("display","none"); 
       $("#thong-tin-thue-phong").css("display","none");
	   $("#khong-co-ket-qua").css("display","none");
	   $("#khong-co-thong-tin-thue-phong").css("display","none");
	   
       var search=$("#maTimKiem").val().trim().length;
       if(search < 1)
	   {
    	   alert("Mời bạn nhập thông tin tìm kiếm!!!");
	   }
       else{
    	   var maTimKiemKH=$("#maTimKiem").val().trim();
    	   $.ajax({
               type: "GET",
               url: "NV_ChinhSuaDonThuePhong",
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
                	   $("#maKH").val(result[0].maKH);
                	   $("#hoTenKH").val(result[0].hoTenKH);
                	   $("#CMND").val(result[0].CMND);
                	   $("#DiaChi").val(result[0].DiaChi)
                	   $("#QuocTich").val(result[0].QuocTich);
                	   $("#SDT").val(result[0].SDT);
                   	   $("#thong-tin-khach-hang").css("display","block");
                   	   
                   	//
	            	   var maKH = result[0].maKH;
	            	   $.ajax({
	                       type: "POST",
	                       url: "NV_TraCuuKhachHang?maKH="+maKH,
	                       dataType: "json",
	                       success: function (result) { 
	                           if (result.check == "fail") {
	                           	$("#khong-co-thong-tin-thue-phong").text("Khách hàng hiện tại không có thông tin thuê phòng");
	                           	$("#khong-co-thong-tin-thue-phong").css("display","inline-block");
	                               return;
	                           }
	                           //Lấy size của list này
	                           var listSize = Object.keys(result).length;
	                           var ngayTraPhongCu = null;
	                           if (listSize > 0) {
	                           	$("#table-thong-tin-thue-phong > tbody").children().remove();
	                           	for(i=0; i<listSize; i++){
	                               	$("#table-thong-tin-thue-phong > tbody").append(
	                                       $('<tr>').append(
	                                           $('<td>').text(result[i].loaiPhong)
	                                           ).append(
	                                           $('<td>').text(result[i].maPhong)
	                                           ).append(
	                                           $('<td>').text(result[i].ngayNhanPhong)
	                                           ).append(
	                                           $('<td>').append(
	                                        		   $('<input type="date" class="form-control">').val(result[i].ngayTraPhong)
	                                        		   		.prop("disabled","true")
	                                        		   		.focusout(function(e){
	                                        		   			e.preventDefault();
	                                        		   			if($(this).closest("tr").find("input[type='date']").disabled == false)
	                                        		   				alert("Mời bạn xác nhận lưu ngày trả phòng vừa thay đổi!");
	                                        		   		})
		                                           		)
		                                       ).append(
		                                       $('<td>').append(
		                                    		   $('<button style="display:none; background-color: red;" class="btn btn-default">')
		                                    		   		.text("Lưu")
		                                    		   		.css('cursor', 'pointer')
	                                    		   			.click(function(e){
	                                    		   				e.preventDefault();
	                                    		   				
	                                    		   				$(this).css("display","none");
	                                    		   				$(this).closest("tr").find("input[type='date']").prop("disabled", true);
	                                    		   				$(this).closest('tr').find('a').css("display","inline-block");
	                                    		   				
	                                    		   				var maKH = $("#maKH").val();
	                                    		   				var maPhong = $(this).closest('tr').find('td:nth-child(2)').text();
	                                    		   				var ngayTraPhongMoi = $(this).closest("tr").find("input[type='date']").val();
	                                    		   				
	                                    		   				var d = new Date();
	                                    		   	            var ngayHienTai = new Date(d.getFullYear(), d.getMonth(), d.getDate());
	                                    		   	            
	                                    		   	         
		                                    		   	        if(new Date(ngayTraPhongMoi) < ngayHienTai || ngayTraPhongMoi == ngayTraPhongCu)
	                                 		   	            	{
		                                    		   	            	alert("Ngày trả phòng phải lớn hơn hoặc bằng ngày hiện tại.\n" +
		                                    		   	            		"Và phải khác ngày trả phòng ban đầu");
		                                    		   	            	$(this).closest('tr').find("input[type='date']").val(ngayTraPhongCu);
		                                    		   	            	return;
	                                 		   	            	}
	                                    		   				var temp=this;
	                                    		   				$.ajax({
	                                    		   					type:"POST",
	                                    		   					url:"NV_ChinhSuaDonThuePhong?ngayTraPhongMoi="+ngayTraPhongMoi
	                                    		   							+"&maKH="+ maKH
	                                    		   							+"&maPhong="+ maPhong
	                                    		   							+"&ngayTraPhongCu="+ ngayTraPhongCu,
                                		   							dataType: "json",
                                		 	                        success: function (result) { 
                                		 	                        	if (result.check == "fail") {
                                		 	                        		alert("Phòng không trống trong những ngày này!");
                                		 	                        		$(temp).closest('tr').find("input[type='date']").val(ngayTraPhongCu);
                                		 		                            return;
                                		 		                        }
                                		 	                        	else if (result.check == "ok")
                            		 	                        		{
                                		 	                        		alert("Thay đổi ngày trả thành công!");
                            		 	                        		}
                                		 	                        		
                                		 	                        },
                                		 	                       error: function (jqXHR, exception) {
                                			                           if (jqXHR.status == 500)
                                			                               alert("Phòng không trống trong những ngày này!");
                                			                       }
	                                    		   				});
	                                    		   				
	                                    		   			})
		                                       	   		)
	                                           ).append(
		                                       $('<td>').append(
		                                    		   $('<a style="color:#0d875c">').text("Thay đổi ngày trả phòng")
		                                    		   		.css('cursor', 'pointer')
	                                    		   			.click(function(e){
	                                    		   				e.preventDefault();	 
	                                    		   				ngayTraPhongCu = $(this).closest('tr').find("input[type='date']").val();
	                                    		   				$(this).css("display","none");
	                                    		   				$(this).closest("tr").find("input[type='date']").prop("disabled", false);
	                                    		   				$(this).closest('tr').find('button').css("display","inline-block");
	                                    		   			})
		                                       	   		)
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
                   }
               },
               error: function (jqXHR, exception) {
                   if (jqXHR.status == 500)
                       alert("Tìm kiếm khách hàng không thành công!");
               }
           });
       }
       
    });
    
    
    
    $("#thay-doi-thong-tin-khach-hang").click(function(e){
    	$("#SDT").attr("readonly",false);
    	$("#DiaChi").attr("readonly",false);
    	$("#QuocTich").attr("readonly",false);
    	$("#thay-doi-thong-tin-khach-hang").prop("disabled",true);
    	$("#xac-nhan-thay-doi-thong-tin-KH").prop("disabled",false);
    });
    
    $("#xac-nhan-thay-doi-thong-tin-KH").click(function(e){
    	var maKH = $("#maKH").val().trim();
    	var hoTenKH = $("#hoTenKH").val().trim();
    	var CMND = $("#CMND").val().trim();
    	var DiaChi = $("#DiaChi").val().trim();
    	var QuocTich = $("#QuocTich").val().trim();
    	var SDT = $("#SDT").val().trim();
    	
    	$.ajax({
    		type:"POST",
    		url:"Them_CapNhat_KhachHang",
    		data:{
    			maKH: maKH,
    			hoTenKH:hoTenKH,
    			CMND:CMND,
    			DiaChi:DiaChi,
    			QuocTich:QuocTich,
    			SDT:SDT
    		},
    		success: function(result){
    			if(result.check == "fail")
				{
    				alert("Cập nhật thông tin khách hàng không thành công!");
    				return;
				}
    			if(result.check == "ok")
				{
    				alert("Cập nhật thông tin khách hàng thành công!");
    				$("#SDT").attr("readonly",true);
    		    	$("#DiaChi").attr("readonly",true);
    		    	$("#QuocTich").attr("readonly",true);
    				$("#thay-doi-thong-tin-khach-hang").prop("disabled",false);
    		    	$("#xac-nhan-thay-doi-thong-tin-KH").prop("disabled",true);
    				return;
				}
    		},
            error: function (jqXHR, exception) {
                if (jqXHR.status == 500)
                    alert("Cập nhật thông tin khách hàng không thành công!");
            }
    	});
    });
    
    
});