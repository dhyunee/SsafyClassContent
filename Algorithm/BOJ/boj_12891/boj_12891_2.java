package java_study.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12891_2 {

	static int s, p, ans;
	static char[] dna;
	static int min_a, min_c, min_g, min_t, cnt_a, cnt_c, cnt_g, cnt_t;

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
			switch (dna[i]) {
			case 'A':
				cnt_a++;
				break;
			case 'C':
				cnt_c++;
				break;
			case 'G':
				cnt_g++;
				break;
			case 'T':
				cnt_t++;
				break;

			}
		}
		// 시작 p에 대해서 확인
		check();
		for (int i = p; i < s; i++) {

			// 하나는 버리고 새로 하나를 취한다. 버리는 것은 맨 앞, 취하는 거 맨 뒤=>중간에 있는 것들은 재사용
			// dna[i-p]==0부터
			switch (dna[i - p]) {// 부분문자열 앞: 버릴 것
			case 'A':
				cnt_a--;
				break;
			case 'C':
				cnt_c--;
				break;
			case 'G':
				cnt_g--;
				break;
			case 'T':
				cnt_t--;
				break;

			}

			switch (dna[i]) {// 새 것
			case 'A':
				cnt_a++;
				break;
			case 'C':
				cnt_c++;
				break;
			case 'G':
				cnt_g++;
				break;
			case 'T':
				cnt_t++;
				break;
			}// 새로운 부분문자열
			check();
		}

	}

	// 부분문자열이 조건에 맞는지 확인
	static void check() {
		if (cnt_a >= min_a && cnt_c >= min_c && cnt_g >= min_g && cnt_t >= min_t)
			ans++;

	}
}
