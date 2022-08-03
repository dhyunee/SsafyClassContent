package java_study.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1527 {

	static long a, b;
	static int cnt = 0;

	static void dfs(long n) {

		if (n > b)
			return;

		else if (n <= b && n >= a) {
			cnt++;
		}
		dfs(n * 10 + 4);
		dfs(n * 10 + 7);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		// 10*(4or7)+(4or7)

		dfs(0);

		System.out.println(cnt);
	}

}
