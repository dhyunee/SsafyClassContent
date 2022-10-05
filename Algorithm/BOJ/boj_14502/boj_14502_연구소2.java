package java_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

import java_algo.boj.boj_14502_연구소.node;

public class boj_14502_연구소2 {
	static int n,m,max;
	static int [][]map,virusmap;
	static boolean[][]visited;
	//벽을 놓을 수있는 위치, virus 위치를 미리 별도의 자료구조에 담아서 활용
	static ArrayList<int[]>zero=new ArrayList<>();
	static ArrayList<int[]>virus=new ArrayList<>();
	static int zerosize;//local도 가능
	//선택된 벽을 세우는 위치
	static int[][]wall=new int[3][2];//항상 3개

	static int []dy= {-1,1,0,0},dx= {0,0,1,-1};
	
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		map=new int[n][m];
		max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				int a=Integer.parseInt(st.nextToken());
				map[i][j]=a;
				if(a==0) zero.add(new int[] {i,j});
				else if(a==2)virus.add(new int[] {i,j});
			}
		}
		
		zerosize=zero.size();
		//벽을 세우는 조합을 수행=>각각에 대해 (벽 3개가 정해진 상태에서) virus를 퍼지게 하고 
		//다 퍼지면 안전 영역을 계산=>max갱신
		comb(0,0);
		System.out.println(max);
	}
	static void comb(int srcidx,int tgtidx) {
		//기저조건
		if(tgtidx==3) {
			//complete code=>virus 퍼지게
			virus();
			return;
		}
		//2번 재귀호출 => srcidx에 대해서도 기저조건 필요
		if(srcidx==zerosize) {
			return;
		}
		
		wall[tgtidx]=zero.get(srcidx);//선택 가능한 0위치를 순서대로 srcidx를 선택
		comb(srcidx+1,tgtidx+1);
		comb(srcidx+1,tgtidx);//현재 tgtidx 선택을 무시하고 다시 받겠다.
		
	}
	
	static void virus() {
		//virusmap을 만들고, bfs용 visited 만든다
		virusmap=new int[n][m];
		visited=new boolean[n][m];
		//virusmap<=map 복사
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				virusmap[i][j]=map[i][j];
			}
		}
		//virusmap<-벽표시
		for(int i=0;i<3;i++) {
			int y=wall[i][0];
			int x=wall[i][1];
			virusmap[y][x]=1;
		}
		//dfs 확산
		//초기 virus를 q에 담는다
		for(int[] v:virus) {
			dfs(v[0],v[1]);
		}
		
		//안전영역 계산=>max 갱신
		
		int sum=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(virusmap[i][j]==0)sum++;
			}
		}
		max=Math.max(max,sum);
	}
	static void dfs(int y,int x) {
		for(int i=0;i<4;i++) {
			int ny=y+dy[i];
			int nx=x+dx[i];
			
			if(ny<0||nx<0||ny>=n||nx>=m||visited[ny][nx])continue;
			if(virusmap[ny][nx]==0) {
				virusmap[ny][nx]=2;
				visited[ny][nx]=true;
				dfs(ny,nx);
			}
		}
	}

}
