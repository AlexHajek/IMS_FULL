<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.3.js" type="text/javascript" ></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Page</title>
</head>
<body>
	<div id="container" style="width:100%; height:400px; border: 4px solid black;"></div>
	<table id="datatable" style="visibility: hidden;">
    <thead>
        <tr><th></th><th>Jane</th><th>John</th><th>Jill</th><th>Josh</th></tr>
    </thead>
    <tbody>
        <tr><th>Apples</th><td>3</td><td>4</td><td>3</td><td>4</td></tr>
        <tr><th>Pears</th><td>2</td><td>0</td><td>3</td><td>4</td></tr>
        <tr><th>Plums</th><td>5</td><td>11</td><td>3</td><td>4</td></tr>
        <tr><th>Bananas</th><td>1</td><td>1</td><td>3</td><td>4</td></tr>
        <tr><th>Oranges</th><td>2</td><td>4</td><td>3</td><td>4</td></tr>
        <tr><th>Grapes</th><td>2</td><td>4</td><td>3</td><td>4</td></tr>
    </tbody>
	</table>
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
            text: 'Data extracted from a HTML table in the page'
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