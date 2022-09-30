package oop.override;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// A a = new B();
		// a.a(3);
		// 호출 가능 여부 : A로 판단
		// 누굴 호출할지 : B로 판단
//		{
//			B b = new C();
//			b.a(5);
//			A a = new C();
//			a.a();
//			B b = new D();
//			b.a();
//			b.a(4);
//			b.b();
//		}
		{
			Parent p = new Child();
			p.m2();
		}

	}
}
