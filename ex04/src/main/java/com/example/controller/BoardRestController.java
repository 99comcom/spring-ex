package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.BoardDAO;
import com.example.domain.BoardVO;
import com.example.service.BoardService;

@RestController
@RequestMapping("/api")
public class BoardRestController {
	@Autowired
	BoardDAO dao;

	 @Autowired
	 BoardService service;
	
	
	@RequestMapping("/board/list")
	public List<BoardVO> list(){
		return dao.list();
	}

	
	@RequestMapping("/board/read/{bno}")
	public BoardVO read(@PathVariable int bno){
		return dao.read(bno);
		
		}


}
