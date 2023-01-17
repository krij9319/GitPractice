<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kadaidto.Kadai1dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員一覧</title>
</head>
<body>
	<h1>一覧表示</h1>
	<table border="3" style="width: 700px">
		<tr>
			<th>名前:</th>
			<th>年齢:</th>
			<th>性別:</th>
			<th>電話番号:</th>
			<th>メール:</th>
		</tr>
		<%
		List<Kadai1dto> list = (ArrayList<Kadai1dto>)request.getAttribute("ka1");
		for(Kadai1dto ka1 : list){
		%>
		<tr>
			<td><%=ka1.getName() %></td>
			<td><%=ka1.getAge() %></td>
			<td><%=ka1.getGender() %></td>
			<td><%=ka1.getPhototel() %></td>
			<td><%=ka1.getMail() %></td>
		</tr>
		<%
		}
		%>
	</table>
	<a href="./">トップページ</a>
</body>
</html>