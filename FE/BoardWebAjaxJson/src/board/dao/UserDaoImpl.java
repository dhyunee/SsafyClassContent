package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import board.common.DBManager;
import board.dto.UserDto;

public class UserDaoImpl implements UserDao{
	
	private static UserDaoImpl instance=new UserDaoImpl();
	
	private UserDaoImpl() {}
	
	public static UserDaoImpl getInstance() {
		return instance;
	}
	

	@Override
	public int userRegister(UserDto userDto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int ret=-1;
		
		try {
			con=DBManager.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" insert into users \n")
			.append(" (user_name, user_password, user_email, user_profile_image_url,user_register_date )\n")
			.append(" values (?,?,?,'',now())");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, userDto.getUserName());
			pstmt.setString(2, userDto.getUserPassword());
			pstmt.setString(3, userDto.getUserEmail());
			
			ret=pstmt.executeUpdate();//영향받은 row 수 return;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return ret;
	}

}
