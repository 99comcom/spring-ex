package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.BoardDAO;
import com.example.domain.BoardVO;

@RestController
@RequestMapping("/api")
public class BoardRestController {
	@Autowired
	BoardDAO dao;

	@RequestMapping("/board/list")
	public HashMap<String, Object> list(String word,int page){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("total", dao.total(word));
		map.put("list", dao.list(word,page));
		return map;
	}
	@RequestMapping(value="/board/insert",method=RequestMethod.POST)
	public void insert(@RequestBody BoardVO vo){
		dao.insert(vo);
	}
	
	@RequestMapping(value="/board/update",method=RequestMethod.POST)
	public void update(@RequestBody BoardVO vo){
		dao.update(vo);
	}
	
	@RequestMapping("/board/read/{bno}")
	public BoardVO read(@PathVariable int bno){
		return dao.read(bno);
		
		}
	@RequestMapping(value="/board/delete/{bno}",method=RequestMethod.POST)
	public void delete(@PathVariable int bno){
		dao.delete(bno);
	}
}
