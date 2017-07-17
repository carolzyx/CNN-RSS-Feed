

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AssPartTwo")
public class AssPartTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AssPartTwo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
PrintWriter out = response.getWriter();
        
		Cookie cookie = new Cookie("key","value");
        cookie.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookie);
		
        String localAddr = request.getLocalAddr();
        String localHost = request.getLocalName();
        String localPort = request.getLocalPort()+"";
        String authType = request.getAuthType();
        String clientLoc = request.getLocale()+"";
        String contextPath = request.getContextPath();
        String userprin = request.getUserPrincipal()+"";
        String meth = request.getMethod();
        String requestUri = request.getRequestURI();
        String proto = request.getProtocol();
        String pathInfo = request.getPathInfo();
        String remoteAddr = request.getRemoteAddr();
        String cooki = request.getCookies()+"";
        	
        getServletContext().setAttribute("localAddr", "Local Address: "+ localAddr);
        getServletContext().setAttribute("localHost", "Local Host: "+ localHost);
        getServletContext().setAttribute("localPort", "Local Port: "+ localPort);
        getServletContext().setAttribute("authType", "Authorization scheme: "+ authType);
        getServletContext().setAttribute("clientLoc", "Preferred Client Locale: "+ clientLoc);
        getServletContext().setAttribute("contextPath", "Context Path: "+ contextPath);
        getServletContext().setAttribute("userprin", "User Principal: "+ userprin);
        getServletContext().setAttribute("meth", "Method: "+ meth);
        getServletContext().setAttribute("requestUri", "Request URI: "+ requestUri);
        getServletContext().setAttribute("proto", "Protocol: "+ proto);
        getServletContext().setAttribute("pathInfo", "PathInfo: "+ pathInfo);
        getServletContext().setAttribute("remoteAddr", "Remote Address: "+ remoteAddr);
        getServletContext().setAttribute("cooki", "Cookies: "+ cooki);
        
        Enumeration e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = (String)e.nextElement();
            String value = request.getHeader(name);
            //out.println(name + ": " + value);
            //out.println("<br></br>");
            getServletContext().setAttribute("name",name+ ": "+ value);
            
            request.getRequestDispatcher("PartTwo.jsp").forward(request, response);       
        }
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
