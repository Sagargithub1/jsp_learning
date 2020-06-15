<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
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
Welcome ${username}

<a href="videos.jsp">Videos Here</a>
<div>
<form action="Logout" method="post">
<center><input type="submit" value="Logout"></center>
</form>
</div>
</body>
</html>