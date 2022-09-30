package com.ssafy.live3.generic.box;

public class UseBoxTest {

    public static void main(String[] args) {
        useNormalBox();
        useGenericBox();
        useNumberBox();
    }

    private static void useNormalBox() {
        // TODO: NormalBox 타입의 객체를 생성하고 사용해보세요.
        // END:
    	nomalbox n=new nomalbox();
    	n.setSome(1);
    	n.setSome("Hello");
    	
    	Object obj=n.getSome();
    	if(obj instanceof String) {
    		String str=(String)obj;
    		System.out.println(str+" : "+str.length());
    	}
    }

    private static void useGenericBox() {
        // TODO: GenericBox 타입의 객체를 생성하고 사용해보세요.
        // END:
    	genericbox<String>s=new genericbox<>();
    	s.setSome("Hello");//컴파일 시점에 타입에 대한 체크
    	String str=s.getSome();
    	System.out.println(str);
    }

    private static void useNumberBox() {
        // TODO: NumberBox 타입의 객체를 생성하고 사용해보세요.
        // END:
    	NumberBox<Number>numbox=new NumberBox<> ();
    	numbox.addSome(1,10L,3.14);
    	
    	NumberBox<Integer>dbox=new NumberBox<>();
    	dbox.addSome(1,3,10);
    	//모든 타입가능 하게 하려면 parameter Object로 하면 됨
    	}

}
