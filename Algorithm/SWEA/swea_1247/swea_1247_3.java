package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//np
public class swea_1247_3 {
	static int n, tc, comx, comy, homex, homey, min;
	static int[][] cust;
	static boolean select[];
	static int[] idx;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			cust = new int[n][2];

			min = Integer.MAX_VALUE;
		

			StringTokenizer st = new StringTokenizer(br.readLine());

			comy = Integer.parseInt(st.nextToken());
			comx = Integer.parseInt(st.nextToken());
			homey = Integer.parseInt(st.nextToken());
			homex = Integer.parseInt(st.nextToken());

			for (int i = 0; i < n; i++) {
				cust[i][0] = Integer.parseInt(st.nextToken());
				cust[i][1] = Integer.parseInt(st.nextToken());
			}
			
			//가장작은 수부터 올림차순으로 정렬
			idx=new int[n];
			for(int i=0;i<n;i++) {
				idx[i]=i;
			}
			//정렬된 현재 시작배열도 경우의 수 중 하나
			
			while(true) {
				check();
				if(!np())break;		
			}
			sb.append("#"+t+" "+min+"\n");
		}
		System.out.println(sb);
	}

	static void check() {
		int sum = dist(comy,cust[idx[0]][0],comx,cust[idx[0]][1]);
		
		for (int i = 1; i < n; i++) {
			sum += dist(cust[idx[i-1]][0],cust[idx[i]][0],cust[idx[i-1]][1],cust[idx[i]][1]);
		}
		sum += dist(homey,cust[idx[n-1]][0],homex,cust[idx[n-1]][1]);
		min = Math.min(min, sum);
		return;
	}
	
	static boolean np() {
	    int i = idx.length-1;
	    while( i>0 && idx[i-1] >= idx[i] ) i--;
	    
	    if( i == 0 ) return false;
	    
	    int j = idx.length-1;
	    while( idx[i-1] >= idx[j]) j--;
	    
	    swap( idx, i-1, j);
	    
	    int k = idx.length-1;
	    while( i<k ) swap(idx, i++, k--);
	    
	    return true;
	}
	
	static void swap(int []idx,int a,int b) {
		int tmp=idx[a];
		idx[a]=idx[b];
		idx[b]=tmp;
		
	}
	
	static int dist(int y1,int y2,int x1,int x2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
}
