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
	<!-- <script type="text/javascript" src="resources/js/write.js"></script>  -->
</head>
<body>
	<h1>글 수정 화면입니다.</h1>
	<!-- views -->
		<form action="/board/modify" method="post">
	    <div class="form-group row">
	    	<div class="col-sm-12 mb-3 mb-sm-0">
	            <input type="text" value="${detail.bno}" name="bno" class="form-control form-control-user" id="exampleFirstName" placeholder="title" readonly>
	        </div>
	        <div class="col-sm-12 mb-3 mb-sm-0">
	            <input type="text" value="${detail.title}" name="title"class="form-control form-control-user" id="exampleFirstName" placeholder="title">
	        </div>
	        <div class="col-sm-12 mb-3 mb-sm-0">
	            <textarea name="content" cols="30" rows="10" class="form-control form-control-user" id="exampleFirstName" placeholder="content">${detail.content}</textarea>
	        </div>
	        <div class="btn btn-primary btn-user btn-block">
	        	<input type="submit" value="수정하기" class="btn btn-primary btn-user btn-block"> 
	        </div>
	        <div class="btn btn-primary btn-user btn-block">
	        	<input type="submit" value="삭제하기" class="btn btn-primary btn-user btn-block"> 
	        </div>
	    </div>
	    </form>
</body>
</html>