package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.UserVO;

@Repository
public class UserDAOimpl implements UserDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.UserMapper";

	@Override
	public List<UserVO> list(String word, int page,int num) {
		HashMap<String, Object>map=new HashMap<String , Object>();
		map.put("word",word );
		map.put("start",(page-1)*num);
		map.put("num",num);
		return session.selectList(namespace+".list",map);
	}

	@Override
	public int total(String word) {
		return session.selectOne(namespace+".total",word);
	}

	@Override
	public void insert(UserVO vo) {
		session.insert(namespace+".insert", vo);
		
	}

	@Override
	public void update(UserVO vo) {
		session.update(namespace+".update", vo);
		
	}

	@Override
	public UserVO read(String uid) {
		return session.selectOne(namespace+".read",uid);
	}

	@Override
	public void delete(String uid) {
		session.delete(namespace+".delete",uid);
	}
	

}
