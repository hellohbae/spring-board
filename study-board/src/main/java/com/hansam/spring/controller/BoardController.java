package com.hansam.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hansam.spring.domain.BoardVO;
import com.hansam.spring.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService mBoardService;
	
	@GetMapping("/list")
	public String boardList(Model model) throws Exception{
		model.addAttribute("list", mBoardService.boardListService());
		
		return "list";
	}
	
	@GetMapping("/detail/{bno}")
	public String boardDetail(@PathVariable int bno, Model model) throws Exception{
		model.addAttribute("detail", mBoardService.boardDetailService(bno));
		
		return "detail";
	}
	
	@GetMapping("/insert")
	public String boardInsertForm(){
		return "insert";
	}
	
	@GetMapping("/insertProc")
	public String boardInsertProc(HttpServletRequest request) throws Exception{
		BoardVO board = (BoardVO) request.getParameterMap();
		
		mBoardService.boardInsertService(board);
		
		return "redirect:/list";
	}
	
	@GetMapping("/update/{bno}")
	public String boardUpdateForm(@PathVariable int bno, Model model) throws Exception{
		model.addAttribute("detail", mBoardService.boardDetailService(bno));
		
		return "update";
	}
	
	@GetMapping("/updateProc")
	public String boardUpdateProc(HttpServletRequest request) throws Exception{
		BoardVO board = (BoardVO)request.getParameterMap();
		mBoardService.boardUpdateService(board);
		
		return "redirect://detail/"+board.getBno();
	}
	
	@GetMapping("/delete/{bno}")
	public String boardDelete(@PathVariable int bno) throws Exception{
		mBoardService.boardDeleteService(bno);
		
		return "redirect:/list";
	}
}
