package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBManager.DBManager;
import Dto.BoardDto;

public class BoardDaoImpl implements BoardDao{

	private static BoardDaoImpl instance = new BoardDaoImpl();
	private DBManager util = DBManager.getInstance();
	private BoardDaoImpl () {}
	
	public static BoardDaoImpl getInstance() {
		return instance;
	}
	@Override
	public int boardInsert(BoardDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int ret = -1;
		
		try {
			con = util.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO board")
			.append(" (board_id, title, content)")
			.append(" VALUES(?, ?, ?)");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1,  dto.getBoardId());
			pstmt.setString(2,  dto.getTitle());
			pstmt.setString(3,  dto.getContent());
			
			ret = pstmt.executeUpdate(); // 영향받은 row수 return
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.close(con, pstmt, rs);
		}
		return ret;
	}

	@Override
	public List<BoardDto> boardList(int limit, int offset) {
		
		List<BoardDto> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int ret = -1;
		
		try {
			con = util.getConnection();
			StringBuilder sb = new StringBuilder();
			
			
			sb.append("SELECT board_id, title")
			.append(" FROM BOARD")
			.append(" ORDER BY board_id")
			.append(" limit ? offset ? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1,  limit);
			pstmt.setInt(2,  offset);
			
			rs = pstmt.executeQuery(); //
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBoardId(rs.getInt("board_id"));
				boardDto.setTitle(rs.getString("title"));
				list.add(boardDto);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.close(con, pstmt, rs);;
		}
		return list;
	}


	@Override
	public int boardListTotalCnt() {
		int totalCnt = -1;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int ret = -1;
		
		try {
			con = util.getConnection();
			StringBuilder sb = new StringBuilder();
			
			
			sb.append("SELECT COUNT(*) FROM BOARD ");
			
			pstmt = con.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery(); //
			if(rs.next()) {
				totalCnt = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.close(con, pstmt, rs);
		}
		return totalCnt;
	}


	@Override
	public BoardDto boardDetail(int boardId) {
		BoardDto boardDto = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = util.getConnection();
			StringBuilder sb = new StringBuilder();
			
			
			sb.append("SELECT b.board_id, b.user_seq, u.user_name, u.user_profile_image_url, b.title, b.content, b.reg_dt, b.read_count ")
			.append(" FROM BOARD AS b, USERS AS u")
			.append(" WHERE b.user_seq = u.user_seq")
			.append(" AND b.board_Id = ?");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1,  boardId);
			
			rs = pstmt.executeQuery(); //
			while(rs.next()) {
				boardDto = new BoardDto();
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
			util.close(con, pstmt, rs);
		}
		return boardDto;
	}

	@Override
	public int boardDelete(int boardId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int ret = -1;
		
		try {
			con = util.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("DELETE FROM board")
			.append(" WHERE board_Id = ?");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1,  boardId);
			
			ret = pstmt.executeUpdate(); // 영향받은 row수 return
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.close(con, pstmt, rs);
		}
		return ret;
	}

	@Override
	public int boardUpdate(BoardDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int ret = -1;
		
		try {
			con = util.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE board")
			.append(" SET title = ?, content = ?")
			.append(" WHERE board_id = ? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,  dto.getTitle());
			pstmt.setString(2,  dto.getContent());
			pstmt.setInt(3,  dto.getBoardId());
			
			ret = pstmt.executeUpdate(); // 영향받은 row수 return
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.close(con, pstmt, rs);
		}
		return ret;
	}

}
