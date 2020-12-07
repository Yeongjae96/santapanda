package kr.co.santapanda.board.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.santapanda.board.service.BoardService;
import kr.co.santapanda.board.vo.BoardVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping
	public ResponseEntity<List<BoardVO>> getBoardList(BoardVO board) {
		return ResponseEntity.ok(boardService.getBoardList(board));
	}
	
	@GetMapping("/{boardNo}")
	public ResponseEntity<BoardVO> getBoard(@PathVariable String boardNo) {
		return ResponseEntity.ok(boardService.getBoard(boardNo));
	}
	
	@PostMapping
	public ResponseEntity<Integer> createBoard(@RequestBody BoardVO board) {
		return ResponseEntity.ok(boardService.createBoard(board));
	}
	
	@PutMapping
	public ResponseEntity<Integer> updateBoard(@RequestBody BoardVO board) {
		return ResponseEntity.ok(boardService.updateBoard(board));
	}
	
	@DeleteMapping
	public ResponseEntity<Integer> deleteBoard(@RequestBody BoardVO board) {
		return ResponseEntity.ok(boardService.deleteBoard(board));
	}
	
	
}
