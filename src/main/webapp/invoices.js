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
						"<tr><td>"+ item.shortName+
						"</td><td>"	+item.productName+
						"</td><td>"	+item.unitCost+
						'</td><td>' +item.unitCost+
						"</td></tr>"
	 				);
	 			})
			}
		});
};

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