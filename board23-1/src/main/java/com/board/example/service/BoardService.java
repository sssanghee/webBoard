package com.board.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.example.mapper.BoardMapper;
import com.board.example.mapper.MemberMapper;
import com.board.example.model.Board;
import com.board.example.model.loginInfo;

@Service
public class BoardService {

	@Autowired
	BoardMapper boardmapper;
	
	@Autowired
	MemberMapper memberMapper;
	
	public List<Board> selectAll(){
		
		return boardmapper.selectAll();
	}
	
	public String tryLogin(loginInfo info) {
		List<loginInfo> getAllInfo = memberMapper.getAllInfo();
		System.out.println("info = ? " + getAllInfo);
				
		String returnVal = "loginFail";
		for(loginInfo each : getAllInfo) {
			if(each.getId().toString().equals(info.getId().toString())) {
				if(each.getPw().toString().equals(info.getPw().toString())) {
					returnVal = "login";
				}
			}
		}
		return returnVal;
	}
	
	public String tryJoin(loginInfo info) {
		List<loginInfo> getAllInfo = memberMapper.getAllInfo();
		
		boolean existId = false;
		for(loginInfo each : getAllInfo) {
			if(each.getId().toString().equals(info.getId().toString())) {
				existId = true;
			}
		}
		if(existId == true) {
			return "joinFail";
		} else {
			memberMapper.insertMemberInfo(info);
			return "join";
		}
	}
	
	public String uploadBoard(Board board) {
		boardmapper.uploadBoard(board);
		return "upload";
	}
	
	public Board setContent(int bno) {
		Board content = boardmapper.setContent(bno);
		return content;
	}
	
	public String deleteContent(Board board) {
		
		boardmapper.deleteBoard(board);
		return "delete";
	}
	
	public String updateBoard(Board board) {
		boardmapper.updateBoard(board);
		return "update";
	}
}
