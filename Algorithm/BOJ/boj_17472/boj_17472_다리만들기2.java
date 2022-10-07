package java_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17472_다리만들기2 {
	static int n, m;
	static int[] dy = { 0, 1, 0, -1 }, dx = { 1, 0, -1, 0 };
	static	List<List<node>> dist=new ArrayList<>();
	static int[][] map;
	static boolean[][] visitedf;
	static boolean []visitedpq;
	static int island = 0;
	static int ans=0;
	static class node{
		int x,d;
		node(int x,int d){
	
			this.x=x;
			this.d=d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visitedf = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visitedf[i][j] && map[i][j] == 1) {
					island++;
					bfs(i, j);

				}
			}
		}
		visitedpq=new boolean [island];
		for(int i=0;i<island;i++)dist.add(new ArrayList<>());
		simul();
		prim();
		System.out.println(ans);
		
	}

	static void bfs(int y, int x) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { y, x });
		visitedf[y][x] = true;
		map[y][x] = island;
		while (!q.isEmpty()) {
			int[] a = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = a[0] + dy[i];
				int nx = a[1] + dx[i];
				if (ny < 0 || nx < 0 || ny >= n || nx >= m)
					continue;
				if (visitedf[ny][nx] || map[ny][nx] == 0)
					continue;
				q.offer(new int[] { ny, nx });
				visitedf[ny][nx] = true;
				map[ny][nx] = island;
			}
		}
	}

	static void simul() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {
					for (int d = 0; d < 4; d++) {
						int cnt = 0;
						int y=i,x=j;
						while (true) {
							int ny = y + dy[d];
							int nx = x + dx[d];
							//System.out.println(ny+" "+nx);
							if (ny < 0 || nx < 0 || ny >= n || nx >= m)break;
							if (map[ny][nx] == map[i][j])break;
							else if (map[ny][nx] == 0) {
								cnt++;
								y=ny;
								x=nx;
							}
							else if(map[ny][nx]!=map[i][j]&&map[ny][nx]<=island) {
								if (cnt==1)break;
								dist.get(map[i][j]-1).add(new node(map[ny][nx]-1,cnt));
								break;
							}
						}
					}
				}

			}
		}
	}
	static void prim() {
		PriorityQueue<node>pq=new PriorityQueue<>((e1,e2)->e1.d-e2.d);
		pq.addAll(dist.get(0));
		visitedpq[0]=true;
		while(!pq.isEmpty()) {
			node nd=pq.poll();
			if(visitedpq[nd.x])continue;
			ans+=nd.d;
			//pq.clear();
			pq.addAll(dist.get(nd.x));
			visitedpq[nd.x]=true;
		}
		
		boolean flag=true;
		for(int i=0;i<island;i++) {
			if(!visitedpq[i]) {
				flag=false;
				break;
			}
		
		}
		if(!flag)ans=-1;
	
	}
}
