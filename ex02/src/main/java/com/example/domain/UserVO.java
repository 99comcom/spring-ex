package com.example.domain;

public class UserVO {
	private String uid;
	private String uname;
	private String upass;
	private String photo;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "UserVO [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", photo=" + photo + "]";
	}
	
	

}
