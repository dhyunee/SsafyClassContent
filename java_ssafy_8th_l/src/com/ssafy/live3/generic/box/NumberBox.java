package com.ssafy.live3.generic.box;

public class NumberBox<T> {
	public void addSome(T...ts) {//T는 Number 또는 Number을 상속 받은 애다.
		double sum=0;//T는 최소한 number 긴응르 사용할 수 있다.
		for(T t:ts) {
			sum+=(double)t;
		}
		System.out.println(sum);
	}
}
