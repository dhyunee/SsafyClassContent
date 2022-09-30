package java_study.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11659 {
	static int[] inp;
	static int min = 0;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		inp = new int[n + 1];
		int ans = 0;
		int[] l = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			inp[i] = Integer.parseInt(st.nextToken());
			ans += inp[i];
			l[i] = ans;
		}

		StringBuilder sb = new StringBuilder();
		int answer = 0;
		for (int i = 0; i < m; i++) {

			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(l[end] - l[first - 1] + "\n");

		}
		System.out.println(sb.toString());
	}

}
