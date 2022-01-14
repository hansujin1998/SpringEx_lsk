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
<link href="../resources/css/sb-admin-2.css" rel="stylesheet"
	type="text/css">
<link href="../resources/css/all.css" rel="stylesheet" type="text/css">
<link href="../resources/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="../resources/css/metisMenu.css" rel="stylesheet"
	type="text/css">
<link href="../resources/css/font-awesome.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../resources/js/bootstrap.js" type="text/javascript"></script>
<script src="../resources/js/metisMenu.js" type="text/javascript"></script>
<script src="../resources/js/sb-admin-2.js" type="text/javascript"></script>
<script src="../resources/js/detail.js" type="text/javascript"></script>
</head>
<body>
	<div class="form-group row">
		<!-- <input type="text" id="aaa" value="${datail.bno}"> -->
		<!-- bno의 값을 가져올때 공백이 있으면 띄워쓰기가 들어가져있다 -->
		<div id="bno" class="col-sm-12 mb-3 mb-sm-0">${detail.bno}</div>
		<div class="col-sm-12 mb-3 mb-sm-0">${detail.title}</div>

		<div class="col-sm-12 mb-3 mb-sm-0">${detail.content}</div>
		<div class="col-sm-12 mb-3 mb-sm-0">
			<a href="modify?bno=${detail.bno}">수정</a> <a
				href="remove?bno=${detail.bno}">삭제</a>
		</div>
		<!-- .panel-body -->
		<div class="panel-body">
			<!-- Button trigger modal -->
			<button id="addReplyBtn" class="btn btn-primary btn-lg"
				data-toggle="modal" data-target="#myModal">댓글달기</button>

			<div>
				<ul id="relist">

				</ul>
			</div>

			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">댓글</h4>
						</div>
						<div class="modal-body">
							<div>
								<input type="text" name="rno" class="form-control">
							</div>
							<div>
								<label>Replyer</label> <input type="text" name="replyer">
							</div>
							<div>
								<label>Reply</label> <input type="text" name="reply">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">닫기</button>
							<button type="button" class="btn btn-primary"
								id="modalRegisterBtn">댓글쓰기</button>
							<button type="button" class="btn btn-primary" id="modalModBtn">댓글수정</button>
							<button type="button" class="btn btn-primary" id="modalRemoveBtn">댓글삭제</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
		</div>
		<!-- /.panel-body -->




	</div>
</body>
</html>