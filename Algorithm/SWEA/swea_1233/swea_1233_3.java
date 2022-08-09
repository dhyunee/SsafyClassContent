package java_study.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_1233_3 {

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

			ans = dfs(1) ? 1 : 0;// 맨 위 부터 시작

			System.out.println("#" + t + " " + ans);
		}

	}

	static boolean dfs(int x) {// x:index
		// 기저 조건
		if (x > n)
			return false;// 정상적이면 이미 true로 판명, 이전 인덱스에서 더 따져보려고 했는데 n을 초과 -> 이전이 연산자
		if (Character.isDigit(node[x])) {// 현재 인덱스의 노드가 숫자<=유효하려면 자식이 없어야 한다.
			if (x * 2 > n)
				return true;
			return false;
		} else {// 현재 index의 노드가 연산자
			return (dfs(x * 2) && dfs(2 * x + 1));

		}
	}

}
