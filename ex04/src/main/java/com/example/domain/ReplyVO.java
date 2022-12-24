package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReplyVO {
	private int rno;
	private int bno;
	private String content;
	
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone ="Asia/Seoul")
	private Date replyDate;
	
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone ="Asia/Seoul")
	private Date updateDate;
	
	private String replyer;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", bno=" + bno + ", content=" + content + ", replyDate=" + replyDate
				+ ", updateDate=" + updateDate + ", replyer=" + replyer + "]";
	}
	

	
	
	
}
