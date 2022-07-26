package exception.custom;

public class controller {
	public int addEmpVocation(empdto dt, int days) throws empexception {
		// 요청에대한 기본 검증
		if (dt == null || dt.getEmpNo() == null) {
			// 문제발생
			throw new empexception("ERR_01", "사원정보가 없숩니다.");
		}

		service s = new service();
		return s.addEmpVocation(dt, days);
	}
}
