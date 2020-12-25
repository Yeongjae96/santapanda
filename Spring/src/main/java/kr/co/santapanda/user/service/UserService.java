package kr.co.santapanda.user.service;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import kr.co.santapanda.common.exception.UnauthorizedException;
import kr.co.santapanda.common.utils.ContextUtil;
import kr.co.santapanda.common.utils.EncryptUtil;
import kr.co.santapanda.config.security.jwt.service.JwtService;
import kr.co.santapanda.user.mapper.UserMapper;
import kr.co.santapanda.user.model.UserVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserMapper userMapper;
	
	private final JwtService jwtService;
	
	public String createUser(UserVO vo) throws Exception {
//		vo.setPassword(EncryptUtil.SHA256(vo.getPassword()));
		userMapper.createUser(vo);
		return vo.getUserId();
	}
	
	public UserVO login(UserVO vo) throws Exception {
		
		String encryptPassword = EncryptUtil.SHA256(vo.getPassword());
		UserVO loginUser = userMapper.login(vo.getUserId(), encryptPassword);
		

		if (loginUser == null) throw new UnauthorizedException();
		
		// 로그인 성공 후 토큰 생성
		String token = jwtService.create("pandaUser", loginUser, "loginToken");
		
		// 헤더에 토큰 발송
		HttpServletResponse response = ContextUtil.getResponse();
		response.setHeader("jwt-auth-token", token);
		
		return loginUser;
	}
	
	public UserVO getUserInfo(String userId) throws Exception {
		return userMapper.getUserInfo(userId);
	}
}
