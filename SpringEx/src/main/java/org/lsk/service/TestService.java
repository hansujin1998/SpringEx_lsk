package org.lsk.service;

import org.lsk.domain.BoardDTO;

public interface TestService {
	
	public void write(BoardDTO b);
	
	public BoardDTO list();
}
