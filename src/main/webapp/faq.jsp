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
textarea{
	resize:none;
}
</style>
</head>
<body>
	<div class="fulldiv">
   <script src="navbar.js"></script>
   <div class="pagebody">
   	<div class="pagecenter">
			<h2>FAQ</h2>
			If you need to send an email to a higher up leave a message here:<br/>
			<form:form action="email.do" method="get" commandName="email">
				<form:textarea rows="20" cols="60" path="stateName"></form:textarea><br/>
				<form:button>Submit Email</form:button>
			</form:form>
			<br/>
		</div>
   </div>
	</div>
	<div class="cleardiv"></div>
</body>
</html>