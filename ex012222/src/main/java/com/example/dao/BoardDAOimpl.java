package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.BoardVO;

@Repository
public class BoardDAOimpl implements BoardDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.BoardMapper";
	
	@Override
	public List<BoardVO> list() {
		return session.selectList(namespace + ".list");
	}

	@Override
	public BoardVO read(int bno) {
		return session.selectOne(namespace + ".read", bno);
	}

	@Override
	public void insert(BoardVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public void update(BoardVO vo) {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int bno) {
		session.delete(namespace + ".delete", bno);
	}

	@Override
	public int total() {
		return session.selectOne(namespace + ".total");
	}

	@Override
	public List<BoardVO> slist(int page, String word) {
		HashMap<String, Object> map=new HashMap<String,Object>();
		map.put("start",(page-1)*5);
		map.put("word", word);
		return session.selectList(namespace+".slist",map);
	}

	@Override
	public int scount(String word) {
		return session.selectOne(namespace+".scount",word);
	}
}
