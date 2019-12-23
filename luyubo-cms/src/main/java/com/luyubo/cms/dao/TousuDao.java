package com.luyubo.cms.dao;

import org.apache.ibatis.annotations.Param;

import com.luyubo.cms.pojo.Tousu;

public interface TousuDao {

	int add(@Param("tousu")Tousu tousu);

}
