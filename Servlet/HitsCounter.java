// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
 
// Extend HttpServlet class
public class HitsCounter extends HttpServlet {
	int hits;
	public void init(){
		hits = 0;
	}
 
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // Create a session object if it is already not  created.
      

      // Set response content type
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");

      PrintWriter out = response.getWriter();
		hits++;
      out.println("<h1><center> No of visits "+hits+"</center></h1>");
  }
}