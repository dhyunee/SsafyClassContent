package Dao;

import java.util.List;

import Dto.BoardDto;

public interface BoardDao {
	int boardInsert(BoardDto dto);
	int boardDelete(int boardId);
	int boardUpdate(BoardDto dto);
	
	/**
	 * @param limit : 가져오는 항목의 개수
	 * @param offset : 건너뛸 수
	 */
	List<BoardDto> boardList(int limit, int offset);
	 int boardListTotalCnt();

	 
	 BoardDto boardDetail(int boardId); // 상세 조회
}
