$(document).ready(function(){
   //댓글 쓰기
   $("#modalRegisterBtn").show();
   //댓글 수정
   $("#modalModBtn").show();
   //댓글 삭제
   $("#modalRemoveBtn").show();
   
   //댓글쓰기 버튼을 클릭하면
   $("#addReplyBtn").on("click",function(){
      //alert("aa");
      //댓글쓰기
      $("#modalRegisterBtn").show();
      //댓글 수정
      $("#modalModBtn").hide();
      //댓글 삭제
      $("#modalRemoveBtn").hide();
      
      $(".modal fade").modal("show");
      //alert("bb");
   })
   //모딜창을 띄워라
   //console.log(replyService); //다시보여
   var bno= $("#bno").html();
   console.log(bno);
   
   //detail.jsp가 실행되자마자 댓글목록리스트가 실행되어야함.
//   replyService.getList({bno:bno},function(list){
//      console.log(list)
//      var str="";
//      
//      for(var i=0;i<list.length;i++){
//         str+= list[i].bno+"  "   
//         str+= list[i].replyer+"  "
//         str+= list[i].reply+"<br>"   
//      }
//      $("#relist").html(str);
//   });
   
   //detail.jsp가 실행되자마자 댓글목록리스트가 실행되어야함.
   showList();
   
   function showList(){
      replyService.getList({bno:bno},function(list){
         console.log(list)
         var str="";
         
         for(var i=0;i<list.length;i++){
            str+= "<li><div>"+list[i].bno+"</div>"   
            str+= "<div><b>"+list[i].replyer+"</b></div>"
            str+= "<div>"+list[i].reply+"</div>"   
         }
         $("#relist").html(str);
      });
   }
   //댓글쓰기 버튼을 클릭하면
   $("#modalRegisterBtn").on("click",function(){
      
      //사용자가 입력한 댓글내용을 저장
      var reply = $("input[name='reply']").val();
      //사용자가 입력한 댓글작성자를 저장
      var replyer = $("input[name='replyer']").val();
      //              ajax보내고자하는 json타입                                ,callback함수호출
      replyService.add({reply:reply,replyer:replyer,bno:bno},
                  function(result){
                     alert("insert 작업 : "+result)
                     //목록리스트를 처리
                     showList();
                  });
      //모달창을 숨겨라
      $(".modal").modal("hide");
   })
   
   // 댓글내용을 클릭하면(수정 및 삭제를 하기 위해서)
   $("#relist").on("click",function(){
	   
	   replyService.reDetail(4,function(detail){
		   
		   console.log(detail.replyer)
		   console.log(detail.reply)
		   
		   $("input[name='replyer']").val(detail.replyer)
		   $("input[name='reply']").val(detail.reply)
		   
	   });
	   
      //modal창 표시
      $(".modal").modal("show");
      //댓글 쓰기 버튼 비활성화
      $("#modalRegisterBtn").hide();
      //댓글 수정 버튼 활성화
      $("#modalModBtn").show();
      //댓글 삭제 버튼 활성화
      $("#modalRemoveBtn").show();
      
   })
   
   
   
   
})

var replyService=(function(){
   
   //댓글쓰기를 하기 위한 함수 선언
   function add(reply,callback){
      console.log("reply.......");
       
      $.ajax({
      //url:"/controller/replies/new",
      url:"/replies/new",
      type:"post",
      data:JSON.stringify(reply), // JSON.stringfy : 자바스크립트의 값을 JASON 문자열로 변환
        contentType:"application/json; charset=utf-8",
        success:function(result){
           //callback함수 선언
           if(callback)
              //만약 콜백함수가 있으면
              callback(result);
           
        },   //통신이 정상적으로 성공했으면
        error:function(){
           
        }      //통신이 비정상적으로 처리가 되어 error가 있으면
     })
   }
   //댓글목록리스트를 하기 위한 함수선언
   function getList(param,callback){
      var bno=param.bno;
      console.log("getList"+bno);
      $.getJSON("/replies/list/"+bno+".json",
            function(data){
               if(callback)
                  callback(data);      
            })//http://localhost:8080/controller/replies/list/4.json 결과값을 보여준다
   }
   
   //댓글수정을 하기 위해 댓글내용 가져오기
   function reDetail(rno,callback){
	  $.getJSON(
			  "/replies/"+rno+".json",
			  function(data){
				  if(callback)
					  callback(data);
			  })
   }
   
   
   //댓글수정을 하기 위한 함수 선언

   
   //댓글삭제를 하기 위한 함수 선언
   
   
   
   
   
   // return {name:"AAA"};
   return {
      add:add,
      getList:getList,
      reDetail:reDetail
         };
})()