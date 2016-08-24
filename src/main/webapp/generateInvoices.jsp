<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoices</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
	<div class="fulldiv">
   <script src="navbar.js"></script>
   <div class="pagebody">
   	<div class="pagecenter">
			<h2>Generate Invoices</h2>
			<form:form>
				<table class="fullwidth">
					<tr>
						<th>Short Name</th>
						<th>Actual Name</th>
						<th>Unit Cost</th>
						<th>Quantity</th>
						<th>Line Total</th>
					</tr>
					<tr>
						
					</tr>
				</table>
			</form:form>
			<br/>
		</div>
   </div>
</body>
</html>