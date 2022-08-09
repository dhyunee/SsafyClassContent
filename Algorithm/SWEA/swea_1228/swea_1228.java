package java_study.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class swea_1228 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> l = new LinkedList<>();
		LinkedList<Integer> cm = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			l.clear();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				l.offer(Integer.parseInt(st.nextToken()));
			}

			int k = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < k; i++) {
				st.nextToken();
				int st_num = Integer.parseInt(st.nextToken());
				int ed_num = Integer.parseInt(st.nextToken());
				for (int j = ed_num - 1; j >= 0; j--) {
					cm.offer(Integer.parseInt(st.nextToken()));

				}
				for (int j = ed_num - 1; j >= 0; j--) {
					l.add(st_num, cm.pollLast());
				}
			}
			sb.append("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				sb.append(l.get(i) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
