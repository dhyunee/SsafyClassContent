package thread.basic;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		consumerthread c1 = new consumerthread(1);
//		consumerthread c2 = new consumerthread(2);
		Thread c2 = new Thread(new consumerRunnable(2));
		c1.start();
		c2.start();
//		c3.start();

		System.out.println("main start");
		for (int i = 0; i < 1000; i++) {
			System.out.println("main" + i);
		}
		System.out.println("main end");
	}
}