import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 월말평가_2번문제 {
	// 0:|, 1:-, 2:+, 3:┌, 4:└, 5:┘, 6:┐
	static char[] block = { '|', '-', '+', '1', '2', '3', '4' };
	static final int UP = 0, LEFT = 1, DOWN = 2, RIGHT = 3;
	static int[] di = { -1, 0, +1, 0 };
	static int[] dj = { 0, -1, 0, +1 };

	static int R, C;
	static int ansi, ansj, ansb;
	static boolean isBlock, isComplete;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]=='M') {
					// 출발지는 주어졌지만, 방향이 안 주어졌기 때문에 방향을 찾아야 함.
					for(int d=0; d<4; d++) {
						int nexti = i+di[d];
						int nextj = j+dj[d];
						if(nexti>=0 && nexti<R && nextj>=0 && nextj<C)
							dfs(i+di[d], j+dj[d], d);
					}
				}
			}
		}

		System.out.println((ansi+1) + " " + (ansj+1) + " " + map[ansi][ansj]);

	}

	static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("----------------");
	}

	private static void dfs(int i, int j, int dir) {
		if(isComplete) return;
		
		// 현재 방문하는 좌표가 빈 칸이면
		if (map[i][j] == '.') {
			
			// 현재 탐색과정이 아직 block 이 아닌 경우 (끊어진 경우)
			if (!isBlock) {
				
				// block 각각에 대해서 따진다.
				for (int b = 0; b < block.length; b++) {
					
					// 연결되면 현재의 좌표를 ans 로 간주하고 map 을 현재 block 으로 놓고 재귀호출
					// 재귀호출로 따지고 원복
					if (isOpen(block[b], (dir + 2) % 4)) {
						
						isBlock = true;
						map[i][j] = block[b];
						ansi = i;
						ansj = j;
						ansb = map[i][j];
						dfs(i, j, dir);
						
						if (isComplete)	return;
						
						isBlock = false;
						map[i][j] = '.';
						ansi = 0;
						ansj = 0;
						ansb = map[i][j];
					}
				}
			}
			return;
		}
		
		// 목적지까지 왔고 bloc 이면 종료
		if(map[i][j]=='Z') {
			if(isBlock)
				isComplete = true;
			return;
		}
		
		// 이 곳까지 왔으면 연결되어서 계속 따지는 과정
		int nextD = nextDir(map[i][j], (dir+2)%4);
		
		int nexti = i+di[nextD];
		int nextj = j+dj[nextD];
		
		if(nexti>=0 && nexti<R && nextj>=0 && nextj<C&& (isOpen(map[nexti][nextj], (nextD+2)%4) || map[nexti][nextj]=='.'|| map[nexti][nextj]=='Z')) {
			dfs(nexti, nextj, nextD);
		}
	}

	// block 별 현재 방향에 대해서 이동 가능 여부
	static boolean isOpen(char block, int dir) {
		switch (block) {
		case '|':
			return dir == UP || dir == DOWN;
		case '-':
			return dir == LEFT || dir == RIGHT;
		case '+':
			return dir == LEFT || dir == RIGHT || dir == UP || dir == DOWN;
		case '1':
			return dir == RIGHT || dir == DOWN;
		case '2':
			return dir == UP || dir == RIGHT;
		case '3':
			return dir == UP || dir == LEFT;
		case '4':
			return dir == DOWN || dir == LEFT;
		}
		return false;
	}

	// block 별 현재 방향에 대한 다음 방향
	static int nextDir(char block, int dir) { // 0:up, 1:left, 2:down, 3:right
		switch (block) {
		case '|':
		case '-':
		case '+':
			return (dir + 2) % 4;
		case '1':
			return dir == RIGHT ? DOWN : RIGHT;
		case '2':
			return dir == UP ? RIGHT : UP;
		case '3':
			return dir == UP ? LEFT : UP;
		case '4':
			return dir == LEFT ? DOWN : LEFT;
		}
		return -1;
	}
}
