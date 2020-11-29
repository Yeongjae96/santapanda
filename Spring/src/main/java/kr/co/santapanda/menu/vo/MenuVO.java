package kr.co.santapanda.menu.vo;

import lombok.Data;

@Data
public class MenuVO {
	private String menuCode;
	private String menuPath;
	private String menuName;
	private String upperMenuCode;
	private int sortOrder;
	private String useYn;
	private String createUserId;
	private String createDt;
	private String updateUserId;
	private String updateDt;
}
