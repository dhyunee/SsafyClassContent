package oop.poly.abstractt;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		os OS = new os();
		OS.print();

		OS.print(new printer());
		OS.print(new SamsungPrinter());
		OS.print(new LGprinter());
	}
}
