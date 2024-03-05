import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        boolean[][] isPal = new boolean[N][N];
        int[] dp = new int[N];

        // 팰린드롬 여부 계산
        for(int i=0; i<N; i++){
            isPal[i][i] = true;
            for(int j=0; j<i; j++){
                if(str.charAt(j)==str.charAt(i) && (i-j<2 || isPal[j+1][i-1])) isPal[j][i] = true;
            }
        }

        // 최소 분할 수 계산
        for(int i=0; i<N; i++){ // 끝점
            if(isPal[0][i]) dp[i] = 1;
            else{
                dp[i] = N;
                for(int j=0; j<i; j++){ // 시작점
                    if(isPal[j+1][i]) dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(dp[N-1]);
    }

}