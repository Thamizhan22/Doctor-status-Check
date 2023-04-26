<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%


try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare","root","");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from active");
if(rs.next())
{     
	out.println("status  :"+rs.getString(1));
	out.println("<br><br>");
	out.println("name    :"+rs.getString(2));
}
}
catch(Exception e)
{
}




%>
</body>
</html>