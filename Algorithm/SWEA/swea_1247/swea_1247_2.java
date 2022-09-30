package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1247_2 {
	static int n, tc, comx, comy, homex, homey, min;
	static int[][] cust;
	static boolean select[];
	static int[] tgt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t < tc; t++) {
			n = Integer.parseInt(br.readLine());
			cust = new int[n][2];
			select = new boolean[n];
			min = Integer.MAX_VALUE;
			tgt = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());

			comy = Integer.parseInt(st.nextToken());
			comx = Integer.parseInt(st.nextToken());
			homey = Integer.parseInt(st.nextToken());
			homex = Integer.parseInt(st.nextToken());

			for (int i = 0; i < n; i++) {
				cust[i][0] = Integer.parseInt(st.nextToken());
				cust[i][1] = Integer.parseInt(st.nextToken());
			}
			perm(0);
			sb.append("#" + t + " " + min + "\n");
		}
		System.out.println(sb);
	}

	static void perm(int tgt_idx) {
		if (tgt_idx == n) {
			int sum = dist(comy,cust[tgt[0]][0],comx,cust[tgt[0]][1]);
			
			for (int i = 1; i < n; i++) {
				sum += dist(cust[tgt[i-1]][0],cust[tgt[i]][0],cust[tgt[i-1]][1],cust[tgt[i]][1]);
			}
			sum += dist(homey,cust[tgt[n-1]][0],homex,cust[tgt[n-1]][1]);
			min = Math.min(min, sum);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (select[i])continue;
			tgt[tgt_idx] = i;
			select[i] = true;
			perm(tgt_idx + 1);
			select[i] = false;

		}
	}
	
	static int dist(int y1,int y2,int x1,int x2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
}
