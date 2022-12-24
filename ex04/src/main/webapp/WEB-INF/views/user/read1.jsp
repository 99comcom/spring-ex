<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<title>사용자정보</title>
</head>
<body>
	<h1>받은 메세지</h1>
		<h4 width=100>아이디 : ${uid}</h4>
		<h4>이  름  :  
		<span id="uname"></span></h4>
		<h4>포인트 :  
		<span id="point"></span></h4>
		<h4>받은메세지 :  
		<span id="receivecnt"></span></h4>
		<h4>보낸메세지 :  
		<span id="sendcnt"></span></h4>

	
	<hr/>
	<a href="/user/list"><button>목록</button></a>
</body>
<script>
	var uid="${uid}";
	$.ajax({
		type:"get",
		url:"/api/user/read/"+uid,
		success:function(data){
			$("#uname").html(data.uname);
			$("#point").html(data.point);
			$("#receivecnt").html(data.receivecnt);
			$("#sendcnt").html(data.sendcnt);
		}
	})
</script>
</html>