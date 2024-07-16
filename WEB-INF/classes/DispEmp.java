import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class DispEmp extends HttpServlet{

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   
      // JDBC driver name and database URL
      String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
      String DB_URL="jdbc:mysql://localhost/demobase";

      //  Database credentials
   String USER = "root";
   String PASS = "sriinformatics";
   Statement stmt=null;
   Connection conn=null;

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      
      String docType =
         "<!doctype html>\n";
      
      out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor = \"#f0f0f0\">\n" +
         "<h1 align = \"center\">" + title + "</h1>\n");
      try {
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

         // Open a connection
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
         stmt = conn.createStatement();
         String sql;
         sql = "SELECT eno,ename,esal,egrade from myemp";
         ResultSet rs = stmt.executeQuery(sql);

         // Extract data from result set
         while(rs.next()){
            //Retrieve by column name
            int teno  = rs.getInt("eno");
            String tename = rs.getString("ename");
            int tesal = rs.getInt("esal");
            String tegrade=rs.getString("egrade");

            //Display values
            out.println("Eno " + teno + "<br>");
            out.println(", Ename " + tename + "<br>");
            out.println(", Esal " + tesal + "<br>");
            out.println(", Egrade " + tegrade + "<br>");
         }
         out.println("</body></html>");

         // Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      } catch(SQLException se) {
         //Handle errors for JDBC
         se.printStackTrace();
      } catch(Exception e) {
         //Handle errors for Class.forName
         e.printStackTrace();
      } finally {
         //finally block used to close resources
         try {
            if(stmt!=null)
               stmt.close();
         } catch(SQLException se2) {
         } // nothing we can do
         try {
            if(conn!=null)
            conn.close();
         } catch(SQLException se) {
            se.printStackTrace();
         } //end finally try
      } //end try
   }
} 
