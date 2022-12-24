<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일업로드</h1>
	<form name="frm" method="post" action="/api/user/insert" enctype="multipart/form-data">
	<input type="text" name="uid">
	<hr/>
	<input type="text" name="upass">
	<hr/>
	<input type="text" name="uname">
	<hr/> 
		<input type="file" name="file">
		<button>Upload</button>

	</form>
</body>
<script>
	$(frm).on("submit",function(e){

		e.preventDefault();

		var file=$(frm.file)[0].files[0];
		var formData = new FormData();
		formData.append("file",file);
		formData.append("uid",$(frm.uid).val());
		formData.append("uname",$(frm.uname).val());
		formData.append("upass",$(frm.upass).val());


		$.ajax({	         
			type : "post",
			url:"/api/user/insert",
			processData:false,
			contentType:false,
			data:formData,
			success:function(){
				alert("성공");
			
				location.href="/";
			}
		})
	})
</script>
</html>