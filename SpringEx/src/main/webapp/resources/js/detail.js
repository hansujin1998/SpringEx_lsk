/**
 * 
 */

$(document).ready(function(){
	$("#addReplyBtn").on("click",function(e){
		alert("버튼 클릭 확인");
//		$(".modal").Modal("show");
	})
//	console.log(replyService); // 함수 호출
//	댓글 쓰기 버튼을 클릭하면
	let bno=$("#bno").html();
	
	showList(); // detail.jsp가 실행되면 댓글 목록리스트가 실행되어야 함.
	
	function showList(){
		replyService.getList({bno:bno}, function(list){
			
			console.log(list);
			let str = "";
			
			for(let i=0; i<list.length; i++){
				str += "<li><div>"+list[i].reply+"</div>"
				str += list[i].replyer+"</div>"
				str += "</li><br>"
			}
			
			$("#reList").html(str);
		});
	}
	
	
	$("#modalRegisterBtn").on("click",function(){
		// 사용자가 입력한 댓글 내용을 저장
		let reply=$("input[name='reply']").val()
		// 사용자가 입력한 댓글 작성자를 저장
		let replyer=$("input[name='replyer']").val()
		
		
					// ajax에 보내고자 하는 json 타입, callback 함수 호출
		replyService.add({reply:reply,replyer:replyer,bno:bno},
				function(result){alert("insert 작업 : "+result);
										showList();
										}
				// 목록리스트를 처리
				
		);
		$(".modal").modal("hide");
		
	})
	
	
})

	let replyService=(function(){ // replyService 함수 선언
		
		// 댓글 쓰기를 위한 함수 선언
		function add(reply,callback){
			console.log("reply변수가 들어간 add함수");
			$.ajax({
				url:"/replies/new",
				type:"post",
				data:JSON.stringify(reply), // JSON.stringfy : 자바스크립트의 값을 JASON 문자열로 변환
				contentType:"application/json; charset=utf-8",
				success:function(result){
					// callback 함수가 있다면 호출하라
					if(callback)
						callback(result);
				},
				error:function(){}
			})
		}
		
		
		// 댓글 목록 리스트 함수 선언 // Type이 get일때만 사용할 수 있다. ($getJSON)
		function getList(param,callback){
			let bno = param.bno;
			console.log(bno);
			$.getJSON("/replies/list/"+bno+".json",
					function(data){
				if(callback)
					callback(data);
			}) // http://localhost:8080/replies/list/1.json의 데이터가 data 안에 들어가 있음
		}
		
		// 댓글 수정을 위한 함수 선언
		
		// 댓글 삭제를 위한 함수 선언
		

		return {
				add:add,
				getList:getList
				
				}; // bbb = 호출부,  add = 선언부 함수
		
	})()


/*
 * var aaa={"mno":100,"firstName":"이",:"lastName":"상국"}
 * 
 *  $.ajax({
	url:"서버주소",
	type:"get/post/put/delete"
	data:JSON.stringfy({변수:"값", 변수:"값", 변수:"값"})
	contentType:"application/json; charset=utf-8"
	success:function(){},
	error:function(){}
 */