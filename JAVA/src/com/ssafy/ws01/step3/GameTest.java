package com.ssafy.ws01.step3;
import java.util.*;

public class GameTest {
	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder();
		sb.append("가위바위보 시작 보기 중 하나 고르셈").append("\n")
		.append("1. 5판 3승").append("\n")
		.append("2. 3판 2승").append("\n")
		.append("3. 1판 1승").append("\n")
		.append("번호를 입력하세요:");
		
		System.out.println(sb);
		
		Scanner sc=new Scanner(System.in);
		int menu=sc.nextInt();
		
		int totalCnt=0;
		int winCnt=0;
		int comwin=0,userwin=0;
		
		int userNo=0;
		int comNo=0;
		
		int Gamecnt=0;
		
		
		switch(menu) {
		case 1: totalCnt=5;winCnt=3;break;
		case 2: totalCnt=3;winCnt=2;break;
		case 3: totalCnt=1;winCnt=1;break;
		}
		while(Gamecnt<totalCnt&&(comwin<winCnt&&userwin<winCnt)) {
			comNo=(int)(Math.random()*3)+1;
			Gamecnt++;
			userNo=sc.nextInt();
			
			if(userNo==comNo-1) {
				System.out.println("이겼습니다!!!");
				userwin++;
			}
			else if(comNo==userNo-1) {
				System.out.println("졌습니다!!!");
				comwin++;
			}
			else if(userNo==0&&comNo==3) {
				System.out.println("졌습니다!!!");
				comwin++;
			}
			else if(comNo==0&&userNo==3) {
				System.out.println("이겼습니다!!!");
				userwin++;
			}
			else System.out.println("비겼습니다!!!");
		}
		
		if(comwin>userwin)System.out.println("### 컴퓨터 승");
		else if(comwin<userwin)System.out.println("### 유저 승");
		else System.out.println("비겼습니다");
		
		sc.close();
//		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요");
//		System.out.println("1. 5판 3승");
//		System.out.println("2. 3판 2승");
//		System.out.println("3. 1판 1승");
//		System.out.print("번호를 입력하세요,");
//		Scanner sc=new Scanner(System.in);
//		int n;
//		n=sc.nextInt();
//		
//		int num;
//		switch(n) { 
//			case 1: num=5;
//				break;
//			case 2: num=3;
//				break;
//			case 3: num=1;
//				break;
//			default: num=0;
//		}
//		
//		int com_cnt=0;
//		int per_cnt=0;
//		
//		for(int i=0;i<num;i++) {
//			int com=(int)(Math.random()*3)+1;
//			System.out.print("가위바위보 중 하나 입력: ");
//			String s=sc.next();
//			int per;
//			if(s=="바위")per=1;
//			else if(s=="가위")per=2;
//			else per=3;
//			
//			if(per-1==com) {
//				com_cnt++;
//				System.out.println("졌습니다!!!");
//				System.out.println(per+" "+com);
//			}
//			if(com-1==per) {
//				per_cnt++;
//				System.out.println("이겼습니다!!!");
//				System.out.println(per+" "+com);
//			}
//			if(per==0&&com==3) {
//				com_cnt++;
//				System.out.println("졌습니다!!!");
//				System.out.println(per+" "+com);
//			}
//			if(com==0&&per==3) {
//				per_cnt++;
//				System.out.println("이겼습니다!!!");
//				System.out.println(per+" "+com);
//			}
//			
//			if((com_cnt==num/2+1)||(per_cnt==num/2+1))break;
//		}
//		String result;
//		result=com_cnt>per_cnt?"### 컴퓨터 승!!!":"### 사람 승!!!";
//		System.out.println(result);
	}
}
