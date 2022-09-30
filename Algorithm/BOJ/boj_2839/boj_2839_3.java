package BOJ;

import java.util.Scanner;

//그리디
public class BOJ_2839_3 {
	static int n,cnt;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
	
		while(true) {
			if(n%5==0) {
				System.out.println(cnt+n/5);
				break;
			}else {
				n-=3;
				cnt++;
			}
			
			if(n<0) {
				System.out.println(-1);
				break;
			}
		}
	}
}
