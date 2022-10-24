package oop.inheritance;

public class Parent extends GrandParent {
	// String name = "아버지";
	public Parent(String name) {
		// super.setName(name);
		super(name);
	}

	public Parent() {
	}// 얘 없으면 기본 생성자 없어서 Child에서 오류 남
}
