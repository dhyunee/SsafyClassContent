package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1541 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int sum=Integer.MAX_VALUE;
		String []array=br.readLine().split("-");
		
		
		for(int i=0;i<array.length;i++) {
			int tmp=0;
			String[] arr = array[i].split("\\+");
			
			for(int j=0;j<arr.length;j++) {
				tmp+=Integer.parseInt(arr[j]);
			}
			if(sum==Integer.MAX_VALUE) {
				sum=tmp;
			}else {
				sum-=tmp;
			}
		}
						
		System.out.println(sum);

	}
}

