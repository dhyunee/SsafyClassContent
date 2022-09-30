package Service;

import java.util.List;

import Dao.MainDao;
import Dao.MainDaoImpl;
import Dto.DongCodeDto;
import Dto.GugunCodeDto;
import Dto.MainDto;
import Dto.SidoCodeDto;

public class MainServiceImpl implements MainService {

	private static MainServiceImpl instance = new MainServiceImpl();

	private MainServiceImpl() {
	}

	public static MainServiceImpl getInstance() {
		return instance;
	}

	MainDao mainDao = MainDaoImpl.getInstance();




	@Override
	public List<GugunCodeDto> getGugun(String sidocode) {
		return mainDao.getGugun(sidocode);
	}

	@Override
	public List<DongCodeDto> getDong(String guguncode) {
		return mainDao.getDong(guguncode);
	}
	
	@Override
	public List<MainDto> mainList(String dongname,String code){

		return mainDao.mainList(dongname,code);
	}

}
