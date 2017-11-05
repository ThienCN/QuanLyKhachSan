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
	                                           $('<td>').text(result[i].ngayTraPhong)
	                                           ).append(
		                                       $('<td>').append(
		                                    		   $('<a>')
		                                    		   		.text("Hủy")
		                                    		   		.css('cursor', 'pointer')
	                                    		   			.click(function(e){
	                                    		   				e.preventDefault();
	                                    		   				if(confirm("Bạn có chắc chắn muốn hủy thuê phòng này không?"))
                                    		   					{
		                                    		   				//Ngày hủy phải bằng ngày nhận phòng
		                                    		   				var maKH = $("#maKH").val();
	                                    		   	            	//console.log(maKH);
	                                    		   	            	var maPhong = $(this).closest('tr').find('td:nth-child(2)').text();
	                                    		   	            	//console.log(maPhong);
	                                    		   	            	var ngayNhanPhong = $(this).closest('tr').find('td:nth-child(3)').text();
	                                    		   	            	var temp=this;
	                                    		   	            	//console.log(ngayNhanPhong);
	                                    		   	            	$.ajax({
	                                    		   	            		type:"DELETE",
	                                    		   	            		url: "NV_ChinhSuaDonThuePhong?maKH="+ maKH
	                                    		   	            									+"&maPhong=" + maPhong
	                                    		   	            									+"&ngayNhanPhong=" + ngayNhanPhong,
	        		   	            									dataType: "json",
	        		   	            			                        success: function (result) {
	        		   	            			                        	if (result.check == "fail") {
	        		   	            				                           		alert("Ngày hủy không hợp lệ.\nNgày hủy phải bằng ngày nhận phòng!!!");
	        		   	            				                           		return;
	        		   	            				                           }
	        		   	            			                        	else{
	        		   	            			                        		$(temp).closest('tr').find('a').text("Đã hủy thuê phòng");
	        		   	            			                        		$(temp).closest('tr').find('a').css("color","red");	        		   	            			                        	}
	        		   	            			                        },
	        		   	            			                        error: function (jqXHR, exception) {
	        		   	            			                           if (jqXHR.status == 500)
	        		   	            			                        	   alert("Tìm kiếm thông tin thuê phòng của khách hàng không thành công!");
	        		   	            			                        }
	                                    		   	            	});
                                    		   					}
	                                    		   				
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
    
    
    
});