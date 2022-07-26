package basic.packagel;

public class Myclass {

	void m1() {
	}

	final void m2() {
	}

	void m3() {
		int n1 = 10;
		final int n2 = 20;

		n1 = 20;
//		n2=10;

		String str = "hello";
		str = "world";

//		final String str2="ssafy";
//		str2="부울경3"

		final int[] array = new int[3];
		array[1] = 10;
		array[1] = 20;
	}
}

final class FinalClass {
}

class SubClass extends Myclass {
	void m1() {
	}// overriding
	// void m2() {}
}