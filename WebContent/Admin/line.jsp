<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gun Allocated to Soldier</title>

<script type="text/javascript" src="<%=request.getContextPath()%>/Admin/js/jscharts.js"></script>
</head>
<body style="overflow: hidden;">

<%-- <form action="<%=request.getContextPath()%>/IndexController">
 --%>	

 
 <c:forEach items="${sessionScope.gunCounts}" var="list1">
 
		<input type="hidden" name="status" value="${list1[1]}"/>
		
		<input type="hidden" name="task" value="${list1[0]}"/>
	</c:forEach>
	
	
	<div id="graph">Loading graph...</div>

	<script type="text/javascript">
	
		var statusname = document.getElementsByName("status");
		var tasks = document.getElementsByName("task");

		var myData = new Array(statusname.length);
		 for(var i=0;i<statusname.length;i++)
			{ 
			myData[i] = new Array(2);
		//myData[0][0] = "marketing"; //emp[0]+""+depl[0];

		
		myData[i][0] = statusname[i].value;
		myData[i][1] = parseInt(tasks[i].value);//emp[1]+""+depl[1];

/* 		myData[1] = new Array(2);
		myData[1][0] = "xyz"; //emp[0]+""+depl[0];
		myData[1][1] = 456;//emp[1]+""+depl[1];
 */
	//	alert(myData);
		}
		
		//new Array([emp[0], depl[0]], [emp[1], depl[1]], ['Mar06-Mar07', 12], ['Mar07-Mar08', 17]);
	//	var colors = [ '#AF0202', '#EC7A00' ];
		var myChart = new JSChart('graph', 'bar');
		myChart.setDataArray(myData);
	//	myChart.colorizeBars(colors);
		myChart.setTitle('Number of Guns Allocated To Soldier');
		myChart.setTitleColor('#8C8382');
		myChart.setAxisNameX('');
		myChart.setAxisNameY('');
		myChart.setAxisColor('#9D9F9D');
		myChart.setAxisNameFontSize(16);
		myChart.setAxisNameColor('#999');
		myChart.setAxisValuesColor('#7E7E7E');
		myChart.setBarValuesColor('#7E7E7E');
		myChart.setAxisPaddingTop(60);
		myChart.setAxisPaddingRight(140);
		myChart.setAxisPaddingLeft(150);
		myChart.setAxisPaddingBottom(40);
		myChart.setTextPaddingLeft(105);
		myChart.setTitleFontSize(11);
		myChart.setBarBorderWidth(1);
		myChart.setBarBorderColor('#DC143C');
		myChart.setBarSpacingRatio(50);
		myChart.setGrid(false);
		myChart.setSize(616, 321);
		myChart.setBackgroundImage('/images/chart_bg.jpg');
		//myChart.setBackgroundColor('#636e7b');
		myChart.draw();
</script>

<input type="hidden" name="flag" value="taskchart">
</body>
</html>