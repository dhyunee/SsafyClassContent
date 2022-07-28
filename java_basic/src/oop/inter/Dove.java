package oop.inter;

public class Dove extends Bird {
	// Bird 가 구현한 Fly 의 두 메소드가 맘에 들지 앙ㄶ는다. => 재정의
	@Override
	public void howtofly() {
		System.out.println("기억이 나지 않음");
	}
}
