package com.ssafy.live1.oop1.person;
//person사용하는 main 주체
public class Personquset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//붕어빵 틀->붕어빵
		int a=10;
		//person이 int처럼 타입-> 클래스 이름은 타입!!!
		Person p=new Person();
		p.name="홍길동";
		p.age=30;
		p.isHungry=true;
		p.eat();
		System.out.println(p.name+" : "+p.isHungry);
	
		Person p2=new Person();
		p2.name="장길산";
		p2.isHungry=true;
		System.out.println(p2.name+" : "+p2.isHungry);
	}

}
