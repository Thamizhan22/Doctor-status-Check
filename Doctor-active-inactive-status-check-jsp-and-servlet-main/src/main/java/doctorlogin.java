	

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
/**
 * Servlet implementation class doctorlogin
 */
@WebServlet("/doctorlogin")
public class doctorlogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("n1");
		String b=request.getParameter("n2");
		String c=request.getParameter("n3");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare","root","");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from doctor where name='"+a+"' ");
		if(rs.next())
		{   
			HttpSession session=request.getSession();	
		    session.setAttribute("doctor" , a);
			st.executeUpdate("update active set status='active' where name='"+a+"' ");
			response.sendRedirect("doctorhome.jsp");
		}
		else
		{
			response.sendRedirect("doctorlogin.jsp");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
