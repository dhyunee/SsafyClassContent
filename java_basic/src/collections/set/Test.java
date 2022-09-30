package collections.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// String
		// set은 순서과 유지 되지 않고 중복도 허용되지 않음
//		{
//			Set<String> set = new HashSet<>();
//			set.add("Hello");
//			set.add("World");
//			set.add("Hello");
//			set.add("SSAFY");
//
//			for (String s : set) {
//				System.out.print(s + " ");
//			}
//		}

		{
			Set<Myclass> set = new HashSet<>();// 주소값이 같아서 게속 4개 다 나옴
			set.add(new Myclass(7, 3, 3));
			set.add(new Myclass(2, 4, 3));
			set.add(new Myclass(7, 3, 3));// 같은데 구분하지 못함=>equals override
			set.add(new Myclass(1, 6, 9));

			for (Myclass s : set) {
				System.out.println(s);
			}
		}

	}

	static class Myclass {
		int y, x, c;

		public Myclass(int y, int x, int c) {
			this.y = y;
			this.x = x;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Myclass [y=" + y + ", x=" + x + ", c=" + c + "]";
		}

		// equals overriding 하는 상황이면 늘 hashcode도 overriding 해줘라
		@Override
		public boolean equals(Object o) {
			if (o != null && o instanceof Myclass) {
				Myclass mc = (Myclass) o;
				if (this.y == mc.y && this.x == mc.x && this.c == mc.c)
					return true;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.y, this.x, this.c);
		}

//		@Override
//		public int compareTo(Myclass o) {
//			if(this.y==o.y) {
//				if(this.x==o.x)return this.c.compareTo(o.c);
//				return this.x-
//			}
//		}

	}
}
