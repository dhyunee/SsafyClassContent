package oop.override;

public class Child extends Parent {
	void m2() {
		System.out.println("Child - m2()");
		super.m1();// super을 통한 것은 overriding이 되지 않고 부모의 메소드를 호출
		// 부모가 다시 overriding 시키는 애를 호출하고 있으면 무한 반복-> stack over flow
	}
}
