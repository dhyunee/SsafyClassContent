
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Algo1_부울경_3반_김송빈 {
	static int n;
	static int ans;
	public static void main(String[] args)throws Exception {
		//System.setIn(new FileInputStream("res/막대기_제공용_input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			n=Integer.parseInt(br.readLine());
			ans=0;
			if(check())System.out.println("#"+t+" "+1);
			else {
				cal(64,0);
				System.out.println("#"+t+" "+ans);
			}
		}
	}
	static boolean check() {
		int n2=n;
		
		while(n2%2==0) {
			n2/=2;
		}
		if(n2==1)return true;
		return false;
		
	}
	static void cal(int n2,int bef) {
		if(bef+n2/2>n) {
			cal(n2/2,bef);
			
		}else if(bef+n2/2==n) {
			ans++;
			return ;
		}else {
			ans++;
			cal(n2/2,bef+n2/2);
		}
	}
}
