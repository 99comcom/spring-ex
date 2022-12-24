package com.example.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class HomeController {
	@Resource(name="uploadPath")
	private String path;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping("/api/display")
	@ResponseBody
	public ResponseEntity<byte[]> display(String fileName) 
			throws Exception{
		ResponseEntity<byte[]> image=null;
		File file=new File(fileName);
		if(file.exists()){
			HttpHeaders header=new HttpHeaders();
			header.add("Content-type", Files.probeContentType(file.toPath()));
			image=new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),
					header, HttpStatus.OK);
		}
		return image;
	}
	
	@RequestMapping(value="/api/download",method=RequestMethod.POST)
	@ResponseBody
	public void download(String image){
		try {
			//path 밑에 생성하니까 맨 끝에 /를 넣어줘야 함.
			String path="c:/image/";
			//파일이 url로 되어있는데, 거기서 맨 마지막 /이후로 가져와야 함.
			int last=image.lastIndexOf("/");
			//맨 마지막 슬래시는 빼주고 이름을 가져와야 하기 때문에 +1을 해줌.
			String fileName=image.substring(last+1);
			//path아래 fileName으로 파일을 만들어줌.
			File file =new File(path+fileName);
			//파일이 이미 존재한다면 아무것도 하지 않고 그냥 빠져나옴. 
			if(file.exists())return;
			//이미지가 url이라서 url로 읽어옴.
			URL url=new URL(image);
			//url로 읽어오기 때문에 바로 copyutils는 안됨. 따라서 Stream을 열어줌.
			InputStream in=url.openStream();
			OutputStream out=new FileOutputStream(path+fileName);
			FileCopyUtils.copy(in, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
