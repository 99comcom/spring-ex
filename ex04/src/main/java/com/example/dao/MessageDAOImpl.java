package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.MessageMapper";

	@Override
	public List<MessageVO> sendList(String uid) {
		return session.selectList(namespace+".sendList",uid);
	}

	@Override
	public List<MessageVO> receiveList(String uid) {
		return session.selectList(namespace+".receiveList",uid);
	}

	@Override
	public void insert(MessageVO vo) {
		session.insert(namespace+".insert",vo);
	}

	@Override
	public MessageVO read(int mid) {
		return session.selectOne(namespace+".read",mid);
	}

	@Override
	public void updateReadDate(int mid) {
		session.update(namespace+".updateReadDate",mid);
		
	}

}
