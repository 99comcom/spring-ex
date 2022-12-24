package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.dao.UserDAO;
import com.example.domain.UserVO;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
	@Autowired
	UserDAO dao;
	
	@Autowired
	PasswordEncoder encoder;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
	
	@RequestMapping("/list")
	public List<UserVO> list(int page){
		return dao.list(page);
		
	}
	@RequestMapping("/read/{uid}")
	public UserVO read(@PathVariable String uid){
		return dao.read(uid);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public int login (@RequestBody UserVO vo){
		int result=0;
		UserVO readVo=dao.read(vo.getUid());
		if(readVo!=null){
			if(encoder.matches(vo.getUpass(), readVo.getUpass())){
				result=1;
			}else{
				result=2;
			}
		}
		return result;
		
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void insert(UserVO vo, MultipartHttpServletRequest multi)
	throws Exception{
		if(multi.getFile("file")!=null){
			MultipartFile file=multi.getFile("file");
			String path="c:/upload/photo";
			String fileName=file.getOriginalFilename();
			File newFile=new File(path+fileName);
			
			if(!newFile.exists())file.transferTo(newFile);
			vo.setPhoto("/upload/photo/"+fileName);
			
		}
		vo.setUpass(encoder.encode(vo.getUpass()));
		dao.insert(vo);
	}
	
	
	
	
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void update(UserVO vo, MultipartHttpServletRequest multi) throws Exception{
		if(multi.getFile("file")!=null){
			MultipartFile file=multi.getFile("file");
			if(vo.getPhoto()!=null){//이전 파일 지움
				File oldFile= new File("c:"+vo.getPhoto());
				if(oldFile.exists())oldFile.delete();
	
			}
			//새로운 파일 업로드
			String path="/update/photo/";
			File newFile=new File("c:"+path+file.getOriginalFilename());
			if(!newFile.exists()) file.transferTo(newFile);
			vo.setPhoto(path+file.getOriginalFilename());
		}
		dao.insert(vo);
	}
}
