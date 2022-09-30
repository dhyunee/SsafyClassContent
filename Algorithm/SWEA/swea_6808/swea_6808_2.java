package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_6808_2 {
	
	static int T,win,lose,n=9;
	static int [] input=new int[19];
	static int []gcard=new int[9];//고정
	static int []icard=new int[9];//gcard에 없는 번호 입력<=순역 만들기 위해 선택할 수 있는 src
	static int[]tgt=new int[9];
	static boolean []select=new boolean[n];
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			win=0;
			lose=0;
			Arrays.fill(input, 0);
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			//규영이 카드
			int num=0;
			for(int i=0;i<n;i++) {
				num=Integer.parseInt(st.nextToken());
				gcard[i]=num;
				input[num]=1;
			}
			//인영이 카드 
			num=0;
			for(int i=1;i<=18;i++) {
				if(input[i]==0) icard[num++]=i;
			}
			perm(0);
			System.out.println("#"+t+" "+win+" "+lose);
		}
	
		
	}
	static void perm(int tgt_idx) {
		//기저 조건
		//규영이의 카드로부터 임의의 카드를 순열로 완성한 경우
		if(tgt_idx==n) {
			check();
			return ;
		}
		
		for(int i=0;i<n;i++) {
			if(select[i])continue;
			
			tgt[tgt_idx]=icard[i];
			select[i]=true;
			perm(tgt_idx+1);
			select[i]=false;
		}
	}
	static void check() {
		int gsm=0,ism=0;
		for(int i=0;i<n;i++) {
			if(gcard[i]>tgt[i])gsm+=(gcard[i]+tgt[i]);
			else ism+=(gcard[i]+tgt[i]);
		}
		if(gsm>ism)win++;
		else if(gsm<ism)lose++;
	}
}
