package thread.basic;

public class consumerRunnable implements Runnable {
	int num;

	public consumerRunnable(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		System.out.println("#" + num + "start");
		for (int i = 0; i < 1000; i++) {
			System.out.println("#" + num + " " + i);
		}
		System.out.println("#" + " " + "end");

	}

}
