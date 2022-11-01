import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_16235_나무재테크 {
	static int n,m,k;
	static int [][]map;
	static List<node> tree;
	
	static class node{
		int y,x,age;

		public node(int y, int x, int age) {
			this.y = y;
			this.x = x;
			this.age = age;
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
	
		map=new int[n][n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		tree=new ArrayList<>();
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int y=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			int z=Integer.parseInt(st.nextToken());
			
			tree.add(new node(y,x,z));
		}
		
		for(int i=0;i<=k;i++) {
			
		}
	}
	
	static void cal() {
		
	}
}
