package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.dao.BoardDAO;
import com.example.domain.PostVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MysqlTest {

	@Autowired
	BoardDAO bdao;
//	@Test 
//	public void list() {
//		bdao.list(); 
//		}
//	@Test 
//	public void read() {
//		bdao.read("rrr"); 
//		}
//	@Test 
//	public void update() {
//		PostVO vo=new PostVO();
//		vo.setUserid("rrr");
//		vo.setUsername("ttt");
//		vo.setEmail("ttt@123123");
//		bdao.update(vo);
//		}
	
//	@Test 
//	public void delete() {
//		bdao.delete("rrr"); 
//		}
	
	
//	@Test
//	public void insert(){
//		PostVO vo=new PostVO();
//		vo.setUserid("rrr");
//		vo.setUsername("rrr");
//		vo.setEmail("123123@123123");
//		vo.setAddress("123123");
//		bdao.insert(vo);
//	}
	
	

}
