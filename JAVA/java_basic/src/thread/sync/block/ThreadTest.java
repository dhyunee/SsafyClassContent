package thread.sync.block;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gas gas = new Gas();
		gas.setAmount(100);

		for (int i = 0; i < 1000; i++) {
			consumerthread ct = new consumerthread(gas);
			producerthread pt = new producerthread(gas);

			ct.start();
			pt.start();
		}
	}

}
