package com.ssafy.live2.modifier.p2;

import com.ssafy.live2.modifier.p1.Parent;
//TODO: Parent를 상속받고 Parent의 member들에 접근해보세요.
 public class OtherPackageChildClass extends Parent{
    // END:
	 public void method() {
		 this.publicVar=10;
		 this.protectVar=10;
		 //this.defaultVar=10; 다른 package 아웃
//		 this.privVar=10;
//		 this.someVar=10;
	 }
}
