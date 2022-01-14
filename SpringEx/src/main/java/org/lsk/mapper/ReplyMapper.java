package org.lsk.mapper;

import java.util.ArrayList;

import org.lsk.domain.ReplyDTO;

public interface ReplyMapper {
	// 댓글 쓰기 설계
	// indest 성공시 ReplyMapper.xml로부터 1
	// insert 실패시 ReplyMapper.xml로부터 0
	// 값을 리턴받는다.
	public int write(ReplyDTO rdto);
	
	// 댓글 목록 설계
	public ArrayList<ReplyDTO> list(int bno);
	
	// 댓글 수정을 하기 위해 댓글 내용 가져오는 것을 설계
	public ReplyDTO detail(int rno);
	
	// 댓글 수정 설계
	// update 성공시 ReplyMapper.xml로부터 1
	// update 실패시 ReplyMapper.xml로부터 0
	// 값을 리턴받는다.
	public int update(ReplyDTO rdto);

	// 댓글 삭제 설계
	// delete 성공시 ReplyMapper.xml로부터 1
	// delete 실패시 ReplyMapper.xml로부터 0
	// 값을 리턴받는다.
	public int remove(ReplyDTO rdto);
}
