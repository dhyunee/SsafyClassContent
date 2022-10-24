package exception;

import java.io.FileNotFoundException;

public class exceptionTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		controller controller = new controller();
		controller.m();
	}

}

class controller {
	public void m() {
		Service service = new Service();
		service.m();
		System.out.println("Controller -last");
	}
}

class Service {
	public void m() {
		Dao dao = new Dao();

		try {
			Class.forName("hello");
			dao.m();
		} catch (FileNotFoundException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}

class Dao {
	public void m() throws FileNotFoundException {
		String s = null;
		s.length();

	}
}