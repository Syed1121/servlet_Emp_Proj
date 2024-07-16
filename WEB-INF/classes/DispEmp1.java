import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DispEmp1 extends HttpServlet
{
 String eno;
 String e;
 boolean flag=false;
 public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
{
res.setContentType("text/html");
PrintWriter out = res.getWriter();
Connection c;
Statement s;
ResultSet rs;
try
{
           eno=req.getParameter("lsempno");
            Class.forName("com.mysql.jdbc.Driver");

             c=DriverManager.getConnection("jdbc:mysql://localhost:3306/demobase","root","sriinformatics");
            s=c.createStatement();
            rs=s.executeQuery("select * from myemp where eno='"+eno+"'");
               while(rs.next())
              {
	out.print(rs.getString(2));
	out.print(rs.getInt(3));
             out.print(rs.getString(4));
	}
}catch(Exception ex)
{
out.println(ex);
}
}
}

