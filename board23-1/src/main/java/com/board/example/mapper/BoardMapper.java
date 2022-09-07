package com.board.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.example.model.Board;

@Mapper
public interface BoardMapper {
	public List<Board> selectAll();
	public void uploadBoard(Board info);
	public Board setContent(int bno);
	public void deleteBoard(Board board);
	public void updateBoard(Board board);
}
