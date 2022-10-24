import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 월말평가_1번문제 {
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		list = new ArrayList<>();
		
		list.add(64);
		
		while(sum() > X) {
			Collections.sort(list);
			int stick = list.remove(0);
			
			list.add(stick/2); // 절반은 일단 킵
			if(X>sum()) // 남은거 다 더해도 X보다 작으면 방금 잘랐던 토막도 버리지 말고 챙기기
				list.add(stick/2);
		}
		System.out.println(list.size());
	}
	
	static int sum() {
		int tmp=0;
		for(int n: list)
			tmp += n;
		return tmp;
	}
}
