package java5.generic.wildcard;

public class Wildcard {

	public static void main(String[] args) {
		// 변수 선언과 할당
		// String, Object 등 모든 generictype 객체가 가능
		generictype<?> gt1 = new generictype<>();
		generictype<?> gt2 = new generictype<Object>();

		generictype<? extends B> gt3 = new generictype<C>();
//		generictype<? extends B> gt4 = new generictype<A>();//오류

		generictype<? super B> gt5 = new generictype<A>();
		// 메소드 호출
		m1(new generictype<Object>());
		m1(new generictype<C>());

		m2(new generictype<C>());
		// m2(new generictype<A>());//오류 extends 하위 클래스여야 함

		m3(new generictype<A>());
//		m3(new generictype<C>());//오류 super 상위 클래스여야 함

	}

	static class generictype<T> {
		T t;
	}

	static class A {
	}

	static class B extends A {
	}

	static class C extends B {
	}

	static void m1(generictype<?> p) {
	}

	static void m2(generictype<? extends B> p) {
	}

	static void m3(generictype<? super B> p) {
	}
}
