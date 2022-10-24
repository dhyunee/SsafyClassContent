package oop.inter;

public class Bird extends Animal implements Fly {

	@Override
	public void howtofly() {
		// TODO Auto-generated method stub
		System.out.println("By wing");
	}

	@Override
	public void howfastfly() {
		// TODO Auto-generated method stub
		System.out.println("50km/h");
	}
}
