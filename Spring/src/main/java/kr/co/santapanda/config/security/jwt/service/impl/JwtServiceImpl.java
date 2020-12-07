package kr.co.santapanda.config.security.jwt.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kr.co.santapanda.common.exception.UnauthorizedException;
import kr.co.santapanda.common.utils.ContextUtil;
import kr.co.santapanda.config.security.jwt.service.JwtService;
import lombok.extern.slf4j.Slf4j;

/**
 * Jwt 토큰 서비스
 * 
 * @author Yeong
 *
 */
@Slf4j
@Service
public class JwtServiceImpl implements JwtService {

	@Value("${jwt.salt}")
	private String SANTA_PANDA;
	
	@Value("${jwt.expmin}")
	private Long expireMin;
	
	/**
	 * JWT 토큰 생성
	 */
	@Override
	public <T> String create(String key, T data, String subject) {
		String jwt = Jwts.builder()
						 .setHeaderParam("typ", "JWT") // 토큰의 타입으로 고정값
						 .setSubject(subject)
						 .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * expireMin))
						 .claim(key, data)
						 .signWith(SignatureAlgorithm.HS256, this.generateKey())
						 .compact();
		return jwt;
	}
	
	/**
	 * JWT 토큰이 사용 여부 판단
	 */
	@Override
	public boolean isUsable(String jwt) {
		try {
			Jws<Claims> claims = Jwts.parser()
									 .setSigningKey(this.generateKey())
									 .parseClaimsJws(jwt);
			return true;
		} catch (Exception e) {
			throw new UnauthorizedException();
		}
	}
	
	/**
	 * 
	 */
	@Override
	public Map<String, Object> get(String key) {
		String jwt = ContextUtil.getHeader(key);
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser()
						 .setSigningKey(generateKey())
						 .parseClaimsJws(jwt);
		} catch (Exception e) {
			throw new UnauthorizedException();
		}
		return claims.getBody();
	}
	
	/**
	 * 고유한 키값을 마들어내는 함수
	 * @return
	 */
	private byte[] generateKey() {
		byte[] key = null;
		try {
			key = SANTA_PANDA.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			if (log.isInfoEnabled()) {
				e.printStackTrace();
			} else {
				log.error("Making JWT Key Error ::: {}", e.getMessage());
			}
		}
		return key;
	}
}
