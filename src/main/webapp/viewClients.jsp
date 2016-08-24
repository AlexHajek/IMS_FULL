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
   <script src="navbar.js"></script>
   <div class="pagebody">
   	<div class="pagecenter">
   		<table class="fullwidth">
				<c:forEach var="t" items="${clients}">
					<tr>
						<td><c:out value="${t.id}"></c:out></td>
						<td><c:out value="${t.name}"></c:out></td>
						<td><c:out value="${t.email}"></c:out></td>
						<td><c:out value="${t.pocn}"></c:out></td>
						<td><c:out value="${t.phone}"></c:out></td>
						<td><c:out value="${t.fax}"></c:out></td>
						<td><c:out value="${t.address.streetAddress1}"></c:out></td>
						<td><c:out value="${t.address.addressCity}"></c:out></td>
						<td><c:out value="${t.address.stateAbbrv.arrvId}"></c:out></td>
						<td>
							<form:form action="updateProduct.do" method="post" commandName="updateClient">
								<form:hidden path="id" id="${t.id}"/>
								<form:button>Update</form:button>
							</form:form>
						</td>
						<td>
							<form:form action="deleteProduct.do" method="post" commandName="updateClient">
								<form:hidden path="id" id="${t.id}"/>
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