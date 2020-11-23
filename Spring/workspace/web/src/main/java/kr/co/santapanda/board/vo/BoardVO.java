package kr.co.santapanda.board.vo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardVO {
	private String boardNo;
	private String title;
	private String password;
	private String content;
	private String createUserId;
	private String createUserNm;
	private Timestamp createDt;
	private String updateUserId;
	private String updateUserNm;
	private Timestamp updateDt;
}
