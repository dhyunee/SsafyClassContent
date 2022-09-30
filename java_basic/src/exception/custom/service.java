package exception.custom;

public class service {
	public int addEmpVocation(empdto dt, int days) throws empexception {
		// 비즈니스 로직(인사규정에 맞는지)
		// 휴가 일수가 5일을 초과하면 안됨
		if (days > 5) {
			// 문제발생
			throw new empexception("ERR_02", "휴가일수가 5일을 초과");
		}
		dao da = new dao();
		return da.addEmpVocation(dt, days);
	}
}