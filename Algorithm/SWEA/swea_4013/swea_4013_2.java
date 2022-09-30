package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4013_2 {
	static int k;
	static int[][] circle;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			k = Integer.parseInt(br.readLine());

			circle = new int[4][8];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					circle[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int x, d;
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());//몇 번째 바퀴
				d = Integer.parseInt(st.nextToken());//시계1/반시계-1
				int[] flag = new int[4];
				flag[x-1]=d;
				//오른쪽
				for(int j = x ; j < 4 ; j++) {
					if(circle[j][6] != circle[j - 1][2]) {
						flag[j] = -flag[j - 1] ;
					} else break;
				}
				
				// 왼쪽
				for(int j = x-2  ; j >= 0 ;j--) {
					if(circle[j][2] != circle[j + 1][6]) {
						flag[j] = -flag[j + 1] ;
					} else break;
				}
				for(int j=0;j<4;j++) {
					if(flag[j]==1) {
						cir1(circle[j]);
					}else if(flag[j]==-1) {
						cir2(circle[j]);
					}
				}
			}
			
			int sum=0;
			for(int i=0;i<4;i++) {
				if(circle[i][0]==1) {
					sum+=Math.pow(2, i);
				}
			}
			System.out.println("#"+t+" "+sum);
		}
	}
	static void cir1(int[] arr) {// 시계
		int tmp = arr[7];
		for (int i = 7; i>0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = tmp;
	}

	static void cir2(int[] arr) {// 반시계
		int tmp = arr[0];
		for (int i = 0; i < 7; i++) {
			arr[i] = arr[i + 1];
		}
		arr[7] = tmp;
	}

}
