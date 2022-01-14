package org.lsk.service;

import java.util.ArrayList;

import org.lsk.domain.BoardDTO;
import org.lsk.domain.Criteria;
import org.lsk.domain.ReplyDTO;
import org.lsk.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Boardservice의 메서드를 반드시 구현해야함


@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardMapper bmapper;
	
	// 게시판 글쓰기 설계된 것을 구현
	public void write(BoardDTO b) {
		bmapper.write(b);
	}
	
	// 게시판 목록리스트 설계된 것을 구현
	public ArrayList<BoardDTO> list(Criteria cri) {
		// ArrayList 동적배열
		return bmapper.list(cri);
	}
	
	// 게시판 목록리스트에서 제목을 클릭했을 때 내용이 나오는 상세페이지 설계된 것을 구현
	@Transactional 
	// 두개의 메서드를 동시에 실행
	public BoardDTO detail(BoardDTO b) {
		bmapper.cntupdate(b);
		return bmapper.detail(b);
	}
		
	// 게시글 수정하기를 눌렀을 때, 내용이 나오는 상세페이지 설계된 것을 구현
	public void modify(BoardDTO b) {
		bmapper.modify(b);
	}
	
	public void delete(BoardDTO b) {
		bmapper.delete(b);
	}
	
	public int getTotalCount(Criteria cri) {
		return bmapper.getTotalCount(cri);
	};

	
}
