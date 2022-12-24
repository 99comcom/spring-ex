package com.example.domain;

public class UserVO {
	private String uid;
	private String upass;
	private String uname;
	private String photo;
	private int point;
	private int receivecnt;
	private int sendcnt;
	
	
	
	public int getReceivecnt() {
		return receivecnt;
	}
	public void setReceivecnt(int receivecnt) {
		this.receivecnt = receivecnt;
	}
	public int getSendcnt() {
		return sendcnt;
	}
	public void setSendcnt(int sendcnt) {
		this.sendcnt = sendcnt;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "UserVO [uid=" + uid + ", upass=" + upass + ", uname=" + uname + ", photo=" + photo + ", point=" + point
				+ ", receivecnt=" + receivecnt + ", sendcnt=" + sendcnt + "]";
	}
	
	
	
}
