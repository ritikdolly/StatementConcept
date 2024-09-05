<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STudent Input</title>
</head>
<body>
<%
	String msg= (String)request.getAttribute("msg");
	if(msg != null){
		out.print(msg);
	}
%>	

<br><br>
	<h1>Student Information</h1>
	<form action="registor" method="post">
		<input type="text" name="name" placeholder="Enter you name"/><br>
		<input type="text" name="regNo" placeholder="Enter you registation Number"/><br>
		<input type="text" name="prog" placeholder="Enter you Programme"/><br>
		<input type="text" name="branch" placeholder="Enter you Branch"/><br>
		<input type="text" name="Bgrp" placeholder="Enter you blood group"/><br>
		<input type="submit" value="Submit"/>
	</form><br><br>
	<a href="index.jsp">Back to Home</a>
</body>
</html>