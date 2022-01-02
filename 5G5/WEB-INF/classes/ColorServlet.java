// A java servlet web application that allows user to choose a color 
//and changes the background color of page accordingly.
/* 

	Author		:	Afrose
	Date		:	06/12/2021
	Program Name:	ColorServlet.java
	Lab Cycle	:	08
	Description	:	Developing web applications
	Topics		:	Servlet, GenericServlet
	
*/
// Import required packages
import java.io.*;
import javax.servlet.*;

public class ColorServlet extends GenericServlet{
	String r = "red";
	String b = "blue";
	String g = "green";
	

	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException {
		String name = req.getParameter("color");
		res.setContentType("text/html");
		PrintWriter pwriter=res.getWriter();
		pwriter.print("<html>");
		if(name.equals(r)){
			pwriter.print("<body bgcolor=\""+r+"\">");
		}
		if(name.equals(g)){
			pwriter.print("<body bgcolor=\""+g+"\">");
		}
		if(name.equals(b)){
			pwriter.print("<body bgcolor=\""+b+"\">");
		}
		
		pwriter.print("<h2><font color=\"green\">Hello World! Welcome to Servlet Programming</font></h2>");
		pwriter.print("</body>");
		pwriter.print("</html>");
	}

}