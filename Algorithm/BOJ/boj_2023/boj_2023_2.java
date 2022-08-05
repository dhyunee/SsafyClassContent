package java_study.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2023_2 {

	static int n;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		// search메소드 작성 search(idx,num)
		// 어차피 맨 앞자리가 소수가 아니면 출발할 필요 없음<=2,3,5,7
		search(1, 2);
		search(1, 3);
		search(1, 5);
		search(1, 7);

		System.out.println(sb.toString());
	}

	static void search(int idx, int num) {
		// 현재 자리수의 수가 소수이면 다음 자리수로 재귀호출
		// 기저조건
		if (idx == n) {
			sb.append(num).append("\n");
			return;
		}
		// 소수인지 따져보고 맞으면 재귀호출
		// 다음자리 수는 선택해서 진행(1,3,7,9)<=짝수하고 5 제외
		// 2 다음자리 1을 따지기 위해서 21을 만드는 건 2를 문자열로 바꾼 뒤 1을 더함(문자열)->다시 숫자로 전환

		int next_num = Integer.parseInt(String.valueOf(num) + 1);
		if (isPrime(next_num))
			search(idx + 1, next_num);

		next_num = Integer.parseInt(String.valueOf(num) + 3);
		if (isPrime(next_num))
			search(idx + 1, next_num);

		next_num = Integer.parseInt(String.valueOf(num) + 7);
		if (isPrime(next_num))
			search(idx + 1, next_num);

		next_num = Integer.parseInt(String.valueOf(num) + 9);
		if (isPrime(next_num))
			search(idx + 1, next_num);

	}

	// 개선된 소수 판별
	static boolean isPrime(int num) {
		if (num == 1)
			return false;
		int sqrt = (int) Math.sqrt(num);
		for (int i = 2; i < sqrt + 1; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
