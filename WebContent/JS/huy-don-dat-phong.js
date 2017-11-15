$(document).ready(function () {
    $("#tim-thong-tin-khach-dat").click(function (e) {
    	
       $("#thong-tin-khach-dat").css("display","none"); 
       $("#thong-tin-dat-phong").css("display","none");
	   $("#khong-co-ket-qua").css("display","none");
	   
       var search = $("#maCode").val().trim().length;
       if(search < 1)
	   {
    	   alert("Mời bạn nhập thông tin tìm kiếm!!!");
	   }
       else{
    	   var maTimKiemKD = $("#maCode").val().trim();
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
                	   $("#maKD").val(result[0].maKD);
                	   $("#hoTenKD").val(result[0].hoTenKD);
                	   $("#CMND").val(result[0].CMND);
                	   $("#DiaChi").val(result[0].DiaChi)
                	   $("#QuocTich").val(result[0].QuocTich);
                	   $("#SDT").val(result[0].SDT);
                   	   $("#thong-tin-khach-dat").css("display","block");
                   	   
                   	//
	            	   var maCode = result[0].maKD;
	            	   $.ajax({
	                       type: "POST",
	                       url: "NV_TraCuuKhachDat?maKD="+maCode,
	                       dataType: "json",
	                       success: function (result) { 
	                           if (result.check == "fail") {
	                           	$("#khong-co-ket-qua").text("Không tồn tại thông tin đặt phòng");
	                           	$("#khong-co-ket-qua").css("display","inline-block");
	                               return;
	                           }
	                           //Lấy size của list này
	                           var listSize = Object.keys(result).length;
	                           var tinhTrang, nguoiHuy;
	                           if (listSize > 0) {
	                           	$("#table-thong-tin-dat-phong > tbody").children().remove();
	                           	for(i=0; i<listSize; i++){
	                           		nguoiHuy = "";
	                           		
	                           		if(result[i].tinhTrang == 1)
	                           			tinhTrang = "Đã đặt thành công";
	                           		else if(result[i].tinhTrang == 0 && result[i].nguoiHuy == null){
	                           			tinhTrang = "Đã bị hủy";
	                           			nguoiHuy = "Khách hủy";
	                           		}
	                           		else if(result[i].tinhTrang == 0 && result[i].nguoiHuy != null){
	                           			tinhTrang = "Đã bị hủy";
	                           			nguoiHuy = result[i].nguoiHuy;
	                           		}
	                           		else if(result[i].tinhTrang == 2)
	                           			tinhTrang = "Đã nhận phòng";
	                           			
	                           		
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
	                                           $('<td>').text(parseFloat(result[i].tienPhong)*0.1)
	                                           ).append(
	                                           $('<td>').text(tinhTrang)   
	                                           ).append(
	                                           $('<td>').text(nguoiHuy)   
	                                           ).append(
		                                       $('<td>').append(
		                                    		   $('<a>')
		                                    		   		.text("Hủy")
		                                    		   		.css('cursor', 'pointer')
	                                    		   			.click(function(e){
	                                    		   				e.preventDefault();
	                                    		   				if($(this).closest('tr').find('td:nth-child(7)').text() == "Đã bị hủy" 
	                                    		   						|| $(this).closest('tr').find('td:nth-child(7)').text() == "Đã nhận phòng"){
	                                    		   					alert("Phòng đã bị hủy hoặc đã nhận phòng rồi!");
	                                    		   					return;
	                                    		   				}
	                                    		   				
	                                    		   				if(confirm("Bạn có chắc chắn muốn hủy đặt phòng này không?"))
                                    		   					{
	                                    		   					var nguoiHuy = prompt("Nếu là khách sạn hủy thì nhân viên hãy điền mã NV của mình vào đây!" +
	                                    		   							"\rCòn nếu là khách hủy thì không cần điền!", "");	
	                                    		   					if(nguoiHuy == "")
	                                    		   						$(this).closest('tr').find('td:nth-child(8)').text("Khách hủy");
	                                    		   					else
	                                    		   						$(this).closest('tr').find('td:nth-child(8)').text(nguoiHuy);
	                                    		   					
	                                    		   					//Tình trạng phải là đang đặt, ngày hủy phải nhỏ hơn hoặc bằng ngày hiện tại
	                                    		   					var tinhTrang = $(this).closest('tr').find('td:nth-child(7)').text();
	                                    		   					if(tinhTrang != "Đã đặt thành công"){
	                                    		   						confirm("Hủy đặt phòng không hợp lệ!");
	                                    		   						return;
	                                    		   					}
	                                    		   					if(tinhTrang == "Đã đặt thành công"){
	                                    		   						var temp=this;
	                                    		   						$.ajax({
		                                    		   	            		type:"DELETE",
		                                    		   	            		url: "NV_ChinhSuaDonDatPhong?maKhachDat="+ $("#maKD").val()
		                                    		   	            									+"&maPhong=" + $(this).closest('tr').find('td:nth-child(2)').text()
		                                    		   	            									+"&ngayNhanPhong=" + $(this).closest('tr').find('td:nth-child(3)').text()
		                                    		   	            									+"&nguoiHuy=" + $(this).closest('tr').find('td:nth-child(8)').text(),
		        		   	            									dataType: "json",
		        		   	            			                        success: function (result) {
		        		   	            			                        	if (result.check == "fail") {
		        		   	            				                           		alert("Ngày hủy không hợp lệ.\nNgày hủy phải nhỏ hơn hoặc bằng ngày nhận phòng!!!");
		        		   	            				                           		return;
		        		   	            				                           }
		        		   	            			                        	else{
		        		   	            			                        		$(temp).closest('tr').find('a').text("Hủy thành công");
		        		   	            			                        		$(temp).closest('tr').find('a').css("color","blue");	
		        		   	            			                        		$(temp).closest('tr').find('td:nth-child(7)').text("Đã bị hủy");  
		        		   	            			                        		$(temp).closest('tr').find('td:nth-child(7)').css("color","red");	      		   	            			                        	}
		        		   	            			                        },
		        		   	            			                        error: function (jqXHR, exception) {
		        		   	            			                           if (jqXHR.status == 500)
		        		   	            			                        	   alert("Tìm kiếm thông tin thuê phòng của khách hàng không thành công!");
		        		   	            			                        }
		                                    		   	            	});
	                                    		   					}                                  		   					
                                    		   					}
	                                    		   				
	                                    		   			})
		                                       	   		)
	                                           )
	                                  );
	                           	}
	                           	$("#thong-tin-dat-phong").css("display","block");
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
    
    
    
});