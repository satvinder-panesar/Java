// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
 
// Extend HttpServlet class
public class SessionTrack extends HttpServlet {
 
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // Create a session object if it is already not  created.
      HttpSession session = request.getSession(true);
	  Integer visitCount;
      // Check if this is new comer on your web page.
      if (session.isNew()){
         visitCount = new Integer(1);
      } else {
         visitCount = (Integer)session.getAttribute("visits");
         visitCount = visitCount + 1;
      }
      session.setAttribute("visits",  visitCount);

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      out.println("<h1><center> No of visits "+session.getAttribute("visits")+"</center></h1>");
  }
}