package collections.map;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("love", "사랑하다");
		map.put("hate", "미워하다");
		map.put("same", "똑같다");
		map.put("ssafy", "취업");

		String meaning = map.get("same");
		System.out.println(meaning);

		// 순서 안지켜짐
		for (String key : map.keySet()) {
			System.out.print(key + " : ");
			System.out.println(map.get(key));
		}

		map.put("love", "사랑해욥");// 중복이어도 오류는 발생 안 함, 그냥 덮어쓴다.
		map.put("equals", "똑같다");// value 중복은 허용
		for (String key : map.keySet()) {
			System.out.print(key + " : ");
			System.out.println(map.get(key));
		}
	}

}
