package oop.inheritance;

public class GrandParent {
	String name = "할아버지";// 상속관계에서 접근 불가능, class, package에서만 가능
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public GrandParent() {
	}

	public GrandParent(String name) {
		this.name = name;
	}
}
