
public class basic_delta {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = { { 1, -1, 3, 4 }, { 5, 2, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int n = input.length;
		int m = input[0].length;

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (input[y][x] == -1) {
					for (int i = 0; i < 4; i++) {
						int ny = y, nx = x;
						while (true) {
							ny = ny + dy[i];
							nx = nx + dx[i];

							if (ny >= n || ny < 0 || nx >= m || nx < 0)
								break;
							System.out.printf("%3d", input[ny][nx]);
						}
						System.out.println();
						// if (ny < n && ny >= 0 && nx < m && nx >= 0) {
						// }
					}
				}
			}
		}

//		for (int y = 0; y < n; y++) {
//			for (int x = 0; x < m; x++) {
//				if (input[y][x] == -1) {
//					for (int i = 0; i < 4; i++) {
//						int ny = y + dy[i], nx = x + dx[i];
//
//						if (ny >= n || ny < 0 || nx >= m || nx < 0)
//							continue;
//						// if (ny < n && ny >= 0 && nx < m && nx >= 0) {
//						System.out.println(input[ny][nx]);
//						// }
//					}
//				}
//			}
//		}
	}
}
