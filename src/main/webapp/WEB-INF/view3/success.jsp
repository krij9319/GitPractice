<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員削除</title>
</head>
<body>
	<h1 style="color:red">下記のデータを削除しました</h1>
	<%
	request.setCharacterEncoding("UTF-8");
	String email = request.getParameter("email");
	%>
	<p>メール:<%=email %></p>
	<a href="./">トップページ</a>
</body>
</html>