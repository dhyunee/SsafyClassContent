package java_study.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11660_2 {

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
			// 행과 열을 모두 합한 누적 계산,현재 좌표 기준으로 원점(시작점)과의 사각형 내의 모든 합
			for (int j = 1; j < n + 1; j++) {
				memoi[i][j] = Integer.parseInt(st.nextToken()) + memoi[i - 1][j] + memoi[i][j - 1]
						- memoi[i - 1][j - 1];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			sb.append(memoi[x2][y2] - memoi[x1 - 1][y2] - memoi[x2][y1 - 1] + memoi[x1 - 1][y1 - 1]).append("\n");
		}
		System.out.println(sb.toString());

	}

}
