package oop.inter;

public class FlyFactory {
	static Fly getinstance(String clsf) {
		switch (clsf) {
		case "dove":
			return new Dove();
		case "airplane":
			return new Airplane();
		case "bird":
			return new Bird();
		default:
			return new Airplane();
		}
	}
}
