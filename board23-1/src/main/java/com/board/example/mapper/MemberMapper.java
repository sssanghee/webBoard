package com.board.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.example.model.loginInfo;

@Mapper
public interface MemberMapper {
	public List<loginInfo> getAllInfo();
	public void insertMemberInfo(loginInfo info);
}
