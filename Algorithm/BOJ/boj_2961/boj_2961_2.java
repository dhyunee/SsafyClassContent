package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2961_2 {
	
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
		
		dfs(0,1,0);
		
		System.out.println(min);
	}
	
	static void dfs(int srcidx,int sinsum,int ssnsum) {
		//기저 조건
		if(srcidx==N) {
			return;
		}
		
		int currsin=src[srcidx][0]*sinsum;
		int currssn=src[srcidx][1]+ssnsum;
		
		//현재 재료에 대한 고려
		min=Math.min(min, Math.abs(currsin-currssn));
		
		
		//다음 재료 선택
		dfs(srcidx+1,currsin,currssn);//select
		dfs(srcidx+1,sinsum,ssnsum);//no select
		
	}

	
}
