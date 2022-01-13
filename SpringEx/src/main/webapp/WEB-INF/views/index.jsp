<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<body>
GET방식<br><br>

<a href="/sample/member?id=abcd&pw=1234&name=이상국">회원가입</a> <!-- get 방식 -->
<form action="/sample/memberDTO" method="get"> <!-- form은 button이 필요하다. -->
	<div>id:<input type="text" name="id"></div> <!-- name (변수) value (초기값) -->
	<div>pw:<input type="password" name="pw"></div>
	<div>name:<input type="text" name="name"></div>
	<input type="submit" value="회원가입">
</form>"src/main/webapp/WEB-INF/views/member.jsp"
<hr>
POST방식<br><br>

<form action="/sample/memberDTO" method="post"> <!-- form은 button이 필요하다. -->
	<div>id:<input type="text" name="id"></div> <!-- name (변수) value (초기값) -->
	<div>pw:<input type="password" name="pw"></div>
	<div>name:<input type="text" name="name"></div>
	<input type="submit" value="회원가입">
</form>

<p>localhost:8080/서버주소</p>

${xxxx}
</body>
</html>