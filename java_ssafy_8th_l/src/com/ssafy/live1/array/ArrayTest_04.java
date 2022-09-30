package com.ssafy.live1.array;

import java.util.Arrays;

public class ArrayTest_04 {
	public static void main(String[] args) {

		String org = "SSAFY";
		// TODO: char []�쓣 �씠�슜�빐 String org�쓽 媛� 臾몄옄瑜� ���옣�븯怨� 異쒕젰�븯�뒗 肄붾뱶瑜� �옉�꽦�븯�떆�삤.
		// END:
		char [] arr= new char[org.length()];
		
		for(int i=0;i<org.length();i++) {
			arr[i]=org.charAt(i);
		}
		System.out.println(Arrays.toString(arr));
		
		char[]b=org.toCharArray();
		for(char x:b) {
			System.out.print(x+" ");
		}
				
	}
}
