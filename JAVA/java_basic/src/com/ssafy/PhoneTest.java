package com.ssafy;

public class PhoneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phone phone = new Phone("S22", 'B', 5000);
		System.out.println(phone.getName());

		Phone phone2 = new Phone("S22", 'A', 10000);
		Phone phone3 = new Phone("S22", 'A', 10000);

		System.out.println(phone2);
		System.out.println(phone3);

		// Phone phone2 = new Phone("S22", 'B');
//		Phone phone = new Phone("Z-Flip");// 생성자(constructor)호출
//		phone.setColor('A');
//
//		Phone phone2 = new Phone("Note");
//		phone2.setColor('B');
//
//		System.out.println(phone.getSalePrice());
//		System.out.println(phone2.getSalePrice());

	}
}
