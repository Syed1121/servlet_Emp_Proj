import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class List extends HttpServlet {
    String eno;
    boolean flag = false;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        Connection c;
        Statement s;
        ResultSet rs;

        try {
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Demo</title>");
            out.print("<style>");
            out.print("body { font-family: Arial, sans-serif; margin: 0; padding: 0; background: url('/second/images/company.png') no-repeat center center fixed; background-size: cover; }");
            out.print(".container { background-color: transparent; width: 90%; max-width: 600px; margin: 50px auto; padding: 20px; border-radius: 8px; box-shadow: transparent; }");
            out.print(".nav-bar { display: flex; justify-content: space-around; flex-wrap: wrap; background-color: transparent; padding: 10px; border-radius: 5px; }");
            out.print(".nav-bar a { text-decoration: none; color: #fff; font-size: 18px; margin: 5px; padding: 10px 20px; background-color: rgba(51, 51, 51, 0.8); border-radius: 5px; transition: background-color 0.3s; }");
            out.print(".nav-bar a:hover { background-color: rgba(85, 85, 85, 0.8); }");
            out.print("@media (max-width: 600px) { .container { width: 95%; margin: 20px auto; } .nav-bar { flex-direction: column; align-items: center; } .nav-bar a { width: 100%; margin: 10px 0; text-align: center; } }");
            out.print("</style>");
            out.print("</head>");
            out.print("<body>");
            out.print("<div class='container'>");
            out.print("<div class='nav-bar'>");
            out.print("<a href='/second/index.html'>HOME</a>");
            out.print("<a href='/second/insrec.html'>INSERT</a>");
            out.print("<a href='/second/DispEmp2'>DISPLAY</a>");
            out.print("<a href='/second/delrec.html'>DELETE</a>");
            out.print("</div>");
            out.print("<form method='GET'>");
            out.print("<center>");
            out.print("Empno <input type='text' name='lsempno'>");
            out.print("<input type='submit' value='Submit'>");
            out.print("</center>");
            out.print("</form>");

            eno = req.getParameter("lsempno");

            if (eno != null && !eno.trim().isEmpty()) {
                Class.forName("com.mysql.jdbc.Driver");
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/demobase", "root", "Pyari$$");
                s = c.createStatement();
                rs = s.executeQuery("select * from myemp where eno='" + eno + "'");

                if (rs.next()) {
                    out.print("<center>");
                    out.print("<table>");
                    out.print("<tr><th>Empname</th><th>Empsal</th><th>Empgrade</th></tr>");
                    out.print("<tr>");
                    out.print("<td>" + rs.getString(2) + "</td>");
                    out.print("<td>" + rs.getInt(3) + "</td>");
                    out.print("<td>" + rs.getString(4) + "</td>");
                    out.print("</tr>");
                    out.print("</table>");
                    out.print("</center>");
                } else {
                  out.print("/n");
                    out.print("<center><p>No employee found with the given number.</p></center>");
                }

                c.close();
            }

            out.print("</div>");
            out.print("</body>");
            out.print("</html>");
        } catch (Exception ex) {
            out.println(ex);
        }
    }
}
