package lambda;

public class Test {

	public static void main(String[] args) {
		int n1 = 10;
		int n2 = 20;

		// #1 인터페이스를 구현한 클래스를 사용 MyFuncIFImpl
		{
			MyFuncIF func = new MyFuncIFImpl();
			int result = func.proc1(n1, n2);
			System.out.println(result);
		}

		// #2 인터페이스를 구현한 익명 클래스를 사용- MyFuncIFImpl 사용X
		{
			MyFuncIF func = new MyFuncIF() {

				@Override
				public int proc1(int n1, int n2) {
					// TODO Auto-generated method stub
					return n1 + n2;
				}
			};
			int result = func.proc1(n1, n2);
			System.out.println(result);
		}
	}

}
