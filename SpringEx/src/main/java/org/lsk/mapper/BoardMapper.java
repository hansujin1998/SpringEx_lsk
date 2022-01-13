package org.lsk.mapper;

import java.util.ArrayList;

import org.lsk.domain.BoardDTO;
import org.lsk.domain.Criteria;

public interface BoardMapper {
	// 게시판 글쓰기와 관련이 되어 있는 DB작업 설계 
	public void write(BoardDTO b);
	
	// 게시판 목록리스트와 관련이 되어 있는 DB작업 설계
	public ArrayList<BoardDTO> list(Criteria cri);
	
	// 게시판 목록리스트에서 제목을 클릭했을 때 내용이 나오는 상세페이지와 관련 되어 있는 DB작업 설계
	public BoardDTO detail(BoardDTO b);
	
	public void cntupdate(BoardDTO b);
	
	// 게시판 글 수정과 관련이 되어 있는 DB작업 설계
	public void modify(BoardDTO b);
	
	// 게시글 삭제와 관련 있는 DB작업 설계
	public void delete(BoardDTO b);
	
	public int getTotalCount(Criteria cri);
}
