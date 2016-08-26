<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.3.js" type="text/javascript" ></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./style.css">
<style type="text/css">
.scroll{
	height:100vh;
	overflow:auto;
}
</style>
</head>
<body>
	<div class="fulldiv">
   <script src="navbar.js"></script>
   <script src="highcharts.js"></script>
   <div class="pagebody">
   	<div class="pagecenter scroll">
			<div id="container" style="width:100%; height:400px;"></div>
			<table id="datatable" style="visibility: visible;">
		    <thead>
		        <tr><th></th><th>On Hand</th><th>Purchased</th><th>Sold</th></tr>
		    </thead>
		    <tbody>
		    	<c:forEach var="t" items="${products}">
		    		<tr><th><c:out value="${t.productName}"></c:out></th>
		    		<td><c:out value="${t.onHandQuantity}"></c:out></td><td>3</td><td>4</td></tr>
		    	</c:forEach>
<!-- 		        <tr><th>Apples</th><td>20</td><td>3</td><td>4</td></tr> -->
<!-- 		        <tr><th>Pears</th><td>25</td><td>2</td><td>0</td></tr> -->
<!-- 		        <tr><th>Plums</th><td>30</td><td>5</td><td>11</td></tr> -->
<!-- 		        <tr><th>Bananas</th><td>18</td><td>1</td><td>1</td></tr> -->
<!-- 		        <tr><th>Oranges</th><td>12</td><td>2</td><td>4</td></tr> -->
<!-- 		        <tr><th>Grapes</th><td>50</td><td>2</td><td>4</td></tr> -->
<!-- 		        <tr><th>a</th><td>50</td><td>2</td><td>4</td></tr> -->
<!-- 		        <tr><th>s</th><td>50</td><td>2</td><td>4</td></tr> -->
<!-- 		        <tr><th>d</th><td>50</td><td>2</td><td>4</td></tr> -->
<!-- 		        <tr><th>f</th><td>50</td><td>2</td><td>4</td></tr> -->
<!-- 		        <tr><th>g</th><td>50</td><td>2</td><td>4</td></tr> -->
<!-- 		        <tr><th>h</th><td>50</td><td>2</td><td>4</td></tr> -->
		    </tbody>
			</table>
			<br/>
		</div>
   </div>
	</div>
	<div class="cleardiv"></div>
</body>
<script type="text/javascript">
$(function () {
    $('#container').highcharts({
        data: {
            table: 'datatable'
        },
        chart: {
            type: 'column'
        },
        title: {
            text: 'Filler data until Reports finalize'
        },
        yAxis: {
            allowDecimals: false,
            title: {
                text: 'Units'
            }
        },
        tooltip: {
            formatter: function () {
                return '<b>' + this.series.name + '</b><br/>' +
                    this.point.y + ' ' + this.point.name.toLowerCase();
            }
        }
    });
});
</script>
</html>