<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
</head>

<% 
String username=request.getParameter("uname"); 
String pass=request.getParameter("pass"); 
try{
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
    Statement ps = con.createStatement();
    String query = "SELECT * from Registrations where uname='"+username+"' and password='"+pass+"'";
    ResultSet rs = ps.executeQuery(query);

    if(rs.next()){
        out.println("<body><center>");
        out.println("<h1>Welcome: "+rs.getString(2)+"</h1>");
        out.println("<h3>You are successfully logged in</h3>");
        out.println("</center></body>");
    } else{
        out.println("<br> <center><font color=\"red\">Invalid Credentials</font></center>");
    }
} catch(Exception e){
    out.println(e.getMessage());
    e.printStackTrace();
}
%>
</html>