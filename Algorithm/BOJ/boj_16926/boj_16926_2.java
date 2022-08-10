package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16926_2 {

	static int N,M,R;
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0}; 
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M]; 
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
		
			for(int j=0;j<M;j++) {
				map[i][j] =Integer.parseInt(st.nextToken()); ;
			}
		}
		
		int cir_num = Math.min(N, M) / 2;
	
		for(int i=0;i<R;i++) {
			rotate();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void rotate() {
		
		int sy=0,ey=N-1;//시작, 종료 y
		int sx=0,ex=M-1;//시작, 종료 x
		
		while(true) {
			if(ey-sy<1||ex-sx<1)return;
			//반시계방향
			//sy,ey,sx,ex 계속 바꿔 줌
			int tmp=map[sy][sx];
			
			//top 좌로 동 
			for(int i=sx;i<ex;i++) {
				map[sy][i]=map[sy][i+1];
			}
			
			//right 상으로 이동(밑의 값이 위로 이동)
			for(int i=sy;i<ey;i++) {
				map[i][ex]=map[i+1][ex];//오른쪽 끝 X 고정
			}
			
			//bottom우로 이동(왼쪽 값이 오른쪽으로 이동)
			for (int i=ex;i>sx;i--) {
				map[ey][i]=map[ey][i-1];
			}
			
			//left 하로 이동
			for(int i= ey;i>sy;i--) {
				map[i][sx]=map[i-1][sx];
			}
			map[sy+1][sx]=tmp;
			
			sy+=1;
			sx+=1;
			ey-=1;
			ex-=1;
		}
	}
}
