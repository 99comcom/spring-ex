package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.ReplyVO;

@Repository
public class ReplyDAOimpl implements ReplyDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.ReplyMapper";
	@Override
	public List<ReplyVO> list(int bno, int page, int num) {
		HashMap<String , Object> map=new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("start", (page-1)*num);
		map.put("num",num);
		return session.selectList(namespace+".list",map);
	}
	@Override
	public int total(int bno) {
		return session.selectOne(namespace+".total",bno);
	}
	@Override
	public void insert(ReplyVO vo) {
		session.insert(namespace+".insert",vo);
		
	}
	@Override
	public void update(ReplyVO vo) {
		session.update(namespace+".update",vo);
		
	}
	@Override
	public void delete(int rno) {
		session.delete(namespace+".delete",rno);
		
	}
	
	
}
