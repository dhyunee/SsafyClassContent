package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_13023_2 {
	static int n, m;
	static List<List<Integer>>friends=new ArrayList<>();
	static boolean done;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for(int i=0;i<n;i++) {
			friends.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			friends.get(x).add(y);
			friends.get(y).add(x);
		}
		// dfs 탐색->모든 저점에서 따져본다. 가능한 경우를 만나면 바로 종료
		for (int i = 0; i < n; i++) {
			dfs(i, 0, 1 << i);

		}
		if (!done)
			System.out.println(0);
		else
			System.out.println(1);
	}

	static void dfs(int num, int cnt, int visited) {
		// 기저조건
		if(done)return;
		if (cnt == 4) {
			done = true;
			return;
		}
		//모든 정점을 대상으로
		for (int x:friends.get(num)) {
			if(x==num||(visited&(1<<x))!=0)continue;
			dfs(x,cnt+1,visited|(1<<x));
		}
	}
}
