package com.example.domain;

public class PostVO {
 private String userid;
 private String username;
 private String email;
 private String address;
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "PostVO [userid=" + userid + ", username=" + username + ", email=" + email + ", address=" + address + "]";
}
 
 
 
 
 
 
 
}
