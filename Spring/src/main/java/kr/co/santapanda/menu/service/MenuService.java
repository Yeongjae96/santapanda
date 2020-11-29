package kr.co.santapanda.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.santapanda.menu.mapper.MenuMapper;
import kr.co.santapanda.menu.vo.MenuVO;

@Service
public class MenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	
	public List<MenuVO> getMenuList() throws Exception {
		return menuMapper.getMenuList();
	}

	
}
