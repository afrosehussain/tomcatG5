// A java Login web application by extending HttpServlet class from 
//javax.servlet.http package and validate the user login credentials.
/* 

	Author		:	Afrose
	Date		:	13/12/2021
	Program Name:	ColorServlet.java
	Lab Cycle	:	09
	Description	:	Developing web applications
	Topics		:	Servlet, HttpServlet
	
*/
// Import required packages
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();

		String name = req.getParameter("uname");
		String pass = req.getParameter("pass");

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
			Statement ps = con.createStatement();
			String query = "SELECT name from Registrations where uname='"+name+"' and password='"+pass+"'";
			ResultSet rs = ps.executeQuery(query);

			if(rs.next()){
				out.println("<body bgcolor=\"lightblue\">");
				out.println("<font color=\"green\" size=\"20\">Welcome "+rs.getString(1)+"</font>");
				out.println("</body>");
			} else{
				out.println("<br> <center><font color=\"red\">Invalid Credentials</font></center>");
				req.getRequestDispatcher("Login.html").include(req,res);
			}
		} catch(Exception e){
			out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}