import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Implements Filter class
public class LogFilter implements Filter  {
   public void  init(FilterConfig config) 
                         throws ServletException{
      // Get init parameter 
      String testParam = config.getInitParameter("test-param"); 

      //Print the init parameter 
      System.out.println("Test Param: " + testParam); 
   }
   public void  doFilter(ServletRequest request, 
                 ServletResponse response,
                 FilterChain chain) 
                 throws java.io.IOException, ServletException {

      // Get the IP address of client machine.   
      String username = request.getParameter("name");

      if(username.equals("satvinder"))
		chain.doFilter(request,response);
	  else{
		PrintWriter out = response.getWriter();
		out.println("<center><h1> Access Denied </h1></center>");
	  }
		  
   }
   public void destroy( ){
      /* Called before the Filter instance is removed 
      from service by the web container*/
   }
}