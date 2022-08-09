package java_study.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_1233_2 {

	static int n, ans;
	static char[] node;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			n = Integer.parseInt(br.readLine());
			node = new char[n + 1];// 0 dummy

			// 두 번빼만 처리
			for (int i = 1; i <= n; i++) {
				node[i] = br.readLine().split(" ")[1].charAt(0);
			}

			int idx = n;
			ans = 1;

			// 뒤에서부터 따져줌
			while (idx != 1) {
				// 현재 idx node의 유효성 검사
				// idx , idx-1(맨끝, 맨 끝-1(왼쪽))=>둘 다 숫자여야 함
				// 위 두 node의 부모=> 연산자
				if (!Character.isDigit(node[idx]) || !Character.isDigit(node[idx - 1])
						|| Character.isDigit(node[idx / 2])) {
					ans = 0;
					break;
				}
				node[idx / 2] = '1';// 실제 수식을 처리 하는 것이 아닌 단순하게 유효성 검사-> 적절한 수로 대체
				idx -= 2;
			}

			System.out.println("#" + t + " " + ans);
		}

	}

}
