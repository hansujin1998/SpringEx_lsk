$(document).ready(
		function() {
			// 댓글 쓰기
			$("#modalRegisterBtn").show();
			// 댓글 수정
			$("#modalModBtn").show();
			// 댓글 삭제
			$("#modalRemoveBtn").show();

			// 댓글쓰기 버튼을 클릭하면
			$("#addReplyBtn").on("click", function() {
				// alert("aa");
				// 댓글 쓰기
				$("#modalRegisterBtn").show();
				// 댓글 수정
				$("#modalModBtn").hide();
				// 댓글 삭제
				$("#modalRemoveBtn").hide();

				$(".modal fade").modal("show");
				// alert("bb");
			})
			// 모딜창을 띄워라
			// console.log(replyService); //다시보여
			var bno = $("#bno").html();
			console.log(bno);

			// detail.jsp가 실행되자마자 댓글목록리스트가 실행되어야함.
			// replyService.getList({bno:bno},function(list){
			// console.log(list)
			// var str="";
			//      
			// for(var i=0;i<list.length;i++){
			// str+= list[i].bno+" "
			// str+= list[i].replyer+" "
			// str+= list[i].reply+"<br>"
			// }
			// $("#relist").html(str);
			// });

			// detail.jsp가 실행되자마자 댓글목록리스트가 실행되어야함.
			showList();

			function showList() {
				replyService.getList({
					bno : bno
				}, function(list) {
					console.log(list)
					var str = "";

					for (var i = 0; i < list.length; i++) {
						str += "<li data-rno='" + list[i].rno + "'><div>"
								+ list[i].bno + "</div>"
						str += "<div><b>" + list[i].replyer + "</b></div>"
						str += "<div>" + list[i].reply + "</div>"
					}
					$("#relist").html(str);
				});
			}

			 
			// 댓글쓰기 버튼을 클릭하면
			$("#modalRegisterBtn").on("click", function() {

				// 사용자가 입력한 댓글내용을 저장
				var reply = $("input[name='reply']").val();
				// 사용자가 입력한 댓글작성자를 저장
				var replyer = $("input[name='replyer']").val();
				// ajax보내고자하는 json타입
				replyService.add({
					reply : reply,
					replyer : replyer,
					bno : bno
				}, function(result) { // 콜백함수 호출
					alert("insert 작업 : " + result)
					// 목록리스트를 처리
					showList();
				});
				// 모달창을 숨겨라
				$(".modal").modal("hide");
			})

			// 댓글내용을 클릭하면(수정 및 삭제를 하기 위해서)
			$("#relist").on("click", "li", function() {
				// rno값을 가져오기
				var rno = $(this).data("rno");

				// alert($("li").data("rno"));
				// 현재는 1만 계속나온다
				alert($(this).data("rno"));
				// 내가 클릭한 li의 data를 가져온다

				replyService.reDetail(rno, function(detail) {

					console.log(detail.replyer)
					console.log(detail.reply)

					// input상자에 value값 삽입
					$("input[name='rno']").val(detail.rno)
					$("input[name='replyer']").val(detail.replyer)
					$("input[name='replyer']").val(detail.reply)

				});

				// modal창 표시
				$(".modal").modal("show");
				// 댓글 쓰기 버튼 비활성화
				$("#modalRegisterBtn").hide();
				// 댓글 수정 버튼 활성화
				$("#modalModBtn").show();
				// 댓글 삭제 버튼 활성화
				$("#modalRemoveBtn").show();

			})

			// 댓글 수정 버튼을 클릭하면
			$("#modalModBtn").on("click", function() {
				// var rno=$("input[name='rno']").val()
				var reply = {
					rno : $("input[name='rno']").val(),
					reply : $("input[name='reply']").val()
				}
				// console.log(rno);
				// 댓글 수정 함수를 호출해서 처리
				replyService.reupdate(reply, function(update) {
					// 콜백영역(update가 정상적으로 처리된 후 조치)
					alert("update 작업 : " + update);
					// 모달창 닫고
					$(".modal").modal("hide");
					// 목록리스트를 실행
					showList();

				})
			})
			
			// 댓글 삭제 버튼을 클릭하면
			$("#modalRemoveBtn").on("click",function(){
				var reply={rno : $("input[name='rno']").val()}
				// 댓글 삭제 함수를 호출해서 처리
				replyService.remove(reply,function(remove){
					// 콜백영역(delete가 정상적으로 처리된 후 조치)
					alert("delete 작업: "+remove);
					// 모달창 닫고
					$(".modal").modal("hide");
					// 목록리스트를 실행
					showList();
				})
			})
			

		})

var replyService = (function() {

	// 댓글쓰기를 하기 위한 함수 선언
	function add(reply, callback) {
		console.log("reply.......");

		$.ajax({
			// url:"/controller/replies/new",
			url : "/replies/new",
			type : "post",
			data : JSON.stringify(reply), // JSON.stringfy : 자바스크립트의 값을 JASON
			// 문자열로 변환
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				// callback함수 선언
				if (callback)
					// 만약 콜백함수가 있으면
					callback(result);

			}, // 통신이 정상적으로 성공했으면
			error : function() {

			} // 통신이 비정상적으로 처리가 되어 error가 있으면
		})
	}

	// 댓글목록리스트를 하기 위한 함수선언
	function getList(param, callback) {
		var bno = param.bno;
		console.log("getList" + bno);
		$.getJSON("/replies/list/" + bno + ".json", function(data) {
			if (callback)
				callback(data);
		})// http://localhost:8080/controller/replies/list/4.json 결과값을 보여준다
	}

	// 댓글수정을 하기 위해 댓글내용 가져오기
	function reDetail(rno, callback) {
		var rno = rno;
		$.getJSON("/replies/" + rno + ".json", function(data) {
			if (callback)
				callback(data);
		})
	}

	// 댓글수정을 하기 위한 함수 선언
	function reupdate(reply, callback) {
		$.ajax({
			url : "/replies/update",
			type : "put",
			data : JSON.stringify(reply), // JSON.stringfy : 자바스크립트의 값을 JASON
											// 문자열로 변환
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				// callback함수 선언
				// 만약 콜백함수가 있으면
				if (callback)
					// callback함수를 호출
					callback(result);

			}, // 통신이 정상적으로 성공했으면
			error : function() {

			} // 통신이 비정상적으로 처리가 되어 error가 있으면
		})
	}

	// 댓글삭제를 하기 위한 함수 선언
	function remove(reply, callback) {
		$.ajax({
			url : "/replies/remove",
			type : "delete",
			data : JSON.stringify(reply), // JSON.stringfy : 자바스크립트의 값을 JASON
											// 문자열로 변환
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				// callback함수 선언
				// 만약 콜백함수가 있으면
				if (callback)
					// callback함수를 호출
					callback(result);

			}, // 통신이 정상적으로 성공했으면
			error : function() {

			} // 통신이 비정상적으로 처리가 되어 error가 있으면
		})
	}
	// return {name:"AAA"};
	return {
		add : add,
		getList : getList,
		reDetail : reDetail,
		reupdate : reupdate,
		remove : remove
	};
})() // 즉시실행 함수
