package Dao;

import java.util.List;

import Dto.DongCodeDto;
import Dto.GugunCodeDto;
import Dto.MainDto;
import Dto.SidoCodeDto;

public interface MainDao {
	// 검색 조건 맞춰서 검색
	

	List<GugunCodeDto> getGugun(String sidocode);

	List<DongCodeDto> getDong(String guguncode);

	// 리스트 띄움
	List<MainDto> mainList(String dongname, String code);

	// map

	// 게시판 추가

}
