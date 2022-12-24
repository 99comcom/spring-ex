package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserDAO;
import com.example.domain.UserVO;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
	@Autowired
	UserDAO dao;
	
	@RequestMapping("/list")
	public List<UserVO> list(){
		return dao.list();
	}
	@RequestMapping("/read/{uid}")
	public UserVO read(@PathVariable String uid){
		return dao.read(uid);
	}
}
