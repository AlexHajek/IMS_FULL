<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajax Testing</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
<div class="fulldiv">
   <script src="navbar.js"></script>
   <div class="pagebody2">
   <br/>
   	<div class="pagecenter">
   	
	<table id="mytable" class="table fullwidth">
		<tr>
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
	</table>
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="invoices.js"></script>


</div>
   </div>
	</div>
</html>
