package kr.co.santapanda.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.santapanda.user.model.UserVO;

@Mapper
public interface UserMapper {

	public int createUser(UserVO vo) throws Exception;
	
	public UserVO login(@Param("userId") String userId, @Param("encryptPassword") String encryptPassword) throws Exception;
	
	public UserVO getUserInfo(@Param("userId") String userId) throws Exception;
}
