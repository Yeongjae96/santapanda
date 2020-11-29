package kr.co.santapanda.menu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.santapanda.menu.vo.MenuVO;

@Mapper
public interface MenuMapper {
	
	public List<MenuVO> getMenuList() throws Exception;
	
	
}
