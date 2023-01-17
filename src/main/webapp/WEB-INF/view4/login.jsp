<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("error") != null){
	%>
	<h1 style="color:red">ログインに失敗しました</h1>
		<form action="KadaiLogin1Servlet" method="post">
		<h1>IDとPWを入力してください</h1><br>
		ID:<input type="text" name="mail"><br>
		PW:<input type="password" name="pw"><br>
		<input type="submit" value="ログイン">
	</form>
	<%
		}else{
	%>
	<form action="KadaiLogin1Servlet" method="post">
		<h1>IDとPWを入力してください</h1><br>
		ID:<input type="text" name="mail"><br>
		PW:<input type="password" name="pw"><br>
		<input type="submit" value="ログイン">
	</form>
	<%
		}
	%>
</body>
</html>