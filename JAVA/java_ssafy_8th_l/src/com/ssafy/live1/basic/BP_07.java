package com.ssafy.live1.basic;

public class BP_07 {
    public static void main(String[] args) {
        int i1 = Integer.MAX_VALUE;//1e9
        
        int i2 = i1+1;
        //오버플로우 발생
        System.out.println(i2);
    }
}
