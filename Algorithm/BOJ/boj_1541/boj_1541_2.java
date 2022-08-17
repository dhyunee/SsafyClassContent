package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1541_2 {
	static char[]charray;
	static int[] numarray = new int[5];
	static int chidx,numidx,sum;
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		charray=br.readLine().toCharArray();
		
		sum=getNum();
		
		boolean isminus=false;
		int minussum=0;
		
		while(true) {
			char oper=getoper();
			int num=getNum();
					
			if(isminus) {
				if(oper=='+') {
					minussum+=num;
				}
				else {
					sum-=minussum;
				}
			}else {
				if(oper=='+')sum+=num;
				else {
					isminus=true;
					minussum=num;
				}
			}
			if(chidx==charray.length)break;
		}
		if(minussum>0)sum-=minussum;
		System.out.println(sum);
	}
	
	//chidx를 이용해서 현재 숫자 문자를 numarray에 담는다. 그리고 숫자로 변환하여 return
	static int getNum() {
		while(chidx<charray.length) {
			if(charray[chidx]=='+'||charray[chidx]=='-')break;
			numarray[numidx++]=charray[chidx++]-'0';
		}
		return calcNum();
	}
	static char getoper() {
		if(chidx<charray.length)return charray[chidx++];
		return 'x';
	}
	
	static int calcNum() {
		int num=0;
		int cnt=numidx-1;
		for(int i=0;i<numidx;i++) {
			//10을 곱함
			for(int j=0;j<cnt;j++) {
				numarray[i]*=10;
			}
			num+=numarray[i];
					cnt--;
		}
		//초기화
		for(int i=0;i<numidx;i++) {
			numarray[i]=0;
		}
		numidx=0;
		return num;
	}
}

