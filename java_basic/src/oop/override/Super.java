package oop.override;

import java.io.IOException;

public class Super {

	// return type:primitive
	int m1() {
		System.out.println("Super - m1()");
		return 1;
	}

	B m2() {
		System.out.println("Super -m1()");
		return new B();
	}

	protected void m3() {
		System.out.println("Super - m3()");
	}

	void m4() throws IOException {
		System.out.println("Super - m4()");
	}

	// overloading 서로 다른 거임 아래 두 메소드는 파라미터 순서가 달라 시그니처 다르다
	void m5(String s, int i) {
	}

	void m5(int i, String s) {
	}

	void m6(int i, String... args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
	}
}
