package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1267_2 {
	
	static int v,e;
	static boolean [][]matrix;
	static boolean[]visited;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
		
			StringTokenizer st=new StringTokenizer(br.readLine());
			v=Integer.parseInt(st.nextToken());
			e=Integer.parseInt(st.nextToken());
			
			matrix=new boolean[v+1][v+1];
			visited=new boolean[v+1];
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<e;i++) {
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				matrix[x][y]=true;
			}
			sb.append('#').append(t).append(' ');
			//위상정렬
			
			for(int i=1;i<v+1;i++) {//모든 정점에서 dfs 시도
				if(visited[i])continue;//이미 방문했으면 skip
				dfs(i);
			}
	
			sb.append('\n');
		}
		System.out.println(sb);
	}
	static void dfs(int x) {
		visited[x]=true;
		for(int i=1;i<v+1;i++) {
			if(matrix[i][x]&&!visited[i])dfs(i);
		}
		sb.append(x).append(' ');
	}
}
