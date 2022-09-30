package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2961 {
	
	static int N,min;
	static int [][]src;
	static boolean[]select;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		src = new int[N][2];
		select = new boolean[N];
		
		min=Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[i][0] = Integer.parseInt(st.nextToken());
			src[i][1] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		System.out.println(min);
	}
	
	public static void subset(int srcIdx) {
		if (srcIdx == N) {
			int sour = 1;
			int bitter = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (select[i]) {
					cnt++;
					sour *= src[i][0];
					bitter += src[i][1];
				}
			}
			if(cnt == 0) return; //공집합이면 리턴
			min=Math.min(min,Math.abs(sour-bitter));
			return;
		}
		select[srcIdx] = true;
		subset(srcIdx + 1);
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}

	
}
