package thread.sync.method;

public class producerthread extends Thread {
	Gas gas;

	public producerthread(Gas gas) {
		this.gas = gas;
	}

	@Override
	public void run() {
		gas.produce();

	}
}
