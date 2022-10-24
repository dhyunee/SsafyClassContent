package thread.sync.block;

public class consumerthread extends Thread {
	Gas gas;

	public consumerthread(Gas gas) {
		this.gas = gas;
	}

	@Override
	public void run() {
//		gas.consume();
		synchronized (gas) {
			gas.consume();
		}
	}
}
