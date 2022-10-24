package oop.override.equals.hash;

public class Test {
	public static void main(String[] args) {
		item item1 = new item();
		item1.itemId = 1;
		item1.itemNm = "item";

		item item2 = new item();
		item2.itemId = 1;
		item2.itemNm = "item";

//		if (item1 == item2) {// reference type: 주소가 당연히 다름
//			System.out.println("same");
//		} else {
//			System.out.println("Not same");
//		}

		if (item1.equals(item2)) {// reference type: 주소가 당연히 다름
			System.out.println("same");
		} else {
			System.out.println("Not same");
		}
	}
}
