package com.mycom.myapp.aspect;

import org.springframework.stereotype.Component;

@Component
public class BusinessProcess {
	public void bp() {
		//Log code가 있어야 할 위치 그러나 aop를 이용해서 log 를 남기려고 함
		System.out.println("BusinessPRocess: bp() is called!");
	}
	public void no_bp() {
		System.out.println("BusinessPRocess: no_bp() is called!");
	}
	public int int_bp() {
		System.out.println("BusinessPRocess: int_bp() is called!");
		return 0;
	}
	public int String_bp(String s1,int i,String s2) {
		System.out.println("BusinessPRocess: String_bp() is called!");
		return 0;
	}
}
