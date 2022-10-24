package com.ssafy.sub;

import static java.lang.Math.max;

import java.util.ArrayList;

import com.ssafy.Phone;

public class PackageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phone p1 = new Phone();

		ArrayList<String> list = new ArrayList<>();

		int i = 10;
		int j = 20;

		int max = max(i, j);
		System.out.println(max);
	}

}
