import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N+1];
		int[] dp = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=i; j++) {
				if(A[i]>A[j]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
					max = Math.max(max, dp[i]);
				}
			}
		}
		System.out.println(max);
	}
}