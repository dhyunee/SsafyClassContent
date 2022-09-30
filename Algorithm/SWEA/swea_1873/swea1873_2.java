package java_study.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1873_2 {

	static int t, h, w, n, ty, tx;
	static char[][] map;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());

		for (int k = 1; k < t; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			map = new char[h][];// input에서 string을 array로 바꿀 거라서

			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();

				// 탱크 위치 파악
				for (int j = 0; j < w; j++) {
					switch (map[i][j]) {
					case '<':
					case '>':
					case '^':
					case 'v':
						ty = i;
						tx = j;
						break;
					}
				}
			}
			// 명령어
			n = Integer.parseInt(br.readLine());
			String oper = br.readLine();
			for (int i = 0; i < n; i++) {
				char c = oper.charAt(i);
				switch (c) {
				case 'U':
					map[ty][tx]='^';
					move(0);
					break;
				case 'D':
					map[ty][tx]='v';
					move(1);
					break;
				case 'L':
					map[ty][tx]='<';
					move(2);
					break;
				case 'R':
					map[ty][tx]='>';
					move(3);
					break;
				case 'S':
					shoot();
					break;
				}
			}
			//출력
			System.out.print("#"+k+" ");
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

	
	static void move(int dir) {
		int ny=ty+dy[dir];
		int nx=tx+dy[dir];
		
		if(ny<0||nx<0||ny>=h||nx>=w)return ;
		if(map[ny][nx]=='.') {
			map[ny][nx]=map[ty][tx];
			map[ty][tx]='.';
			ty=ny;
			tx=nx;
		}
	}
	
	static void shoot() {
		int dir=0;
		switch(map[ty][tx]) {
		case '^':dir=0;break;
		case 'v':dir=1;break;
		case '<':dir=2;break;
		case '>':dir=3;break;
		}
		int ny=ty;
		int nx=tx;
		while(true) {
			ny=ny+dy[dir];
			nx=nx+dx[dir];
			if(ny<0||nx<0||ny>=h||nx>=w)return;
			if(map[ny][nx]=='*') {
				map[ny][nx]='.';
				return;
			}
			else if(map[ny][nx]=='#')return ;
		}
	}
}
