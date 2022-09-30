package java_study.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_9229 {

	static int T, N, M, ans;
	static int[] src, tgt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			// 초기화
			src = new int[N];
			tgt = new int[2];

			ans = -1;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				src[i] = Integer.parseInt(st.nextToken());
			}

			// 조합
			comb(0, 0);
			System.out.println("#" + t + " " + ans);
		}

	}

	static void comb(int src_idx, int tgt_idx) {
		// 기저조건 -tgt
		if (tgt_idx == 2) {
			int sum = tgt[0] + tgt[1];
			if (sum > M)
				return;
			ans = Math.max(ans, sum);
			return;
		}

		// 기저조건 src
		if (src_idx == N)
			return;

		tgt[tgt_idx] = src[src_idx];

		// 현재 값을 받아들임
		comb(src_idx + 1, tgt_idx + 1);
		// 받아들이지 않음
		comb(src_idx + 1, tgt_idx);
	}

}
