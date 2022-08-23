package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//prim+priorityqueue
public class swea_3124_2 {
	static int v, e, T;
	static long sum;
	static ArrayList<ArrayList<Edge>>vertex;//인접 리스트
	static boolean[] visited;//정점 방문 체크
	//현재 고려 대상인 정점(간선) 중 비용이 가장 작은 것을 리턴해줌
	static PriorityQueue<Edge> pq=new PriorityQueue<>((e1,e2)->e1.c-e2.c);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			vertex=new ArrayList<ArrayList<Edge>>();
			for(int i=0;i<=v;i++) {
				vertex.add(new ArrayList<Edge>());
			}
			
			visited=new boolean[v+1];
			//초기화
			sum = 0;
			pq.clear();
			//입력
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				vertex.get(v1).add(new Edge(v2, c));
				vertex.get(v2).add(new Edge(v1, c));
			}
			// prim시작
			prim();
			
			System.out.println("#"+t+" "+sum);
		}

	}
	
	static void prim() {
		//시작 정점 선택->1번 부터 할게
		int cnt=1;
		visited[1]=true;
		pq.addAll(vertex.get(1));//시작 정점 1번에서 갈 수 있는 모든 정점(간선)을 pq에 담는다.
		
		while(!pq.isEmpty()) {
			Edge eg=pq.poll();
			if(visited[eg.v])continue;//최소 비용으로 연결하려는 정점이 이미 방문했으면 skip
			
			visited[eg.v]=true;
			sum+=eg.c;//새로 방문하는 정점까지 가는 비용
			cnt++;
			if(cnt==v)break;//필요한 모든 정점을 다 연결한 거
			pq.addAll(vertex.get(eg.v));
		}
	}

	static class Edge {
		int v, c;

		public Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
}
