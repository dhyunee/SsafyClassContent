package oop.inheritance;

public class Child extends Parent {
	public Child() {
		// 컴파일러가 자동으로 부모의 기본 생성자를 호출하는 코드를 넣어준다.
		super();

		System.out.println(super.name);// 같은 패키지여서 가능
	}
}
