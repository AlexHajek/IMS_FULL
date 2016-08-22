<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Client List</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
	<div class="fulldiv">
   <div class="navbar">
			<ul>
				<li><a href="home.jsp">Home</a></li>
			  <li><a href="updateClientList.do">Update Client</a></li>
			  <li><a href="updateProduct.do">Update Product</a></li>
			  <li><a href="invoices.do">Generate Invoices</a></li>
			  <li><a href="reports.do">Generate Reports</a></li>
			  <li><a href="faq.jsp">FAQ</a></li>
			  <li><a href="about.jsp">About</a></li>
			</ul>
   </div>
   <div class="pagebody">
   	<div class="pagecenter">
   		<h1>Create New Client</h1>
				<form:form action="updateclient.do" method="post" commandName="myClient">
			<!-- path=bean property -->
					<table class="fullwidth">
						<tr>
							<td>
								Name:<br/> <form:input path="name" /> <br/>
								<form:errors path="name" cssClass="error" /><br/>
							</td>
							<td>
								Email:<br/> <form:input path="email" /> <br/>
								<form:errors path="email" cssClass="error" /><br/>
							</td>
						</tr>
					</table>
					<table class="fullwidth">
						<tr>
							<td>
								Person of Contact:<br/> <form:input path="pocn" /> <br/>
								<form:errors path="pocn" cssClass="error" /><br/>
							</td>
							<td>
								Phone Number:<br/> <form:input path="phone" /> <br/>
								<form:errors path="phone" cssClass="error" /><br/>
							</td>
							<td>
								Fax Number:<br/> <form:input path="fax" /> <br/>
								<form:errors path="fax" cssClass="error" /><br/>
							</td>
						</tr>
					</table>
				ClientId:<br/> <form:input path="id" /> <br/>
					<form:errors path="id" cssClass="error" /><br/>
				
				<!-- Address:<br/> <form:input path="address" /><br/>
					<form:errors path="address" cssClass="error" /><br/>
				ClientType:<br/> <form:input path="clientType" /><br/>
					<form:errors path="clientType" cssClass="error" /><br/>
					-->
				<input type="submit" value="Register" />
			</form:form>
			<br/>
		</div>
   </div>
	</div>
	<div class="cleardiv"></div>
</body>
</html>