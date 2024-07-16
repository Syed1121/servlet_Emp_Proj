import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class co extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
String url="jdbc:mysql://localhost:3306/example";
try
{
Class.forName("org.gjt.mm.mysql.Driver");
Connection con=DriverManager.getConnection(url,"root","brilliant");
pw.println("connection succeded girl!");
}
catch(Exception se)
{
pw.println(se);
}
}
}