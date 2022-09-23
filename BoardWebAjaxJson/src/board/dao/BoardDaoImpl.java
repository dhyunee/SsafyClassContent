package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.common.DBManager;
import board.dto.BoardDto;

public class BoardDaoImpl implements BoardDao{

	private static BoardDaoImpl instance=new BoardDaoImpl();
	private BoardDaoImpl() {}
	
	public static BoardDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public int boardInsert(BoardDto boardDto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int ret=-1;
		
		try {
			con=DBManager.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" insert into board \n")
			.append(" (user_seq, title, content, reg_dt,read_count)\n")
			.append(" values (?,?,?,now(),0)");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardDto.getUserSeq());
			pstmt.setString(2, boardDto.getTitle());
			pstmt.setString(3, boardDto.getContent());
			
			ret=pstmt.executeUpdate();//영향받은 row 수 return;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return ret;
	}

	@Override
	public List<BoardDto> boardList(int limit, int offset) {
		
		List<BoardDto>list=new ArrayList<BoardDto>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=DBManager.getConnection();
			StringBuilder sql=new StringBuilder();

			
			sql.append(" select b.board_id,b.user_seq,u.user_name,u.user_profile_image_url,b.title,b.content,b.reg_dt,b.read_count \n")
			.append("from BOARD b,USERS u \n")
			.append(" where b.user_seq=u.user_seq \n")
			.append("order by b.board_id desc \n")
			.append(" limit ? offset ?");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, limit);
			pstmt.setInt(2, offset);

			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto boardDto =new BoardDto();
				boardDto.setBoardId(rs.getInt("board_id"));
				boardDto.setUserSeq(rs.getInt("user_seq"));
				boardDto.setUserName(rs.getString("user_name"));
				boardDto.setUserProfileImageUrl(rs.getString("user_profile_image_url"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setRegDt(rs.getTimestamp("reg_dt").toLocalDateTime());
				boardDto.setReadCount(rs.getInt("read_count"));
				list.add(boardDto);
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return list;
	}

	@Override
	public List<BoardDto> boardListSearchWord(int limit, int offset, String searchWord) {
		List<BoardDto>list=new ArrayList<BoardDto>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=DBManager.getConnection();
			StringBuilder sql=new StringBuilder();

			
			sql.append(" select b.board_id,b.user_seq,u.user_name,u.user_profile_image_url,b.title,b.content,b.reg_dt,b.read_count \n")
			.append("from BOARD b,USERS u \n")
			.append(" where b.user_seq=u.user_seq \n")
			.append(" and b.title like ?")//주의!!! like에 ?처리 어떻게?=>%?%안됨 
			.append("order by b.board_id desc \n")
			.append(" limit ? offset ?");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, "%"+searchWord+"%");
			pstmt.setInt(2, limit);
			pstmt.setInt(3, offset);

			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto boardDto =new BoardDto();
				boardDto.setBoardId(rs.getInt("board_id"));
				boardDto.setUserSeq(rs.getInt("user_seq"));
				boardDto.setUserName(rs.getString("user_name"));
				boardDto.setUserProfileImageUrl(rs.getString("user_profile_image_url"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setRegDt(rs.getTimestamp("reg_dt").toLocalDateTime());
				boardDto.setReadCount(rs.getInt("read_count"));
				list.add(boardDto);
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return list;
	}

	@Override
	public int boardListTotalCnt() {
		int totalCnt=-1;
		List<BoardDto>list=new ArrayList<BoardDto>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=DBManager.getConnection();
			StringBuilder sql=new StringBuilder();

			
			sql.append(" select count(*) from BOARD b \\n");

			pstmt=con.prepareStatement(sql.toString());

			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				totalCnt=rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return totalCnt;
	}

	@Override
	public int boardListSearchWordTotalCnt(String searchWord ) {
		int totalCnt=-1;
		List<BoardDto>list=new ArrayList<BoardDto>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=DBManager.getConnection();
			StringBuilder sql=new StringBuilder();

			
			sql.append(" select count(*) from BOARD where title like ? \n");

			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, '%'+searchWord+'%');
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				totalCnt=rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return totalCnt;
	}

	@Override
	public BoardDto boardDetail(int boardId) {
		BoardDto boardDto=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=DBManager.getConnection();
			StringBuilder sql=new StringBuilder();
			
			sql.append(" select b.board_id,b.user_seq,u.user_name,u.user_profile_image_url,b.title,b.content,b.reg_dt,b.read_count \n")
			.append("from BOARD b,USERS u \n")
			.append(" where b.user_seq=u.user_seq \n")
			.append("and b.board_Id= ? \n");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardId);

			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				boardDto =new BoardDto();
				boardDto.setBoardId(rs.getInt("board_id"));
				boardDto.setUserSeq(rs.getInt("user_seq"));
				boardDto.setUserName(rs.getString("user_name"));
				boardDto.setUserProfileImageUrl(rs.getString("user_profile_image_url"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setRegDt(rs.getTimestamp("reg_dt").toLocalDateTime());
				boardDto.setReadCount(rs.getInt("read_count"));
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return boardDto;
	}


}
