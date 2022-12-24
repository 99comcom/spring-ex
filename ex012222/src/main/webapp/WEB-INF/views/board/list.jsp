<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Board List</title>
</head>
<body>
	<h1>Board List</h1>
	<a href="/board/insert">Register</a>
	<span>글수: ${total}</span>
	<table border=1 width=500>
		<c:forEach items="${list}" var="vo">
		<tr>
			<td>${vo.bno}</td>
			<td><a href="/board/read?bno=${vo.bno}">${vo.title}</a></td>
			<td>${vo.writer}</td>
			<td><fmt:formatDate value="${vo.regDate}" pattern="yyyy년MM월dd일 HH:mm:ss"/></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>