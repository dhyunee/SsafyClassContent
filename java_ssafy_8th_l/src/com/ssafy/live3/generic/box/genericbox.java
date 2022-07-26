package com.ssafy.live3.generic.box;

public class genericbox<T> {
	private T some;
	public genericbox() {
		
	}
	public genericbox(T some) {
		super();
		this.some=some;
	}
	public T getSome() {
		return some;
	}
	public void setSome(T some) {
		this.some = some;
	}
	
}
