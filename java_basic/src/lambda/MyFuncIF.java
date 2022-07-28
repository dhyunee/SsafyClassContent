package lambda;

@FunctionalInterface
public interface MyFuncIF {
	int proc1(int n1,int n2);
	default int proc2(int n1,int n2) {
		return n1-n2;
	}
}
