package oop.inheritance;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrandParent gp = new GrandParent();
		System.out.println(gp.getName());

		// 1 by setter
//		Parent p = new Parent();
//		p.setName("아버지");

		// 2 by constructor
		Parent p = new Parent("어머니");
		System.out.println(p.getName());
	}

}
