

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Servlet implementation class data1
 */
@WebServlet("/data1")
public class data1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public data1() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String feedUrl = request.getParameter("feedurl");
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(feedUrl);
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
	    
		String str2 = new String();
		
		try {
		    System.out.println(response1.getStatusLine());
		    HttpEntity entity1 = response1.getEntity();
			
			SAXReader rea = new SAXReader();
			Document doc = rea.read(feedUrl);
			Element channel = doc.getRootElement().element("channel");
			Element foo;
			
//			PrintWriter out = response.getWriter();
//			response.setContentType("text/html");
			
			for(Iterator i = channel.elementIterator("item");i.hasNext();){
				foo = (Element)i.next();

				str2 = str2 +"<br>"+"<a href="+foo.elementText("link")+">"+foo.elementText("title")+"</a>"+"<br>";				
				
			}
//			System.out.println(str2);
//			out.println("<html>");
//			out.println("<head>");
//			out.println("<title>More News</title>");
//			out.println("</head>");
//			out.println("<body>");
//			out.println("<br></br>");
//			out.println(str2);  
//			out.println("</body>");
//			out.println("</html>");
			
		    EntityUtils.consume(entity1);
		    System.out.println("Get"); 
		}
		catch (DocumentException e) {
			e.printStackTrace();
		} 
		finally {
		    response1.close();
		}
		
			HttpSession session = request.getSession();
			session.setAttribute("content", str2);
		
		request.getRequestDispatcher("data1.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
