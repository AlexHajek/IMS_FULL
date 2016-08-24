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
   		<h1>Create New Product Category</h1>
			<form:form action="registerProductCat.do" method="post" commandName="newProductCat">
						<!-- path=bean property -->
						<table class="fullwidth">
							<tr>
								<td>
									Product Category:<br/> <form:input path="categoryDescription" cssClass="inputfields fullwidth"/> <br/>
									<form:errors path="categoryDescription" cssClass="error" /><br/>
								</td>
							</tr>
						</table>
				<input type="submit" value="Register" />
			</form:form>
			<br/>
		</div>
   </div>
	</div>
	<div class="cleardiv"></div>
</body>
</html>