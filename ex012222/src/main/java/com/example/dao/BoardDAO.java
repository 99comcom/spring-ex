package com.example.dao;

import java.util.List;

import com.example.domain.BoardVO;

public interface BoardDAO {
	public List<BoardVO> list();
	public BoardVO read(int bno);
	public void insert(BoardVO vo);
	public void update(BoardVO vo);
	public void delete(int bno);
	public int total();
	public List<BoardVO> slist(int start, String word);
	public int scount(String word);
	
}
