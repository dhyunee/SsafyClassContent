package com.mtcom.myboard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mtcom.myboard.dao.BoardDao;
import com.mtcom.myboard.dto.BoardDto;
import com.mtcom.myboard.dto.BoardFileDto;
import com.mtcom.myboard.dto.BoardParamDto;
import com.mtcom.myboard.dto.BoardResultDto;

//Controller의 요청에 의해 필요한 파라미터는 받고, 원하는 결과 데이터를 만들어서 리턴해준다.
//Business logic의 핵심을 바로 Service layer에서!!!
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao dao;

	private final int SUCCESS = 1;
	private final int FAIL = -11;
//C:\Users\SSAFY\Documents\workspace-sts-3.9.14.RELEASE\BoardFiluploadSpringMVCMqbatis\src\main\webapp\resources\static
	private final String uploadPath = "C:" + File.separator + "Users" + File.separator + "SSAFY" + File.separator
			+ "Documents" + File.separator + "workspace-sts-3.9.14.RELEASE" + File.separator
			+ "BoardFiluploadSpringMVCMqbatis" + File.separator + "src" + File.separator + "main" + File.separator
			+ "webapp" + File.separator + "resources" + File.separator + "static";

	private final String uploadFolder = "upload";

	@Override
	public BoardResultDto boardList(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = new BoardResultDto();

		try {
			// 목록, 총건수를 가져온다.
			List<BoardDto> list = dao.boardList(boardParamDto);
			int count = dao.boardListTotalCount();
			boardResultDto.setList(list);
			boardResultDto.setCount(count);
			boardResultDto.setResult(SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}

		return boardResultDto;
	}

	@Override
	public BoardResultDto boardListSearchWord(BoardParamDto boardParamDto) {

		BoardResultDto boardResultDto = new BoardResultDto();

		try {
			// 목록, 총건수를 가져온다.
			List<BoardDto> list = dao.boardListSearchWord(boardParamDto);
			int count = dao.boardListSearchWordTotalCount(boardParamDto);
			boardResultDto.setList(list);
			boardResultDto.setCount(count);
			boardResultDto.setResult(SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}

		return boardResultDto;
	}

	@Override
	public BoardResultDto boardDetail(BoardParamDto boardParamDto) {

		BoardResultDto boardResultDto = new BoardResultDto();

		try {
			//현재 게시글을 현재 사용자가 읽었는지 (visit)확인
			//안 읽었으면 신규로 게시글 읽었다는 insert를 하고, 게시글 조회수 +1처리
			//읽었으면 무시
			int userReadCount=dao.boardUserReadCount(boardParamDto);
			if(userReadCount==0) {
				dao.boardUserReadInsert(boardParamDto.getBoardId(),boardParamDto.getUserSeq() );
				dao.boardReadCountUpdate(boardParamDto.getBoardId());
			}
			
			// db에서 게시글 정보를 가져온다.
			BoardDto boardDto = dao.boardDetail(boardParamDto);
			// 게시글 작성자와 현재 상세조회하고 있는 사용자의 동일인 여부 확인 필요
			if (boardDto.getUserSeq() == boardParamDto.getUserSeq()) {
				boardDto.setSameUser(true);
			} else {
				boardDto.setSameUser(false);
			}
			
			//해당 게시글에 대한 첨부파일 정보 추가
			List<BoardFileDto>fileList=dao.boardDetailFileList(boardDto.getBoardId());
			boardDto.setFileList(fileList);
			
			// boardResultDto의 일부인 boardDto를 설정
			boardResultDto.setDto(boardDto);
			boardResultDto.setResult(SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}

		return boardResultDto;
	}

	@Override
	@Transactional //DB transaction 정책//파일 저장을 원복이나 복구 불가
	public BoardResultDto boardInsert(BoardDto boardDto, MultipartHttpServletRequest request) {
		BoardResultDto boardResultDto = new BoardResultDto();
		// 게시글을 테이블에 등록
		// 물리적인 파일 저장
		// 여러 개의 파일이 기본
		// multipart의 각 part 별로 파일을 구분해서 물리적으로 저장=> 파일 업로드 정보를 테이블에 저장
		try {
			dao.boardInsert(boardDto);
			System.out.println("generated key:" + boardDto.getBoardId());

			File uploadDir = new File(uploadPath + File.separatorChar + uploadFolder);// 업로드된 파일이 저장될 폴더(디렉토리)
			if (!uploadDir.exists())
				uploadDir.mkdir();

			List<MultipartFile> fileList = request.getFiles("file");

			//nullpoint 예외 발생
//			String str=null;
//			str.length();
			
			for (MultipartFile partFile : fileList) {
				int boardId = boardDto.getBoardId();
				String fileName = partFile.getOriginalFilename();// 첨부된 원래 파일 명,이 이름으로는 바로 저장하지 않고 UUID를 이용해서 중복 불가한
																	// 파일이름을 만든다.

				// Random UUID File id
				UUID uuid = UUID.randomUUID();// 대체될 파일 이름

				// 파일 확장자
				String extension = FilenameUtils.getExtension(fileName);// 원래 파일의 확장자만 추출

				// 실제 저장할 파일 전체 이름은
				String savingFileName = uuid + "." + extension;

				File destFile = new File(
						uploadPath + File.separatorChar + uploadFolder + File.separator + savingFileName);

				// 파일 객체를 통해서 파일을 저장
				partFile.transferTo(destFile);

				
				// 테이블에 첨부파일 정보 저장
				BoardFileDto boardFileDto = new BoardFileDto();
				boardFileDto.setboardId(boardId);
				boardFileDto.setFileName(fileName);
				boardFileDto.setFileSize(partFile.getSize());
				boardFileDto.setFileContentType(partFile.getContentType());
				boardFileDto.setFileUrl(uploadFolder + "/" + savingFileName);

				dao.boardFileInsert(boardFileDto);

			}

			boardResultDto.setResult(SUCCESS);
			// 물리적인 파일 업로드 경로 설정

//	    	int ret = dao.boardInsert(boardDto); // insert 되는 건수   
//	        if( ret == 1 ) {
//	            boardResultDto.setResult(SUCCESS);
//	        }else {
//	            boardResultDto.setResult(FAIL);
//	        }

		} catch (IOException e) {//ioexception은 nullpoint 못잡음
			//만약, 파일 저장 작업 중 오류가 발생하면 IOException catch block의 코드가 실행됨.
			//2가지 작업 필요
			//#1. 예외 발생 이전에 저장된 파일을 모두 삭제=> 직접 물리적인 파일 삭제 작업 수행
			//#2 이전에 테이블에 등록된 작업 취소=>spring을 통해서! @Transaction을 이용하기 위해 runtimeException 계열의 예외를 발생 throw new RuntimException()
			
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
			throw new RuntimeException();
			//->catch(Exception e)여야 함 : exeption이 nullpoint 잡고 runtimeexception던짐(생성)
			//->data base에 오류나기전 들어간 거 빼야해서
		}

		return boardResultDto;
	}

	@Override
	@Transactional
	public BoardResultDto boardUpdate(BoardDto boardDto, MultipartHttpServletRequest request) {
		BoardResultDto boardResultDto = new BoardResultDto();

		try {
			dao.boardUpdate(boardDto);

			File uploadDir = new File(uploadPath + File.separatorChar + uploadFolder);// 업로드된 파일이 저장될 폴더(디렉토리)
			if (!uploadDir.exists())
				uploadDir.mkdir();

			// 기존에 첨부된 물리적인 파일 삭제, 첨부 파일이 여러 개 감안
			List<String> fileUrlList = dao.boardFileUrlDeleteList(boardDto.getBoardId());

			for (String fileUrl : fileUrlList) {
				File file = new File(uploadPath + File.separator + fileUrl);// fileUrl은 upload...
				if (file.exists()) {
					file.delete();
				}
			}
			// 테이블에서 게시판 파일 정보 삭제
			dao.boardFileDelete(boardDto.getBoardId());

			//수정과정에서 새로 추가된 첨부 파일 등록
			List<MultipartFile> fileList = request.getFiles("file");

			for (MultipartFile partFile : fileList) {
				int boardId = boardDto.getBoardId();
				String fileName = partFile.getOriginalFilename();// 첨부된 원래 파일 명,이 이름으로는 바로 저장하지 않고 UUID를 이용해서 중복 불가한
																	// 파일이름을 만든다.

				// Random UUID File id
				UUID uuid = UUID.randomUUID();// 대체될 파일 이름

				// 파일 확장자
				String extension = FilenameUtils.getExtension(fileName);// 원래 파일의 확장자만 추출

				// 실제 저장할 파일 전체 이름은
				String savingFileName = uuid + "." + extension;

				File destFile = new File(
						uploadPath + File.separatorChar + uploadFolder + File.separator + savingFileName);

				// 파일 객체를 통해서 파일을 저장
				partFile.transferTo(destFile);

				// 테이블에 첨부파일 정보 저장
				BoardFileDto boardFileDto = new BoardFileDto();
				boardFileDto.setboardId(boardId);
				boardFileDto.setFileName(fileName);
				boardFileDto.setFileSize(partFile.getSize());
				boardFileDto.setFileContentType(partFile.getContentType());
				boardFileDto.setFileUrl(uploadFolder + "/" + savingFileName);

				dao.boardFileInsert(boardFileDto);

			}

			boardResultDto.setResult(SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}

//	@Override
//	public BoardResultDto boardDelete(int boardId) {
//		BoardResultDto boardResultDto = new BoardResultDto();
//
//		try {
//			int ret = dao.boardDelete(boardId);
//			if (ret == 1) {// delete 되는 건수
//				boardResultDto.setResult(SUCCESS);
//			} else
//				boardResultDto.setResult(FAIL);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			boardResultDto.setResult(FAIL);
//		}
//		return boardResultDto;
//	}

	@Override
	@Transactional
	public BoardResultDto boardDelete(int boardId) {
	    
	    BoardResultDto boardResultDto = new BoardResultDto();
	    
	    try {
	        List<String> fileUrlList = dao.boardFileUrlDeleteList(boardId);
	        for(String fileUrl : fileUrlList) {
	            File file = new File(uploadPath + File.separator, fileUrl);                
	            if(file.exists()) {
	                file.delete();
	            }
	        }
	        
	        // 삭제 순서
	        dao.boardFileDelete(boardId);
	        dao.boardReadCountDelete(boardId);
	        dao.boardDelete(boardId);        
	        boardResultDto.setResult(SUCCESS);
	        
	    }catch(Exception e) {
	        e.printStackTrace();
	        boardResultDto.setResult(FAIL);
	        // 파일업로드 등이 실패할 경우 IOException 이 발생하는데, IOException 을 throw 할 경우 Rollback 되지 않는다.
	        // UncheckedException 발생
	        throw new RuntimeException();            
	    }
	    
	    return boardResultDto;
	}

}
