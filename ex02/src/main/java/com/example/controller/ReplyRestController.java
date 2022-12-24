package com.example.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ReplyDAO;
import com.example.domain.BoardVO;
import com.example.domain.ReplyVO;
import com.example.domain.UserVO;


@RestController
@RequestMapping("/api")
public class ReplyRestController {
	@Autowired
	ReplyDAO dao;

	@RequestMapping("/reply/list/{bno}")
	public HashMap<String, Object> list(@PathVariable int bno, int page, int num){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("total", dao.total(bno));
		map.put("list", dao.list(bno, page, num));
		return map;
	}
	

	
	@RequestMapping(value="/reply/insert", method=RequestMethod.POST)
	public void insert(@RequestBody ReplyVO vo){
		dao.insert(vo);
	}
	@RequestMapping(value="/reply/update", method=RequestMethod.POST)
	public void update(@RequestBody ReplyVO vo){
		dao.update(vo);
	}
	@RequestMapping(value="/reply/delete/{rno}", method=RequestMethod.POST)
	public void delete(@RequestBody int rno){
		dao.delete(rno);
	}
}
