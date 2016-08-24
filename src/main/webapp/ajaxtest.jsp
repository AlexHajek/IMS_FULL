<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajax Testing</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<table id="mytable" class="table">
		<tr>
			<td>ProductShort</td><td>ProductName</td><td>Unit Price</td><td>Amount</td><td>Total Cost</td>
		</tr>
		<tr>
			<td>
				<select name="myList" id="myList">
					<c:forEach items="${products}" var="myProduct">
						<option value="${myProduct}">
        					${myProduct}
    					</option>
					</c:forEach>
				</select>
			</td>
		</tr>
	</table>
	<div id="myDiv">
	
	</div>
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">

$("#myList").select(function(){
		$.ajax({
			header: {
				Accept : "application/json; charset=utf-8"
			},
			url: "http://localhost:7001/IMS_Front/getProduct.do?a="+$("#myList").val(),
			method: "GET",
			success: function(resp){
				$("#mytable").html("<tr><td>ProductShort</td><td>ProductName</td><td>Unit Price</td><td>Amount</td><td>Total Cost</td></tr>");
				//$("#mytable").html("Hi");
				//var myProduct = JSON.parse(resp);
				//var table = document.getElementById('myDiv');
				//var html = table.innerHTML;
				//html += "Hello";	
				//table.html(html);	
				$.each(resp, function(i, item){
	 				$("#mytable").append(
	 					//"<tr><td> Hello </td></tr>"
						"<tr><td>"	+item.shortName+
						"</td><td>"	+item.productName+
						"</td><td>"	+item.unitCost+
						"</td><td>"	+item.packSize+
						"</td><td>" +item.unitCost+
						"</td></tr>"
	 				);
	 			})
			}
		});
});
</script>
</html>