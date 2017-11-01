$(document).ready(function () {
    //Lấy số hàng của bảng
    var rows = document.getElementById("table-products").getElementsByTagName("tbody")[0].getElementsByTagName("tr").length;
    //Disable button xác nhận
    $(':input[type="submit"]').prop('disabled', true);
    //Tổng tiền
    var sum = 0;

    //Show chi tiết thông tin phòng
    $("#infodon1").click(function () {
        $("#collapse1").toggle();
    });
    $("#infodon2").click(function () {
        $("#collapse1").toggle();
    });
    $("#btnhide1").click(function () {
        $("#collapse1").hide();
    });

    $("#infodoi1").click(function () {
        $("#collapse2").toggle();
    });
    $("#infodoi2").click(function () {
        $("#collapse2").toggle();
    });
    $("#btnhide2").click(function () {
        $("#collapse2").hide();
    });

    $("#infott1").click(function () {
        $("#collapse3").toggle();
    });
    $("#infott2").click(function () {
        $("#collapse3").toggle();
    });
    $("#btnhide3").click(function () {
        $("#collapse3").hide();
    });

    //Button + clicked
    $('.qtyplus1').click(function (e) {
        // Stop acting like a button
        e.preventDefault();
        // Get the field name
        fieldName = $(this).attr('field');
        // Get its current value
        var currentVal = parseInt($('input[name=' + fieldName + ']').val());
        // If is not undefined
        if (!isNaN(currentVal)) {
            // Increment
            $('input[name=' + fieldName + ']').val(currentVal + 1);
        } else {
            // Otherwise put a 0 there
            $('input[name=' + fieldName + ']').val(0);
        }
    });
    //Button - clicked
    $('.qtyminus1').click(function (e) {
        // Stop acting like a button
        e.preventDefault();
        // Get the field name
        fieldName = $(this).attr('field');
        // Get its current value
        var currentVal = parseInt($('input[name=' + fieldName + ']').val());
        // If it isn't undefined or its greater than 0
        if (!isNaN(currentVal) && currentVal > 0) {
            // Decrement one
            $('input[name=' + fieldName + ']').val(currentVal - 1);
        } else {
            // Otherwise put a 0 there
            $('input[name=' + fieldName + ']').val(0);
        }
    });

    //Button + clicked
    $('.qtyplus2').click(function (e) {
        // Stop acting like a button
        e.preventDefault();
        // Get the field name
        fieldName = $(this).attr('field');
        // Get its current value
        var currentVal = parseInt($('input[name=' + fieldName + ']').val());
        // If is not undefined
        if (!isNaN(currentVal)) {
            // Increment
            $('input[name=' + fieldName + ']').val(currentVal + 1);
        } else {
            // Otherwise put a 0 there
            $('input[name=' + fieldName + ']').val(0);
        }
    });
    //Button - clicked
    $('.qtyminus2').click(function (e) {
        // Stop acting like a button
        e.preventDefault();
        // Get the field name
        fieldName = $(this).attr('field');
        // Get its current value
        var currentVal = parseInt($('input[name=' + fieldName + ']').val());
        // If it isn't undefined or its greater than 0
        if (!isNaN(currentVal) && currentVal > 0) {
            // Decrement one
            $('input[name=' + fieldName + ']').val(currentVal - 1);
        } else {
            // Otherwise put a 0 there
            $('input[name=' + fieldName + ']').val(0);
        }
    });

    //Button + clicked
    $('.qtyplus3').click(function (e) {
        // Stop acting like a button
        e.preventDefault();
        // Get the field name
        fieldName = $(this).attr('field');
        // Get its current value
        var currentVal = parseInt($('input[name=' + fieldName + ']').val());
        // If is not undefined
        if (!isNaN(currentVal)) {
            // Increment
            $('input[name=' + fieldName + ']').val(currentVal + 1);
        } else {
            // Otherwise put a 0 there
            $('input[name=' + fieldName + ']').val(0);
        }
    });
    //Button - clicked
    $('.qtyminus3').click(function (e) {
        // Stop acting like a button
        e.preventDefault();
        // Get the field name
        fieldName = $(this).attr('field');
        // Get its current value
        var currentVal = parseInt($('input[name=' + fieldName + ']').val());
        // If it isn't undefined or its greater than 0
        if (!isNaN(currentVal) && currentVal > 0) {
            // Decrement one
            $('input[name=' + fieldName + ']').val(currentVal - 1);
        } else {
            // Otherwise put a 0 there
            $('input[name=' + fieldName + ']').val(0);
        }
    });

    //Thêm vào giỏ hàng
    $(".add-to-cart").click(function (e) {
        e.preventDefault();
        var button = $(this); // Lấy đối tượng button mà người dùng click
        var id = button.attr("id"); // id của sản phẩm là id của button
        var name = button.attr("data-name"); // name của sản phẩm là thuộc tính data-name của button
        var price = button.attr("data-price"); // price của sản phẩm là thuộc tính data-price của button
        sum+=parseFloat(price);

        // Số lượng phòng
        fieldName = button.attr('field');
        // Get its current value
        var quantity = parseInt($('input[name=' + fieldName + ']').val());

        if (quantity > 0) {
            $("#table-products > tbody:last").append("<tr>" + "<td>" + name + "</td>" + "<td>" + price + "</td>" + "<td>" + quantity + "</td>" + '<td class="price">' + price * quantity + "</td>" + "<td>" + '<a class="delete-row" onclick="deleteRow(this)">Hủy</a>' + "</td>" + "</tr>");
            rows++;
        }

        if (rows > 0) {
            $(':input[type="submit"]').prop('disabled', false); //Enable button xác nhận khi có đặt phòng
        }
        
      //Tính tổng tiền
        function updateTotals() {
        	var totalPrice = getColumnTotal('.price');
        	$(".tongtien").text( toMoney(totalPrice) );
        	}
        	function getSubtotal(quantity, price) {
        	return (quantity * price).toFixed(2);
        	}
        	function getColumnTotal(selector) {
        	return Array.from( $(selector) ).reduce(sumReducer, 0);
        	}
        	function sumReducer(total, cell) {
        	return total += parseInt(cell.innerHTML, 10);
        	}
        	function toMoney(number) {
        		alert(number.toFixed(2));
        	return '$' + number.toFixed(2);
        	}
        alert(sum);
    });
    
    
});
