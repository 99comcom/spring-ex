package com.example.dao;

import java.util.List;

import com.example.domain.MissionVO;

public interface MissionDAO {
	public List<MissionVO> list(String m_keyword, int m_start, int m_number);
	public MissionVO read(String mission_code);
	public void insert(MissionVO vo);
	public void update(MissionVO vo);
	public void delete(String mission_code);

}
