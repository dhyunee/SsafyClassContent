package java_study.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_2805 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());

			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				char[] a = s.toCharArray();
				for (int j = 0; j < n; j++) {
					map[i][j] = a[j] - '0';
				}
			}

			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += map[n / 2][i];
			}

			for (int i = 1; i <= n / 2; i++) {
				for (int j = i; j < n - i; j++) {
					sum += map[n / 2 - i][j];
					sum += map[n / 2 + i][j];
				}

			}

			System.out.println("#" + t + " " + sum);

		}

	}

}
