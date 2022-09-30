package basic.staticc;

public class Myclass {
	static int cnt = 10;
	int num = 20;

	static {
		System.out.println("static intializer");
		cnt++;
	}

	void m1() {
		System.out.println("non static m1");
		cnt++;
		num++;
	}

	static {
		System.out.println("static intializer");
		cnt++;
	}

	static void m2() {
		System.out.println("static m2");
		cnt++;
	}

}
