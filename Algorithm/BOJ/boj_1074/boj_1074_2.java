package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1074_2 {

	static int n,r,c,ans;
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		n=(int)Math.pow(2, n);
		int y=0,x=0;
		while(n>1) {
			n/=2;
			if(r<y+n&&c<x+n) {
				;
			}else if(r<n+y&&c>=n+x) {
				ans+=n*n;
				x+=n;
				
			}else if(r>=n+y&&c<n+x) {
				ans+=n*n*2;
				y+=n;
			}else if(r>=n+y&&c>=n+x) {
				ans+=n*n*3;
				y+=n;
				x+=n;
			}
		}
		
		System.out.println(ans);
	}
	
}
