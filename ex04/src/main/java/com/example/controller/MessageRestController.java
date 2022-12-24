package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.MessageDAO;
import com.example.domain.MessageVO;
import com.example.service.MessageService;

@RestController
@RequestMapping("/api/message")
public class MessageRestController {
	@Autowired
	MessageDAO dao;
	
	@Autowired
	MessageService service;
	
	@RequestMapping("/send/{uid}")
	public List<MessageVO> sendList(@PathVariable String uid){
		return dao.sendList(uid);
	}
	@RequestMapping("/receive/{uid}")
	public List<MessageVO> receiveList(@PathVariable String uid){
		return dao.receiveList(uid);
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void insert(@RequestBody MessageVO vo){
		service.insert(vo);
	}
	//메세지읽기
	@RequestMapping("/read/{mid}")
	public MessageVO read(@PathVariable int mid){
		return service.read(mid);
	}

}
