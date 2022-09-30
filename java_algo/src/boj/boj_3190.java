package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_3190 {
	static int n,k,l;
	static int [][]map;
	static int []dy= {0,-1,0,1}, dx= {1,0,-1,0};//왼쪽으로 도는 기준
	static boolean [][]exist;
	static Queue<int[]>dumli=new ArrayDeque<int[]>();
	static Queue<int[]>dummy=new ArrayDeque<int[]>();
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		k=Integer.parseInt(br.readLine());
		map=new int [n][n];
		exist=new boolean[n][n];
		for(int i=0;i<k;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=1;
		}
		
		l=Integer.parseInt(br.readLine());
		int dir=0;
		for(int i=0;i<l;i++) {
			StringTokenizer sts=new StringTokenizer(br.readLine());
			int t=Integer.parseInt(sts.nextToken());
			char d=sts.nextToken().charAt(0);
			if(d=='L') {
				dir+=1;
				if(dir>3)dir=0;
			}else if(d=='D') {
				dir-=1;
				if(dir<0)dir=3;
			}
			dumli.add(new int[] {t,dir});
		}
		dummy.add(new int[] {0,0});
		int x=0,y=0,std=0,total_time=0;
		exist[x][y]=true;
		while(true) {
			x+=dx[std];
			y+=dy[std];
			if(y>=n||x>=n||y<0||x<0||exist[y][x])break;
			total_time++;
			if(map[y][x]==1) {
				map[y][x]=0;
				exist[y][x]=true;
			}else {
				exist[y][x]=true;
				int []delete=dummy.poll();
				exist[delete[0]][delete[1]]=false;
			}dummy.add(new int[] {y,x});
			if(!dumli.isEmpty()) {
			if(dumli.peek()[0]==total_time) {
				int []change=dumli.poll();
				std=change[1];
				}
			}
		}
		System.out.println(total_time+1);
	}

}
