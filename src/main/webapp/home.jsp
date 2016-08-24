<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
	<div class="fulldiv">
   <div class="navbar grad">
			<ul>
				<li><a href="home.jsp">Home</a></li>
			  <li><a href="updateClientList.do">Update Client</a></li>
			  <li><a href="updateProduct.do">Update Product</a></li>
			  <li><a href="updateProductCats.do">Update Categories</a></li>
			  
			  <li><a href="viewProducts.do">View Products</a></li>
			  <li><a href="invoices.do">Generate Invoices</a></li>
			  <li><a href="reports.do">Generate Reports</a></li>
			  <li><a href="faq.jsp">FAQ</a></li>
			  <li><a href="about.jsp">About</a></li>
			  <li><a href="ajaxtest.do">AjaxTest</a></li>
			</ul>
   </div>
   <div class="pagebody">
   	<div class="pagecenter">
			<h2>Temporary Home</h2>
			<a href="updateClientList.do">Client Update</a><br/>
			<a href="updateProduct.do">Product Update</a><br/>
			<button class="grad">Test</button>
			<br/>
		</div>
   </div>
	</div>
	<div class="cleardiv"></div>
</body>
</html>