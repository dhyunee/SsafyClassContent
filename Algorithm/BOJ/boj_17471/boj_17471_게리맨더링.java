package java_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17471_게리맨더링 {
	static int[] tgt;
	static int[] people;
	static boolean[] visited,visit;
	static boolean[][] map;
	static int[] tgt2;
	static int n;
	static int min=Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		people = new int[n];
		map = new boolean[n][n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int t=Integer.parseInt(st.nextToken());
			
			for(int j=0;j<t;j++) {
				int x=Integer.parseInt(st.nextToken());
				map[i][x-1] = true;
				map[x-1][i]=true;
				
			}
		}
		for (int i = 1; i < n/2+1; i++) {
			visited = new boolean[n];
			tgt = new int[i];
			tgt2 = new int[n - i];
			subset(0, 0, i);
			//System.out.println(i);
		}
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}

	static void subset(int tgtidx, int srcidx, int limit) {
		//System.out.println(limit);
		if (tgtidx == limit) {
			int tgt2idx = 0;
			visit=new boolean[n];
			for (int i = 0; i < n; i++) {
				boolean in = false;
				for (int j = 0; j < limit; j++) {
					if (tgt[j] == i) {
						
						in = true;
						break;
					}
				}

				if (!in) {
					tgt2[tgt2idx] = i;
					tgt2idx++;
				}
			}
		
			if(connect(tgt)&&connect(tgt2)) {
				min=Math.min(min,Math.abs(diff(tgt)-diff(tgt2)));
			}
			return;
		}
		if (srcidx == n)return;
		tgt[tgtidx] = srcidx;
		visited[srcidx] = true;
		subset(tgtidx + 1, srcidx + 1, limit);
		visited[srcidx] = false;
		subset(tgtidx, srcidx + 1, limit);

	}

	static boolean connect(int []arr) {
		if(arr.length==1)return true;
		Queue<Integer>q=new ArrayDeque<>();
		q.offer(arr[0]);
		visited[arr[0]]=true;
		while(!q.isEmpty()) {
			int x=q.poll();
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==x)continue;
				if(visit[arr[i]])continue;
				if(map[x][arr[i]]) {
					visit[arr[i]]=true;
					q.offer(arr[i]);
				}
			}
		}
		boolean flag=true;
		for(int i=0;i<arr.length;i++) {
			if(!visit[arr[i]]) {
				flag=false;
				break;
			}
		}
		return flag;
	}

	static int diff(int []arr) {
		//System.out.println(arr.length);
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=people[arr[i]];
		}
		return sum;
	}
}
