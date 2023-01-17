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
	<%
		request.setCharacterEncoding("UTF-8");
		String error = request.getParameter("error");
		if(error != null && error.equals("1")){
			Kadai1dto ka1 = (Kadai1dto)session.getAttribute("input_data");
	%>
	<h1 style="color:red">登録失敗</h1>
	<h1>以下の項目を入力してください</h1>
	<form action="Kadai1RegisterConfirmServlet" method="post">
		名前:<input type="text" name="name" value="<%=ka1.getName() %>"><br>
		年齢:<input type="number" name="age" value="<%=ka1.getAge() %>"><br>
		性別:<br>
		<input type="radio" name="gender" value="男性">男性
		<input type="radio" name="gender" value="女性">女性<br>
		電話番号:<input type="tel" name="phototel" value="<%=ka1.getPhototel() %>"><br>
		メール:<input type="email" name="mail" value="<%=ka1.getMail() %>"><br>
		パスワード:<input type="password" name="pw"><br>
		<input type="submit" value="送信"><br>
		<a href="./">トップページ</a>
	</form>
	
	<%
	}else{
	%>
	
	<h1>以下の項目を入力してください</h1>
	<form action="Kadai1RegisterConfirmServlet" method="post">
		名前:<input type="text" name="name"><br>
		年齢:<input type="number" name="age"><br>
		性別:<br>
		<input type="radio" name="gender" value="男性">男性
		<input type="radio" name="gender" value="女性">女性<br>
		電話番号:<input type="tel" name="phototel"><br>
		メール:<input type="email" name="mail"><br>
		パスワード:<input type="password" name="pw"><br>
		<input type="submit" value="送信"><br>
		<a href="./">トップページ</a>
	</form>
	
	<%
	}
	%>
</body>
</html>