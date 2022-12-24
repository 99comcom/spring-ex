<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Board Register</title>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
	<h1>Board Modify</h1>
	<form method="post" name="frm">
		<input type="hidden" name="bno" value="${vo.bno}">
		<input type="text" name="title" size=50 value="${vo.title}">
		<hr>
		<input type="text" name="writer" value="black" readonly>
		<hr>
		<textarea rows="10" cols="50" name="content">${vo.content}</textarea>
		<hr>
		<button type="submit" id="update">Modify</button>
		<button type="button" id="delete">Delete</button>
		<button type="reset">Reset</button>
		<button type="button" id="list">List</button>
	</form>
</body>
<script>
	$("#list").on("click", function(){
		location.href="/board/list";
	});
	
	$("#update").on("click",function(e){
		e.preventDefault();
		if(!confirm("수정하실래요?")) return;
		frm.action="/board/update";
		frm.method="post";
		frm.submit();
	});
	
	$("#delete").on("click", function(){
		if(!confirm("삭제하실래요?")) return;
		frm.action="/board/delete";
		frm.method="post";
		frm.submit();
	})
</script>
</html>