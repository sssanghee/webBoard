package com.board.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.example.mapper.BoardMapper;
import com.board.example.model.Pagination;

@Service
public class PaginationService {
	
	@Autowired
	BoardMapper boardMapper;
	
	public Pagination setPaging(int idx){
		Pagination pagination = new Pagination();

		int totCountBoard = boardMapper.countPage();
		pagination.setIdx(idx);
		pagination.setCountBoard(10);
		
		if(totCountBoard < 10) {
			pagination.setTotalIdx(1);
			pagination.setShowTotIdx(10);			
		}else {
			int totIdx = totCountBoard / 10;
			if(totCountBoard % 10 > 0) {
				totIdx++; 
			}

			pagination.setTotalIdx(totIdx);
			pagination.setShowTotIdx(10);
		}
	
		
		return pagination;
	}
	
}
