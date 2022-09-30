package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class jo_1828 {

	static int n,max,cnt;
	static int[][] input; //input[i][0]:재료의 최저 온도,input[i][1]:i번째 최고 온도
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		input=new int[n][2];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			input[i][0]=Integer.parseInt(st.nextToken());
			input[i][1]=Integer.parseInt(st.nextToken());
		}
		
		//외의실과 같은 문제로 greedy하게  해결=> 최고 온도로 정렬 
		Arrays.sort(input,(o1,o2)->o1[1]-o2[1]);
		
		//초기화
		max=Integer.MIN_VALUE;
		cnt=0;
		
		//순회하면서 최저 온도가 현재 max(최고온도 의미)보다 더 높으면 같이 보관이 안됨 냉장고 추가로 필요
		for(int i=0;i<n;i++) {
			if(max<input[i][0]) {
				cnt++;
				max=input[i][1];
			}
		}
		System.out.println(cnt);
	}

}
