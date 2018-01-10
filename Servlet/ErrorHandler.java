import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Extend HttpServlet class
public class ErrorHandler extends HttpServlet {
 
  // Method to handle GET method request.
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
     
      response.setContentType("text/html");
 
      PrintWriter out = response.getWriter();
      out.println("<h1><center> Error occured<br>Details:<br>code "+request.getAttribute("javax.servlet.error.status_code")+"</h1></center>");

  }
  // Method to handle POST method request.
  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
     doGet(request, response);
  }
}