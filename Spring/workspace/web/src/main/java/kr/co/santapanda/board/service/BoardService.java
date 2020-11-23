package kr.co.santapanda.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.santapanda.board.mapper.BoardMapper;
import kr.co.santapanda.board.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public BoardVO getBoard(String boardNo) {
		return boardMapper.getBoard(boardNo);
	}
	
	public List<BoardVO> getBoardList(BoardVO board) {
		return boardMapper.getBoardList(board);
	}
	
	public int createBoard(BoardVO board) {
		return boardMapper.createBoard(board);
	}
	
	public int updateBoard(BoardVO board) {
		return boardMapper.updateBoard(board);
	}
	
	public int deleteBoard(BoardVO board) {
		return boardMapper.deleteBoard(board);
	}
	
	
}
