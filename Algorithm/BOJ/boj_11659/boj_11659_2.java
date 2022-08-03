package java_study.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11659_2 {

	static int n, m;
	static int[] accu;// memoi<=이전 수부터의 합을 미리 계산

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		accu = new int[n + 1];// 0 dummy
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			accu[i] = Integer.parseInt(st.nextToken()) + accu[i - 1];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			sb.append(accu[to] - accu[from - 1]) .append( "\n");
		}
		System.out.println(sb);
	}

}
