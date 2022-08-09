package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_6808_4 {
	
	static int T,win,lose,n=9;
	static int [] input=new int[19];
	static int []gcard=new int[9];//고정
	static int []icard=new int[9];//np에 의해 스스로 순열의 경우의 수로 계속 바뀜
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
		
			//정렬
			//정렬한 결과도 하나의 경우의 수
			//인영이의 카드는 이미 정렬되어 있음 (작은수 -> 큰수)(가장 작은 수)
			//np이용 
			while(true) {
				//complete code
				check();
				if(!np())break;
			}
			
			System.out.println("#"+t+" "+win+" "+lose);
		}

	}
	
	static boolean np() {
		int [] src=icard;
		int i=src.length-1;
		
		while(i>0&&src[i-1]>=src[i])--i;
		if(i==0)return false;//descending 가장 큰 수
		
		int j=src.length-1;
		while(src[i-1]>=src[j])--j;
		swap(src,i-1,j);
		
		int k=src.length-1;
		while(i<k) {
			swap(src,i++,k--);
		}
		
		return true;
	}
	
	static void swap(int []array,int i,int j ) {
		int tmp=array[i];
		array[i]=array[j];
		array[j]=tmp;
	}
	
	static void check() {
		int gsm=0,ism=0;
		for(int i=0;i<n;i++) {
			if(gcard[i]>icard[i])gsm+=(gcard[i]+icard[i]);
			else ism+=(gcard[i]+icard[i]);
		}
		if(gsm>ism)win++;
		else if(gsm<ism)lose++;
	}
}
