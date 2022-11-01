package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15666_N과M_12 {
	static int n,m;
	static List<List<Integer>>ans=new ArrayList<>();
	static int []num;
	static int []tgt;
	static boolean []visited;
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		num=new int[n];
		tgt=new int[m];
		visited=new boolean[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		perm(0);
		
		for(int i=0;i<ans.size();i++) {
			for(int j=0;j<m;j++) {
				System.out.print(ans.get(i).get(j)+" ");
			}System.out.println();
		}
		
	}
	
	static void perm(int tgtidx) {
		if(tgtidx==m) {
			List<Integer>list=new ArrayList<>();
			boolean dup=false;
			for(int i=0;i<m;i++) {
				list.add(num[tgt[i]]);
			}
			for(int i=0;i<ans.size();i++) {
				int cnt=0;
				for(int j=0;j<m;j++) {
					if(list.get(j)==ans.get(i).get(j))cnt++;
				}
				if(cnt==m) {
					dup=true;
					break;
				}
			}
			if(!dup)ans.add(new ArrayList<>(list));
			return ;
		}
		
		for(int i=0;i<n;i++) {
			if(visited[i])continue;
			tgt[tgtidx]=i;
			visited[i]=true;
			perm(tgtidx+1);
			visited[i]=false;
		}
		
	}
}
