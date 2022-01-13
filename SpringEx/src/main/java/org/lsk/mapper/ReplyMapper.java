package org.lsk.mapper;

import java.util.ArrayList;

import org.lsk.domain.ReplyDTO;

public interface ReplyMapper {
	// 댓글 쓰기 설계
	public int write(ReplyDTO rdto);
	
	// 댓글 목록 설계
	public ArrayList<ReplyDTO> list(int bno);
}
