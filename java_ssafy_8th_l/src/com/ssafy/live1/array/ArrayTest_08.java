package com.ssafy.live1.array;


public class ArrayTest_08 {
    public static void main(String[] args) {
        String[] students = {"홍길동", "임꺽정", "장길산", "이몽룡"};
        // TODO: 諛곗뿴�뿉�꽌 �엫爰쎌젙怨� �옣湲몄궛�쓽 �쐞移섎�� 蹂�寃쏀빐�꽌 異쒕젰�븯�떆�삤.
        // END:
        String tmp=students[1];
        students[1]=students[2];
        students[2]=tmp;
        
        for(String s:students) {
        	System.out.println(s);
        }
    }
}
