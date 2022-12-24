package com.example.controller;

import java.io.File;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dao.ProductDAO;
import com.example.domain.ProductVO;
import com.example.domain.UserVO;

@RestController
@RequestMapping("/api/product")
public class ProductrestController {
	@Autowired
	ProductDAO dao;
	
	@Resource(name="uploadPath")
	private String path;
	

@RequestMapping("/list")
public HashMap<String,Object> list(int page,int num,String word){
	HashMap<String,Object> map=new HashMap<String,Object>();
	map.put("list",dao.list(page,num,word));
	map.put("total",dao.total(word));
	return map;
}
@RequestMapping(value="/insert", method=RequestMethod.POST)
public void insert(ProductVO vo ,MultipartFile file) throws Exception{
	System.out.println(vo.toString());
	if(!file.isEmpty()){
		String uploadPate=path+"product/";
		String fileName=System.currentTimeMillis()+"_"+file.getOriginalFilename();
		FileCopyUtils.copy(file.getBytes(), new File(uploadPate+fileName));
		vo.setImage("/upload/product/"+fileName);
	}
	dao.insert(vo);
}

}


