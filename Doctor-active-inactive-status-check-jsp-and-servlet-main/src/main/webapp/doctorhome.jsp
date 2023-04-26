<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

String ab=session.getAttribute("doctor").toString();
out.println("welcome "+ab);
session.setAttribute("doctorname", ab);

%>

<form action="logout" method="post">
<input type="submit" value="logout">
</form>
</body>
</html>