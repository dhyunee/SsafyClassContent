package Dao;

import Dto.UserDto;

public interface LoginDao {
	public UserDto login(String userEmail);

}
