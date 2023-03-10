<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시판 목록</title>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<h1>상품정보</h1>
	<div id="shop"></div>
	<script id="temp" type="text/x-handlebars-template">
        <div><img src="/api/display?fileName={{image}}" width=100></div>
		<h3>{{code}} : {{title}}</h3>
	</script>
	<hr>
	<div id="attach"></div>
	<script id="temp1" type="text/x-handlebars-template">
		{{#each .}}
			<a href="{{id}}" image="{{image}}">x</a>
			<img src="/api/display?fileName={{image}}" width=200>
			
		{{/each}}
	</script>
	<hr>
	<form name="frm">
	<input type="file" name="files" multiple>
	<button>파일 업로드</button>	
	</form>
</body>
<script>
	var code="${code}"
		getRead();
	$("#attach").on("click","a",function(e){
		e.preventDefault();
		var id=$(this).attr("href");
		var image=$(this).attr("image");
		alert(id+image)
		$.ajax({
			type:"post",
			url:"/api/shop/delAttach",
			data:{id:id,image:image},
			success:function(){
				alert(" 성공")
				getRead();
			}
		})
	})
	$(frm).on("submit",function(e){
		e.preventDefault();
		if(!confirm('첨부파일을 모두 업로드 하시겠습니까?'))return;
		var formData=new FormData();
		formData.append("code",code);
		
		var files=$(frm.files)[0].files;
		for(var i=0;i<files.length; i++){
			formData.append("files",files[i]);
		}
		$.ajax({
			type:"post",
			url:"/api/shop/attach",
			data:formData,
			processData:false,
			contentType:false,
			success:function(){
				alert("등록꾸")
				getRead();
			}
			
		})
	})
	
	
	function getRead(){
		$.ajax({
			type:"get",
			url:"/api/shop/read/"+code,
			success:function(data){
				var temp=Handlebars.compile($("#temp").html());
				$("#shop").html(temp(data.shop));
				
				var temp=Handlebars.compile($("#temp1").html());
				$("#attach").html(temp1(data.attach));
			}
		});
	}
</script>
</html>