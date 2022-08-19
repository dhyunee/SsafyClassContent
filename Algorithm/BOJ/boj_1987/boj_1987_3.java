package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//visited배열을 bitmasking의 파라미터로
public class boj_1987_3 {

	static int r, c, max;
	static int[][] map;
	
	static int visited;
	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0;j<c;j++) {
				map[i][j]=tmp[j]-'A';
			}
			
		}
		max = Integer.MIN_VALUE;
		//map[0][0]시작-->어떤 integer값이 있을 건데 그 값을 1을 <<연산 수행
		dfs(0, 0, 1,1<<map[0][0]);//0000->001000
		System.out.println(max);
	}

	// 좌표 방문한면 (알파벳)
	// 방문할 때마다 max확인
	static void dfs(int y, int x, int cnt,int visit) {
		max = Math.max(max, cnt);

		// 다음 방문
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx<0 || nx >= c || 0 > ny || ny >= r || (visit&1<<map[ny][nx])!=0)continue;

			dfs(ny, nx, cnt + 1,visit|1<<map[ny][nx]);
		}
	}
}
