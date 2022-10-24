package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {
//		{
//			ArrayList al = new ArrayList();// generic에 대한 경고
//		}
//		{
//			ArrayList<Integer> al = new ArrayList<>();
//		}
//		{
//			List<Integer> al = new ArrayList<>();// list는 interface 타입,오른쪽은 기능 구현한 것
//			al.add(0);
//			al.add(9);
//			al.add(1);
//			al.add(7);
//			al.add(0, 9);
//			al.add(1, 8);
//			System.out.println(al);
//
//			al.remove(2);// by index
//			System.out.println(al);
//
//		}

		// 순회
//		{
//			List<String> al = new ArrayList<>();// list는 interface 타입,오른쪽은 기능 구현한 것
//			al.add("손흥민");
//			al.add("이강인");
//			al.add("이승우");
//			al.add("이강인");
//			System.out.println(al);
//
//			// for
//			for (int i = 0; i < al.size(); i++) {
//				String s = al.get(i);
//				System.out.print(s + " ");
//			}
//			System.out.println();
//
//			// for each - index가 없다.
//			for (String s : al) {
//				System.out.print(s + " ");
//			}
//			System.out.println();
//
//			// iterator
//			Iterator<String> itr = al.iterator();
//			while (itr.hasNext()) {
//				String s = itr.next();
//				System.out.print(s + " ");
//			}
//		}

		// #순회 중 삭제

		{
//			List<String> al = new ArrayList<>();// list는 interface 타입,오른쪽은 기능 구현한 것
//			al.add("손흥민");
//			al.add("이강인");
//			al.add("이강인");
//			al.add("이승우");
//
//			System.out.println(al);
//
//			// for
//			for (int i = 0; i < al.size(); i++) {
//				String s = al.get(i);
//				if (s.equals("이강인"))
//					al.remove(i);
//			}
//			System.out.println(al);
//			//아무래도 삭제하면 index도 달라지니깐...
			// reverse order로 해결 가능
//			for (int i = al.size() - 1; i >= 0; i--) {
//				String s = al.get(i);
//				if (s.equals("이강인"))
//					al.remove(i);
//				System.out.println(al);
//			}

//			for (String s : al) {
//				if (s.equals("이강인"))
//					al.remove(s);
//				System.out.println(al);
//			}
//			// iterator 사용
//			Iterator<String> itr = al.iterator();
//			while (itr.hasNext()) {
//				String s = itr.next();
//				if (s.equals("이강인"))
//					itr.remove();
//			}
//			System.out.println(al);

//			al.removeIf(el -> el.equals("이강인"));//lambda
//			System.out.println(al);

			// sort
			{
				List<String> al = new ArrayList<>();// list는 interface 타입,오른쪽은 기능 구현한 것
				al.add("A");
				al.add("C");
				al.add("B");
				al.add("D");

				System.out.println(al);
				Collections.sort(al);
				System.out.println(al);
			}
		}
	}

}
