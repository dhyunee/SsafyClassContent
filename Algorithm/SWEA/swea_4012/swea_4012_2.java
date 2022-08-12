package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class swea_4012_2 {
	static int N,T,min;
	static int[][] map;
	static int[]arrA,arrB;//재료 인덱스 관리 ->나눈 후
	static boolean[] select;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			select=new boolean[N];
			
			arrA=new int[N/2];
			arrB=new int[N/2];
			
			for(int i=0; i<N; i++){
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
					
			comb(0,0);
			System.out.println("#" + t + " " + min);	
        }			  
	}

	public static void comb(int start, int r){
		if(r==N/2){
			solve();
			
			return;
		}
		
		if(start==N)return;
		
		select[start] = true;
		comb(start+1, r+1);
		select[start] = false;
		comb(start+1,r);
	}

	public static void solve(){
		int idxA=0,idxB=0;
		for(int i=0; i<N; i++){
			if(select[i])arrA[idxA++]=i;
			else arrB[idxB++]=i;
		}

		int suma=0;	
		int sumb=0;	
	
		for(int i=0; i<N/2; i++){
			for(int j=0; j<N/2; j++){
				if(i==j)continue;
				suma += map[arrA[i]][arrA[j]];
				sumb += map[arrB[i]][arrB[j]];
			}
		}

		min = Math.min(min, Math.abs(suma-sumb));
	}
}
