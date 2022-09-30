package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_17135 {

	static int n,m,d,max;
	static int[][] map;
	static int [] archer=new int[3];//조합에서 tgt 역할
	static List<enemy>em=new ArrayList<>();//적 기본 정보
	static List<enemy>em_cpy=new ArrayList<>();//적 정보 원본 관리
	//적 중에 가장 가까운 적을 꺼내는 자료구조
	static PriorityQueue<enemy>pq=new PriorityQueue<>((e1,e2)->e1.d==e2.d?e1.x-e2.x:e1.d-e2.d);
	
	static class enemy{
		int y,x,d;//d:궁수와 거리
		boolean dead;
		
		enemy(int y,int x){//d,dead는 문제 풀익 과정에서 set
			this.y=y;
			this.x=x;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());//사정거리
		
		map=new int[n][m];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				int x=Integer.parseInt(st.nextToken());
				map[i][j]=x;
				if(x==1)em_cpy.add(new enemy(i,j));
			}
		}
		//조합 완성되면 시뮬레이션 진행 -> 새로운 조합이 완성되면 시뮬레이션 다시 진행
		comb(0,0);
		
		System.out.println(max);
		
	}
	//현재 궁사의 조합 각각에 대한 시뮬레이션
	static void check() {
		//적 초기화
		em.clear();
		for(enemy e:em_cpy) {
			em.add(new enemy(e.y, e.x));
		}
		//시뮬레이션
		int dead=0;
		while(true) {
			//궁사가 활을 발사
			for(int i=0;i<3;i++) {
				//priorityqueue이용해서 가장 가까운 적 선별
				pq.clear();
				int ac=archer[i];//첫 번째 궁사~~ 세번째 궁사
				//em->pq로 이동하면서 계산
				int size=em.size();
				for(int j=0;j<size;j++) {
					enemy e=em.get(j);
					e.d=Math.abs(ac-e.x)+Math.abs(n-e.y);//사정거리 계산
					
					if(e.d<=d) {//사정거리 안에 드는 적만 pq에 담음
						pq.offer(e);
					}
				}
				//pq가 비워있지 않으면 제거 대상 있음->표시
				if(!pq.isEmpty()) {
					pq.poll().dead=true;
				}
			}
			//적을 정리(죽은 적 제거 ,적 이동)
			Iterator<enemy>iter=em.iterator();
			while(iter.hasNext()) {
				enemy e=iter.next();
				if(e.dead) {
					iter.remove();
					dead++;
				}else if(e.y==n-1) iter.remove();
				else e.y++;
			}
			
			//모든 적이 다 사라지면 -> 죽거나 전부 영역을 벗어나거나
			if(em.size()==0) break;
		
		}
		max=Math.max(max, dead);
	}
	
	static void comb(int srcidx,int tgtidx) {
		if(tgtidx==3) {
			//궁사의 위치가 지정되어 simul돌려야 함->최댓값 구함
			check();	
			return;
		}
		
		if(srcidx==m)return;
		archer[tgtidx]=srcidx;
		
		comb(srcidx+1,tgtidx+1);
		comb(srcidx+1,tgtidx);
	}
}
