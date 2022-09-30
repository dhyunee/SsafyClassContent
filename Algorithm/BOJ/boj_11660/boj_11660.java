package java_study.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11660 {

	static int n, m;
	static int[][] memoi;
	static int x1, y1, x2, y2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		memoi = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			memoi[i][0] = 0;
			for (int j = 1; j < n + 1; j++) {
				memoi[i][j] = Integer.parseInt(st.nextToken()) + memoi[i][j - 1];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			int answer = 0;
			for (int j = x1; j <= x2; j++) {
				answer += (memoi[j][y2] - memoi[j][y1 - 1]);
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());

	}

}
