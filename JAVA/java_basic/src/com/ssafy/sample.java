package com.ssafy;

public class sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 10;
		Pass1 p = new Pass1();
		p.val = 10;
		change(i);
		change(p);
		System.out.println(i);
		System.out.println(p.val);

	}

	static void change(int x) {
		x = 5;
	}

	static void change(Pass1 p) {
		p.val = 5;
	}
}

class Pass1 {
	public int val = 3;
}