package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//시뮬레이션 +bfs
public class boj_16236 {
	static int[][] map;
	static int n, sy, sx, ssize, seatcnt, ans;
	// 아기 상어가 물고기 찾는 과정->bfs
	static Queue<node> q = new ArrayDeque<>();
	static boolean[][] visited;
	// 사방탐색
	static int[] dx = { 0, 0, -1, 1 }, dy = { -1, 1, 0, 0 };

	static class node {
		int y, x, d;

		node(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int x = Integer.parseInt(st.nextToken());
				map[i][j] = x;
				if (x == 9) {
					sx = j;
					sy = i;
				}
			}
		}
		// 초기화
		ssize = 2;// 최초 상어 크기
		// 시뮬레이션
		while (true) {
			// 먹이 사냥이 가능한 동안, 먹이사냥<=bfs(),bfs()는 사냥하는 동안 걸리는 시간를 return
			// bfs()가 0 리턴하면 더이상 먹을 고기가 없음
			// bfs가 0아닌 다른 값을 리턴하면 먹이사냥에 걸린 시간이므로 ans에 누적합으로 더해준다.
			int cnt = bfs();
			if (cnt == 0)
				break;
			ans += cnt;// 누적 시간
		}
		System.out.println(ans);

	}

	static int bfs() {
		// 가장 작은 y,x,d(거리)
		int miny = Integer.MAX_VALUE, minx = Integer.MAX_VALUE, mind = Integer.MAX_VALUE;
		// visited 초기화
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], false);
		}

		visited[sy][sx] = true;// 항상 상어 위치에서 출발
		q.offer(new node(sy, sx, 0));

		while (!q.isEmpty()) {

			node nd = q.poll();

			// 물고기&&먹을 수 있는
			if (map[nd.y][nd.x] != 0 && map[nd.y][nd.x] < ssize) {
				// 먹이에 대한 계산을 해야 함
				if (nd.d < mind) {
					mind = nd.d;
					miny = nd.y;
					minx = nd.x;
				} else if (nd.d == mind) {
					if (nd.y < miny) {
						mind=nd.d;
						miny = nd.y;
						minx = nd.x;
					} else if (nd.y == miny) {
						if (minx > nd.x) {
							minx = nd.x;
							miny=nd.y;
							minx=nd.d;
						}
					}
				}
			}
			// 가지치기
			if (nd.d + 1 >= mind)
				continue;

			for (int i = 0; i < 4; i++) {
				int ny = nd.y + dy[i];
				int nx = nd.x + dx[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[ny][nx] || map[ny][nx] > ssize)
					continue;

				visited[ny][nx] = true;
				q.offer(new node(ny, nx, nd.d + 1));
			}
		}
		// 먹이를 먹었든가 못먹었든가 처리
		if (mind == Integer.MAX_VALUE)
			return 0;// 먹을 물고기를 찾지 못했다.
		else {
			seatcnt++;// 먹은 물고기 수 증가
			if (seatcnt == ssize) {
				ssize++;
				seatcnt = 0;
			}

			map[miny][minx] = 0;// 먹은 물고기 자리는 빈칸
			map[sy][sx] = 0;// 상어가 출발한 자리

			// 새로운 상어의 자리-먹은 물고기의 자리
			sy = miny;
			sx = minx;
		}
		return mind;

	}

}
