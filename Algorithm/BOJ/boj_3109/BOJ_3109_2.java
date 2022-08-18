package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_2 {
	static int r,c,ans;
	static int []dy= {-1,0,-1};
	static char [][]map;

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		map=new char[r][];

		for(int i=0;i<r;i++) {
			map[i]=br.readLine().toCharArray();
		}
		for(int i=0;i<r;i++) {
			if(dfs(i,0))ans++;
		}
		System.out.println(ans);
	}
	
	static boolean dfs(int y,int x) {
		//다음 방문 좌표
		int nx=x+1;
		if(nx==c-1)return true;
		
		for(int i=0;i<3;i++) {
			int ny=y+dy[i];
			if(ny<0||ny>=r||map[ny][nx]!='.')continue; 
			//갈 수 있으면 방문 처리 후 방문
			map[ny][nx]='x';
			if(dfs(ny,nx))return true;
			
		}
		return false;
	}
	
}
