var count = 0;
var clientSelected = false;

function fillRow(){ 
		$.ajax({
			header: {
				Accept : "application/json; charset=utf-8"
			},
			url: "http://localhost:7001/IMS_Front/getProduct.do?a="+$("#myList").val(),
			method: "GET",
			success: function(resp){
				//$("#mytable").html("<tr><td>ProductShort</td><td>ProductName</td><td>Unit Price</td><td>Amount</td><td>Total Cost</td></tr>");
				$.each(resp, function(i, item){
	 				$("#mytable").append(
						"<tr><td><input id="+item.shortName+" value="+ item.shortName+" readonly>"+
						"</input></td><td><input id=productName"+count+" value="+item.productName+" readonly>"+
						"</input></td><td><input id=unitCost"+count+" value="+item.unitCost+" readonly>"+
						"</input></td><td>"+
						 "<input id="+count+" class='amount'></input>"+
						"</td><td><input id=total"+count+" readonly></td></tr>"
	 				);
	 			})	
			}
		});
		count += 1;
};
$("#mytable").on('change','.amount', function(){
	//alert("HAI");
	var grandtotal = 0;
	var test = $(this);
    var price = parseFloat($("#unitCost"+(test.attr('id'))).val());
    var amount = parseFloat($(this).val());
    var total = parseFloat(price*amount);
    //alert($("#total"+(test.attr('id'))).val(total));
    $("#total"+(test.attr('id'))).val(total);
    for(i = 1; i<($('#mytable tr').length-1); i++){
    	grandtotal += parseFloat($("#total"+i).val());
    }
    $("#grandTotal").val(grandtotal);
    
});
/*
$("#amount").change(function(){
	alert("hai");
    var price = parseFloat($("#5").val());
    var amount = $(this).val();
    var total = price*amount;
    $("#157").val(total);
});
*/
function addRow(){
	var productList = document.getElementById("myList");
	$.ajax({
		header: {
			Accept : "application/json; charset=utf-8"
		},
		url: "http://localhost:7001/IMS_Front/getAllProducts.do",
		method: "GET",
		success: function(resp){
			//$("#mytable").html("<tr><td>ProductShort</td><td>ProductName</td><td>Unit Price</td><td>Amount</td><td>Total Cost</td></tr>");
			$.each(resp, function(i, item){
 				$("#mytable").append(productList
//					'<tr><td><select name="myList" id="myList">'+
//				'<c:forEach items="${products}" var="myProduct">'+
//					'<option value="${myProduct}">'+
//    					'${myProduct}'+
//					'</option>'+
//				'</c:forEach>'+
//			'</select>'	
 				);
 			})
		}
	});
};

function getSum(){
	var myAmount = document.getElementById("amount").value;
	var sumAmount = myAmount*unitCost;
	alert("hai");
	$("mytable").append(
			"<tr><td>3</td></tr>"
	)
};

function setClient(){
	$.ajax({
		header: {
			Accept : "application/json; charset=utf-8"
		},
		url: "http://localhost:7001/IMS_Front/getClient.do?a="+$("#myClients").val(),
		method: "GET",
		success: function(resp){
			//$("#mytable2").html("<tr><td>Client</td><td>Client Type</td><td>Subtotal</td><td>Tax</td><td>Total</td></tr>");
			//$("#mytable").html("<tr><td>ProductShort</td><td>ProductName</td><td>Unit Price</td><td>Amount</td><td>Total Cost</td></tr>");
			if(clientSelected == false){
			$.each(resp, function(i, item){
				//var testing = item.clientId;
 				$("#mytable2").append(
 						'<tr id="myrow"><td><input id="clientName" value='+item.name+' readonly></input></td>'+
 						'<td><input id="clientType" value='+item.clientType.clientType+' readonly></input></td>'+
 						'<td><input readonly></input></td>'+
 						'<td><input readonly></input></td>'+
 						'<td><input id = "grandTotal" readonly></input></td></tr>'
//					'<tr><td><select name="myList" id="myList">'+
//				'<c:forEach items="${products}" var="myProduct">'+
//					'<option value="${myProduct}">'+
//    					'${myProduct}'+
//					'</option>'+
//				'</c:forEach>'+
//			'</select>'	
 						
 				);
 			})
 			clientSelected = true;
			}
			else{
				$("#myrow").remove();
				clientSelected = false;
				setClient();
			}
		}
	});
}
$("#mytable2").on('change','#myClients', function(){
	var grandtotal2 = 0;
	for(i = 1; i<($('#mytable tr').length-1); i++){
		grandtotal2 += parseFloat($("#total"+i).val());
	}
	$("#grandTotal").val(grandtotal2);
});

function genReport(){
	if(clientSelected == true){
		/*
		for(i = 1; i<($('#mytable tr').length-1); i++){
			//var productArray = $("#");
		}
		*/
		$.ajax({
			header: {
				Accept : "application/json; charset=utf-8"
			},
			url: "http://localhost:7001/IMS_Front/sendInvoice.do",
			method: "POST",
			success: function(resp){
			}
		})
	}
}
//	$.ajax({
//		header: {
//			Accept : "application/json; charset=utf-8"
//		},
//		url: "http://localhost:7001/IMS_Front/",
//		method: "GET",
//		success: function(resp){
//			//$("#mytable").html("<tr><td>ProductShort</td><td>ProductName</td><td>Unit Price</td><td>Amount</td><td>Total Cost</td></tr>");
//			$.each(resp, function(i, item){
//				$("[id]='amount'").append(
// 						'<tr><td>3</td></tr>'
// 				);
// 			})
//		}
//	});

//function selectClient(){
//	$.ajax({
//		header: {
//			Accept : "application/json; charset=utf-8"
//		},
//		url: "http://localhost:7001/IMS_Front/getClient.do?a="+$("#myClients").val(),
//		method: "GET",
//		success: function(resp){
//			$("#mytable").html("<tr><td>ProductShort</td><td>ProductName</td><td>Unit Price</td><td>Amount</td><td>Total Cost</td></tr>");
//			$.each(resp, function(i, item){
// 				$("#mytable").append(
//					"<td>"+ item.shortName+
//					"</td><td>"	+item.productName+
//					"</td><td>"	+item.unitCost+
//					'</td><td>' +item.unitCost+
//					"</td></tr>"+
//					"<tr>"
// 				);
// 			})
//		}
//	});
//};