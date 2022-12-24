package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.ShopVO;

@Repository
public class ShopDAOImpl implements ShopDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.ShopMapper";

	@Override
	public List<ShopVO> list() {
		return session.selectList(namespace+".list");
	}

	@Override
	public void insert(ShopVO vo) {
		session.insert(namespace+".insert",vo);
		
	}

}
 