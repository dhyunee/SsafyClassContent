package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class robot_ans {
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int t, n, ans;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];

			char[][] arr = new char[n][n];
			for (int y = 0; y < n; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int x = 0; x < n; x++) {
					arr[y][x] = st.nextToken().charAt(0);
				}
			}

			ans = 0;
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					char robot = map[y][x];

					if (robot == 'A')
						go(y, x, 1);
					else if (robot == 'B')
						go(y, x, 2);

					else if (robot == 'C')
						go(y, x, 4);

				}
			}
			System.out.println("#" + (i + 1) + " " + ans);
		}

	}

	static void go(int i, int j, int de) {
		for (int d = 0; d < de; d++) {
			int ny = i;
			int nx = j;
			while (true) {
				ny = ny + dy[d];
				nx = nx + dx[d];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					break;
				if (map[ny][nx] != 'S')
					break;
				ans++;
			}

		}
	}
}
