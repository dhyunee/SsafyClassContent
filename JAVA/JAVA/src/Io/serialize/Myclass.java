package Io.serialize;

import java.io.Serializable;

public class Myclass implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int n;
	String str;
	
	int x;//애 넣고 test에 없어도 그대로 출력->x는 그냥 초기값 가짐
	
}
