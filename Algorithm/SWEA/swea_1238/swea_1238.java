package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1238 {

	static int l,s,maxnum,maxdepth;
	static boolean [][]matrix=new boolean[101][101];//0 dummy
	//visited는 matrix[x][0]사용할 거임
	static Queue<vertex>q=new ArrayDeque<>();
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
			//초기화
			for(int i=0;i<=100;i++) {
				for(int j=0;j<=100;j++)matrix[i][j]=false;
			}
			
			maxnum=Integer.MIN_VALUE;
			maxdepth=Integer.MIN_VALUE;
			StringTokenizer st=new StringTokenizer(br.readLine());
			l=Integer.parseInt(st.nextToken());
			s=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<l/2;i++) {
				matrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=true;
			}
			bfs();
			System.out.println("#"+t+" "+maxnum);
		}
	}
	
	static void bfs() {
		matrix[s][0]=true;
		q.offer(new vertex(s, 0));
		
		while(!q.isEmpty()) {
			vertex vt=q.poll();
			
			//최대 depth, 최대 번호 check
			if(vt.d>maxdepth) {
				maxdepth=vt.d;
				maxnum=vt.n;
			}
			else if(vt.d==maxdepth)maxnum=Math.max(maxnum, vt.n);
			
			for(int i=1;i<=100;i++) {
				//vt.n 정점에 갈 수 있는지 1~100까지 모든 정점을 고려
				//i정점 visited체크
				if(!matrix[vt.n][i]||matrix[i][0])continue;
				q.offer(new vertex(i, vt.d+1));
				matrix[i][0]=true;
			}
		}
	}
	//정점
	static class vertex{
		int n,d;
		public vertex(int n,int d) {
			this.n=n;//정점번호
			this.d=d;//depth
		}
	}
}
