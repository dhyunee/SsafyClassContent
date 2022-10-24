package Service;

import Dto.UserDto;

public interface UserService {
	public int userRegister(UserDto userDto);
	public int deleteUser(UserDto userDto );
}
