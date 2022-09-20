package board.service;

import board.dao.UserDao;
import board.dao.UserDaoImpl;
import board.dto.UserDto;

public class UserServiceImpl implements UserService {
	
	private static UserServiceImpl instance=new UserServiceImpl();
	
	private UserServiceImpl() {
		
	}
	public static UserServiceImpl getInstance() {
		return instance;
	}
	
	//쓰레드에 의해 userDap가 공유되면?
	//userDao 가 만약 멤버 변수가 있으면 해당 멤버 변수에 대해 thread-sage한 코딩이 필요 synchronized...등
	//userDao가 만약 멤버 변수가 없다면 문제되지 않음
	
	//싱글톤 디자인 패턴을 적용한 객체가 상테값을 가지지 않으며 thread-safe 하다.
	UserDao userDao=UserDaoImpl.getInstance();//member

	@Override
	public int userRegister(UserDto userDto) {
		//dao 객체 생성
		return userDao.userRegister(userDto);
		//dao 객체=null
		
	}

}
