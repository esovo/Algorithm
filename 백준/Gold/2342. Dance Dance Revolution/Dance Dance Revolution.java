import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] dirs;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        N = strs.length-1; 
        dirs = new int[N]; 
        for(int i=0; i<N; i++) dirs[i] = Integer.parseInt(strs[i]);
        dp = new int[N][5][5]; 
        System.out.println(move(0,0,0));
    }

    private static int move(int idx, int left, int right){
        if(idx == N) return 0;
        if(dp[idx][left][right]!=0) return dp[idx][left][right];
        int lp = left==0 ? 2 : dirs[idx]==left ? 1 : Math.abs(dirs[idx]-left)==2 ? 4 : 3;
        int rp = right==0 ? 2 : dirs[idx]==right ? 1 : Math.abs(dirs[idx]-right)==2 ? 4 : 3;
        int lscore = dirs[idx] != right ? move(idx+1, dirs[idx], right)+lp : Integer.MAX_VALUE;
        int rscore = dirs[idx] != left ? move(idx+1, left, dirs[idx])+rp : Integer.MAX_VALUE;
        dp[idx][left][right] = Math.min(lscore, rscore);
        return dp[idx][left][right];
    }

}