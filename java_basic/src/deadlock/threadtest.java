package deadlock;

public class threadtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj1 = new sharedobject();
		Object obj2 = new sharedobject();
		Thread t1 = new thread1(obj1, obj2);
		Thread t2 = new thread2(obj1, obj2);
		t1.start();
		t2.start();

	}

}
