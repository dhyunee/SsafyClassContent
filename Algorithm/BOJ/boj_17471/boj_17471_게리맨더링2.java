package java_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//부분집합
//인접행렬
//인접 여부->bfs
public class boj_17471_게리맨더링2 {

	static int n;
	static int min=Integer.MAX_VALUE;
	static int [][]matrix;
	static boolean []select;//subset
	static boolean []visited;//bfs-연결 확인
	static Queue<Integer>q=new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		matrix = new int[n+1][n+1];//0 dummy 아니고 인구 수 넣을 거임
		select =new boolean[n+1];
		visited=new boolean[n+1];
		
		//구역별 인구수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			matrix[i][0] = Integer.parseInt(st.nextToken());
		}

		//구역별 인접 행렬
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			int t=Integer.parseInt(st.nextToken());//i 구역에 인접한 구역 수
			
			for(int j=1;j<=t;j++) {//i 구역에 인접한 구역 번호
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		subset(1);
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}

	static void check() {
		//2개의 선거구에 포함된 구역 모두 연결된 연결구조=>bfs
		//적어도 한 개의 구역을 포함하는지
		
		//초기화
		Arrays.fill(visited, false);
		q.clear();
		
		//A
		for(int i=1;i<=n;i++) {
			if(select[i]) {
				visited[i]=true;
				q.offer(i);
				break;
			}
		}
		if(q.size()==0)return;
		//방문할 수 있는 곳을 방문 및 visited 체크
		while(!q.isEmpty()) {
			int v=q.poll();
			for(int i=1;i<=n;i++) {
				int adj=matrix[v][i];
				if(adj!=0&&!visited[adj]&&select[adj]) {//연결할 수 있고 아직 방문하지 않았고 같은 선거구에 있음
					visited[adj]=true;//연결된 정점이 true로 표시된다.
					q.offer(adj);					
				}
			}
		}
		
		//B 선택되지 않은 선거구 
		for(int i=1;i<=n;i++) {
			if(!select[i]) {
				visited[i]=true;
				q.offer(i);
				break;
			}
		}

		while(!q.isEmpty()) {
			int v=q.poll();
			for(int i=1;i<=n;i++) {
				int adj=matrix[v][i];
				if(adj!=0&&!visited[adj]&&!select[adj]) {//연결할 수 있고 아직 방문하지 않았고 B 선거구에 있음
					visited[adj]=true;//연결된 정점이 true로 표시된다.
					q.offer(adj);
				}
			}
		}
		//모두 방문할 수 있는지 확인
		//visited[]검사
		boolean visitAll=true;
		for(int i=1;i<=n;i++) {
			if(!visited[i]) {
				visitAll=false;
				break;
			}
		}
		
		//모두 방문 가능 (모두 연결)
		//A,B 각각 인구수 계산하고 차이를 min에 반영
		//각 구역의 인구수는 matrix[v][0]
		if(visitAll) {
			int suma=0;
			int sumb=0;
			
			for(int i=1;i<=n;i++){
				if(select[i])suma+=matrix[i][0];
				else sumb+=matrix[i][0];
			}
			min=Math.min(min, Math.abs(suma-sumb));
		}
	}
	
	//select[]에 선택 비선택 표기함
	static void subset(int srcidx) {
	
		//기저조건 두 개의 선거구로 나눔
		if (srcidx == n+1) {
			check();
			return;
		}
		select[srcidx] = true;
		subset(srcidx+1);
		visited[srcidx] = false;
		subset(srcidx + 1);

	}
}
