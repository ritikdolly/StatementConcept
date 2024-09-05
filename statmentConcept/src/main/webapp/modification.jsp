<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg = (String) request.getAttribute("msg");
		if(msg != null){
			out.print(msg);
		}
	%>
	
	<%
    String operation = request.getParameter("operation");
	%>
	<br><br>
	<form action="modify" method="post">
		<input type="text" name="reg" placeholder="Enter Registation Number"/><br>
		<input type="hidden" name="operation" value="<%= operation %>">
		<input type="submit" value="Submit"/>
	</form><br><br>
	<a href="index.jsp">Back to Home</a>
</body>
</html>