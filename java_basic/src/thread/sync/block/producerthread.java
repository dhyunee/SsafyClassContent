package thread.sync.block;

public class producerthread extends Thread {
	Gas gas;

	public producerthread(Gas gas) {
		this.gas = gas;
	}

	@Override
	public void run() {
//		gas.produce();
		synchronized (gas) {
			gas.produce();
		}
	}
}
