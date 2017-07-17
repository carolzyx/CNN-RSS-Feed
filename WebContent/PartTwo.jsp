<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlet Information</title>
</head>
<body>
<h1><%
out.println("Information");
%></h1>
<br><%=application.getAttribute("localAddr") %></br>
<br><%=application.getAttribute("localHost") %></br>
<br><%=application.getAttribute("localPort") %></br>
<br><%=application.getAttribute("authType") %></br>
<br><%=application.getAttribute("clientLoc") %></br>
<br><%=application.getAttribute("contextPath") %></br>
<br><%=application.getAttribute("userprin") %></br>
<br><%=application.getAttribute("meth") %></br>
<br><%=application.getAttribute("requestUri") %></br>
<br><%=application.getAttribute("proto") %></br>
<br><%=application.getAttribute("pathInfo") %></br>
<br><%=application.getAttribute("remoteAddr") %></br>
<br><%=application.getAttribute("cooki") %></br>
<br><%=application.getAttribute("name") %></br>
</body>
</html>