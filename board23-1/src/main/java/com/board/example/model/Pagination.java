package com.board.example.model;

public class Pagination {
	private int idx;		//선택된 페이지 번호
	private int totalIdx;	//총 페이지 개수
	private int showTotIdx;	//한페이지에 보여줄 페이지 개수
	private int countBoard; //한페이지 게시글 수 
	
	public int getCountBoard() {
		return countBoard;
	}
	public void setCountBoard(int countBoard) {
		this.countBoard = countBoard;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getTotalIdx() {
		return totalIdx;
	}
	public void setTotalIdx(int totalIdx) {
		this.totalIdx = totalIdx;
	}
	public int getShowTotIdx() {
		return showTotIdx;
	}
	public void setShowTotIdx(int showTotIdx) {
		this.showTotIdx = showTotIdx;
	}
	
}
