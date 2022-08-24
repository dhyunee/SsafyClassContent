package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//서로소 find union 사용
public class swea_7465_2 {
	static int tc, n, m, ans;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			parent = new int[n + 1];
			makeset();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				union(x, y);
			}

			// 집합의 수 찾기->parent[i]==i 갯수 증가
			int cnt = 0;
			for (int i = 1; i < n + 1; i++) {
				if (parent[i] == i)
					cnt++;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

	static void makeset() {
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
	}

	static int findset(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = findset(parent[x]);
	}

	static void union(int x, int y) {
		int px = findset(x);
		int py = findset(y);
		if (px > py)
			parent[py] = px;
		else
			parent[px] = py;
	}

}
