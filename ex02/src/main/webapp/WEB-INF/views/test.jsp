<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>

<!-- jQuery 2.1.4 -->
<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script>
	var bno = 1344;
	
	function getAllList() {
		$.getJSON("/replies/all/" + bno, function(data) {
			console.log(data.length);
			
			var str = "";
			
			$(data).each(function() {
				str += "<li data-rno='"+this.rno+"' class='replyLi'>" + this.rno + ":" + this.replytext + "</li>";
			});
			
			$("#replies").html(str);
		});
	}
	/* 	
	$("#btnn").on("click", function() {
		alert("클릭!!!");
	});
	*/
	/* 
	$( document ).ready(function() {
		$('#btnn').click(function(){
			alert("Dddd");
		});
	});
	*/
	$(document).ready(function() {		// 책에 없는거 추가해줌(없으니까 안됨-이유 몰라...)
		$("#replyAddBtn").on("click", function() {
			var replyer = $("#newReplyWriter").val();
			var replytext = $("#newReplyText").val();
	
			$.ajax({
				type : "post",
				url : "/replies",
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : "text",
				data : JSON.stringify({
					bno : bno,
					replyer : replyer,
					replytext : replytext
				}),
				success : function(result) {
					if(result == "SUCCESS") {
						alert("등록 되었습니다.");
						getAllList();
					}
				}
			});
		});
	});
</script>

<html>
<head>
	<title>Home</title>
</head>
<body>
	<h2>Ajax Test Page</h2>
	
	<div>
		<div>
			REPLYER <input type="text" name="replyer" id="newReplyWriter">
		</div>
		<div>
			REPLY TEXT <input type="text" name="replytext" id="newReplyText">
		</div>
		<button id="replyAddBtn">ADD REPLY</button>
		<button id="btnn">btnn</button>
	</div>
	
	<ul id="replies">
	</ul>
	
</body>
</html>
