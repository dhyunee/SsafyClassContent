package exception.custom;

public class empexception extends Exception {// 조건 1.exception 을 상속

	private static final long serialVersionUTD = 1l;

	//

	String excode;

	public empexception() {
	}

	public empexception(String message) {
		super(message);// 조건 2. exception 객ㅊ 생성을 위해 super()을 호출해 메세지 전달
	}

	public empexception(String excode, String message) {
		super(message);
		this.excode = excode;
	}

}
