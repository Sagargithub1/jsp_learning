<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Videos</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("pragma", "no-cache"); // http 1.0
response.setHeader("Expires","0");//proxies
if(session.getAttribute("username")==null)
{
	response.sendRedirect("login.jsp");
}
%>
<iframe width="560" height="315" src="https://www.youtube.com/embed/cYc3FjhMMzI" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</body>
</html>