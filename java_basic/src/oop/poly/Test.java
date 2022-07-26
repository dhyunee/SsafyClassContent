package oop.poly;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
//		m(a);// A-a!
//		m(b);// A와 상속 관계 A-a!
//		m(c); // void m(A a)로 들어갈 수 있지만 더 구체적인 곳에 들어감 만약 m(C c)가 없으면 A-a!출력
//		m(d);
//
//		B bd = new D();// 파라미터 전달 시 타입은 왼쪽을 기준으로 !
//		m(bd);

		// instanceof: 실제로 만들어진 객체의 타입, 하지만 이것도(오른쪽) 다형성이 존재
		m2(a);
		m2(b);
		m2(c);
		m2(d);
	}

//	static void m(A a) {
//		System.out.println("A a!");
//		a.a();
//	}
//
//	static void m(C c) {
//		System.out.println("C c!");
//		c.a();
//	}
	// a,b,c,d를 구분하고 싶다
	static void m2(A a) {
		if (a instanceof D) {
			System.out.println("D");
		} else if (a instanceof C) {
			C tmp = (C) a;
			System.out.println("C");
		} else if (a instanceof B) {
			System.out.println("B");
		} else if (a instanceof A) {
			System.out.println("A");
		}
	}
}
