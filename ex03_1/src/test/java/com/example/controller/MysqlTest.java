package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.dao.BoardDAO;
import com.example.dao.ReplyDAO;
import com.example.mapper.MysqlMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MysqlTest {	
	@Autowired
	ReplyDAO dao;
	
	@Autowired
	BoardDAO bdao;
	
	@Test
	public void test(){
		bdao.updateReplycnt(514, -1);
	}
}
