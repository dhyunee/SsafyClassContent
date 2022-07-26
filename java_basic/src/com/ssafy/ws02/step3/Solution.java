package com.ssafy.ws02.step3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	static int[] dx = { -1, -1, -1, 1, 1, 1, 0, 0 };
	static int[] dy = { 0, 1, -1, 0, 1, -1, 1, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();

			char[][] arr = new char[n][n];

			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					arr[y][x] = sc.next().charAt(0);
				}
			}
			int[][] visited = new int[n][n];

			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {

					if (visited[y][x] == 0 && arr[y][x] == 'G') {
						visited[y][x] = 1;
						for (int j = 0; j < 8; j++) {
							int ny = y + dy[j], nx = x + dx[j];
							if (ny < n && 0 <= ny && nx < n && 0 <= nx) {
								if (arr[ny][nx] == 'B' && visited[ny][nx] == 0) {
									visited[ny][nx] = 2;
								}
							}
						}
					}
				}
			}

			int Maxcnt = 0;
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					int cnt = 0;
					if (visited[y][x] == 0 && arr[y][x] == 'B') {

						for (int j = 0; j < n; j++) {
							if (arr[y][j] == 'B')
								cnt++;
							if (arr[j][x] == 'B')
								cnt++;
						}
						Maxcnt = Math.max(Maxcnt, cnt + -1);
					}
				}
			}
			System.out.println("#" + (i + 1) + " " + Maxcnt);
		}
	}
}
