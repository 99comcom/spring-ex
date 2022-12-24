package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ShopDAO;
import com.example.domain.ShopVO;

@RestController
@RequestMapping("/api/shop")
public class ShopRestController {
	@Autowired
	ShopDAO dao;

	@RequestMapping("/list")
	public List<ShopVO> list(){
		return dao.list();
	}
	
}
