package java_study.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//조<-->우 반복
//좌<-->우 반복되는 중간에 상하가 반복된다.
//좌<-->우 한 번 실행되면 그 다음에 움직이는 칸 수 하나씩 줄임
public class swea_1954_3 {

	static int t, n;
	static int[][] snail;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			snail = new int[n][n];

			int y = 0;
			int x = -1;// 1이 더해질 거여서 미리 보정
			int d = 1;// 상하좌우 개념 X 그냥 1:증가, -1:감소

			int num = 1;// 시작 숫자
			int count = n;// 시작부터 계속 이어지는 방향에 대해 숫자를 기록할 것 수 점점 줄어듦
			int total = n * n;// while 문 횟수

			while (num <= total) {
				// 우->좌->우->좌 반복
				for (int i = 0; i < count; i++) {
					x += d;
					snail[y][x] = num++;
				}

				count--;// 우 다 기록 또는 좌 다 기록하면 움직일 칸 하나씩 줄임

				// 하->상->하->상 반복
				for (int i = 0; i < count; i++) {
					y += d;
					snail[y][x] = num++;
				}
				// 방향 전환
				d = d * (-1);
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
