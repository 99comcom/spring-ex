package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MissionVO {
	private int mission_code;
	
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone ="Asia/Seoul")
	private Date m_start_Date;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone ="Asia/Seoul")
	private Date m_last_Date;
	
	private String m_category;
	private String m_image;
	private String m_title;
	private String m_info;
	private String m_content;
	private String m_content_image;
	private int m_target;
	private int m_result;
	private String m_user_id;
	private int m_get_point;
	
	
	
	
	
	public int getM_get_point() {
		return m_get_point;
	}


	public void setM_get_point(int m_get_point) {
		this.m_get_point = m_get_point;
	}


	public String getM_user_id() {
		return m_user_id;
	}


	public void setM_user_id(String m_user_id) {
		this.m_user_id = m_user_id;
	}


	@Override
	public String toString() {
		return "Mission [mission_code=" + mission_code + ", m_start_Date=" + m_start_Date + ", m_last_Date="
				+ m_last_Date + ", m_category=" + m_category + ", m_image=" + m_image + ", m_title=" + m_title
				+ ", m_info=" + m_info + ", m_content=" + m_content + ", m_content_image=" + m_content_image
				+ ", m_target=" + m_target + ", m_result=" + m_result + "]";
	}
	
	
	public int getMission_code() {
		return mission_code;
	}
	public void setMission_code(int mission_code) {
		this.mission_code = mission_code;
	}
	public Date getM_start_Date() {
		return m_start_Date;
	}
	public void setM_start_Date(Date m_start_Date) {
		this.m_start_Date = m_start_Date;
	}
	public Date getM_last_Date() {
		return m_last_Date;
	}
	public void setM_last_Date(Date m_last_Date) {
		this.m_last_Date = m_last_Date;
	}
	public String getM_category() {
		return m_category;
	}
	public void setM_category(String m_category) {
		this.m_category = m_category;
	}
	public String getM_image() {
		return m_image;
	}
	public void setM_image(String m_image) {
		this.m_image = m_image;
	}
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	public String getM_info() {
		return m_info;
	}
	public void setM_info(String m_info) {
		this.m_info = m_info;
	}
	public String getM_content() {
		return m_content;
	}
	public void setM_content(String m_content) {
		this.m_content = m_content;
	}
	public String getM_content_image() {
		return m_content_image;
	}
	public void setM_content_image(String m_content_image) {
		this.m_content_image = m_content_image;
	}
	public int getM_target() {
		return m_target;
	}
	public void setM_target(int m_target) {
		this.m_target = m_target;
	}
	public int getM_result() {
		return m_result;
	}
	public void setM_result(int m_result) {
		this.m_result = m_result;
	}
	
	
	
}


