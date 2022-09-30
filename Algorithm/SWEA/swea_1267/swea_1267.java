package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1267 {
	
	static int v,e;
	static int []indegree;
	static boolean [][]matrix;
	static Queue<Integer>q=new ArrayDeque<Integer>();
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
		
			StringTokenizer st=new StringTokenizer(br.readLine());
			v=Integer.parseInt(st.nextToken());
			e=Integer.parseInt(st.nextToken());
			
			matrix=new boolean[v+1][v+1];
			indegree=new int[v+1];
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<e;i++) {
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				matrix[x][y]=true;
				indegree[y]++;
			}
			sb.append('#').append(t).append(' ');
			//위상정렬
			//진입 차수가 0인 항목을 queue에 넣고 시작
			for(int i=1;i<v+1;i++) {
				if(indegree[i]==0)q.offer(i);
			}
			
			while(!q.isEmpty()) {
				int vq=q.poll();
				sb.append(vq).append(' ');
				for(int i=1;i<=v;i++) {
					if(matrix[vq][i]) {
						indegree[i]--;
						if(indegree[i]==0)q.offer(i);
					}
				}
			}
	
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
