package kr.co.santapanda.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class GlobalExceptionController {
	
	// 400
    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<String> BadRequestException(final RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    
    // 401
//    @ExceptionHandler({ AccessDeniedException.class })
//    public ResponseEntity<String> handleAccessDeniedException(final AccessDeniedException ex) {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
//    }
    
	// 500
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<String> handleAll(final Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
    // JWT 인증에러
	@ExceptionHandler
	public ResponseEntity<String> UnauthorizedExceptionHandler(UnauthorizedException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
	}
}
