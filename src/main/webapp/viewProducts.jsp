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
			  <li><a href="updateProductCats.do">Update Product</a></li>
			  
			  <li><a href="viewProducts.do">View Products</a></li>
			  <li><a href="invoices.do">Generate Invoices</a></li>
			  <li><a href="reports.do">Generate Reports</a></li>
			  <li><a href="faq.jsp">FAQ</a></li>
			  <li><a href="about.jsp">About</a></li>
			</ul>
   </div>
   <div class="pagebody">
   	<div class="pagecenter">
   		<table class="fullwidth">
				<c:forEach var="t" items="${products}">
					<tr>
						<td><c:out value="${t.productUPC}"></c:out></td>
						<td><c:out value="${t.productName}"></c:out></td>
						<td><c:out value="${t.productDescription}"></c:out></td>
						<td><c:out value="${t.shortName}"></c:out></td>
						<td><c:out value="$ ${t.unitCost}"></c:out></td>
						<td><c:out value="${t.packSize}"></c:out></td>
						<td><c:out value="${t.reorderQuantity}"></c:out></td>
						<td><c:out value="$ ${t.retailPrice}"></c:out></td>
						<td><c:out value="${t.productWeight}"></c:out></td>
						<td>
							<form:form action="updateProduct.do" method="post" commandName="updateProduct">
								<form:hidden path="productUPC" id="${t.productUPC}"/>
								<form:button>Update</form:button>
							</form:form>
						</td>
						<td>
							<form:form action="deleteProduct.do" method="post" commandName="updateProduct">
								<form:hidden path="productUPC" id="${t.productUPC}"/>
								<form:button>Delete</form:button>
							</form:form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
   </div>
	</div>
	<div class="cleardiv"></div>
</body>
</html>