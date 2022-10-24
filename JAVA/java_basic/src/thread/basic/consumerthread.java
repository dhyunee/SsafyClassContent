package thread.basic;

public class consumerthread extends Thread {

	int num;

	public consumerthread(int num) {
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
