package design.singleton;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Loger loger=new Loger();
//		Loger loger2=new Loger();
		Loger loger = Loger.getInstance();
		loger.log("Hello");

		Loger loger2 = Loger.getInstance();

		if (loger == loger2)
			System.out.println("same");
	}

}
