package com.example.controller;

import java.io.File;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dao.UserDAO;
import com.example.domain.UserVO;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
	@Autowired
	UserDAO dao;
	@Resource(name="uploadPath")
	private String path;
	
	@RequestMapping("/list")
	public HashMap<String,Object> list(String word,int page,int num){
		HashMap<String,Object>  map=new HashMap<String,Object>();
		map.put("total",dao.total(word));
		map.put("list",dao.list(word, page, num));
		return map;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public void insert(UserVO vo ,MultipartFile file) throws Exception{
		System.out.println(vo.toString());
		if(!file.isEmpty()){
			String uploadPate=path+"photo/";
			String fileName=System.currentTimeMillis()+"_"+file.getOriginalFilename();
			FileCopyUtils.copy(file.getBytes(), new File(uploadPate+fileName));
			vo.setPhoto("/upload/photo/"+fileName);
		}
		dao.insert(vo);
	}
	

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void update(@RequestBody UserVO vo){
		dao.update(vo);
	}
	
	@RequestMapping("/read/{uid}")
	public UserVO read(@PathVariable String uid){
		return dao.read(uid);
	}
	
	@RequestMapping(value="/delete/{uid}", method=RequestMethod.POST)
	public void delete(@RequestBody String uid){
		dao.delete(uid);
	}
	
}
