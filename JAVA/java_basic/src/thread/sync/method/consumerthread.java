package thread.sync.method;

public class consumerthread extends Thread {
	Gas gas;

	public consumerthread(Gas gas) {
		this.gas = gas;
	}

	@Override
	public void run() {
		gas.consume();

	}
}
