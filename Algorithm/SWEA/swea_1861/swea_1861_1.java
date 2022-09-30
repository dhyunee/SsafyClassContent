package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import swea.swea_1861.node;


public class swea_1861_1 {

	static int [][]map;
	static int T,N,NO,CNT;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			NO=0;
			CNT=1;
			
			N=Integer.parseInt(br.readLine());
			map=new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			//bfs
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					
					dfs(i,j,map[i][j],1);
					
				}
			}
			System.out.println("#"+t+" "+NO+" "+CNT);
		}

	}
	static int []dy= {-1,1,0,0},dx= {0,0,-1,1};
	
	static void dfs(int y,int x,int no,int cnt) {
		

		if(cnt>CNT) {
			CNT=cnt;//최대 방문 수 갱신
			NO=no;
		}
		else if(cnt==CNT) {
			NO=no<NO?no:NO;
		}
		
		for(int i=0;i<4;i++) {
			int ny=y+dy[i];
			int nx=x+dx[i];
			
			if(ny<0||nx<0||ny>=N||nx>=N||map[ny][nx]!=map[y][x]+1)continue;
			dfs(ny,nx,no,cnt+1);

		}
	}
}
