<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>게시글 정보</title>
   <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
   <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
   <h1>게시글정보</h1>
   <h3>
      번호: ${bno} 
      조회수: <span id="viewcnt"></span>
      댓글수: <span id="replycnt"></span>
   </h3>
   <hr/>
   <h3>제목: <span id="title"></span></h3>
   <p id="content"></p>
   <a href="/list"><button>목록으로</button></a>
   <hr/>
   <div>
   		<input plaeholder="댓글입력" size=80>
   		<button>등록</button>
   </div>
   <h1>댓글목록</h1>
   <table id="tbl"></table>
      <script id="temp" type="text/x-handlebars-template">

		{{#each.}}
		<tr>
			<td>{{rno}}<td>
			<td>{{content}}<td>
			<button class="delete" rno={{rno}} >삭제</button>
		</tr>
		{{/each}}
   </script>
</body>
<script>
   var bno="${bno}";
   getRead();
   getReplyList();
   
   $("#tbl").on("click",".row .delete", function(){
	   var rno=$(this).attr("rno");
	   if(confirm(rno+"번 댓글을 삭제하실래요?"))return;
	   $.ajax({
		   type:"post",
		   url:"/api/reply/delete/"+rno,
		   success:function(){
			   getRead();
			   getReplyList();
			   alert("삭제성공")
		   }
	   })
   })
   
   function getRead(){
      $.ajax({
         type:"get",
         url:"/api/board/read/" + bno,
         dataType: "json",
         success:function(data){
            $("#title").html(data.title);
            $("#content").html(data.content);
            $("#replycnt").html(data.replycnt);
            $("#viewcnt").html(data.viewcnt);
         }
      });
   }
   
   <script>
	function getReplyList(){
		$.ajax({
			type:"get",
			url:"/api/reply/list",
			datetype:"json",
			success:function(data){
				var temp=Handlebars.compile($("#temp").html())
				$("#tbl").html(temp(data));
			}			
		})
	}
</script>
   
   
</script>   
</html>