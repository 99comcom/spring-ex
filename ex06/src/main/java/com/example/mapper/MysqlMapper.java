package com.example.mapper;

import org.apache.ibatis.annotations.Select;

public interface MysqlMapper {
	 public String getTime(); @Select("select now() today2")
	 public String getTime2();
}
