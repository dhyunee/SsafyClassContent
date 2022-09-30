package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15686_2 {

	static int N,M,min;
	static List<int[]>house,src,tgt;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		house=new ArrayList<>();
		src=new ArrayList<>();//치킨 집
		tgt=new ArrayList<>();//선택된 치킨 집
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
	
				if (n == 2) {
					src.add(new int [] {i,j});
				} else if (n == 1) {
					house.add(new int[] {i,j});
				}
			}
			
		}

		min=Integer.MAX_VALUE;
		comb(0,0);
		System.out.println(min);

	}


	// 1. 가장 먼저 조합으로 어디 치킨 집을 찾을 건지 선택
	static void comb(int srcidx,int tgtidx) {
		if (tgtidx == M) {
			// 2. bfs 불러와서 찾은 조합으로 찾기!
			//현재 치킨집 조합을 기준으로 모든 집에서 최단거리 치킨 집을 계산해서 모두 더한다. =>합의 최솟값을 구한다.
			int sum=0;// 치킨 거리 합
			int size=house.size();
			for(int i=0;i<size;i++) {//모든 집 각각에 대해 고려
				int dist=Integer.MAX_VALUE;//i번째 집의 치킨 거리
				int [] h=house.get(i);//이 집으로부터 선택된 m 개의 치킨 집의 거리를 계산해 최솟값 선택
				for(int j=0;j<M;j++) {
					int []c=tgt.get(j);
					dist=Math.min(Math.abs(h[0]-c[0])+Math.abs(h[1]-c[1]),dist);
				}
				sum+=dist;//현제 M개의 치킨 거리 누적합
				
			}
			min=Math.min(sum, min);
			return;
		}
		if (srcidx == src.size())
			return;
		
		tgt.add(src.get(srcidx));
		comb(srcidx+1,tgtidx+1);
		tgt.remove(src.get(srcidx));//list이므로 명시적으로 삭제 코드
		comb(srcidx+1,tgtidx);

	}


}
