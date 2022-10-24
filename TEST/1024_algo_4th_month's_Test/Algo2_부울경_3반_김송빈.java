import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Algo2_부울경_3반_김송빈 {

	static int r, c;
	static char[][] map;
	static int sy, sx;
	static int ey, ex;
	static int[] dy = { 0, 1, 0, -1 }, dx = { 1, 0, -1, 0 };
	static int[][] dir = { { 1, 3 }, { 0, 2 }, { 0, 1, 2, 3 }, { 0, 1 }, { 3, 0 }, { 3, 2 }, { 2, 1 } };
	static char ans;
	static List<Integer> hs;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#" + t + " ");
			hs = new ArrayList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			map = new char[r][c];

			for (int i = 0; i < r; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < c; j++) {
					char x = map[i][j];
					if (x == 'M') {
						sy = i;
						sx = j;
					} else if (x == 'Z') {
						ey = i;
						ex = j;
					}
				}
			}

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] != '.' && map[i][j] != 'Z' && map[i][j] != 'M')
						simul(i, j, map[i][j]);
				}
			}

			for (int a : hs)
				sb.append(a + " ");

			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void simul(int y, int x, char d) {
		switch (d) {
		case '|':
			for (int i = 0; i < 2; i++) {
				int ny = y + dy[dir[0][i]];
				int nx = x + dx[dir[0][i]];
				if (map[ny][nx] == '.') {
					if (hs.isEmpty()) {
						hs.add(ny + 1);
						hs.add(nx + 1);
						check(ny, nx);
					}
					break;
				}
			}
			break;

		case '-':
			for (int i = 0; i < 2; i++) {
				int ny = y + dy[dir[1][i]];
				int nx = x + dx[dir[1][i]];
				if (map[ny][nx] == '.') {
					if (hs.isEmpty()) {
						hs.add(ny + 1);
						hs.add(nx + 1);
						check(ny, nx);
					}
					break;
				}
			}
			break;

		case '+':
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[dir[2][i]];
				int nx = x + dx[dir[2][i]];
				if (map[ny][nx] == '.') {
					if (hs.isEmpty()) {
						hs.add(ny + 1);
						hs.add(nx + 1);
						check(ny, nx);
					}
					break;
				}
			}
			break;
		case '1':
			for (int i = 0; i < 2; i++) {
				int ny = y + dy[dir[3][i]];
				int nx = x + dx[dir[3][i]];
				if (map[ny][nx] == '.') {
					if (hs.isEmpty()) {
						hs.add(ny + 1);
						hs.add(nx + 1);
						check(ny, nx);
					}
					break;
				}
			}
			break;
		case '2':
			for (int i = 0; i < 2; i++) {
				int ny = y + dy[dir[4][i]];
				int nx = x + dx[dir[4][i]];
				if (map[ny][nx] == '.') {
					if (hs.isEmpty()) {
						hs.add(ny + 1);
						hs.add(nx + 1);
						check(ny, nx);
					}
					break;
				}
			}
			break;
		case '3':
			for (int i = 0; i < 2; i++) {
				int ny = y + dy[dir[5][i]];
				int nx = x + dx[dir[5][i]];
				if (map[ny][nx] == '.') {
					if (hs.isEmpty()) {
						hs.add(ny + 1);
						hs.add(nx + 1);
						check(ny, nx);
					}
					break;
				}
			}
			break;
		case '4':
			for (int i = 0; i < 2; i++) {
				int ny = y + dy[dir[6][i]];
				int nx = x + dx[dir[6][i]];
				if (map[ny][nx] == '.') {
					if (hs.isEmpty()) {
						hs.add(ny + 1);
						hs.add(nx + 1);
						check(ny, nx);
					}
					break;
				}
			}
			break;

		}
	}

	static void check(int y, int x) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= r || nx >= c || ny < 0 || nx < 0)
				continue;
			if (map[ny][nx] != '.') {
				if (i == 0) {
					if (map[ny][nx] == '-' || map[ny][nx] == '3' || map[ny][nx] == '4' || map[ny][nx] == '+') {
						list.add(0);
					}
				} else if (i == 1) {
					if (map[ny][nx] == '|' || map[ny][nx] == '3' || map[ny][nx] == '2' || map[ny][nx] == '+') {
						list.add(1);
					}
				} else if (i == 2) {
					if (map[ny][nx] == '-' || map[ny][nx] == '1' || map[ny][nx] == '2' || map[ny][nx] == '+') {
						list.add(2);
					}
				} else {
					if (map[ny][nx] == '|' || map[ny][nx] == '1' || map[ny][nx] == '4' || map[ny][nx] == '+') {
						list.add(3);
					}
				}
			}
		}

		if (list.size() == 4)
			ans = '+';
		else {

			for (int i = 0; i < 7; i++) {
				int confirm = 0;
				if (i == 2)
					continue;
				for (int j = 0; j < 2; j++) {
					for (int l : list) {
						if (l == dir[i][j])
							confirm++;
					}
				}
				if (confirm == 2) {
					if (i == 0)
						ans = '|';
					else if (i == 1)
						ans = '-';
					else if (i == 3)
						ans = '1';
					else if (i == 4)
						ans = '2';
					else if (i == 5)
						ans = '3';
					else if (i == 6)
						ans = '4';
					break;
				}
			}
		}
	}
}
