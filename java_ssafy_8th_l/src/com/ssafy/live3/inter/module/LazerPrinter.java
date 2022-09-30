package com.ssafy.live3.inter.module;

public class LazerPrinter implements Printer {
	@Override
	public void print(String filename) {
		System.out.println("lazer printer: "+filename);
	}
}
