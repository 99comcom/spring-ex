package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	UserDAO udao;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("/list")
	public List<UserVO> list(int page) {
		return udao.list(page);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	// 프론트에서 들어온 uid,upass
	public int login(@RequestBody UserVO vo) {
		int result = 0;
		// db에서 얻어오는 uid,upass
		UserVO readvo = udao.read(vo.getUid());
		// vo값이 있어야 비밀번호를 확인할 수 있음.
		if (readvo != null) {
			// 비밀번호를 암호환 값이 우리가 입력해서 들어간 원래 비밀번호와 맞다면 db에서 정보를 뱉어냄. 그걸 가지고 프론트에서
			// 로그인 알림처리 작업을 해줌.
			result = passwordEncoder.matches(vo.getUpass(), readvo.getUpass()) ? 1 : 2;
		}
		return result;
	}

	@RequestMapping("/read/{uid}")
	public UserVO read(@PathVariable String uid) {
		UserVO vo = udao.read(uid);
		return vo;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(UserVO vo, MultipartFile file){
		try{
			
	
		if (!file.isEmpty()) {
			String path = "c:/upload/photo";
			File newFile = new File(path + file.getOriginalFilename());
			if (!newFile.exists())
				file.transferTo(newFile);
			vo.setPhoto(path + file.getOriginalFilename());
		}
		// 암호화과정. encoding 되어 들어갔으니 db에는 암호화된 암호가 들어감.따라서 decode가 필요함.
		String password = passwordEncoder.encode(vo.getUpass());
		vo.setUpass(password);
	}catch(Exception e){
		e.printStackTrace();
	}
		udao.insert(vo);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(UserVO vo, MultipartFile file) {
		// 수정하게 되면 이전 이미지는 필요없으니까 지워줌. 공백도 null은 아니니까 ""로 하는 게 더 나을듯?
		try { 
			if (!file.isEmpty()) {
				if (vo.getPhoto() != null) {
					File oldFile = new File(vo.getPhoto());
					System.out.println(vo.getPhoto());
					if (oldFile.exists())
						oldFile.delete();
				}
				// 새롭게 수정된 파일을 업로드
				String path = "c:/upload/photo/";
				File newFile = new File(path + file.getOriginalFilename());
				if (!newFile.exists()) {
					file.transferTo(newFile);
				}
				vo.setPhoto(path + file.getOriginalFilename());

			}
		} catch (Exception e)  {
			e.printStackTrace();
		}
		udao.update(vo);
		
	}

	@RequestMapping(value = "/update/password", method = RequestMethod.POST)
	// 프론트에서 FormData로 보내는 게 아닌 이상 @RequestBody를 붙여줘야 함.
	public void updatePassword(@RequestBody UserVO vo) {
		String password = passwordEncoder.encode(vo.getUpass());
		vo.setUpass(password);
		udao.updatePassword(vo);
	}

}
