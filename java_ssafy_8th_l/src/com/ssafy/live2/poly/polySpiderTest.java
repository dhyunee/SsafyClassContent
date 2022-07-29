package com.ssafy.live2.poly;
import com.ssafy.live2.extend.person.*;

public class polySpiderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiderMan sman=new SpiderMan("피터파커",true);
		SpiderMan sman2=sman;
		Person person=sman;
		Object obj=person;
		
		//명시적 형 변환
		SpiderMan reSpider= (SpiderMan)obj;
		reSpider.fireWeb();
		
		
		//뭐든 담을 수 있는 만능의 주머니
		Object []objs=new Object[4];
		objs[0]=sman;
		objs[1]="Hello";
		objs[2]=objs;
		objs[3]=1;//기본형인데 왜 될까나?-->autoboxing
		
		SpiderMan fromObjectArray=(SpiderMan)objs[0];
		fromObjectArray.fireWeb();
		
		if (objs[1] instanceof SpiderMan) {
			SpiderMan fromObjectArray2=(SpiderMan)objs[1];
			fromObjectArray.fireWeb();
		}
		
		for(Object o:objs) {
			System.out.println(o.getClass().getName());
		}
	}

}
