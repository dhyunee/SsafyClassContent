package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import board.common.DBManager;
import board.dto.BoardDto;

public class BoardDaoImpl implements BoardDao{

	private static BoardDaoImpl instance=new BoardDaoImpl();
	private BoardDaoImpl() {}
	
	public static BoardDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public int boardwrite(BoardDto boardDto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int ret=-1;
		try{
			conn=DBManager.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" insert into board/n").append("( BoardId, UserSeq, Title, Content, RegDt, ReadCount )\n")
			.append(" values()")
		}
		return 0;
	}

}
