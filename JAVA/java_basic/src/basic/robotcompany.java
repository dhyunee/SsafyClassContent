package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class robotcompany {
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int robo_cnt = 0;

			char[][] arr = new char[n][n];
			for (int y = 0; y < n; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int x = 0; x < n; x++) {
					arr[y][x] = st.nextToken().charAt(0);
				}
			}
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					if (arr[y][x] == 'A') {
						int nx = x;
						while (true) {
							nx = nx + dx[1];
							if (nx < 0 || nx >= n)
								break;

							if (arr[y][nx] == 'S')
								robo_cnt++;
							else
								break;
						}
					} else if (arr[y][x] == 'B') {
						int nx = x, ny = y;
						boolean[][] visited = new boolean[n][n];
						visited[ny][nx] = true;
						while (true) {
							for (int l = 0; l < 2; l++) {
								nx = nx + dx[l];
								ny = ny + dy[l];

								if (nx < 0 || nx >= n || ny < 0 || ny >= n)
									break;

								if (arr[ny][nx] == 'S' && visited[ny][nx] == false) {
									visited[ny][nx] = true;
									robo_cnt++;
								}

								else
									break;
							}
						}
					} else if (arr[y][x] == 'C') {
						int nx = x, ny = y;
						boolean[][] visited = new boolean[n][n];
						while (true) {
							for (int l = 0; l < 4; l++) {
								nx = nx + dx[l];
								ny = ny + dy[l];

								if (nx < 0 || nx >= n || ny < 0 || ny >= n)
									break;

								if (arr[ny][nx] == 'S' && visited[ny][nx] == false) {
									robo_cnt++;
									visited[ny][nx] = true;
								} else
									break;
							}
						}
					}
				}
			}

			System.out.println("#" + (i + 1) + " " + robo_cnt);

		}
	}

}
