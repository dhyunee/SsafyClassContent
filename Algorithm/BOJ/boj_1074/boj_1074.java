package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1074 {

	static int n,r,c,ans;
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		int size=(int)Math.pow(2, n);
		solve(size,r,c);
		System.out.println(ans);
	}
	
	static void solve(int size,int r,int c) {
		if(size==1) {
			return;
		}
		
		if(r<size/2&&c<size/2) {
			solve(size/2,r,c);
		}
		else if(r<size/2&&c>=size/2) {
			ans+=size*size/4;
			solve(size/2,r,c-size/2);
		}
		else if(r>=size/2&&c<size/2) {
			ans+=size*size/4*2;
			solve(size/2,r-size/2,c);
		}
		else if(r>=size/2&&c>=size/2) {
			ans+=size*size/4*3;
			solve(size/2,r-size/2,c- size/2);
		}
	}
}
