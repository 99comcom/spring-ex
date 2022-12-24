package com.example.dao;

import java.util.List;

import com.example.domain.ReplyVO;

public interface ReplyDAO {
	public List<ReplyVO> list(int bno, int page, int num );
	public int total(int bno);
	public void insert(ReplyVO vo);
	public void update(ReplyVO vo);
	public void delete(int rno);
	
			
}
