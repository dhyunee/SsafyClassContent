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
			System.out.println(funcIFImpl.m(5));// 파라미터 및 리턴 결과 출력
		}
	}

	// 내가 제공해줌 ㅇㅇ supplier
}
