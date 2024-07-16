import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DispEmp2 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Statement stmt = null;
        Connection conn = null;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";

        out.println("<html>");
        out.println("<head><title>demo</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; background: url('/second/images/company.png') no-repeat center center fixed; background-size: cover; }");
        out.println(".container { background-color: transparent; width: 90%; max-width: 600px; margin: 50px auto; padding: 20px; border-radius: 8px; box-shadow: transparent; }");
        out.println(".nav-bar { display: flex; justify-content: space-around; flex-wrap: wrap; background-color: transparent; padding: 10px; border-radius: 5px; }");
        out.println(".nav-bar a { text-decoration: none; color: #fff; font-size: 18px; margin: 5px; padding: 10px 20px; background-color: rgba(51, 51, 51, 0.8); border-radius: 5px; transition: background-color 0.3s; }");
        out.println(".nav-bar a:hover { background-color: rgba(85, 85, 85, 0.8); }");
        out.println("@media (max-width: 600px) { .container { width: 95%; margin: 20px auto; } .nav-bar { flex-direction: column; align-items: center; } .nav-bar a { width: 100%; margin: 10px 0; text-align: center; } }");
        out.println("table { width: 100%; margin: 20px 0 0 0; border-collapse: collapse; }");
        out.println("td, th { padding: 10px; border: 2px solid #ddd; text-align: center; }");
        out.println("th { background-color: rgba(51, 51, 51, 0.8); color: white; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<div class='nav-bar'>");
        out.println("<a href='/second/index.html'>HOME</a>");
        out.println("<a href='/second/insrec.html'>INSERT</a>");
        out.println("<a href='/second/List'>LISTY</a>");
        out.println("<a href='/second/delrec.html'>DELETE</a>");
        out.println("</div>");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demobase", "root", "Pyari$$");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT eno, ename, esal, egrade FROM myemp");

            out.println("<center>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>ENO</th>");
            out.println("<th>ENAME</th>");
            out.println("<th>ESAL</th>");
            out.println("<th>EGRADE</th>");
            out.println("</tr>");
            
            while (rs.next()) {
                int teno = rs.getInt("eno");
                String tename = rs.getString("ename");
                int tesal = rs.getInt("esal");
                String tegrade = rs.getString("egrade");

                out.println("<tr>");
                out.println("<td>" + teno + "</td>");
                out.println("<td>" + tename + "</td>");
                out.println("<td>" + tesal + "</td>");
                out.println("<td>" + tegrade + "</td>");
                out.println("</tr>");
            }
            
            out.println("</table></center>");
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            out.println(ex);
        }

        out.println("</div>");
        out.println("</body></html>");
    }
}
