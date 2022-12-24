package com.example.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.dao.ShopDAO;
import com.example.domain.ShopVO;


@RestController
@RequestMapping("/api/shop")



public class ShopRestController {
	@Autowired
	ShopDAO dao;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
	
	//CKEditer이미지 업로드
	@RequestMapping(value="/ckupload",method=RequestMethod.POST)
	public HashMap<String,Object> ckUpload(String code,MultipartHttpServletRequest multi) throws Exception{
		HashMap<String,Object> map=new HashMap<>();
		MultipartFile file=multi.getFile("file");
		if(file.isEmpty()){
			String path= "c:/upload/shop/"+code;
			File newPath=new File(path);
			if(!newPath.exists())newPath.mkdir();
			file.transferTo(new File(path+"/"+file.getOriginalFilename()));
			map.put("url","/upload/shop/"+code+"/"+file.getOriginalFilename());
			
		}
		return map;
	}
	
	
	
	@RequestMapping("/list")
	public List<ShopVO> list(){
		return dao.list();
		
	}
	@RequestMapping("/read")
	public ShopVO read(String code){
		return dao.read(code);
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void update(ShopVO vo,MultipartHttpServletRequest multi) throws Exception{
		if(multi.getFile("file")!=null){
			MultipartFile file=multi.getFile("file");
			String path="c:/upload/shop/";
			String name=file.getOriginalFilename();
			File newFile=new File(path+name);
			if(!newFile.exists()){
				file.transferTo(newFile);
			}
			vo.setImage("/upload/shop/"+name);
		}
		dao.Update(vo);
		
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void insert(ShopVO vo,MultipartHttpServletRequest multi) throws Exception  {
		if(multi.getFile("file")!=null){
			MultipartFile file=multi.getFile("file");
			String path="c:/upload/shop/";
			String name=file.getOriginalFilename();
			File newFile=new File(path+name);
			if(!newFile.exists()){
				file.transferTo(newFile);
			}
			vo.setImage("/upload/shop/"+name);
		}
		String code=sdf.format(new Date());
		vo.setCode(code);
		System.out.println(vo.toString());
		dao.insert(vo);
	}

}
