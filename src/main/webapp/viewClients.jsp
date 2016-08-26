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
					<th>Full Name/<br/>Email</th>
					<th>Phone#/<br/>Fax#</th>
					<th>Person to Contact/<br/>Client Type</th>
					<th colspan="2">Address Line 1/<br/>City, State</th>
					<th>Address Line 2/<br/>ZIP Code</th>
					<th>Update/<br/>Delete<br/>Client</th>
				</tr>
				<c:forEach var="t" items="${clients}">
					<form:form action="updateClientInfo.do" method="post" commandName="updateClient">
						<tr class="top-border">
							<form:hidden path="id" value="${t.id}"/>
							<td><c:out value="${t.name}"></c:out></td>
							<form:hidden path="name" value="${t.name}"/>
							<td>
								<form:input path="phone" value="${t.phone}"/> <br/>
								<form:errors path="phone" cssClass="error" /><br/>
							</td>
							<td>
								<form:input path="pocn" value="${t.pocn}"/> <br/>
								<form:errors path="pocn" cssClass="error" /><br/>
							</td>
							<td colspan="2">
								<form:input path="address.streetAddress1" value="${t.address.streetAddress1}"/> <br/>
								<form:errors path="address.streetAddress1" cssClass="error" /><br/>
							</td>
							<td>
								<form:input path="address.streetAddress2" value="${t.address.streetAddress2}"/> <br/>
								<form:errors path="address.streetAddress2" cssClass="error" /><br/>
							</td>
							<td>
								<form:button name="update">Update</form:button>
							</td>
						</tr>
						<tr>
							<td>
								<form:input path="email" value="${t.email}"/><br/>
								<form:errors path="email" cssClass="error" /><br/>
							</td>
							<td>
								<form:input path="fax" value="${t.fax}"/> <br/>
								<form:errors path="fax" cssClass="error" /><br/>
							</td>
							<td><c:out value="${t.clientType.clientType}"></c:out></td>
							<form:hidden path="clientType.clientType" value="${t.clientType.clientType}"/>
							<td>
								<form:input path="address.addressCity" value="${t.address.addressCity}"/> <br/>
								<form:errors path="address.addressCity" cssClass="error" /><br/>
							</td>
							<td>
								<form:input path="address.stateAbbrv.stateAbbrv" value="${t.address.stateAbbrv.stateAbbrv}"/> <br/>
								<form:errors path="address.stateAbbrv.stateAbbrv" cssClass="error" /><br/>
							</td>
							<td>
								<form:input path="address.addressZip" value="${t.address.addressZip}"/> <br/>
								<form:errors path="address.addressZip" cssClass="error" /><br/>
							</td>
							<td>
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