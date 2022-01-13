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
	};
}
