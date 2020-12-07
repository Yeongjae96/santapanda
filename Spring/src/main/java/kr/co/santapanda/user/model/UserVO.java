package kr.co.santapanda.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserVO {
	
	private String userNo;
	private String userId;
	private String password;
	private String name;
	private String email;
	private String useYn;
	
}
