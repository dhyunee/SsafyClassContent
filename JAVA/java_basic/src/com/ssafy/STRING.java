package com.ssafy;

public class STRING {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i1 = 10;
		int i2 = 10;

		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		String s4 = new String("Hello");

		if (i1 == i2)
			System.out.println("i1==i2");
		if (s1 == s2)
			System.out.println("s1==s2");
		if (s3.equals(s4))
			System.out.println("s3==s4");
	}

}
