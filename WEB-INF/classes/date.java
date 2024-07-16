import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class date extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
Date d=new Date();
pw.println("<html>");
pw.println("<head><title>web</title></head>");
pw.println("<body>"+d+"</body>");
pw.println("</html>");
}
}