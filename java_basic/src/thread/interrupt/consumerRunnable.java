package thread.interrupt;

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

			if (i == 500) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println("Interrupted!!!!!!!");
				}

			}

		}
		System.out.println("#" + " " + "end");

	}

}
