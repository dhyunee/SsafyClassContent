package oop.override2;

public class yum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Koreanfood kf = new kimchi();
		kf.a();

		Koreanfood kf1 = new chikensoup();
		kf1.c();

		kimchi k = new cucumblekimch();
		k.b(5);

//		Koreanfood kf2 = new kimchi();
//		kf2.b();
	}

}
