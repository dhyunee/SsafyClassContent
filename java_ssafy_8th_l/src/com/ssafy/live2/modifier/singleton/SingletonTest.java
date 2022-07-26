package com.ssafy.live2.modifier.singleton;

class SingletonClass{
    // TODO:SingletonClass에 Singleton Design Pattern을 적용하시오.
    // END:
	//staeless 한 클래스 -> 변수(상태) 없이 기능만 존재
    private static SingletonClass sc=new SingletonClass();
 
	private SingletonClass() {
    	
    }
	
	public static SingletonClass getSingletonClass() {
		return sc;
	}
	public void sayHello() {
      System.out.println("Hello");
    }
    
  }

  public class SingletonTest {
    public static void main(String[] args) {
      // TODO:SingletonClass를 사용해보세요.  
      // END:
    	SingletonClass sc=SingletonClass.getSingletonClass();
    	sc.sayHello();
    }
  }
