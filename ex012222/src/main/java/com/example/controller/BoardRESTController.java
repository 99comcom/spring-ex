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
public class BoardRESTController {
	@Autowired
	BoardDAO dao;
	
	@RequestMapping("/board/list")
	public HashMap<String, Object> list(int page, String word){
		HashMap<String, Object> map=new HashMap();
		map.put("total", dao.scount(word));
		map.put("list", dao.slist(page,word));
		return map;
	}
	
	@RequestMapping("/board/read/{bno}")
	public BoardVO read(@PathVariable int bno){
		return dao.read(bno);
	}
	
	@RequestMapping(value="/board/insert", method=RequestMethod.POST)
	public void insert(@RequestBody BoardVO vo){
		dao.insert(vo);
	}
	
	@RequestMapping(value="/board/update", method=RequestMethod.POST)
	public void update(@RequestBody BoardVO vo){
		dao.update(vo);
	}
	
	@RequestMapping(value="/board/delete/{bno}", method=RequestMethod.POST)
	public void delete(@PathVariable int bno){
		dao.delete(bno);
	}
}
