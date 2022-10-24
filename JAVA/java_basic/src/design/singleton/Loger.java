package design.singleton;

public class Loger {
	// #3 자신과 동일한 타입의 멤버 변수를 static으로 선언
	private static Loger loger = new Loger();

	// 1. 생성자를 private으로
	private Loger() {
	}

	// #2 외부에 객체를 한 개만 제공하는 method 구현
	public static Loger getInstance() {
//		if (loger == null) {
//			loger = new Loger();
//		}

		return loger;
	}

	// 외부에서 따로 객체를 만들자 않아도 되게 static이용
	public void log(String message) {
		System.out.println("[log]" + message);
	}
}
