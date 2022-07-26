package com.ssafy;

public class pho {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Phone[] phoneArray = new Phone[5];
		// phone객체를 가르킬 수 있는 레퍼런스만 5개 만듦 그래서 null오류 발생
		for (int i = 0; i < phoneArray.length; i++) {
			phoneArray[i] = new Phone();
			phoneArray[i].setPrice(i * 200);
		}
		for (Phone phone : phoneArray)
			System.out.println(phone.getPrice());
	}

}
