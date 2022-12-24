package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.dao.BoardDAO;
import com.example.mapper.MysqlMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MysqlTest {	
	@Autowired
	BoardDAO dao;
	
//	@Test
//	public void slist(){
//		dao.slist(5,"Å¬·¡½º");
//	}
	

	
//	@Test
//	public void read(){
//		dao.read(1);
//	}
}
