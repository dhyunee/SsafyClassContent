package java_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs
//key-> bitmasking
public class boj_1194_달이차오른다가자 {

	static int N,M,ans;
	static char[][]map;
	static boolean [][][]visited;
	static int []dy= {-1,0,1,0},dx= {0,1,0,-1};
	static Queue<node>q=new ArrayDeque<>();
	
	static class node{
		int y,x,key,d;

		public node(int y, int x, int key, int d) {
			this.y = y;
			this.x = x;
			this.key = key;
			this.d = d;
		}	
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		visited=new boolean[N][M][1<<6];
		
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<M;j++) {
				char ch=str.charAt(j);
				map[i][j]=ch;
				if(ch=='0') {
					q.offer(new node(i,j,0,0));
					visited[i][j][0]=true;
				}
			}
		}
		bfs();
		System.out.println(ans);
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			node nd=q.poll();
			
			//문을 찾으면 탈출
			if(map[nd.y][nd.x]=='1') {
				ans=nd.d;
				return;
			}
			
			//4방 탐색
			for(int d=0;d<4;d++) {
				int ny=nd.y+dy[d];
				int nx=nd.x+dx[d];
				int key=nd.key;
				
				if(ny<0||nx<0||ny>=N||nx>=M||map[ny][nx]=='#')continue;
				
				//새로 가려는 좌표가 a,b,...f 키 좌표이면 획득
				if(map[ny][nx]>='a'&&map[ny][nx]<='f') {
					key|=(1<<(map[ny][nx]-'a'));
					
				}
				//해당 키를 가지고 있는지 없으면 skip
				else if(map[ny][nx]>='A'&&map[ny][nx]<='F') {
					if((key&(1<<(map[ny][nx]-'A')))==0)continue;
					
				}
				//기존에 방문했으면 skip
				if(visited[ny][nx][key])continue;
				visited[ny][nx][key]=true;
				q.offer(new node(ny,nx,key,nd.d+1));
			}
		}
		ans=-1;
	}

}
