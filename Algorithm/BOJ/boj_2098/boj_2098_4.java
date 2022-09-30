package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//dp+memoization+bitmask
//모든 도시를 맨 앞에 두며서 따질 필요가 없음 -> 순환 구조니깐
//맨 앞의 도시를 하나로 미리 정해놔도 됨
//dp 점진적으로 계산을 할 수 있어야 함 결과를 계속 저장하고 그 다음 계산에 영향을 미쳐야 함
//dp[i][j] i는 현재 도시: j는 거쳐온 도시 값은 남은 도시를 방문하는데 필요한 최소 비용
//dp[3][1,3,6,7]=100:현재 3에 있고 남은 2,4,5 도시를 방문하는데 최소 비용이 100;
//1,3,6,7->어떻게 표시? bitmasking
//dp[3][1100101]<예> 1,6,7->3/1,7,6->3

//계산 방법
//	dp[3][1100101]=>1,3,6,7방문 후 남은 2,4,5방문하는 최소 비용;
//	//2번 도시 를 간다고 가정 (4번도 가야하고 5번도 가야 함)
//	dp[2][1,2,3,6,7]->dp[2][1100111] 4번 먼저가면dp[2][1101101] 5번 먼저 가면 dp[2][1110101]

//dp[3][1100101]==>dp[2][1100111]+3->2비용][dp[4][1101101]+3->4비용][dp[5][1110101]+3->5비용] 중 최소 비용

//위 과정을 반복하게 되면 마지막 dp[5][1111111]=5->1,dp[4][1111111]=4->1
public class boj_2098_4 {

	static int[][] W;
	static int n, allmask,INF=987654321;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		W = new int[n][n];
		allmask=(1<<n)-1;//5개 도시->1<<5:100000	->	-1	->11111
		dp=new int[n][allmask];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				W[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(tsp(0,1));//0번째 도시 0000..1
	}
	static int tsp(int x,int mask) {
		//기저조건
		if(mask==allmask) {
			if(W[x][0]==0)return INF;
			
			return W[x][0];
		}
		//이미 계산된 dp가 있으면 그걸 return
		if(dp[x][mask]!=0)return dp[x][mask];
		//없으면
		dp[x][mask]=INF;
		
		//x로 부터 갈 수 있는 남은 도시를 탐색
		for(int i=0;i<n;i++) {
			//경로 없거나 이미 방문한 경우 제외
			if(W[x][i]==0||(mask&(1<<i))!=0)continue;
			
			dp[x][mask]=Math.min(dp[x][mask],tsp(i,mask|(1<<i))+W[x][i]);
		}
		return dp[x][mask];
	}
}
