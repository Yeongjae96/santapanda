package kr.co.santapanda.common.exception;

public class UnauthorizedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8229784113821847763L;
	
	public UnauthorizedException() {
		super("계정 권한이 유효하지 않습니다.\n 다시 로그인 해주세요");
	}
	
}
