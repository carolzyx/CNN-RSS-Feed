<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Subscription</title>
</head>
<body>
<div style="background-color=#CCCCCC">
<form action="forward1" method="get" name="form1">
<tr>
<td><%
out.print("Feed URL: ");
%></td>
<td><input name="feedurl" id="feedurl" type="text"></td>
<td><input type="submit" value="Add Subscription"></td>
</tr>
</form>
</div>
<br>
<br>
<div style="background-color: #FAEBD7;float:center">
<%=session.getAttribute("content")%>
</div>
</body>
</html>