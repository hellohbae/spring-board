package com.hansam.spring.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hansam.spring.domain.BoardVO;

@Repository("com.hansam.spring.mapper.BoardMapper")
public interface BoardMapper {
	
	public int boardCount()	throws Exception;
	
	public List<BoardVO> boardList() throws Exception;
	
	public BoardVO boardDetail(int bno) throws Exception;
	
	public void boardInsert(BoardVO board) throws Exception;
	
	public void boardUpdate(BoardVO board) throws Exception;
	
	public void boardDelete(int bno) throws Exception;
}
