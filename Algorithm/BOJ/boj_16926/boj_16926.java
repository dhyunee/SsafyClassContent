package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16926 {


	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {1,0,-1,0}; 
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M]; 
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
		
			for(int j=0;j<M;j++) {
				arr[i][j] =Integer.parseInt(st.nextToken()); ;
			}
		}
		
		int cir_num = Math.min(N, M) / 2;
	
		for(int i=0;i<R;i++) {
			
			for(int j=0;j<cir_num;j++) {
				int x = j;
				int y = j;
				
				int tmp = arr[y][x];
				
				int idx=0;
				
				while(idx<4) {
					int nx = x + dx[idx];
					int ny = y + dy[idx];
					
					if(nx>=j&&ny>=j&&nx<M-j&&ny<N-j) {
						int tmp2=arr[ny][nx];
						arr[ny][nx]=tmp;
						tmp=tmp2;
						x = nx;
						y = ny;
					}
					
					else idx++;
				}
			}
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
