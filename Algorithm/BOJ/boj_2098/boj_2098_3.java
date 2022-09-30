package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//np+circle만들면 맨 앞자리 고정 가능->(n-1)!
public class boj_2098_3 {

	static int[][] matrix;
	static int n, min;
	static int[] src;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		matrix = new int[n][n];
		src = new int[n];
		src = new int[n];
		select=new boolean[n];
		for (int i = 0; i < n; i++) {
			src[i]=i;	
		}
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				matrix[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		min=Integer.MAX_VALUE;
		while(true) {
			check();
			
			if(!np())break;
		}
		System.out.println(min);
	}
	
	static boolean np() {
		int i=n-1;
		int j=i;
		int k=i;
		
		while(i>1&&src[i-1]>=src[i])i--;
		if(i==1)return false;
		
		while(src[i-1]>=src[j])j--;
		swap(i-1,j);
		
		while(i<k) {
			swap(i++,k--);
		}
		return true;
	}
	
	static void swap(int a,int b) {
		int tmp=src[a];
		src[a]=src[b];
		src[b]=tmp;
	}
	
	static void check() {
		int sum=0;
		for(int i=0;i<n-1;i++) {
			int cost=matrix[src[i]][src[i+1]];
			if(cost==0)return;
			sum+=cost;
		}
		int cost=matrix[src[n-1]][src[0]];
		if(cost==0)return;
		sum+=cost;
		min=Math.min(min, sum);
	}
}
