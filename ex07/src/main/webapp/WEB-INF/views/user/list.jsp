<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<title>사용자목록</title>
</head>
<body>
	<h1>사용자목록</h1>
	<table id="tbl" border=1></table>
	<script id="temp" type="text/x-handlebars-template">
	{{#each .}}
		<tr class="row">
			<td>{{uid}}</td>
			<td>{{uname}}</td>
			<td width=50>{{point}}</td>
			<td>
				<a href="/user/read/{{uid}}"><button>보낸 메세지{{sendcnt}}</a>
			</td>
			<td width=30></td>
			<td>
				<a href="/user/read1/{{uid}}"><button>받은 메세지{{receivecnt}}</a>
			<td width=30></td>
			</td>
			
		</tr>
	{{/each}}
</script>
</body>
	<script>
	getList();
	
		function getList(){
			$.ajax({
				type:"get",
				url:"/api/user/list",
				dateType:"json",
				success:function(data){
					var temp=Handlebars.compile($("#temp").html());
					$("#tbl").html(temp(data));
				}
			});
		}
	</script>

</html>