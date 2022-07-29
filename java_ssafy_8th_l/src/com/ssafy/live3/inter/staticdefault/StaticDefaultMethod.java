package com.ssafy.live3.inter.staticdefault;

interface Aircon {
    void makeCool();
    
    // TODO: 2. 건조기능을 추가해보자.
    // END:
    	
    default void dry() {
    	System.out.println("건조");
    }
    
    static void howto() {
    	System.out.println("냉매 이용해 공기를 차갑게");
    }
    
    // TODO: 3.Aircon이 동작 방식에 대해 설명해보자.
    // END:
    
}

class OldisButGoodies1 implements Aircon{
    @Override
    public void makeCool() {
        System.out.println("전체 냉각해줘");
    }
}

class OldisButGoodies2 implements Aircon{
    @Override
    public void makeCool() {
        System.out.println("집중 냉각해줘");
    }
}

class NoWind1 implements Aircon{
	public void makeCool() {
		System.out.println("무풍");
	}
	
	@Override
	public void dry() {
		// TODO Auto-generated method stub
		System.out.println("종료버튼 클릭 후 건조");
	}
}
// TODO: 1. 무풍 에어컨을 구현해보자.
// END:

public class StaticDefaultMethod {
    public static void main(String[] args) {
    	Aircon.howto();
        Aircon [] aircons = {new OldisButGoodies1(), new OldisButGoodies2()};
        for(Aircon aircon: aircons) {
            if(aircon==null) {
                continue;
            }
            aircon.makeCool();
        }
    }
}
