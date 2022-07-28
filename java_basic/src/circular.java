
public class circular {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] input = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int n = input.length;

		// nomal
//		{
//			for (int i = 0; i < n; i++) {
//				System.out.printf("%2s", input[i]);
//			}
//		}
//		nomal*2
//		{
//			for (int i = 0; i < n*2; i++) {
//				System.out.printf("%2s", input[i]);
//			}
//			
//		}

//		{
//			int cnt = 0;
//			while (true) {
//				if (cnt == 20)
//					break;
//				System.out.printf("%2s", input[cnt % n]);
//				cnt++;
//
//			}
//		}
		{
			// 대각선 출력
			int[][] intArray = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
					{ 16, 17, 18, 19, 20 }, };
			int len = intArray.length;
			int size = intArray[0].length;
			for (int x = 0; x < len + size - 1; x++) {
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < len; j++) {
						if (i + j == x)
							System.out.println(intArray[j][i]);
					}
				}
			}
			// 지그재그
			for (int x = 0; x < len + size - 1; x++) {
				if (x % 2 == 0) {

					for (int i = 0; i < size; i++) {
						for (int j = 0; j < len; j++) {
							if (i + j == x)
								System.out.println(intArray[j][i]);
						}
					}
				} else {
					for (int i = 0; i < len; i++) {
						for (int j = 0; j < size; j++) {
							if (i + j == x)
								System.out.println(intArray[i][j]);
						}
					}
				}
			}
		}

	}
}
