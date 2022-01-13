package org.lsk.mapper;

import org.lsk.domain.BoardDTO;

public interface TestMapper {
	
	public void write(BoardDTO b);
	
	public BoardDTO list();
}
