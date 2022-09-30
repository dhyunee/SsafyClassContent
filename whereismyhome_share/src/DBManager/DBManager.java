package DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DBManager {
	//connection 객체를 얻어서 리턴
	
	 private final static String url = "jdbc:mysql://localhost:3306/my_house?serverTimezone=UTC";
	 
	    private final static String user = "root";
	    private final static String pass ="root";
	    
	    private final String driverName = "com.mysql.cj.jdbc.Driver";
	    
	    
	    private static DBManager instance = new DBManager();

	    private DBManager() {
	        // JDBC 드라이버를 로딩한다. 드라이버 로딩은 객체 생성 시 한번만 진행하도록 하자.
	        try {
	            Class.forName(driverName);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

	    public static DBManager getInstance() {
	        return instance;
	    }
	    
	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, user, pass);
	    }

	    /**
	     * 사용한 리소스들을 정리한다.
	     * Connection, Statement, ResultSet 모두 AutoCloseable 타입이다.
	     * ... 을 이용하므로 필요에 따라서
	     * select 계열 호출 후는 ResultSet, Statement, Connection
	     * dml 호출 후는 Statement, Connection 등 다양한 조합으로 사용할 수 있다.
	     *
	     * @param closeables
	     */
	    public void close(AutoCloseable... closeables) {
	        for (AutoCloseable c : closeables) {
	            if (c != null) {
	                try {
	                    c.close();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }

		//connection 객체를 반납받는
	public static void releaseConnection(ResultSet rs,PreparedStatement pstmt, Connection con) {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
