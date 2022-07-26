package com.ssafy;

public class food {

	private String name = "chicken";
	private int price;
	private int favor;

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getFavor() {
		return favor;
	}

	public food(String name, int price, int favor) {
		this(name, price);
		this.favor = favor;
	}

	public food(String name, int price) {
		this.name = name;
		this.price = price;
	}

}
