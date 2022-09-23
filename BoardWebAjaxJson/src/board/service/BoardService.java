package board.service;

import java.util.List;

import board.dto.BoardDto;
import board.dto.UserDto;

public interface BoardService {
	int boardInsert(BoardDto boardDto);
	List<BoardDto>boardList(int limit,int offset);
	List<BoardDto>boardListSearchWord(int limit,int offset,String searchWord);
	int boardListTotalCnt();
	int boardListSearchWordTotalCnt(String searchWord);
	BoardDto boardDetail(int boardId,int userSeq);//상세
}
