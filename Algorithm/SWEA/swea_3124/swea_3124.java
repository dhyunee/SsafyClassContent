package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_3124 {

	static int v, e, T;
	static long sum;
	static int[] parents;
	static Edge[] egs;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			sum = 0;
			parents = new int[v + 1];
			egs = new Edge[e];

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				egs[i] = new Edge(v1, v2, c);
			}
			// kruskal시작
			// 간선 정렬
			Arrays.sort(egs, (e1, e2) -> e1.c - e2.c);
			makeSet();
			int cnt = 0;// 간선의 수(v-1)개가 선택되면 종료
			for (int i = 0; i < e; i++) {
				Edge eg = egs[i];// 이 간선이 연결하려는 두 정점에 대해서 cycle 체크
				if(union(eg.v1,eg.v2)) {//true이면 cycle이 아님
					cnt++;
					sum+=eg.c;
				}
				if(cnt==v-1)break;
			}
			System.out.println("#"+t+" "+sum);
		}

	}

	static void makeSet() { // 각 부모를 자신으로 설정
		for (int i = 1; i <= v; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int x) { // 부모 찾기
		if (parents[x] == x)
			return x;
		return parents[x] = findSet(parents[x]);
	}

	static boolean union(int a, int b) { // 합집합
		int p = findSet(a);
		int q = findSet(b);
		if (p == q)
			return false;
		if (p < q)
			parents[q] = p;
		else
			parents[p] = q;
		return true;
	}

	static class Edge {
		int v1, v2, c;

		public Edge(int v1, int v2, int c) {
			this.c = c;
			this.v1 = v1;
			this.v2 = v2;
		}
	}
}
