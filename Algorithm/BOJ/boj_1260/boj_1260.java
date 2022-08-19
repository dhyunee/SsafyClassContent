package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1260 {

	static int n, m, v;
	static boolean[][] matrix;// 방문할 수 있는 정점 관계
	// static boolean []visited;
	static Queue<Integer> q = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		matrix = new boolean[n + 1][n + 1];// 0 dummy
		// visited=new boolean[n+1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			matrix[n1][n2] = true;
			matrix[n2][n1] = true;
		}

		// dfs
		// visited[v]=true;
		matrix[v][0] = true;// index 0이 vistied역할
		dfs(v);

		sb.setCharAt(sb.length() - 1, '\n');

		// bfs
		for (int i = 0; i < n + 1; i++) {
			matrix[i][0] = false;
		}
		bfs();
		

		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	static void dfs(int x) {
		sb.append(x).append(" ");

		for (int i = 1; i < n + 1; i++) {
			if (matrix[x][i] && !matrix[i][0]) {
				matrix[i][0] = true;
				dfs(i);
			}
		}
	}

	static void bfs() {
		matrix[v][0] = true;
		q.offer(v);
		while (!q.isEmpty()) {
			int x = q.poll();
			sb.append(x).append(" ");
			for (int i = 1; i < n + 1; i++) {
				if (matrix[x][i] && !matrix[i][0]) {
					matrix[i][0] = true;
					q.offer(i);
				}
			}
		}
	}
}
