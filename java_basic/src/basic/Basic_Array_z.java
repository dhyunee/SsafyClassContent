package basic;

public class Basic_Array_z {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1 대각선:왼쪽 아래에서 오른쪽 위로
		{
			int[][] intArray = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
					{ 16, 17, 18, 19, 20 }, };
			int line = intArray.length + intArray[0].length - 1;
			int col = intArray[0].length;
			int row = intArray.length;

			int r = 0, c = 0;

			for (int i = 0; i < line; i++) {
				r = i;// i 증가처럼 처음에는 같이 증가--->바닥에 고정되는 형태
				c = 0;// 처음에는 맨 앞에서 출발--->점점 증가하는 형태

				if (i >= row) {
					r = row - 1;
					c = i - row + 1;
				}
				while (true) {
					if (r < 0 || c > col - 1) {
						System.out.println();
						break;
					}
					System.out.printf("%3d", intArray[r][c]);
					// 대각선 이동
					r--;
					c++;
				}
			}
		}
		// 2 대각선 지그재그: 왼쪽 아래에서 오른쪽 위로 다시 오른쪽 위에서 왼쪽 아래로
		{
			int[][] intArray = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
					{ 16, 17, 18, 19, 20 }, };

			int line = intArray.length + intArray[0].length - 1;
			int col = intArray[0].length;
			int row = intArray.length;

			int r = 0, c = 0;

			for (int i = 0; i < line; i++) {

				if (i % 2 == 0) {
					r = i;// i 증가처럼 처음에는 같이 증가--->바닥에 고정되는 형태
					c = 0;// 처음에는 맨 앞에서 출발--->점점 증가하는 형태

					if (i >= row) {
						r = row - 1;
						c = i - row + 1;
					}
					while (true) {
						if (r < 0 || c > col - 1) {
							System.out.println();
							break;
						}
						System.out.printf("%3d", intArray[r--][c++]);
						// 대각선 이동
					}
				} else {
					r = 0;// i 증가처럼 처음에는 같이 증가--->바닥에 고정되는 형태
					c = i;// 처음에는 맨 앞에서 출발--->점점 증가하는 형태

					if (i >= row) {
						r = i - col + 1;
						c = col - 1;
					}
					while (true) {
						if (c < 0 || r > row - 1) {
							System.out.println();
							break;
						}
						System.out.printf("%3d", intArray[r++][c--]);
						// 대각선 이동
					}
				}
			}
		}
	}

}
