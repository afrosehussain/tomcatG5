/***************
    Author       :   Afrose
    Program Name :   ProductServlet.java
    Program No   :   04
    Description  :   Java Servlets

***************/
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

//define the servlet class by extending httpservlet abstract
public class ProductsServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        String proid = req.getParameter("product");
        String catid= req.getParameter("category");
        String price = req.getParameter("price");

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
            PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?)");
            ps.setString(1,proid);
            ps.setString(2,catid);
            ps.setString(3,price);

            int i=ps.executeUpdate();
            if(i>0){
                out.print("<font color=\"green\" size=\"20\">Product Added Successfully.</font>");   
            }
 

        }
        catch(Exception ee){
            out.println(ee.getMessage());
            ee.printStackTrace();
        }



    }
}