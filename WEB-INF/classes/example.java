import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class example extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
pw.println("<html>");
pw.println("<head><title>GEETHA</title></head>");
pw.println("<body>GEETHA</body>");
pw.println("</html>");
}
}