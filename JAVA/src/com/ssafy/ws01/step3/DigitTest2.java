package com.ssafy.ws01.step3;

public class DigitTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target=5/2;
		int blank=0;//출력할 공백문자 수
		boolean isincrease=true;//공백 증가 or 감소
		int no=1;
//		while(no<=17) {
//			for(int i=0;i<blank;i++)System.out.printf("%3s"," ");
//			for(int i=0;i<5-2*blank;i++)System.out.printf("%3d",no++);
//			System.out.println();
//			
//			if(isincrease)blank++;
//			else blank--;
//			
//			if(blank==target)isincrease=false;
//		}
		int cnt=0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(i>2) {
					if(j<4-i)System.out.printf("%3s"," ");
					else if(j<5-(4-i))System.out.printf("%3d",++cnt);
				}
				else {
					if(j<i)System.out.printf("%3s"," ");
					else if(4-j<i)System.out.printf("%3s"," ");
					else System.out.printf("%3d",++cnt);
				}
			}
			
			System.out.println();
		}
		
//		for(int i=1;i<6;i++)System.out.printf(i+"  ");
//		System.out.println();
//		
//		
//		System.out.print("   ");
//		for(int i=6;i<9;i++)System.out.print(i+"  ");
//		System.out.println();
//	
//		System.out.print("      ");
//		System.out.print(9);
//		System.out.println();
//	
//		System.out.print("   ");
//		for(int i=10;i<13;i++)System.out.print(i+" ");
//		System.out.println();
//
//		for(int i=13;i<18;i++)System.out.print(i+" ");
	}

}
