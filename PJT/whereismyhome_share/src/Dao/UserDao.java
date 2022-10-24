package Dao;

import Dto.UserDto;

public interface UserDao {

	public int userRegister(UserDto userdto);
	public int deleteUser(UserDto userDto );
}
