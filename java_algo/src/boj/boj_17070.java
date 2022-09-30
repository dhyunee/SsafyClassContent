package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17070 {

	static int []dy= {0,1,1},dx= {1,0,1};
	static int n;
	static int [][]map;
	static int cnt=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		map=new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)map[i][j]=Integer.parseInt(st.nextToken());
		}
		cal(0,1,0);
		System.out.println(cnt);
	}
	static void cal(int y,int x,int d) {
		if(y==n-1&&x==n-1) {
			cnt++;
			return;
		}
		
		if(d==0) {
			int ny=y+dy[0];
			int nx=x+dx[0];
			if(ny>=0&&nx>=0&&ny<n&&nx<n&&map[ny][nx]==0) {
			map[ny][nx]=1;
			cal(ny,nx,0);
			map[ny][nx]=0;
			}
			ny=y+dy[2];
			nx=x+dx[2];
			if(ny>=0&&nx>=0&&ny<n&&nx<n&&map[ny][nx]==0&&map[y+1][x]==0&&map[y][x+1]==0) {
			map[ny][nx]=1;
			cal(ny,nx,2);
			map[ny][nx]=0;
			}
		}
		if(d==1) {
			int ny=y+dy[1];
			int nx=x+dx[1];
			if(ny>=0&&nx>=0&&ny<n&&nx<n&&map[ny][nx]==0) {
			map[ny][nx]=1;
			cal(ny,nx,1);
			map[ny][nx]=0;
			}
			ny=y+dy[2];
			nx=x+dx[2];
			if(ny>=0&&nx>=0&&ny<n&&nx<n&&map[ny][nx]==0&&map[y+1][x]==0&&map[y][x+1]==0) {
			map[ny][nx]=1;
			cal(ny,nx,2);
			map[ny][nx]=0;
			}
		}
		if(d==2) {
			int ny=y+dy[0];
			int nx=x+dx[0];
			if(ny>=0&&nx>=0&&ny<n&&nx<n&&map[ny][nx]==0) {
			map[ny][nx]=1;
			cal(ny,nx,0);
			map[ny][nx]=0;
			}
			ny=y+dy[1];
			nx=x+dx[1];
			if(ny>=0&&nx>=0&&ny<n&&nx<n&&map[ny][nx]==0) {
			map[ny][nx]=1;
			cal(ny,nx,1);
			map[ny][nx]=0;
			}
			ny=y+dy[2];
			nx=x+dx[2];
			if(ny>=0&&nx>=0&&ny<n&&nx<n&&map[ny][nx]==0&&map[y+1][x]==0&&map[y][x+1]==0) {
			map[ny][nx]=1;
			cal(ny,nx,2);
			map[ny][nx]=0;
			}
		}
		
		
	}

}
