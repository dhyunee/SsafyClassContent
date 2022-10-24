package basic.staticc;

public class Test {
	public static void main(String[] args) {
		System.out.println("MAIN");
		System.out.println(Myclass.cnt);
		Myclass mc = new Myclass();
		System.out.println(mc.num);
		System.out.println(mc.cnt);
		Myclass.m2();
		mc.m1();
		mc.m2();
		System.out.println(Myclass.cnt);
		System.out.println(mc.num);
	};
}
