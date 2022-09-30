package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1600_2 {
	static int[] kdy = { -2, -2, -1, -1, 1, 1, 2, 2 }, kdx = { -1, 1, -2, 2, -2, 2, -1, 1 };
	static int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 };
	static int k, w, h;
	static int[][] map;
	static int[][] dp;

	//dp 3차원 해서 kcnt횟수세는 거는?
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h+1][w+1];
		dp = new int[h+1][w+1];

		for (int i = 1; i < h+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < w+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<h+1;i++) {
			for(int j=1;j<h+1;j++) {
				dp[i][j]=Math.min(dp[i-1][j]+1,dp[1][j-1]+1);
				if(i-2>=0&&j-1>=0)dp[i][j]=Math.min(dp[i][j], dp[i-2][j-1]+1);
				if(i-1>=0&&j-2>=0)dp[i][j]=Math.min(dp[i][j], dp[i-1][j-2]+1);
				
			}
		}
		System.out.println(dp[h][w]);
	}

}
