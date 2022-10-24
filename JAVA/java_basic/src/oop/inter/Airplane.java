package oop.inter;

//인터페이스를 implements 하는 순간, 의무 사항이 발생->override
//반드시 기능을 구현해야 함
public class Airplane extends Transportaion implements Fly {

	private int no;
	private String name;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void howtofly() {
		// TODO Auto-generated method stub
		System.out.println("By engine");
	}

	@Override
	public void howfastfly() {
		// TODO Auto-generated method stub
		System.out.println("800km/h");
	}

}
