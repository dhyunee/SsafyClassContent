package com.mtcom.myboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mtcom.myboard.dto.BoardDto;
import com.mtcom.myboard.dto.BoardFileDto;
import com.mtcom.myboard.dto.BoardParamDto;
import com.mtcom.myboard.dto.UserDto;

//dao layer는 Controller, Service를 바라보고 코드를 작성X , DB 등 Persistance를 보고 작성
@Mapper
public interface BoardDao {
	//목록
	//limit, offset
	public List<BoardDto>boardList(BoardParamDto boardParamDto); 
	int boardListTotalCount();
	
	//searchWord
	public List<BoardDto>boardListSearchWord(BoardParamDto boardParamDto); 
	int boardListSearchWordTotalCount(BoardParamDto boardParamDto);
	
	//상세
	BoardDto boardDetail(BoardParamDto boardParamDto);//게시글 상세
	List<BoardFileDto>boardDetailFileList(int boardId);//특정 게시그에 첨부된 첨부파일 정보들
	
	//글 수정
	int boardUpdate(BoardDto dto);//게시글 수정
	List<String> boardFileUrlDeleteList(int boardId);//해당 게시글 첨부파일 url=>물리적인 파일 삭제에 사용
	
	//글 삭제
	int boardDelete(int boardId);
	int boardFileDelete(int boardId);//게시글 파일 정보 삭제
	
	//글 등록
	int boardInsert(BoardDto dto);//게시글 등록
	int boardFileInsert(BoardFileDto dto);//첨부파일 등록

	//조회수 관련
	//1 user 1 view 조거능로 readCount 처리
	int boardUserReadCount(BoardParamDto boardParamDto);//2 개의 파라미터 mybatis map에 대응<=Dto
	int boardUserReadInsert(@Param("boardId") int boardId,@Param("userSeq")int userSeq);//2개의 파라미터 mybatis map 대응<=@Param 활용
	
	int boardReadCountUpdate(int boardId);//게시글 조회수 1 증가
	int boardReadCountDelete(int boardId);//게시글 읽었는지 정보 삭제
}
