package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

//인접 리스트
public class boj_1260_2 {

	static int n, m, v;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;

	static Queue<Integer> q = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		list = new ArrayList<>(n + 1);
		visited = new boolean[n + 1];

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			list.get(n1).add(n2);
			list.get(n2).add(n1);
		}

		for (int i = 1; i < n + 1; i++) {
			Collections.sort(list.get(i));
		}

		// dfs
		visited[v] = true;
		dfs(v);

		sb.setCharAt(sb.length() - 1, '\n');

		// bfs
		visited = new boolean[n + 1];
		bfs();

		sb.setLength(sb.length() - 1);

		System.out.println(sb);
	}

	static void dfs(int x) {
		sb.append(x).append(" ");

		for (int i : list.get(x)) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}

	static void bfs() {
		visited[v] = true;
		q.offer(v);
		while (!q.isEmpty()) {
			int x = q.poll();
			sb.append(x).append(" ");
			for (int i : list.get(x)) {
				if (!visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
}
