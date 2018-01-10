import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
// Extend HttpServlet class
public class ReadCookies extends HttpServlet {
 
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      Cookie cookie = null;
	  Cookie[] cookies = null;
      // Get an array of Cookies associated with this domain
      cookies = request.getCookies();
      
	  // Set response content type
      response.setContentType("text/html");
 
      PrintWriter out = response.getWriter();
      if( cookies != null ){
         out.println("<h2> <center>Found Cookies Name and Value</center></h2>");
         for (int i = 0; i < cookies.length; i++){
            cookie = cookies[i];
            out.println("Name : " + cookie.getName( ) + ",  ");
            out.println("Value: " + cookie.getValue( )+" <br/>");
         }
      }else{
          out.println(
            "<h2>No cookies founds</h2>");
      }
   }
}