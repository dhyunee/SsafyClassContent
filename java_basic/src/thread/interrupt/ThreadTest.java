package thread.interrupt;

public class ThreadTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		consumerthread c1 = new consumerthread(1);
//		consumerthread c2 = new consumerthread(2);
		Thread c2 = new Thread(new consumerRunnable(2));
		c1.start();
		c2.start();
//		c3.start();

		Thread.sleep(2000);
		c2.interrupt();

	}
}