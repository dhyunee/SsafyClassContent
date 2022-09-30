package basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BASIC_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 빈도수출력

		{
			int[] alphacnt = new int[26];// a-z빈도수
			String str = "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi";
			int strlength = str.length();
			for (int i = 0; i < strlength; i++) {
				alphacnt[str.charAt(i) - 'a']++;
			}
			for (int i = 0; i < 26; i++) {
				System.out.println((char) (i + 'a') + " : " + alphacnt[i]);
			}
		}
		// 규칙이 다른 경우 확인
		// 세자리 수가 각각 곱셈을 표현 236->2*3==6(맞음) 233(틀림)
		{
			int[] arr = { 3, 2, 6, 3, 4, 4, 1, 4, 2, 2, 3, 6, 1, 3, 5, 1, 5, 1, 1, 1, 1, 2, 4, 2, 2, 2, 4 };
//			int Wrongcnt = 0;
//			for (int i = 2; i < arr.length; i += 3) {
//
//				if (arr[i - 2] * arr[i - 1] == arr[i]) {
//					System.out.println("맞음");
//				} else {
//					System.out.println("틀림");
//					Wrongcnt++;
//				}
//			}
		}

		{
			// reverse
			String[] arr = { "111", "222", "333", "444", "555", "666", "777" };
			int center = arr.length / 2;
//			for (int i = 0; i < center; i++) {
//				String tmp = arr[i];
//				arr[i] = arr[arr.length - i - 1];
//				arr[arr.length - i - 1] = tmp;
//			}

//			for (int i = 0, r = arr.length - 1; i < center; i++, r--) {
//				String tmp = arr[i];
//				arr[i] = arr[r];
//				arr[r] = tmp;
//			}
			List<String> strlist = Arrays.asList(arr);
			Collections.reverse(strlist);

			System.out.println(Arrays.toString(arr));
//			System.out.println(Wrongcnt);
		}
	}
}
