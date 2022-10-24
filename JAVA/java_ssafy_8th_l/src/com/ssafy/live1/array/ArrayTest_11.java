package com.ssafy.live1.array;


public class ArrayTest_11 {
	public static void main(String[] args) {
		int[] intArray = { 3, 27, 13, 8, 235, 7, 22, 9, 435, 31, 54 };
		double min=Double.MAX_VALUE;
		double max=Double.MIN_VALUE;
		// TODO: �쐞 諛곗뿴�쓽 �슂�냼 以� �룊洹�(�떎�닔, �냼�닽�젏 �꽭吏몄뿉�꽌 諛섏삱由� 異쒕젰)怨� �젅��媛� 湲곗��쑝濡�
		//  �룊洹좎뿉�꽌 媛��옣 嫄곕━媛� 癒� 媛믪쓣 異쒕젰�븯�떆�삤.(�뿬�윭 媛쒖씪 寃쎌슦�뒗 �븯�굹留�)
		// END:
		int sum=0;
		for(int x:intArray) {
			sum+=x;
		}
		int minIdx=-1;
		int maxIdx=-1;
		double avg=(double)(sum)/intArray.length;
		for(int i=0;i<intArray.length;i++) {
			min=Math.min(min,Math.abs(intArray[i]-avg));
			if (min==Math.abs(intArray[i]-avg))minIdx=i;
			max=Math.max(max, Math.abs(intArray[i]-avg));
			if (max==Math.abs(intArray[i]-avg))maxIdx=i;
		
		}
		
		System.out.printf("avg:%.2f, maxDiff: %d, minDiff:%d%n", avg, intArray[maxIdx], intArray[minIdx]);

	}
}
