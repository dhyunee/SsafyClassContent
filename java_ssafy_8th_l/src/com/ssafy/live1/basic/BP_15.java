package com.ssafy.live1.basic;

public class BP_15 {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        System.out.println((a > b) & (b > 0));
        
        System.out.println((a += 10) > 15 | (b -= 10) > 15);
        System.out.println("a = " + a + ", b = " + b);

        a  =10;
        b = 20;
        System.out.println((a += 10) > 15 || (b -= 10) > 15);
        //첫 번째만 읽고 true인 경우 두 번째는 안 읽음
        System.out.println("a = " + a + ", b = " + b);
    }
}
