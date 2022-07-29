package com.ssafy.ws01.step3;

public class DigitTest1 {
	public static void main(String[] args) {
		int cnt=0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(j<i)System.out.printf("%3s"," ");
				else System.out.printf("%3d",++cnt);
			}
			System.out.println();
		}
//			System.out.print((i+1)+"  ");
//		}
//		System.out.println();
//		
//		cnt+=1;
//		System.out.print("   ");
//		for(int i=6;i<10;i++) {
//			System.out.print(i+"  ");
//		}
//		System.out.println();
//		
//		cnt+=1;
//		for(int i=0;i<cnt;i++)System.out.print("   ");
//		for(int i=10;i<13;i++) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		
//		cnt+=1;
//		for(int i=0;i<cnt;i++)System.out.print("   ");
//		for(int i=13;i<15;i++) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		
//		cnt+=1;
//		for(int i=0;i<cnt;i++)System.out.print("   ");
//		System.out.print(15);
	}
}
