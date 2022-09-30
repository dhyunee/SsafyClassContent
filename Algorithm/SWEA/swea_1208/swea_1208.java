package java_study.swea;

import java.util.Scanner;

public class swea_1208 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {

			int answer = 0;
			int n = sc.nextInt();
			int[] l = new int[100];

			int min_idx = -1, max_idx = -1;

			for (int j = 0; j < 100; j++) {
				l[j] = sc.nextInt();
			}
			int max = 0;
			int min = 101;
			while (n > 0) {

				if (Math.abs(max - min) <= 1)
					break;
				for (int j = 0; j < 100; j++) {
					int a = l[j];
					if (min > a) {
						min = a;
						min_idx = j;
					}
					if (max < a) {
						max = a;
						max_idx = j;
					}
				}
				l[max_idx] = l[max_idx] - 1;
				l[min_idx] = l[min_idx] + 1;
				max--;
				min++;
				n--;
			}
			for (int j = 0; j < 100; j++) {
				int a = l[j];
				if (min > a) {
					min = a;
				}
				if (max < a) {
					max = a;
				}
			}
			answer = max - min;

			System.out.println("#" + i + " " + answer);
		}
		sc.close();

	}

}
