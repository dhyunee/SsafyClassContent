package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//조합으로
public class swea_5215 {

	static int T,N,L,max;
	static Item[]src;
	static Item[]tgt;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<T;t++) {
			max=0;
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
		
			src=new Item[N];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine()) ;
				src[i]=new Item(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			//tgt->1->2->...->n개로 재료를 사용
			for(int i=1;i<=N;i++) {
				tgt=new Item[i];
				comb(0,0);
			}
			System.out.println("#"+t+" "+max);
			
		}

	}
	
	static void comb(int srcIdx,int tgtIdx) {
		if(tgtIdx==tgt.length) {
			//complete code: L을 초과하지 않는 최댓값을 따져본다.
			int cal=0;
			int point=0;
			
			//sum of calories
			for(int i=0;i<tgtIdx;i++) {
				cal+=tgt[i].c;
			}
			
			//확인
			if(cal<=L) {
				for(int i=0;i<tgtIdx;i++) {
					point+=tgt[i].p;
				}
				max=Math.max(max, point);
			}
			return;
		}
		if(srcIdx==N)return;
		
		tgt[tgtIdx]=src[srcIdx];
		comb(srcIdx+1,tgtIdx+1);//select
		comb(srcIdx+1,tgtIdx);//no select
	}
	
	
	static class Item{
		int p;//맛에 대한 포인트
		int c;//칼로리
		public Item(int p,int c){
			this.p=p;
			this.c=c;
		}
	}
}
