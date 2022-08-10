package boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_16935 {

	static int n,m,r;
	static int [][]arr;
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		
		arr=new int [n][m];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<r;i++) {
			int cal=Integer.parseInt(st.nextToken());
			if(cal==1)s1();
			else if(cal==2)s2();
			else if(cal==3)s3();
			else if(cal==4)s4();
			else if(cal==5)s5();
			else if(cal==6)s6();
			
		}
		
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	static void s1() {
		for(int c = 0 ; c < arr[0].length ; c++) {
			for(int r1 = 0, r2 = arr.length - 1 ; r1 < r2 ; r1++, r2--) {
				int temp = arr[r1][c];
				arr[r1][c] = arr[r2][c];
				arr[r2][c] = temp;
			}
		}
	}
	static void s2() {
		for(int r = 0 ; r < arr.length ; r++) {
			for(int c1 = 0, c2 = arr[0].length - 1 ; c1 < c2 ; c1++, c2--) {
				int temp = arr[r][c1];
				arr[r][c1] = arr[r][c2];
				arr[r][c2] = temp;
			}
		}
	}
	static void s3() {
		int[][] result = new int[arr[0].length][arr.length];
		
		for(int r = 0 ; r < arr.length ; r++) {
			for(int c = 0 ; c < arr[0].length ; c++) {
				result[c][arr.length - 1 - r] = arr[r][c];
			}
		}
		
		arr = result;
		
	}
	
	static void s4() {
		int [][]result=new int [arr[0].length][arr.length];
	    for (int i = 0; i < arr.length; i++) {
	    	for (int j = 0; j < arr[0].length; j++) {
	    		result[arr[0].length - 1 - j][i] = arr[i][j];
	           
	        }
	    }
	    arr=result;
		
	}
	
	static void s5() {
		int[][] result = new int[arr.length][arr[0].length];
		
		int r_size = arr.length;
		int c_size = arr[0].length;

		for(int r = 0 ; r < r_size / 2 ; r++) {
			for(int c = 0 ; c < c_size / 2 ; c++) {
				result[r][c + c_size / 2] = arr[r][c];
			}
		}
		
		for(int r = 0 ; r < r_size / 2 ; r++) {
			for(int c = c_size / 2 ; c < c_size ; c++) {
				result[r + r_size / 2][c] = arr[r][c];
			}
		}

		for(int r = r_size / 2 ; r < r_size ; r++) {
			for(int c = c_size / 2 ; c < c_size ; c++) {
				result[r][c - c_size / 2] = arr[r][c];
			}
		}

		for(int r = r_size / 2 ; r < r_size ; r++) {
			for(int c = 0 ; c < c_size / 2 ; c++) {
				result[r - r_size / 2][c] = arr[r][c];
			}
		}
		
		arr = result;
	}
	
	static void s6() {
		int[][] result = new int[arr.length][arr[0].length];
		
		int r_size = arr.length;
		int c_size = arr[0].length;

		//1->4
		for(int r = 0 ; r < r_size / 2 ; r++) {
			for(int c = 0 ; c < c_size / 2 ; c++) {
				result[r+r_size/2][c] = arr[r][c];
			}
		}
		
		//2->1
		for(int r = 0 ; r < r_size / 2 ; r++) {
			for(int c = c_size / 2 ; c < c_size ; c++) {
				result[r][c-c_size/2] = arr[r][c];
			}
		}

		//3->2
		for(int r = r_size / 2 ; r < r_size ; r++) {
			for(int c = c_size/2 ; c < c_size ; c++) {
				result[r-r_size/2][c] = arr[r][c];
			}
		}

		//4->3
		for(int r = r_size / 2 ; r < r_size ; r++) {
			for(int c = 0 ; c < c_size / 2 ; c++) {
				result[r][c_size/2+c] = arr[r][c];
			}
		}
		
		arr = result;
	}
}
