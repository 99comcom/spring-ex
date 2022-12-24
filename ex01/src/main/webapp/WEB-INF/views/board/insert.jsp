<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board Register</title>
</head>
<body>
	<h1>Board Register</h1>
	<form method="post">
		<input type="text" name="title" size=50>
		<hr/>
		<input type="text" name="writer" value="black">
		<hr>
		<textarea rows="10" cols="50" name="content"></textarea>
		<hr>
		<button type="submit">Register</button>
		<button type="reset">reset</button>
	</form>
</body>
</html>