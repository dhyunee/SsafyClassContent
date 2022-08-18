package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {
	static int r,c,ans;
	static int []dx= {1,1,1},dy= {-1,0,-1};
	static char [][]map;

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		map=new char[r][c];

		for(int i=0;i<r;i++) {
			map[i]=br.readLine().toCharArray();
		}
		for(int i=0;i<r;i++)solve(i,0);
		System.out.println(ans);
	}
	
	static boolean solve(int y,int x) {
		map[y][x]='x';
		
		if(x==c-1) {
			ans++;
			return true;
		}
		
		for(int i=0;i<3;i++) {
			int ny=y+dy[i];
			int nx=x+dx[i];
			if(ny<r&&ny>=0&&map[ny][nx]=='.') {
				if(solve(ny,nx))return true;
			}
		}
		return false;
	}
	
}
