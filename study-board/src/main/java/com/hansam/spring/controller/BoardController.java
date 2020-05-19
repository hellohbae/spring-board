package com.hansam.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hansam.spring.domain.BoardVO;
import com.hansam.spring.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService mBoardService;
	
	@GetMapping("/test")
	public String testview() throws Exception {

		return "test2";
	}


	@GetMapping("/list")
	public String boardList(Model model) throws Exception {
		model.addAttribute("list", mBoardService.boardListService());

		return "list";
	}

	@GetMapping("/detail/{bno}")
	public String boardDetail(@PathVariable int bno, Model model) throws Exception {
		model.addAttribute("detail", mBoardService.boardDetailService(bno));

		return "detail";
	}

	@GetMapping("/insert")
	public String boardInsertForm() {
		return "insert";
	}

	@PostMapping("/insertProc")
	public String boardInsertProc(HttpServletRequest request) throws Exception {
		BoardVO board = new BoardVO();

		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setWriter(request.getParameter("writer"));

		mBoardService.boardInsertService(board);

		return "redirect:/list";
	}

	@GetMapping("/update/{bno}")
	public String boardUpdateForm(@PathVariable int bno, Model model) throws Exception {
		model.addAttribute("detail", mBoardService.boardDetailService(bno));

		return "update";
	}

	@PostMapping("/updateProc")
	public String boardUpdateProc(HttpServletRequest request) throws Exception {
		BoardVO board = new BoardVO();
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setBno(Integer.parseInt(request.getParameter("bno")));

		mBoardService.boardUpdateService(board);

		return "redirect:/detail/" + request.getParameter("bno");
	}

	@GetMapping("/delete/{bno}")
	public String boardDelete(@PathVariable int bno) throws Exception {
		mBoardService.boardDeleteService(bno);

		return "redirect:/list";
	}
}
