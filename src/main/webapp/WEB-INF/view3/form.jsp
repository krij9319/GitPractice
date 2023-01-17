<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員削除</title>
</head>
<body>
	<h1>削除するメールを入力してください</h1>
	<form action="Kadai3DeleteServlet" method="post">
		メール:<input type="email" name="email"><br>
		<input type="submit" value="送信">
		<a href="./">トップページ</a>
	</form>
</body>
</html>