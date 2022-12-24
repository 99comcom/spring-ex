<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Board Infomation</title>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
	<h1>Board Infomation</h1>
	<h3>${vo.bno}: ${vo.title}</h3>
	<h3>${vo.regDate}</h3>
	<p>${vo.content}</p>
	<hr>
	<button id="update">수정</button>
	<button id="list">목록</button>
</body>
<script>
	$("#list").on("click", function(){
		location.href="/board/list";
	});
	
	$("#update").on("click", function(){
		location.href="/board/update?bno=" + ${vo.bno}
	});
</script>	
</html>