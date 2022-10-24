package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1600 {


	static int[] dy = { -2, -2, -1, -1, 1, 1, 2, 2, 0, 0, 1, -1 }, dx = { -1, 1, -2, 2, -2, 2, -1, 1, 1, -1, 0, 0 };
	static int k, w, h;
	static int[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h][w];
		visited = new boolean[h][w][k + 1];

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = bfs(0, 0, 0, 0);

		System.out.println(result);
	}

	static int bfs(int y, int x, int kcnt, int tcnt) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { y, x, kcnt, tcnt });
		visited[y][x][0] = true;

		while (!q.isEmpty()) {
			int[] a = q.poll();
			y = a[0];
			x = a[1];
			kcnt = a[2];
			tcnt = a[3];
			if (y == h - 1 && x == w - 1) {
				return tcnt;
			}

			for (int i = 0; i < 12; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (i < 8) {
					if (ny >= h || nx >= w || ny < 0 || nx < 0 || map[ny][nx] == 1 || kcnt + 1 > k
							|| visited[ny][nx][kcnt + 1])
						continue;
					visited[ny][nx][kcnt + 1] = true;
					q.offer(new int[] { ny, nx, kcnt + 1, tcnt + 1 });
				} else {
					if (ny >= h || nx >= w || ny < 0 || nx < 0 || map[ny][nx] == 1 || kcnt > k || visited[ny][nx][kcnt])
						continue;
					visited[ny][nx][kcnt] = true;
					q.offer(new int[] { ny, nx, kcnt, tcnt + 1 });

				}
			}
		}
		return -1;
	}
}