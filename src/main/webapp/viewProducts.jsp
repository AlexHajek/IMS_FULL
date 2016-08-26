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
<style type="text/css">
input{
	border: none;
	padding-top: 5px;
	margin-top: 5px;
	color: yellow;
	width: 80%;
	background-color: transparent;
}
table{
  border-collapse: collapse;
}
td{
	text-align: left;
}
.top-border{
	border-top: 2px solid yellow;
}
.scroll{
	height:100vh;
	overflow:auto;
}
</style>
</head>
<body>
	<div class="fulldiv">
	 <script src="navbar.js"></script>
   <div class="pagebody">
   	<div class="pagecenter scroll">
   		<table class="fullwidth">
   			<tr>
					<th>UPC Code/<br/>Description</th>
					<th>Full Name/<br/>Short Name</th>
					<th>Quantity:<br/>On Hand/<br/>Reorder</th>
					<th>Cost:<br/>Unit/<br/>Retail</th>
					<th>Product:<br/>Weight/<br/>Size</th>
					<th>Catergories</th>
					<th>Update/<br/>Delete<br/>Product</th>
				</tr>
				<c:forEach var="t" items="${products}">
					<form:form action="updateProductInfo.do" method="post" commandName="updateProduct">
						<tr class="top-border">
							<td><c:out value="${t.productUPC}"></c:out></td>
							<form:hidden path="productUPC" value="${t.productUPC}"/>
							<td>
								<form:input path="productName" value="${t.productName}"/> <br/>
								<form:errors path="productName" cssClass="error" /><br/>
							</td>
							<td><c:out value="${t.onHandQuantity}"></c:out></td>
							<form:hidden path="productUPC" value="${t.productUPC}"/>
							<td>
								<form:input path="unitCost" value="${t.unitCost}"/> <br/>
								<form:errors path="unitCost" cssClass="error" /><br/>
							</td>
							<td>
								<form:input path="productWeight" value="${t.productWeight}"/> <br/>
								<form:errors path="productWeight" cssClass="error" /><br/>
							</td>
							<td rowspan="2">
								<form:select path="categoriesString" multiple="true">
									<form:options items="${categories}" itemValue="categoryId" itemLabel="categoryDescription" />
								</form:select><br/>
								<form:errors path="categoriesForProduct" cssClass="error" /><br/>
							</td>
							<td>
								<form:button name="update">Update</form:button>
							</td>
						</tr>
						<tr>
							<td>
								<form:input path="productDescription" value="${t.productDescription}"/> <br/>
								<form:errors path="productDescription" cssClass="error" /><br/>
							</td>
							<td>
								<form:input path="shortName" value="${t.shortName}"/> <br/>
								<form:errors path="shortName" cssClass="error" /><br/>
							</td>
							<td>
								<form:input path="reorderQuantity" value="${t.reorderQuantity}"/> <br/>
								<form:errors path="reorderQuantity" cssClass="error" /><br/>
							</td>
							<td>
								<form:input path="retailPrice" value="${t.retailPrice}"/> <br/>
								<form:errors path="retailPrice" cssClass="error" /><br/>
							</td>
							<td>
								<form:input path="packSize" value="${t.packSize}"/> <br/>
								<form:errors path="packSize" cssClass="error" /><br/>
							</td>
							<td>
								<form:hidden path="productUPC" value="${t.productUPC}"/>
							  <form:button name="delete">Delete</form:button>
							</td>
						</tr>
					</form:form>
				</c:forEach>
			</table>
		</div>
   </div>
	</div>
	<div class="cleardiv"></div>
</body>
</html>