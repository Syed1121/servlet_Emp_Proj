import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class table extends HttpServlet
{
protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
response.setContentType("text/html");
PrintWriter pw=response.getWriter();

int eno=Integer.parseInt(request.getParameter("eno"));
String ename=request.getParameter("ename");
int esal=Integer.parseInt(request.getParameter("esal"));
String egrade=request.getParameter("egrade");

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","sriinformatics");

pw.println("connection ok");

PreparedStatement ps=con.prepareStatement("insert into myemp values(?,?,?,?)");
ps.setInt(1,eno);
ps.setString(2,ename);
ps.setInt(3,esal);
ps.setString(4,egrade);
int i=ps.executeUpdate();
if(i>0)
{
pw.println("details are registered succesfully");
}
}catch(Exception ex)
{
ex.printStackTrace();
}

}
}