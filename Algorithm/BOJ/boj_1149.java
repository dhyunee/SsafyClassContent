package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1149 {

	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int [][]map=new int[n+1][4];
		int [][]dp=new int[n+1][4];
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=1;j<=3;j++)map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		dp[1][1]=map[1][1];
		dp[1][2]=map[1][2];
		dp[1][3]=map[1][3];

		for(int i=2;i<=n;i++) {
			dp[i][1]=Math.min(dp[i-1][2]+map[i][1],dp[i-1][3]+map[i][1]);
			dp[i][2]=Math.min(dp[i-1][1]+map[i][2],dp[i-1][3]+map[i][2]);
			dp[i][3]=Math.min(dp[i-1][1]+map[i][3],dp[i-1][2]+map[i][3]);
		}
		System.out.println(Math.min(dp[n][1], Math.min(dp[n][2], dp[n][3])));
	}

}
