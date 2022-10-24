package com.ssafy.live2.extend.person;

public class SpiderManQuest {
	
	public static void main(String[] args) {
		SpiderMan sman=new SpiderMan("피터파커",true);
		sman.eat();//person
		sman.jump();//person
		sman.fireWeb();//spiderman
		sman.isSpider=true;
		sman.eat();//person
		sman.jump();//person
		sman.fireWeb();
	}

}
