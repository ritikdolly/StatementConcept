<%@page import="stmt.AddStdInfo.AddStudent"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Student Information</h1>
	<%
	AddStudent StdDisplay= (AddStudent) request.getAttribute("StdDisplay");
	 if (StdDisplay != null) {
		    %>
		        <p>Name: <%= StdDisplay.getName() %></p>
		        <p>Registration Number: <%= StdDisplay.getReg_no() %></p>
		        <p>Programme: <%= StdDisplay.getProg() %></p>
		        <p>Branch: <%= StdDisplay.getBranch() %></p>
		        <p>Blood Group: <%= StdDisplay.getBlood_grp() %></p>
		    <%
		        } else {
		    %>
		        <p>No student information available.</p>
		    <%
		        }
		    %>
		    <br><br>
		    <a href="index.jsp">Back to Home</a>
		
</body>
</html>