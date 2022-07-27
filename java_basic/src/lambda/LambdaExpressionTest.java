package lambda;

public class LambdaExpressionTest {

	public static void main(String[] args) {
//		UseFuncIF.exec1(()->{System.out.println("Hello");});//파라미터로 FuncIF1을 구현한 객체가 옴
		// UseFuncIF.exec1(()->{return "hello";});//오류발생 ->void m()이니깐 아무런 return 값을 가지면
		// 안 됨

		{
			UseFuncIF.exec2(() -> {
				return 10;
			});
			UseFuncIF.exec2(() -> 10);// 리턴 값 있으면 그냥 값만 가져도 됨
			UseFuncIF.exec2(() -> {
				int n1 = 10, n2 = 20;
				return n1 + n2;
			});
			UseFuncIF.exec2(() -> sm1());
		}
		{
			UseFuncIF.exec3((n) -> "입력값에 10을 더하면: " + (n + 10));
			UseFuncIF.exec3(n -> "입력값에 10을 더하면: " + (n + 10));// 하나일때만 괄호 뺼 수 있음
			UseFuncIF.exec3(n -> {
				if (n % 2 == 0)
					return "짝수";
				else
					return "홀수";
			});
		}

		{
			UseFuncIF.exec4((n1, n2) -> n1 + n2);
			UseFuncIF.exec4((n1, n2) -> Math.min(n1, n2));
			UseFuncIF.exec4(5, 22, (n1, n2) -> n1 + n2);

		}

		{
			// 두 객체의 y,x 좌표 중 y가 큰 객체를 리턴
			UseFuncIF.exec5(new Myclass(7, 2), new Myclass(3, 9), (mc1, mc2) -> {
				return mc1.y > mc2.y ? mc1 : mc2;
			});

			// 두 객체의 y+x 합이 더 큰 객체를 리턴
			UseFuncIF.exec5(new Myclass(7, 2), new Myclass(3, 9),
					(mc1, mc2) -> mc1.y + mc1.x > mc2.y + mc2.x ? mc1 : mc2);
		}

	}

	// 누군가가 아래의 interfce를 구현한 객체가 필요하다.
	static interface FuncIF1 {
		void m();
	}// 파라미터X, 리턴X

	static interface FuncIF2 {
		int m();
	}// 파라미터X, 리턴 int

	static interface FuncIF3 {
		String m(int n);
	}// 파라미터 O,리턴 String

	static interface FuncIF4 {
		int m(int n1, int n2);// 파라미터 2개, 리턴 int
	}

	static interface FuncIF5 {
		Myclass m(Myclass mc1, Myclass mc2);// 적절하게 기능을 수행하는 메소드 이름 있으면 좋음
	}

	static int sm1() {
		return 1;
	}

	// 누군가가 바로 나다.(user)

	static class UseFuncIF {
		public static void exec1(FuncIF1 funcIFImpl) {
			funcIFImpl.m();
		}

		public static void exec2(FuncIF2 funcIFImpl) {
			System.out.println(funcIFImpl.m());// 리턴 결과 출력
		}

		public static void exec3(FuncIF3 funcIFImpl) {
			System.out.println(funcIFImpl.m(10));// 파라미터 및 리턴 결과 출력
		}

		public static void exec4(FuncIF4 funcIFImpl) {
			System.out.println(funcIFImpl.m(7, 3));// 파라미터 및 리턴 결과 출력
		}

		public static void exec4(int n1, int n2, FuncIF4 funcIFImpl) {
			System.out.println(funcIFImpl.m(n1, n2));// 파라미터 및 리턴 결과 출력
		}

		public static void exec5(Myclass mc1, Myclass mc2, FuncIF5 funcIFImpl) {
			System.out.println(funcIFImpl.m(mc1, mc2));// 파라미터 및 리턴 결과 출력
		}
	}

	static class Myclass {
		int y, x;

		public Myclass(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Myclass [y=" + y + ", x=" + x + "]";
		}

	}

}
