package com.ssafy.live2.extend.person;

public class SpiderMan extends Person{
	public boolean isSpider;
	public Spider spider=new Spider();
	
	public SpiderMan(String name,boolean isSpider){
		//this혹은 super가 올 수 있고 얘네는 무조건 첫번째
		super(name);
		this.isSpider=isSpider;
	}
	
	public void fireWeb() {
		if(isSpider) {
			//null pointer==>null.xx
			spider.fireweb();
		}else System.out.println("사람일때는 참자");
	}
	public void jump() {
		if(isSpider)spider.jump();
		else super.jump();//person의 jump
	}
	
}
