package kr.co.santapanda.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.santapanda.menu.service.MenuService;
import kr.co.santapanda.menu.vo.MenuVO;

@Controller
@RequestMapping("/api/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping
	public ResponseEntity<List<MenuVO>> getMenuList() throws Exception {
		return ResponseEntity.ok(menuService.getMenuList());
	}
	
	
	
}
