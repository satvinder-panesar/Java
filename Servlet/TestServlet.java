// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class TestServlet extends HttpServlet {
 

  public void init() throws ServletException
  {
 
  }

  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // Set response content type
      response.setContentType("text/html");
	  //response.setIntHeader("Refresh",5);
	  String name = request.getParameter("name");
	  Cookie username = new Cookie("username", request.getParameter("name"));
	  username.setMaxAge(60*60*24);
	  response.addCookie(username);
      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println("<center><h1> Servlet response -- Welcome 	" + name + "</h1></center>");
	  //response.sendRedirect("http://www.google.com");
	  
  }
  
  public void destroy()
  {
      // do nothing.
  }
}