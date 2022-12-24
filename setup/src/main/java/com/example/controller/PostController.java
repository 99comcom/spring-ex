package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dao.BoardDAO;

@Controller
public class PostController {
	@Autowired
	BoardDAO dao;
	@RequestMapping(value="/posts")
	public String list(Model model){
		model.addAttribute("list",dao.list());
		return"/post/posts";
	}
}
