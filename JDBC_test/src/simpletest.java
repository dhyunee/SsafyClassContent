import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class simpletest {

	public static void main(String[] args)throws Exception {
		//jdbc driver class loading (driver �� �ڽ��� ��ü�� drivermanager�� ���)
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//connection ��ü�� ���� /ȹ��=> java ==mysql ���ᱸ��(������ ���ľ� �Ѵ�)
		Connection con= 
				DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","root","root");
		
		//connection ��ü�� ���� preparedstatement(statement) ��ü ����-> sql ����
		//select
		//PreparedStatement pstmt=con.prepareStatement("select count(*)cnt from customer");
//		PreparedStatement pstmt=con.prepareStatement("insert into customer values (3,"��浿")");
//		int ret=pstmt.executeQuery();
//		System.out.println(ret);
		
		//����
//		PreparedStatement pstmt=con.prepareStatement("update customer set customer_nm='tkarlfehd2' where custormer_id=?");
//		pstmt.setInt(1, 3);//1��° ����ǥ 3���� 
//		int ret=pstmt.executeUpdate();
//		System.out.println(ret);
		
		PreparedStatement pstmt=con.prepareStatement("select * from product");
		ResultSet rset=pstmt.executeQuery();
		while(rset.next()) {
			System.out.println(rset.getInt("product_id"+"/"+rset.getString("product_nm")+"/"+
					rset.getInt("product_price")));
		}
		
//		PreparedStatement pstmt=con.prepareStatement("select count(*)cnt from customer");
//		PreparedStatement pstmt=con.prepareStatement("insert into customer values (3,"��浿")");
//		int ret=pstmt.executeQuery();
//		System.out.println(ret);
		
		//�۾� 1 : ��� /���� /����=> ������ ����� �޴´�. (������ ������ ���� row �� return)
		
		//�۾� 2: ��ȸ(���, �� ��ȸ)=>resultset ��ü�� ���� ����� �ް� ,�װ� �̿��� ���
//		ResultSet rset=pstmt.executeQuery();
//		if(rset.next()) {
//			System.out.println(rset.getInt("cnt"));
//		}
//		
		rset.close();
		pstmt.close();
		con.close();
		//resultset, preparedstatement , connection ������ �ڿ��� �ݳ�(Ư�� connection �� �ſ� ��� �ڿ�)
		
		//�� ��� �������� MySQL ���� �۾� �� ������ �߻��ϸ� MySQL�� SQLException ��ü�� �߻��Ѵ�.
		

	}

}
