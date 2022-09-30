import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class simpletest {

	public static void main(String[] args)throws Exception {
		//jdbc driver class loading (driver 가 자신의 객체를 drivermanager에 등록)
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//connection 객체를 생성 /획득=> java ==mysql 연결구조(인증을 거쳐야 한다)
		Connection con= 
				DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","root","root");
		
		//connection 객체를 통해 preparedstatement(statement) 객체 생성-> sql 수행
		//select
		//PreparedStatement pstmt=con.prepareStatement("select count(*)cnt from customer");
//		PreparedStatement pstmt=con.prepareStatement("insert into customer values (3,"삼길동")");
//		int ret=pstmt.executeQuery();
//		System.out.println(ret);
		
		//수정
//		PreparedStatement pstmt=con.prepareStatement("update customer set customer_nm='tkarlfehd2' where custormer_id=?");
//		pstmt.setInt(1, 3);//1번째 물음표 3으로 
//		int ret=pstmt.executeUpdate();
//		System.out.println(ret);
		
		PreparedStatement pstmt=con.prepareStatement("select * from product");
		ResultSet rset=pstmt.executeQuery();
		while(rset.next()) {
			System.out.println(rset.getInt("product_id"+"/"+rset.getString("product_nm")+"/"+
					rset.getInt("product_price")));
		}
		
//		PreparedStatement pstmt=con.prepareStatement("select count(*)cnt from customer");
//		PreparedStatement pstmt=con.prepareStatement("insert into customer values (3,"삼길동")");
//		int ret=pstmt.executeQuery();
//		System.out.println(ret);
		
		//작업 1 : 등록 /수정 /삭제=> 정수로 결과를 받는다. (정수는 영향을 받은 row 수 return)
		
		//작업 2: 조회(목록, 상세 조회)=>resultset 객체를 통해 결과를 받고 ,그걸 이용해 출력
//		ResultSet rset=pstmt.executeQuery();
//		if(rset.next()) {
//			System.out.println(rset.getInt("cnt"));
//		}
//		
		rset.close();
		pstmt.close();
		con.close();
		//resultset, preparedstatement , connection 순으로 자원을 반납(특히 connection 은 매우 비싼 자원)
		
		//위 모든 과정에서 MySQL 관련 작업 중 오류가 발생하면 MySQL은 SQLException 객체를 발생한다.
		

	}

}
