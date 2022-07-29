package com.ssafy.live1.array;

public class ArrayTest_05 {
    public static void main(String[] args) {
        String org = "1234567890";
        int [] n=new int[org.length()];
        int sum=0;
        for(int i=0;i<org.length();i++) {
        	n[i]=org.charAt(i)-'0';
        	sum+=n[i];
        }
        System.out.println(sum);
        // TODO: String "1234567890" �쓽 �옄由� 蹂� �닔瑜� 1李⑥썝 諛곗뿴�뿉 ���옣�븯怨� 諛곗뿴�쓣 �닚�쉶�빐�꽌 洹� �빀�쓣 異쒕젰�븯�떆�삤.
        // END:
    }
}
