import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateEmp extends HttpServlet
{
 String eno;
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
out.print("<html>");
out.print("<head><title>demo</title></head>");
out.print("<body>");
out.print("<form method=GET>");
out.print("<center>");
out.print("Empno<input type=text name=uempno>");
out.print("<input type=submit value=submit>");
out.print("</center>");
out.print("</form>");
out.print("</body>");
out.print("</html>");
           eno=req.getParameter("uempno");
            Class.forName("com.mysql.jdbc.Driver");

             c=DriverManager.getConnection("jdbc:mysql://localhost:3306/demobase","root","sriinformatics");
            s=c.createStatement();
            rs=s.executeQuery("select * from myemp where eno='"+eno+"'");
               while(rs.next())
              {
             out.print("<html>");
             out.print("<head><title>demo</title></head>");
             out.print("<body>");
  out.print("<form>");
             out.print("Ename:<input type=text name=ename></br>");
             out.print("Esalary:<input type=text name=esal></br>");
            out.print("Egrade:<input type=text name=egrade>");
             out.print("<input type=submit value=submit>");
out.print("</form>");
            out.print("</body>");
            out.print("</html>");
           
	}
}catch(Exception ex)
{
out.println(ex);
}
}
}

