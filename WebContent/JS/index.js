
$(document).ready(function () {
    $("#loadbtn").click(function (e) {
        e.preventDefault();
        text = '<br><div class="row"><div class="col-lg-4 col-md-4 col-sm-4 col-xs-12" id="image7"><img src= "./Images/pic7.jpg" style= "width:100%;" alt= "Gym" ><div class="overlay"><div class="text"><h2>Gym</h2><p>Thân hình quyến rũ săn chắc hay chỉ đơn giản là chạy bộ tập thể dục</p></div></div></div>'
            + '<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12" id="image8"><img src="./Images/pic8.jpg" style="width:100%;" alt="Bar" ><div class="overlay"><div class="text"><h2>Bar</h2><p>Lắc lư theo những điệu nhạc sôi động cùng thưởng thức ly Whisky tuyệt vời</p></div></div></div>'
            + '<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12" id="image9"><img src= "./Images/pic9.jpg" style= "width:100%;" alt= "Sea" ><div class="overlay"><div class="text"><h2>Lặn biển</h2><p>Những rạn san hô tuyệt đẹp cùng nhiều loài cá đủ màu sắc sẽ khiến bạn mê say</p></div></div></div></div>'

        $("#portfolio").append(text);
        $("#loadbtn").hide();
        
    });
    
    $("#btntimphong").click(function (e){
        
        var ngayHienTai = new Date();
        dayHienTai = ngayHienTai.getDate();
        monthHienTai = ngayHienTai.getMonth() + 1;
        yearHienTai = ngayHienTai.getFullYear();
        var ngayhientai=[dayHienTai, monthHienTai, yearHienTai].join('/');
        
        var ngayNhan = new Date($("#ngaynhanphong").val());
        var ngayTra = new Date($("#ngaytraphong").val());
        
        dayNhan = ngayNhan.getDate();
        monthNhan = ngayNhan.getMonth() + 1;
        yearNhan = ngayNhan.getFullYear();
        
        dayTra = ngayTra.getDate();
        monthTra = ngayTra.getMonth() + 1;
        yearTra = ngayTra.getFullYear();
        
        var ngaynhanphong=[dayNhan, monthNhan, yearNhan].join('/');
        var ngaytraphong=[dayTra, monthTra, yearTra].join('/');
        
        if (ngaynhanphong == "NaN/NaN/NaN" || ngaytraphong == "NaN/NaN/NaN"){
            alert("Nhập đầy đủ ngày nhận phòng và ngày trả phòng!!!");
            e.preventDefault();
        }
        else if (ngaynhanphong >= ngaytraphong){
            alert("Ngày nhận phòng và ngày trả phòng không hợp lệ!!!");
            e.preventDefault();
        }
        else if (ngayhientai >= ngaynhanphong){
            alert("Ngày nhận phòng phải lớn hơn ngày hiện tại!!!");
            e.preventDefault();
        }
    	
    });});