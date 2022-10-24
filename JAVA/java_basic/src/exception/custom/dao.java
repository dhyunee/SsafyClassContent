package exception.custom;

//DB 연결 담당
public class dao {
	public int addEmpVocation(empdto dt, int days) throws empexception {
		// DB관련 작업 수행 전 valication check
		if (dt.getEmpNo().indexOf("emp") != 0) {// 사번이 emp로 시작하지 않으면
			// 문제 발생
			throw new empexception("ERR_03", "사원의 사번이 올바르지 않습니다.");

		}
		System.out.println("휴가등록 완료");
		return 1;
	}
}
