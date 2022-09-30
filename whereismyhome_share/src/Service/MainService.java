package Service;

import java.util.List;

import Dto.DongCodeDto;
import Dto.GugunCodeDto;
import Dto.MainDto;
import Dto.SidoCodeDto;

public interface MainService {
	//검색
	//시도 가지고 오고
	//화면에 뿌려주고
	//구군을 가지고 오고
	//화면에 뿌려주고
	//동

	List<GugunCodeDto> getGugun(String sidocode);
	List<DongCodeDto> getDong(String guguncode);
	//리스트 띄움
	List<MainDto>mainList(String dongname,String code);
	
}
