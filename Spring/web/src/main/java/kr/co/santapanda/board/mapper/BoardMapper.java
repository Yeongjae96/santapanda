package kr.co.santapanda.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.santapanda.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	public BoardVO getBoard(@Param("boardNo") String boardNo);
	
	public List<BoardVO> getBoardList(BoardVO board);
	
	public int createBoard(BoardVO board);
	
	public int updateBoard(BoardVO board);
	
	public int deleteBoard(BoardVO board);
	
}
