package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1987_2 {

	static int r, c, max;
	static char[][] map;
	static boolean[] visited = new boolean[26];// 알파벳이니깐
	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		max = Integer.MIN_VALUE;
		dfs(0, 0, 1);
		System.out.println(max);
	}

	// 좌표 방문한면 (알파벳)
	// 방문할 때마다 max확인
	static void dfs(int y, int x, int cnt) {
		max = Math.max(max, cnt);
		visited[map[y][x] - 'A'] = true;

		// 다음 방문
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx<0 || nx >= c || 0 > ny || ny >= r || visited[map[ny][nx] - 'A'])
				continue;

			dfs(ny, nx, cnt + 1);

		}
		visited[map[y][x] - 'A'] = false;
	}
}
