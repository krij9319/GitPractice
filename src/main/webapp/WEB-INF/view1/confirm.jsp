<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kadaidto.Kadai1dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録</title>
</head>
<body>
	<h1>以下の内容で登録します。本当によろしいでしょうか？</h1>
	<%
		Kadai1dto ka1 = (Kadai1dto)session.getAttribute("input_data");
	%>
	名前:<%=ka1.getName() %><br>
	年齢:<%=ka1.getAge() %><br>
	性別:<%=ka1.getGender() %><br>
	電話番号:<%=ka1.getPhototel() %><br>
	メール:<%=ka1.getMail() %><br>
	パスワード:********<br>
	<a href="Kadai1RegisterExecuteServlet">送信</a><br>
	<a href="Kadai1RegisterConfirmServlet">登録画面</a>
</body>
</html>