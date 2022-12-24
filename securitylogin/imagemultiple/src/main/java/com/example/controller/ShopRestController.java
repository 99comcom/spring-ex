package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
	
	@Autowired
	ShopDAO sdao;
	
	
	@RequestMapping("/list")
	public HashMap<String, Object> list(int page,int num){
	HashMap<String, Object>map=new HashMap<>();
	map.put("list", sdao.list(page, num));
	map.put("total", sdao.total());
	return map;
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void insert(ShopVO vo,MultipartFile file) throws IllegalStateException, IOException{
		if(!file.isEmpty()){
			String strFile="c:/upload/shop/"+file.getOriginalFilename();
			File newFile =new File(strFile);
			if(!newFile.exists()) file.transferTo(newFile);
			vo.setImage(strFile);
		}
		vo.setCode(sdf.format(new Date()));
		 sdao.insert(vo);
	}
	
	@RequestMapping(value="/addAttach",method=RequestMethod.POST)
	//여러개면  MultipartHttpServletRequest, 한개면 MultipartFile
	public void addAttach(String code, MultipartHttpServletRequest multi) throws IllegalStateException, IOException{
		List<MultipartFile>	files=multi.getFiles("files");
		String path="c:/upload/shop/"+code;
		File filePath=new File(path);
		//메인이미지의 code로 폴더를 만듦.
		if(!filePath.exists()) filePath.mkdir();
		for(MultipartFile file:files){
			if(!file.isEmpty()){
				String strFile=file.getOriginalFilename();
				//메인이미지의 code로 만들어진 폴더 안에 부수이미지 파일들이 전부 들어감.
				File newFile=new File(path+"/"+strFile);
				//중복파일은 안넣음.
				if(!newFile.exists()) 	{
					file.transferTo(newFile);
					sdao.addAttach(code, path+"/"+strFile);
				}
			
			}
			
		}
		
	}
	
	@RequestMapping(value="/read/{code}")
	public ShopVO read(@PathVariable String code){
		return sdao.read(code);
	}
	
	@RequestMapping(value="/getAttach")
	public List<HashMap<String,Object>> getAttach(String code){
		return sdao.getAttach(code);
	}
	
	@RequestMapping(value="/delAttach",method=RequestMethod.POST)
	public void delAttach(int id,String image){
		sdao.delAttach(id);
		File file = new File(image);
		if(file.exists()) file.delete();
	}
	
	@RequestMapping(value="/addSale",method=RequestMethod.POST)
	public void addSale(String code){
			sdao.addSale(code);
	}
	
	@RequestMapping(value="/getSale")
	public List<ShopVO> getSale(){
		return sdao.getSale();
	}
	
	
	


}
