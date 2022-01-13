package org.lsk.service;
// 전달

import java.util.ArrayList;

import org.lsk.domain.BoardDTO;
import org.lsk.domain.Criteria;

public interface BoardService {
	// 게시판 글쓰기
	public void write(BoardDTO b);
	
	// 게시판 목록 리스트
	public ArrayList<BoardDTO> list(Criteria cri);
	
	// 게시판 상세페이지
	public BoardDTO detail(BoardDTO b);
	
	// 게시판 수정페이지
	public void modify(BoardDTO b);
	
	// 게시판 삭제페이지
	public void delete(BoardDTO b);
	
	// 게시판 글 작성 수
	public int getTotalCount(Criteria cri);
}
