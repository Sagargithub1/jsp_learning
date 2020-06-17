<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="web.practice.login.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegisterDetails</title>
</head>
<body>
<jsp:useBean id="user"
	class="web.practice.bean.UserBean"/>

<jsp:setProperty property="*" name="user"/>
 <%
  UserDao userDao = new UserDao();
  int status = userDao.registerUser(user);
  if (status > 0) {
   out.print("You are successfully registered");
  }
 %>
</body>
</html>