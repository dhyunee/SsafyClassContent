package java_study.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_9229_2 {

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

		for (int i = src_idx; i < src.length; i++) {
			tgt[tgt_idx] = src[i];// 현재 tgt_idx자리가 계속 변경
			comb(i + 1, tgt_idx + 1);
		}

	}

}
