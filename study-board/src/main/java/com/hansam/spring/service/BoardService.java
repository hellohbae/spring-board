package com.hansam.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hansam.spring.domain.BoardVO;
import com.hansam.spring.mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	BoardMapper mBoardMapper;
	
	public int boardCountService() throws Exception{
		return mBoardMapper.boardCount();
	}
	
	public List<BoardVO> boardListService() throws Exception{
		return mBoardMapper.boardList();
	}
	
	public BoardVO boardDetailService(int bno) throws Exception{
		return mBoardMapper.boardDetail(bno);
	}
	
	public void boardInsertService(BoardVO board) throws Exception{
		mBoardMapper.boardInsert(board);
	}
	
	public void boardUpdateService(BoardVO board) throws Exception{
		mBoardMapper.boardUpdate(board);
	}
	
	public void boardDeleteService(int bno) throws Exception{
		mBoardMapper.boardDelete(bno);
	}
}
