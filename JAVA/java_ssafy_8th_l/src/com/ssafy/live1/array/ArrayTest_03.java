package com.ssafy.live1.array;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest_03 {
    public static void main(String[] args) {

        int N = 6;
        Random rand = new Random();
        int [] arr=new int[5];
        for(int i=0;i<5;i++) {
        	arr[i]=rand.nextInt(N)+1;
        }
        System.out.println(Arrays.toString(arr));
        // TODO: 1~6源뚯��쓽 random �젙�닔 5媛쒕�� ���옣�븷 諛곗뿴�쓣 留뚮뱾怨� 媛믪쓣 ���옣�븯�떆�삤.
        // END:
        int sum=0;
        for(int i=0;i<5;i++) {
        	if(arr[i]%2==0) {
        		sum+=arr[i];
        	}
        }
        System.out.println(sum);
        // TODO: �쐞 諛곗뿴�뿉 ���옣�맂 �슂�냼 以� 吏앹닔留� �뜑�빐�꽌 �빀�쓣 異쒕젰�븯�떆�삤.
        // END:
    }
}
