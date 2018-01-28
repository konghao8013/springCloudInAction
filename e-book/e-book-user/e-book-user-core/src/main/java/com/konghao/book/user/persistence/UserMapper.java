package com.konghao.book.user.persistence;

import org.apache.ibatis.annotations.Param;

import com.konghao.book.user.domain.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	Integer Login(@Param("userName") String userName, @Param("password") String password);
}