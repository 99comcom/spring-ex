package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.MissionVO;

@Repository
public class MissionDAOImpl implements MissionDAO {
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.MissionMapper";

	@Override
	public List<MissionVO> list(String m_keyword, int m_start, int m_number) {
		HashMap<String,Object> map =new HashMap<>();
		map.put("m_keyword", m_keyword);
		map.put("m_start", m_start);
		map.put("m_number", m_number);
		return session.selectList(namespace+".list",map);
	}

	@Override
	public MissionVO read(String mission_code) {
		return session.selectOne(namespace+".read",mission_code) ;
	}

	@Override
	public void insert(MissionVO vo) {
		session.insert(namespace+".insert",vo);
		
	}

	@Override
	public void update(MissionVO vo) {
		session.update(namespace+".update",vo);
		
	}

	@Override
	public void delete(String mission_code) {
	session.delete(namespace+".delete",mission_code);
	
		
	}
	
	

}
