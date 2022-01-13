package org.lsk.service;

import java.util.ArrayList;

import org.lsk.domain.BoardDTO;
import org.lsk.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{
	@Autowired
	private TestMapper tmapper;
	
	public void write(BoardDTO b) {
		tmapper.write(b);
	}
	
	public BoardDTO list() {
		return tmapper.list();
	}
	
}
