<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../resources/css/sb-admin-2.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/all.css">
    <link rel="stylesheet" href="../resources/css/dataTables.bootstrap4.css">
    <!-- Custom styles for this page -->
    
<title>Insert title here</title>
</head>
<body>
<!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
        <h1>게시판 목록 리스트</h1>
            <!-- <h6 class="m-0 font-weight-bold text-primary">게시판 목록 리스트</h6> -->
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>게시판 번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>조회수</th>
                            <th>작성일</th>
                            <th>좋아요</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>게시판 번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>조회수</th>
                            <th>작성일</th>
                            <th>좋아요</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <c:forEach items="${list}" var="test"> <!-- spring의 반복문 태그 -->
	                        <tr>
	                            <td>${test.bno}</td>
	                            <td>${test.title}</td>
	                            <td>${test.writer}</td>
	                            <td>${test.cnt}</td>
	                            <td>${test.regdate}</td>
	                            <td>${test.good}</td>
	                        </tr>
	                    </c:forEach> <!-- forEach 태그의 속성 item(값), var(변수) -->
                    </tbody>
                </table>
                        <!--<c:forEach items="${list}" var="test"> <!-- spring의 반복문 태그 -->
	                	<!--</c:forEach> <!-- forEach 태그의 속성 item(값), var(변수) -->
            </div>
        </div>
    </div>
</body>
</html>