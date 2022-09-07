package com.board.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.example.mapper.BoardMapper;
import com.board.example.model.Board;
import com.board.example.model.loginInfo;
import com.board.example.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<String> tryLogin(loginInfo info) {
		try {
			System.out.println("회원정보 "+ info.getId() + ")))) " + info.getPw());
			
			String loginInfo = boardService.tryLogin(info);
			return new ResponseEntity<>(loginInfo, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/join")
	@ResponseBody
	public ResponseEntity<String> tryJoin(loginInfo info){
		try {
			String joinInfo = boardService.tryJoin(info);
			return new ResponseEntity<>(joinInfo, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/uploadBoard")
	@ResponseBody
	public ResponseEntity<String> uploadBoard(Board board){
		System.out.println(board.getBno());
		System.out.println(board.getContent());
		System.out.println(board.getTitle());
		System.out.println(board.getId());
		System.out.println(board.getRegidate());
		
		String msg = boardService.uploadBoard(board);
		
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Board>> abc() {
		try {
			List<Board> a = boardService.selectAll();
			return new ResponseEntity<>(a, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getContent/{bno}")
	public ResponseEntity<Board> setContent(@PathVariable("bno") int bno){
		try {
			Board a = boardService.setContent(bno);
			return new ResponseEntity<>(a, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteBoard")
	public ResponseEntity<String> deleteContent(Board board){
		try {
			String res = boardService.deleteContent(board);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateBoard")
	public ResponseEntity<String> updateBoard(Board board){
		try {
			String res = boardService.updateBoard(board);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
