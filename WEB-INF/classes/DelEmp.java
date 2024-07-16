import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DelEmp extends HttpServlet
{
 String eno;

    String e;

    boolean flag=false;

public void doGet(HttpServletRequest req, HttpServletResponse res)
throws IOException, ServletException
{
res.setContentType("text/html");
PrintWriter out = res.getWriter();
Connection c;
Statement s;
ResultSet rs;
try
{
           eno=req.getParameter("dempno");
            Class.forName("com.mysql.jdbc.Driver");

             c=DriverManager.getConnection("jdbc:mysql://localhost:3306/demobase","root","Pyari$$");
            s=c.createStatement();

            s.executeQuery("select *from myemp");

                rs=s.getResultSet();

            while(rs.next())

              {
                   e=rs.getString(1);
                
                    if(e.equals(eno))
                    {
                        flag=true;
                        s.executeUpdate("delete from myemp where eno='"+eno+"'");
                        break;
                    }
              }
              if(flag==true)
                out.println(" User Data deleted successfully");
              else
                out.println("Sorry  user data is Not Available");

            s.close();
            c.close();
           
        }
        catch(Exception ex)
     {
out.println(ex);
}
    }
}

