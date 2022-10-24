package exception.custom;

public class Test {

	public static void main(String[] args) {
		controller cont = new controller();
		empdto dt = getempdto();
		try {
			cont.addEmpVocation(dt, 4);
		} catch (empexception e) {
			switch (e.excode) {
			// 아래의 코드는 동일한 처리<=switch case문 필요 없음 다만 구조적인 형태를 취하기 위해
			case "ERR_01":
				System.out.println(e.excode + " : " + e.getMessage());
				break;
			case "ERR_02":
				System.out.println(e.excode + " : " + e.getMessage());
				break;
			case "ERR_03":
				System.out.println(e.excode + " : " + e.getMessage());
				break;
			}
		}
	}

	static empdto getempdto() {
		// return null;// empdto자체가 null
		// return new empdto();// empdto의 empNo null
		// return new empdto("111");
		return new empdto("emp111");
	}

}
