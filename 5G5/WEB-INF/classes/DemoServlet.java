import java.io.*;
import javax.servlet.*;

public class DemoServlet implements Servlet {
	ServletConfig config = null;
	public void init(ServletConfig config) {
		this.config=config;
		System.out.println("Initialization config");
	}

	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException {
		res.setContentType("text/html");
		PrintWriter pwriter=res.getWriter();
		pwriter.print("<html>");
		pwriter.print("<body>");
		pwriter.print("<h2><font color=\"green\">Hello World! Welcome to Servlet Programming</font></h2>");
		pwriter.print("</body>");
		pwriter.print("</html>");
	}

	public void destroy() {
		System.out.println("servlet life cycle finished");
	}

	public ServletConfig getServletConfig() {
		return config;
	}

	public String getServletInfo() {
		return "A Demo program";
	}
}