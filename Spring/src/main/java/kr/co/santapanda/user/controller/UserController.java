package kr.co.santapanda.user.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import kr.co.santapanda.common.exception.UnauthorizedException;
import kr.co.santapanda.config.security.jwt.service.JwtService;
import kr.co.santapanda.user.model.UserVO;
import kr.co.santapanda.user.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody UserVO vo) throws Exception{
		return ResponseEntity.ok(userService.createUser(vo));
	}
	
	@GetMapping
	public ResponseEntity<UserVO> getUserInfo(@RequestParam("userId") String userId) throws Exception {
		return ResponseEntity.ok(userService.getUserInfo(userId));
	}
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody UserVO vo) throws Exception {
		
		UserVO loginUser = userService.login(vo);
		
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		resultMap.put("status", true);
		resultMap.put("data", loginUser);
		
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.ACCEPTED);
	}
	
}
