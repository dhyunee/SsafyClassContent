package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576_2 {

	static int m, n,max;
	static int[][] map;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static Queue<node> q = new ArrayDeque<>();

	static class node{
		int y,x,d;
		public node(int y,int x,int d) {
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		boolean flag = false;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int x = Integer.parseInt(st.nextToken());
				map[i][j]=x;
				if (x == 1)q.offer(new node(i,j,0));
			}
		}

		if (q.size() == n * m)System.out.println(0);
		else {
			bfs();
			
		}
	}

	static void bfs() {
		while (!q.isEmpty()) {
			node y_x=q.poll();
			int y = y_x.y;
			int x = y_x.x;
			int d=y_x.d;
			max=Math.max(max, d);
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny >= n || nx >= m || ny < 0 || nx < 0)continue;
				if (map[ny][nx] == 0) {//익지 않은 토마토
					map[ny][nx] =1;//익은 토마토
					q.offer(new node(ny,nx,d+1));
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(max);
	}
}
