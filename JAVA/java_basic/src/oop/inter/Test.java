package oop.inter;

public class Test {

	public static void main(String[] args) {
		// 본질적인 상속 관계 type polymorphism
//		{
//			Animal bird = new Bird();
//			bird.eat();// 본질적인 is a 관계의 메소드
//		}
//		// 본질적인 상속 관계 type polymorphism
//		{
//			Fly bird = new Bird();
//			bird.howfastfly();
//
//			Fly airplane = new Airplane();
//			bird.howfastfly();
//		}
		// 구체적인 추상화
		// 실제로 Fly를 구현한 클래스를 알지 않아도 된다.
		// 단지 Fly를 구현한 클래스의 객체만 필요
		// Test.java 이해당시자(사용자)와 getinstance()를 제공하는 이해당사자(제공자)
		// 중간에서 일종의 공유되는 약속, 규약을 의미
		{
			Fly fly = FlyFactory.getinstance("airplane");
			fly.howfastfly();
			fly.howtofly();
		}
	}

//	static Fly getinstance(String clsf) {
//		switch(clsf) {
//		case "dove":return new Dove();
//		case "airplane":return new Airplane();
//		case "bird":return new Bird();
//		default: return new Airplane();
//		}
//	}
}
