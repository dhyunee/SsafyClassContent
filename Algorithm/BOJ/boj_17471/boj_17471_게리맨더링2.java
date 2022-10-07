package java_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//�κ�����
//�������
//���� ����->bfs
public class boj_17471_�Ը��Ǵ���2 {

	static int n;
	static int min=Integer.MAX_VALUE;
	static int [][]matrix;
	static boolean []select;//subset
	static boolean []visited;//bfs-���� Ȯ��
	static Queue<Integer>q=new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		matrix = new int[n+1][n+1];//0 dummy �ƴϰ� �α� �� ���� ����
		select =new boolean[n+1];
		visited=new boolean[n+1];
		
		//������ �α���
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			matrix[i][0] = Integer.parseInt(st.nextToken());
		}

		//������ ���� ���
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			int t=Integer.parseInt(st.nextToken());//i ������ ������ ���� ��
			
			for(int j=1;j<=t;j++) {//i ������ ������ ���� ��ȣ
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		subset(1);
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}

	static void check() {
		//2���� ���ű��� ���Ե� ���� ��� ����� ���ᱸ��=>bfs
		//��� �� ���� ������ �����ϴ���
		
		//�ʱ�ȭ
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
		//�湮�� �� �ִ� ���� �湮 �� visited üũ
		while(!q.isEmpty()) {
			int v=q.poll();
			for(int i=1;i<=n;i++) {
				int adj=matrix[v][i];
				if(adj!=0&&!visited[adj]&&select[adj]) {//������ �� �ְ� ���� �湮���� �ʾҰ� ���� ���ű��� ����
					visited[adj]=true;//����� ������ true�� ǥ�õȴ�.
					q.offer(adj);					
				}
			}
		}
		
		//B ���õ��� ���� ���ű� 
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
				if(adj!=0&&!visited[adj]&&!select[adj]) {//������ �� �ְ� ���� �湮���� �ʾҰ� B ���ű��� ����
					visited[adj]=true;//����� ������ true�� ǥ�õȴ�.
					q.offer(adj);
				}
			}
		}
		//��� �湮�� �� �ִ��� Ȯ��
		//visited[]�˻�
		boolean visitAll=true;
		for(int i=1;i<=n;i++) {
			if(!visited[i]) {
				visitAll=false;
				break;
			}
		}
		
		//��� �湮 ���� (��� ����)
		//A,B ���� �α��� ����ϰ� ���̸� min�� �ݿ�
		//�� ������ �α����� matrix[v][0]
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
	
	//select[]�� ���� ���� ǥ����
	static void subset(int srcidx) {
	
		//�������� �� ���� ���ű��� ����
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
