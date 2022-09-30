package java_study.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12891_3 {

	static int s, p, ans;
	static char[] dna;
	static int min_a, min_c, min_g, min_t;
	// A B C D E F G H I J K L M N O P Q R S T
	static int[] cnt = new int[20];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		dna = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		min_a = Integer.parseInt(st.nextToken());
		min_c = Integer.parseInt(st.nextToken());
		min_g = Integer.parseInt(st.nextToken());
		min_t = Integer.parseInt(st.nextToken());
		solve();
		System.out.println(ans);
	}

	static void solve() {
		// 시작 p 개 부분 문자열부터 확인
		for (int i = 0; i < p; i++) {
			cnt[dna[i] - 'A']++;
		}
		// 시작 p에 대해서 확인
		check();
		for (int i = p; i < s; i++) {

			cnt[dna[i - p] - 'A']--;
			cnt[dna[i] - 'A']++;
			check();
		}

	}

	// 부분문자열이 조건에 맞는지 확인
	static void check() {
		if (cnt[0] >= min_a && cnt[2] >= min_c && cnt[6] >= min_g && cnt[19] >= min_t)
			ans++;

	}
}
