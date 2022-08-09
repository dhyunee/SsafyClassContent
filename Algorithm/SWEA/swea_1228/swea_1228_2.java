package java_study.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1228_2 {

	static int n, m;
	static List<String> list = new LinkedList<String>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			// 초기화
			list.clear();

			n = Integer.parseInt(br.readLine());// 1
			StringTokenizer st = new StringTokenizer(br.readLine());// 2
			for (int i = 0; i < n; i++) {
				list.add(st.nextToken());
			}

			m = Integer.parseInt(br.readLine());// 3
			st = new StringTokenizer(br.readLine());// 4

			for (int i = 0; i < m; i++) {
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());// idx
				int y = Integer.parseInt(st.nextToken());// 삽입 할 문자열 수

				for (int j = 0; j < y; j++) {
					list.add(x + j, st.nextToken());
				}
			}
			sb.append("#" + t + " ");
			for (int i = 0; i < 10; i++)
				sb.append(list.get(i) + " ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
