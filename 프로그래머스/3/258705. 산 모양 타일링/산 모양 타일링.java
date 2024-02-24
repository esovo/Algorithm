class Solution {
    
    public int solution(int n, int[] tops) {
        int[][] dp = new int[n][2];
        if(tops[0] == 1){ // 위쪽 삼각형이 있는 경우
            dp[0][0] = 3; // 없, 위, 왼
            dp[0][1] = 1; // 오
        }
        else{ // 위쪽 삼각형이 없는 경우
            dp[0][0] = 2; // 없, 왼
            dp[0][1] = 1; // 오
        }
        for(int i=1; i<n; i++){
            dp[i][0] = (dp[i-1][0]*(2+tops[i]) + dp[i-1][1]*(1+tops[i])) % 10007;
            dp[i][1] = (dp[i-1][0]+dp[i-1][1]) % 10007;
        }

        return (dp[n-1][0]+dp[n-1][1]) % 10007;
    }

}