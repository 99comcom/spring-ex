package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.PostVO;

@Repository
public class MysqlDAOImpl implements BoardDAO {
	@Autowired
	SqlSession session; String namespace="com.example.mapper.BoardMapper";
	@Override
	public List<HashMap<String, Object>> list() {
		return session.selectList(namespace + ".list"); 
	}
	@Override
	public void insert(PostVO vo) {
		session.insert(namespace+".insert",vo);
		
	}
	@Override
	public PostVO read(String userid) {
		
		return session.selectOne(namespace+".read",userid);
	}
	@Override
	public void update(PostVO vo) {
		session.update(namespace+".update",vo);
		
	}
	@Override
	public void delete(String userid) {
		session.delete(namespace+".delete",userid);
		
	}



}