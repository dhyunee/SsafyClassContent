package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class swea_1861 {

	static int [][]map;
	static int T,N,NO,CNT;
	static Queue<node>q=new ArrayDeque<>();
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
					q.add(new node(i,j,map[i][j],1));
					bfs();
					
				}
			}
			System.out.println("#"+t+" "+NO+" "+CNT);
		}

	}
	static int []dy= {-1,1,0,0},dx= {0,0,-1,1};
	
	static void bfs() {
		//숫자가 전부 달라서 visited 필요없음
		while(!q.isEmpty()) {
			node nd=q.poll();
			
			if(nd.cnt>CNT) {
				CNT=nd.cnt;//최대 방문 수 갱신
				NO=nd.no;
			}
			else if(nd.cnt==CNT) {
				NO=nd.no<NO?nd.no:NO;
			}
			
			for(int i=0;i<4;i++) {
				int ny=nd.y+dy[i];
				int nx=nd.x+dx[i];
				
				if(ny<0||nx<0||ny>=N||nx>=N||map[ny][nx]!=map[nd.y][nd.x]+1)continue;
				q.offer(new node(ny,nx,nd.no,nd.cnt+1));
				break;//조건에 맞는 다음 방 번호는 한 개이므로 더 이상 delta를 따져볼 필요 없음
			}
		}
	}

	static class node{
		int y,x,no;//no시작 방 번호 계속 따라다녀야 함
		int cnt;
		
		public node(int y,int x,int no,int cnt) {
			this.cnt=cnt;
			this.no=no;
			this.x=x;
			this.y=y;
		}
		
	}

}
