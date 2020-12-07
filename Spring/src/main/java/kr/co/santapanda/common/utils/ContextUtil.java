package kr.co.santapanda.common.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import io.jsonwebtoken.lang.Collections;

public class ContextUtil {

	/**
	 * 어디서든 HttpSerlvetRequest를 받아올 수 있음.
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	}
	
	public static String getHeader(String key) {
		return getRequest().getHeader(key);
	}
	
	
	/**
	 * HttpServletRequset에 key-value 한쌍 할당
	 * @param key
	 * @param value
	 */
	public static void setRequestAttribute(String key, Object value) {
		getRequest().setAttribute(key, value);
	}
	
	/**
	 * HttpServletRequest에 키값으로 attribute 조회
	 * @param key
	 * @return
	 */
	public static Object getRequestAttribute(String key) {
		return getRequest().getAttribute(key);
	}
	
	/**
	 * HttpServletRequest의 파라미터 조회 (단일)
	 * @param key
	 * @return
	 */
	public static String getParameter(String key) {
		return getRequest().getParameter(key);
	}
	
	/**
	 * HttpSerlvetRequest의 파라미터 조회 (다중)
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getParameters(String key) {
		return Collections.arrayToList(getRequest().getParameterValues(key));
	}
	
}
