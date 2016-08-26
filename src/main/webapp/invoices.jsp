<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generate Invoices</title>
<link rel="stylesheet" href="./style.css">
<style>
	#chart{
		height: 500px;
	}
	.top-border{
		border-top: 2px solid yellow;
	}
</style>
</head>
<body>
<div class="fulldiv">
   <script src="navbar.js"></script>
   <div class="pagebody2">
   <br/>
   <br/>
   	<div class="pagecenter" id="chart">
   	 <h1>Generate Invoices</h1>
	<table id="mytable" class="table fullwidth">
		<tr class="top-border">
			<td>ProductShort</td><td>ProductName</td><td>Unit Price</td><td>Amount</td><td>Total Cost</td>
		</tr>
		<tr>
			<td>
				<select name="myList" onchange="fillRow()" id="myList">
					<c:forEach items="${products}" var="myProduct">
						<option value="${myProduct}">
        					${myProduct}
    					</option>
					</c:forEach>
				</select>
			</td>
		</tr>
 		   
<!--  		<tr>  -->
<!-- 			<td> -->
<!--  				<input id="amount"></input>  -->
<!--  			<td>  -->
<!--  			<td>  -->
<!--  				<input id="5" value="5"></input>  -->
<!--  			</td>  -->
<!--  			<td>  -->
<!--  				<input id="157"></input>  -->
<!--  			</td>  -->
<!--  		</tr>  -->
 		 
	</table>
	</div>
	<br/>
	<div class="pagecenter">
	<table id="mytable2" class="table fullwidth">
		<tr class="top-border">
			<td>Client</td><td>Client Type</td><td>Tax Rate (%)</td><td>Subtotal($)</td><td>Grand Total($)</td>
		</tr>
		<tr>
			<td>
				<select name="myClients" onchange="setClient()" id="myClients">
					<c:forEach items="${clients}" var="myClient">
						<option value="${myClient}">
        					${myClient}
    					</option>
					</c:forEach>
				</select>
			</td>
		</tr>
 		   
<!--  		<tr>  -->
<!-- 			<td> -->
<!--  				<input id="amount"></input>  -->
<!--  			<td>  -->
<!--  			<td>  -->
<!--  				<input id="5" value="5"></input>  -->
<!--  			</td>  -->
<!--  			<td>  -->
<!--  				<input id="157"></input>  -->
<!--  			</td>  -->
<!--  		</tr>  -->
 		 
	</table>
	</div>
	<br/>
	 
	<button type="button" id="invoiceBtn">Generate Invoice</button>
	
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="invoices.js"></script>
<script>
</script>
</div>
   </div>
	</div>
</html>
