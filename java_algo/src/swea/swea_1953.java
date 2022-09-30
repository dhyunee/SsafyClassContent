package java_algo.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1953 {
	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
	static int[][] dir = { { 2, 5, 6 }, { 2, 4, 7 }, { 3, 4, 5 }, { 3, 6, 7 } };
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs(R, C, map[R][C]);
			
			int cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(visited[i][j])cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}

	static void bfs(int y, int x, int d) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { y, x, d,0 });
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int[] a = q.poll();
			y = a[0];
			x = a[1];
			d = a[2];
			int time=a[3];
			
			if(time==L)return;

			switch (d) {
			case 1:
				for (int i = 0; i < 4; i++) {
					boolean flag = false;
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx])
						continue;
					for (int j = 0; j < dir[i].length; j++) {
						if (map[ny][nx] == dir[i][j]) {
							flag = true;
							break;
						}
					}
					if (flag) {
						visited[ny][nx] = true;
						q.offer(new int[] { ny, nx, map[ny][nx],time+1 });
					}

				}
			case 2:

				for (int i = 0; i < 2; i++) {
					boolean flag = false;
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx]) {
						for (int j = 0; j < dir[1].length; j++) {
							if (map[ny][nx] == dir[1][j]) {
								flag = true;
								break;
							}
						}
						if (flag) {
							visited[ny][nx] = true;
							q.offer(new int[] { ny, nx, map[ny][nx],time+1 });
						}

					}
				}
			case 3:
				for (int i = 2; i < 4; i++) {
					boolean flag = false;
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx]) {
						for (int j = 0; j < dir[1].length; j++) {
							if (map[ny][nx] == dir[1][j]) {
								flag = true;
								break;
							}
						}
						if (flag) {
							visited[ny][nx] = true;
							q.offer(new int[] { ny, nx, map[ny][nx],time+1 });
						}

					}
				}
			case 4:
				for (int i = 0; i < 4; i+=3) {
					boolean flag = false;
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx]) {
						for (int j = 0; j < dir[1].length; j++) {
							if (map[ny][nx] == dir[1][j]) {
								flag = true;
								break;
							}
						}
						if (flag) {
							visited[ny][nx] = true;
							q.offer(new int[] { ny, nx, map[ny][nx] ,time+1});
						}

					}
				}
			case 5:
				for (int i = 1; i < 4; i+=2) {
					boolean flag = false;
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx]) {
						for (int j = 0; j < dir[1].length; j++) {
							if (map[ny][nx] == dir[1][j]) {
								flag = true;
								break;
							}
						}
						if (flag) {
							visited[ny][nx] = true;
							q.offer(new int[] { ny, nx, map[ny][nx],time+1 });
						}

					}
				}
				
			case 6:
				for (int i = 1; i < 3; i++) {
					boolean flag = false;
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx]) {
						for (int j = 0; j < dir[1].length; j++) {
							if (map[ny][nx] == dir[1][j]) {
								flag = true;
								break;
							}
						}
						if (flag) {
							visited[ny][nx] = true;
							q.offer(new int[] { ny, nx, map[ny][nx],time+1 });
						}

					}
				}
			case 7:
				for (int i = 0; i < 4; i+=2) {
					boolean flag = false;
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx]) {
						for (int j = 0; j < dir[1].length; j++) {
							if (map[ny][nx] == dir[1][j]) {
								flag = true;
								break;
							}
						}
						if (flag) {
							visited[ny][nx] = true;
							q.offer(new int[] { ny, nx, map[ny][nx],time+1 });
						}

					}
				}

			}

		}

	}
	
}
