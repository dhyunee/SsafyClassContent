package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_5014 {
	static int f,s,g,u,d;
	static int []tower;
	static int ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		f=Integer.parseInt(st.nextToken());
		s=Integer.parseInt(st.nextToken());
		g=Integer.parseInt(st.nextToken());
		u=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		
		tower=new int [f+1];
		tower[s]=2;
		dfs(s,0);
	
		
		System.out.println(ans==Integer.MAX_VALUE?"use the stairs":ans);
	}
	static void dfs(int fl,int cnt) {
		if(fl==g) {
			ans=Math.min(cnt, ans);
			return ;
		}
		if(fl+u<=f&&tower[fl+u]<2) {
			tower[fl+u]++;
			dfs(fl+u,cnt+1);

		}
		if(fl-d>=1&&tower[fl-d]<2) {
			tower[fl-d]++;
			dfs(fl-d,cnt+1);

		}
	}
}
