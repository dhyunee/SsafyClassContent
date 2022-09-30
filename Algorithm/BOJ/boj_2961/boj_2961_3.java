package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//binary counting<=본질적으로 부분집합으로 문제를 푸는 방식
//부분집합 원소 하나를 선택 /비선택, boolean select[]
//boolean ===bit(0,1)동일한 성격
public class boj_2961_3 {
	
	static int N,min;
	static int [][]src;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		src = new int[N][2];
		
		min=Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[i][0] = Integer.parseInt(st.nextToken());
			src[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//모든 부분집합의 경우의 수
		//4개 ->2^4
		//1<<4 
		//00000001->0010000(16)
		int cnt=1<<N;//N개 원소를 가지는 부분집합의 수
		
		//i==0->00000000
		//i==3->00000011
		//i==8->00001000
		//i==15->0001111
		for(int i=1;i<cnt;i++) {//모든 부분집합에 대해서 (공집합 제외)
			//각각의 부분집합에서 어떤 원소가 선택/ 비선택
			//i가 select 역할(i는 단순한 cnt변수가 아니다)
			
			int sin=1;
			int ssn=0;
			
			//현재 부분집합 중 선택되 재료를 파악 ->계산
			for(int j=0;j<N;j++) {
				if((i&(1<<j))==1) {//i와 비교해보니 j가 선택되었다 확인
					sin*=src[j][0];
					ssn+=src[j][1];	
				}
			}
			
			min=Math.min(min, Math.abs(sin-ssn));
		}
		
		System.out.println(min);
	}
}
