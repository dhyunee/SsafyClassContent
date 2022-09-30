package java_algo.swea;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1249 {

	static int n;
	static int [][]map;
	static boolean [][]visited;
	static int []dy= {0,1,0,-1},dx= {1,0,-1,0};
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=tc;t++) {
			n=Integer.parseInt(br.readLine());
			ans=Integer.MAX_VALUE;
			map=new int[n][n];
			visited=new boolean[n][n];
			
			for(int i=0;i<n;i++) {
				char []arr=br.readLine().toCharArray();
				for(int j=0;j<n;j++) {
					map[i][j]=arr[j]-'0';
				}
			}
			visited[0][0]=true;
			cal(0,0,0);
			System.out.println(ans);
		}
	}
	
	static void cal(int y,int x,int val) {
		if(y==n-1&&x==n-1) {
			ans=Math.min(ans, val);
			return;
		}
		if(val>=ans)return;
		for(int i=0;i<4;i++) {
			int ny=y+dy[i];
			int nx=x+dx[i];
			if(ny>=n||nx>=n||ny<0||nx<0||visited[ny][nx])continue;
			visited[ny][nx]=true;
			cal(ny,nx,val+map[ny][nx]);
			visited[ny][nx]=false;
		
		}
	}
}
