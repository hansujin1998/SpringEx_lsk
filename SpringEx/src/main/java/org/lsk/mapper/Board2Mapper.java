package org.lsk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.lsk.domain.Board2DTO;

public class Board2Mapper {

	@Select("select * from Board2 where bno>0")
	public List<Board2DTO> getList() {
		return null;
	} 
}
