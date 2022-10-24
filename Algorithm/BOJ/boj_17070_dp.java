package java_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17070_dp {
	static int n;
	static int[][] map;
	static int[][][] dp;
	// dp[d][y][x]
	// 0:대각 1:가로 2:세로
	// dp[0][3][2]:3,2좌표로 대각선에서 이동해 올때 모든 경우의 수의 합

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		dp = new int[4][n + 1][n + 1];
		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		dp[1][1][2] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 2; j <= n; j++) {
				// 현재 i,j 이동할 때 대각선은 i+1,j+1 가로 i,j+1 세로 i+1,j

				// 대각선
				if (i + 1 <= n && j + 1 <= n && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0 && map[i][j + 1] == 0)
					dp[0][i + 1][j + 1] = dp[1][i][j] + dp[0][i][j] + dp[2][i][j];
				// 가로
				if (j + 1 <= n &&  map[i][j + 1] == 0)
					dp[1][i][j + 1] = dp[1][i][j] + dp[0][i][j] ;
				// 세로
				if (i + 1 <= n &&  map[i+1][j] == 0)
					dp[2][i+1][j] = dp[2][i][j] + dp[0][i][j] ;
			}
		}
		// 마지막 도착지인 n,n 오는 세가지 방향의 모든 경우의 수의 합
		System.out.println(dp[0][n][n] + dp[1][n][n] + dp[2][n][n]);
	}

}
