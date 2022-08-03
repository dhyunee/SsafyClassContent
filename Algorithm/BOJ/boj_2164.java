package java_study.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_2164 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// System.out.println(n/2+1);
		if (n == 1)
			System.out.println(1);
		else {
			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i <= n; i++) {
				q.offer(i);

			}
			int x;
			while (true) {
				q.poll();
				x = q.poll();
				if (q.isEmpty())
					break;
				q.offer(x);
			}
			System.out.println(x);
		}
	}
}
