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
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/list.js"></script>
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
                    	<c:forEach items="${list}" var="board"> <!-- spring의 반복문 태그 -->
	                        <tr>
	                            <td>${board.bno}</td>
	                            <td><a href="/board/detail?bno=${board.bno}">${board.title}</a></td>
	                            <td>${board.writer}</td>
	                            <td>${board.cnt}</td>
	                            <td>${board.regdate}</td>
	                            <td>${board.good}</td>
	                        </tr>
	                	</c:forEach> <!-- forEach 태그의 속성 item(값), var(변수) -->
                    </tbody>
                </table>
                <form id="actionForm" action="/board/list" method="get">
                <div class="form-control bg-light border-0 small">
                	<input name="pageNum" type="hidden" value="${pageMaker.cri.pageNum}">
              	    <input name="amount" type="hidden" value="${pageMaker.cri.amount}">
   		            <select name="search">
	               		<option value="T">제목</option>
	               		<option value="C">내용</option>
	               		<option value="W">작성자</option>
	               		<option value="TC">제목 + 내용</option>
	               		<option value="TCW">제목 + 내용 + 작성자</option>
	               	</select>
	               	<input type="text" name="keyword" value="${pageMaker.cri.keyword}">
	               	<button id="search_button" type="submit" class="btn btn-primary">
	               		<i class="fas fa=search fa-sm">검색</i>
	               	</button>
                </div>
                <div id="dataTable_paginate" class="dataTables_paginate paging_simple_numbers">
               		<ul class="pagination">
               			<c:if test="${pageMaker.prev}">
	                		<li class="paginate_button page-item previous" id="dataTable_previous">
	                			<a href="${pageMaker.startPage-1}" class="page-link">이전</a>
	                		</li>
                		</c:if>
                		<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                			<li class="paginate_button page-item">
                				<a href="${num}" class="page-link">${num}</a>
                			</li>
                		</c:forEach>
                		<c:if test="${pageMaker.next}">
	                		<li class="paginate_button page-item next" id="dataTable_next">
	                			<a href="${pageMaker.endPage+1}" class="page-link">다음</a>
	                		</li>
                		</c:if>
               		</ul>
                </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>