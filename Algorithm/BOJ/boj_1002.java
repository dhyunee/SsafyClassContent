package java_study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1002{

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());

			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			int dist = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); // 중점간 거리 distance의 제곱

			if (x1 == x2 && y1 == y2 && r1 == r2)
				System.out.println(-1);

			else if (dist > Math.pow(r1 + r2, 2))
				System.out.println(0);

			else if (dist < Math.pow(r2 - r1, 2))
				System.out.println(0);

			else if (dist == Math.pow(r2 - r1, 2))
				System.out.println(1);

			else if (dist == Math.pow(r1 + r2, 2))
				System.out.println(1);

			else
				System.out.println(2);
		}

	}
}
