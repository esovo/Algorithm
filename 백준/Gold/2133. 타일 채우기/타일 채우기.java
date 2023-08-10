import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        for(int i=3; i<=30; i++){
            dp[i] += dp[i-2]*3;
            for(int j=2; j<=i/2; j++) {
                dp[i] += dp[i - (2 * j)] * 2;
            }
        }
        System.out.println(dp[n]);
        
    }
    
}