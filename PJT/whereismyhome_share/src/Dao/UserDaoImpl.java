package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBManager.DBManager;
import Dto.UserDto;

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
			
			System.out.println(userDto.getUserEmail());
			
			ret=pstmt.executeUpdate();//영향받은 row 수 return;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return ret;
	}

	@Override
	public int deleteUser(UserDto userDto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int ret=-1;
		try {
			conn=DBManager.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select User_Email from Users \n").append(" where User_Email=? and user_password=?");
			
			pstmt.setString(1, userDto.getUserEmail());
			pstmt.setString(2, userDto.getUserPassword());
			ret=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs, pstmt, conn);
		}
		return ret;
	}

}
