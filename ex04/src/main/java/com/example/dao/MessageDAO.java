package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.MessageVO;

public interface MessageDAO {
	public List<MessageVO> sendList(String uid);
	public List<MessageVO> receiveList(String uid);
	public void insert(MessageVO vo);
	public MessageVO read(int mid);
	public void updateReadDate(int mid);

}
