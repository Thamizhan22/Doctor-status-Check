

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

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		try
		{
			HttpSession s=request.getSession(); 
			String a=s.getAttribute("doctorname").toString();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare","root","");
			Statement st=con.createStatement();
		    st.executeUpdate("update active set status='inactive' where name='"+a+"' ");
		    response.sendRedirect("doctorlogin.jsp");
		}

		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
