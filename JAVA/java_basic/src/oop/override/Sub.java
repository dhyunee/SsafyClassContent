package oop.override;

public class Sub extends Super {
	@Override
	int m1() {
		System.out.println("Sub - m1()");
		return 1;
	}

	@Override
	C m2() {
		System.out.println("Sub -m2");
		return new C();
	}

	public void m3() {
		System.out.println("Sub - m3()");
	}

	@Override
	void m4() {
		System.out.println("Sub - m4()");
	}

	void m6(int i, String... args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
	}
}
