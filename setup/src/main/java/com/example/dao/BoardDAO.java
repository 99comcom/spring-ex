package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.PostVO;

public interface BoardDAO {
	 public List<HashMap<String, Object>> list();
	 public void insert(PostVO vo);
	 public PostVO read(String userid);
	 public void update(PostVO vo);
	 public void delete(String userid);
}
