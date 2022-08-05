//안됨

package java_study.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class boj_2023 {

	static Set<Integer> set = new HashSet<>();
	static List<List<Integer>> list = new ArrayList<>();
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<Integer>());
		}
		list.get(0).add(2);
		list.get(0).add(3);
		list.get(0).add(5);
		list.get(0).add(7);

		cal(0);
		for (int pn : list.get(n - 1))
			System.out.println(pn);
	}

	static void cal(int cnt) {
		if (cnt >= n)
			return;

		while (list.get(cnt).size() > 0) {
			int x = list.get(cnt).remove(0);

			for (int i = 1; i < 9; i++) {
				int res = x * 10 + i;
				prime_check(res, n + 1);
			}
		}
		cal(cnt + 1);

	}

	static void prime_check(int x, int cnt) {
		for (int i = 1; i < Math.sqrt(x) + 1; i++) {
			if (x % i == 0)
				return;
		}
		list.get(cnt).add(x);
	}
}
