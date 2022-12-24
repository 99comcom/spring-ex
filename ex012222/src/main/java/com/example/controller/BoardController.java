package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.BoardDAO;
import com.example.domain.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardDAO dao;
	
	@RequestMapping(value="/board/list")
	public String list(Model model){
		model.addAttribute("total", dao.total());
		model.addAttribute("list", dao.list());
		return "/board/list";
	}
	
	@RequestMapping(value="/board/read")
	public String read(Model model, int bno){
		model.addAttribute("vo", dao.read(bno));
		return "/board/read";
	}
	
	@RequestMapping(value="/board/insert")
	public String insert(){
		return "/board/insert";
	}
	
	
	@RequestMapping(value="/board/insert", method=RequestMethod.POST)
	public String insert(BoardVO vo){
		System.out.println(vo.toString());
		dao.insert(vo);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/board/update")
	public String update(Model model, int bno){
		model.addAttribute("vo", dao.read(bno));
		return "/board/update";
	}
	
	@RequestMapping(value="/board/update", method=RequestMethod.POST)
	public String Update(BoardVO vo){
		System.out.println(vo.toString());
		dao.update(vo);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/board/delete", method=RequestMethod.POST)
	public String delete(int bno){
		dao.delete(bno);
		return "redirect:/board/list";
	}
}






