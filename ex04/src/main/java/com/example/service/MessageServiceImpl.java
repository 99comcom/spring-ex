package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.MessageDAO;
import com.example.dao.UserDAO;
import com.example.domain.MessageVO;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageDAO mdao;
	
	@Autowired
	UserDAO udao;
	

	@Transactional
	@Override
	public void insert(MessageVO vo) {
		mdao.insert(vo);
		udao.updatePoint(10, vo.getSender());
	}

	//3������ ���ÿ� �۵���Ű�� data ���� �������� ����Ʈ�� ��¥�� �־��ش�.
	@Transactional
	@Override
	public MessageVO read(int mid) {
		MessageVO vo=mdao.read(mid);
		if(vo.getReadDate()==null ){
		udao.updatePoint(5, vo.getReceiver());
		mdao.updateReadDate(mid);
		}
		return mdao.read(mid);
	}
	
}
