package org.lsk.service;

import java.util.ArrayList;

import org.lsk.domain.ReplyDTO;
import org.lsk.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyMapper rmapper;
	public int write(ReplyDTO rdto) {
		return rmapper.write(rdto);
	}
	
	public ArrayList<ReplyDTO> list(int bno) {
		return rmapper.list(bno);
	}

	@Override
	public ReplyDTO detail(int rno) {
		// TODO Auto-generated method stub
		return rmapper.detail(rno);
	}

	@Override // 댓글수정 설계된 것을 구현
	public int update(ReplyDTO rdto) {
		// TODO Auto-generated method stub
		return rmapper.update(rdto);
	}

	@Override // 댓글삭제 설계된 것을 구현
	public int remove(ReplyDTO rdto) {
		// TODO Auto-generated method stub
		return rmapper.remove(rdto);
	};
	
}
