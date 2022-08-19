package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//visited배열을 bitmasking의 파라미터로
//bfs
public class boj_1987_4 {

	static int r, c, max;
	static int[][] map;
	
	static int visited;
	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
	static Queue<node>q=new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0;j<c;j++) {
				map[i][j]=tmp[j]-'A';
			}
			
		}
		max = Integer.MIN_VALUE;
		bfs();
	}

	static void bfs() {
		q.offer(new node(0,0,1,1<<map[0][0]));
		while(!q.isEmpty()) {
			node nd=q.poll();
			max=Math.max(max, nd.cnt);
			for (int i = 0; i < 4; i++) {
				int nx = nd.x + dx[i];
				int ny = nd.y + dy[i];

				if (nx<0 || nx >= c || 0 > ny || ny >= r || (nd.visit&1<<map[ny][nx])!=0)continue;
				q.offer(new node(ny,nx,nd.cnt+1,nd.visit|map[ny][nx]));
			}
		}
	}
	
	static class node{
		int y,x,cnt,visit;
		node(int y,int x,int cnt,int visit) {
			this.cnt=cnt;
			this.visit=visit;
			this.x=x;
			this.y=y;
		}
	}
}
