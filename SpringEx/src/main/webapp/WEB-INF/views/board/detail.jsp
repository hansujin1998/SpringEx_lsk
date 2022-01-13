<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../resources/css/all.css">
	<link rel="stylesheet" type="text/css" href="../resources/css/sb-admin-2.css">
	<link rel="stylesheet" type="text/css" href="../resources/css/dataTables.bootstrap4.css">
	<link href="../resources/css/font-awesome.css" rel="stylesheet" type="text/css">
	<link href="../resources/css/metisMenu.css" rel="stylesheet">
	<link href="../resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<!-- views -->
		<h1>상세 게시판</h1>
	    <div class="form-group row">
	    <!-- <input type="text" id="aaa" value="${detail.bno}"> -->
	    	<div id="bno" class="col-sm-12 mb-3 mb-sm-0">${detail.bno}</div>
	        <div class="col-sm-12 mb-3 mb-sm-0">
	           ${detail.title}
	        </div>
	        <div class="col-sm-12 mb-3 mb-sm-0">
	           ${detail.content}
	        </div>
	        <div class="btn btn-primary btn-user btn-block">
	        	<a href="/board/modify?bno=${detail.bno}">수정</a>
	        </div>
	        <div class="btn btn-primary btn-user btn-block">
	        	<a href="/board/delete?bno=${detail.bno}">삭제</a>
	        </div>
	    </div>
        <div class="panel-body">
                <!-- Button trigger modal -->
               <button id="addReplyBtn" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                           	댓글쓰기
               </button>
               
               
               <div>
               		<ul id="reList"></ul>
               </div>
               
               
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	              	<div class="modal-dialog">
		                   <div class="modal-content">
		                       <div class="modal-header">
		                           <h4 class="modal-title" id="myModalLabel">댓글</h4>
		                       </div>
		                       <div class="modal-body">
		                       		<div>
										<label>작성자</label>
										<input type="text" name="reply">
									</div>
									<div>
										<label>내용 쓰기</label>
										<input type="text" name="replyer">
									</div>
		                       </div>
		                       <div class="modal-footer">
		                       	   <button type="button" class="btn btn-primary">수정하기</button>
		                           <button type="button" class="btn btn-primary">삭제하기</button>
		                           <button type="button" id="modalRegisterBtn" class="btn btn-primary">댓글 쓰기</button>
		                           <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
		                       </div>
		                   </div>
		                   <!-- /.modal-content -->
		              </div>
		              <!-- /.modal-dialog -->
		          </div>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/detail.js"></script>
    <script type="text/javascript" src="../resources/js/bootstrap.js"></script>
    <script type="text/javascript" src="../resources/js/sb-admin-2.js"></script>
    <script type="text/javascript" src="../resources/js/metisMenu.js"></script>             
</body>
</html>