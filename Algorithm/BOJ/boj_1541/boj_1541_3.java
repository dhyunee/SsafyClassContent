package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1541_3 {

	static int sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stMinus=new StringTokenizer(br.readLine(),"-");
		
		//for 문 사용시 int sizeMinus=stMinus.countTokens(); 현재 시점에 남아있는 토큰 수
		//while(stMinus.hasMoreTokens()) 
		for(int j=0;j<stMinus.countTokens();j++){
			String token=stMinus.nextToken();
			
			int num=0;
			StringTokenizer stPlus=new StringTokenizer(token,"+");
			int sizePlus=stPlus.countTokens();
			
			for(int i=0;i<sizePlus;i++) {
				num+=Integer.parseInt(stPlus.nextToken());
			}
			
			if(j==0)sum=num;
			else sum-=num;
		}
		System.out.println(sum);
		
	}
}
