package java5.generic.basic;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		objectcotainer oc = new objectcotainer();
		oc.setElement("String");
		// ...다른 코드

		String str = (String) oc.getElement();// type을 알고 있을 때

		if (oc.getElement() instanceof String) {// type을 모를 때 확인 코드 필요
			String str2 = (String) oc.getElement();
		}
		stringcontainer sc = new stringcontainer();
		sc.setElement("string");
		String str3 = sc.getElement();

		// T 대신 실제로 사용될 타입을 <>안에 넣어줌
		genericcontainer<String> gc = new genericcontainer<String>();
		gc.setElement("String");
		String str4 = gc.getElement();

		genericcontainer<Integer> gc2 = new genericcontainer<>();
		gc2.setElement(10);
		Integer n1 = gc2.getElement();
		int n2 = gc2.getElement();

		// Reference Type Collections
		ArrayList<String> a = new ArrayList<>();
		a.add("Hello");
		ArrayList<Myclass> mc = new ArrayList<>();
		mc.add(new Myclass());

	}

	static class Myclass {
		int n;
	}
}
