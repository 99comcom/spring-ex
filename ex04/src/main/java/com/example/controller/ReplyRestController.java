package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ReplyDAO;
import com.example.domain.ReplyVO;
import com.example.service.ReplyService;

@RestController
@RequestMapping("/api/reply")

public class ReplyRestController {
	@Autowired
	ReplyDAO dao;
	
	@Autowired
	ReplyService service;
	
	@RequestMapping("/list/{bno}")
	public HashMap<String,Object> list(@PathVariable int bno) {
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("total", dao.total(bno));
		map.put("list",dao.list(bno));
		return map;
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void insert(@PathVariable ReplyVO vo){
		service.insert(vo);
	}
	
	@RequestMapping(value="/delete/{rno}",method=RequestMethod.POST)
	public void delete(@PathVariable int rno){
		service.delete(rno);
	}
	

}
