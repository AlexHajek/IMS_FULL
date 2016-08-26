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

<style>
	.mylabels{
		width: 300px;
	}

</style>
</head>
<body>
	<div class="fulldiv">
   <script src="navbar.js"></script>
   <div class="pagebody">
   	<div class="pagecenter">
   		<h1>Create New Client</h1>
				<form:form action="updateclient.do" method="post" commandName="myClient">
			<!-- path=bean property -->
					<table class="fullwidth">
						<tr>
							<td>
								Name:<br/> <form:input path="name" class="mylabels" /> <br/>
								<form:errors path="name" cssClass="error" /><br/>
							</td>
						</tr>
						<tr>
							<td>
								Email:<br/> <form:input path="email" class="mylabels" /> <br/>
								<form:errors path="email" cssClass="error" /><br/>
							</td>
						</tr>
						<tr>
							<td>
								Person of Contact:<br/> <form:input path="pocn" class="mylabels"/> <br/>
								<form:errors path="pocn" cssClass="error" /><br/>
							</td>
						</tr>
					</table>
					<table class="fullwidth">
						<tr>
							<td>
								Phone Number:<br/> <form:input path="phone" class="mylabels" /> <br/>
								<form:errors path="phone" cssClass="error" /><br/>
							</td>
							<td>
								Fax Number:<br/> <form:input path="fax" class="mylabels" /> <br/>
								<form:errors path="fax" cssClass="error" /><br/>
							</td>
						</tr>
					</table>
					<table class="fullwidth">
					<tr>
						<td>
								StreetAddress 1:<br/> <form:input path="address.streetAddress1"  class="mylabels"/> <br/>
								<form:errors path="address.streetAddress1" cssClass="error" />
						</td>
						<td>
								StreetAddress 2:<br/> <form:input path="address.streetAddress2" class="mylabels" /> <br/>
								<form:errors path="address.streetAddress2" cssClass="error" />
						</td>
					</tr>
					</table>
					<table class="fullwidth">	
					<tr>
						<td>
							City:<br/> <form:input path="address.addressCity" class="mylabels" /> <br/>
								<form:errors path="address.addressCity" cssClass="error" />
						</td>
						<td>
							ZIP Code:<br/> <form:input path="address.addressZip" class="mylabels" /> <br/>
							<form:errors path="address.addressZip" cssClass="error" />
						</td>
					</tr>
					</table>
					<table class="fullwidth">
					<tr>
						
							StateName:<br/> <form:select path="address.stateAbbrv.arrvId">
										<form:options items="${myAbbrvs}" itemValue="arrvId" itemLabel="stateName"/>
									</form:select> <br/>
							<form:errors path="address.stateAbbrv.arrvId" cssClass="error" />
						
						
							ClientType:<br/> <form:select path="clientType.clientTypeId">
										<form:options items="${clientTypes}" itemValue="clientTypeId" itemLabel="clientType"/>
									</form:select><br/>
							<form:errors path="clientType.clientTypeId" cssClass="error" />
						
					</tr>
					</table>
					<br/>
				<!--  ClientTypeID:<br/> <form:input path="clientType.clientTypeId" /> <br/>
					<form:errors path="clientType.clientTypeId" cssClass="error" />  -->
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