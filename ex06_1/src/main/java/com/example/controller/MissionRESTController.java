package com.example.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.dao.MissionDAO;
import com.example.domain.MissionVO;


@RestController
@RequestMapping("/api/mission")
public class MissionRESTController {
	@Autowired
	MissionDAO dao;
	
	
	@RequestMapping("/list")
	public List<MissionVO> list(String m_keyword, int m_start, int m_number){
		return dao.list(m_keyword, m_start, m_number);
		
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void insert(MissionVO vo) {
		
		dao.insert(vo);
	}

}
