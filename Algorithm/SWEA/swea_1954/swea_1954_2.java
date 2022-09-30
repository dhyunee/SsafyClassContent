package java_study.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_1954_2 {

	static int t, n;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] snail;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			snail = new int[n][n];

			int y = 0;
			int x = 0;
			int d = 0;

			int num = 1;
			// nxn만큼 반복하면서 숫자를 저장
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {// 얘를 이용해서 좌표찍는다는 의미는 아님 그냥 횟수 세주는 거
					snail[y][x] = num++;// 숫자 기록

					// 현재 방향으로 이동하다가 더 이상 못 가면 다음 방향으로 전환
					if (d == 0) {
						if (x + dx[d] >= n || snail[y][x + dx[d]] != 0)
							d = 1;
					} else if (d == 1) {
						if (y + dy[d] >= n || snail[y + dy[d]][x] != 0)
							d = 2;
					} else if (d == 2) {
						if (x + dx[d] < 0 || snail[y][x + dx[d]] != 0)
							d = 3;
					} else if (d == 3) {
						if (y + dy[d] < 0 || snail[y + dy[d]][x] != 0)
							d = 0;
					}

					// 위 조건에 해당하지 않으면 d는 이전의 d 해당하면 d 변경
					x += dx[d];
					y += dy[d];
				}
			}
			System.out.println("#" + tc);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
