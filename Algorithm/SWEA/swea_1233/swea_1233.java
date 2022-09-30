package java_study.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1233 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			String[] tree = new String[n + 1];
			for (int i = 1; i < n + 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				tree[Integer.parseInt(st.nextToken())] = st.nextToken();

			}
			int ans = 1;
			int node_idx = n / 2;
			for (int i = 1; i < n + 1; i++) {
				if (tree[i].charAt(0) >= '0' && tree[i].charAt(0) <= '9') {
					if (i <= node_idx) {
						ans = 0;
						break;
					}
				} else {
					if (i > node_idx) {
						ans = 0;
						break;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
