import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        
        List<Integer>[] adj_list = new ArrayList[n+1];
        for(int i=1; i<=n; i++) adj_list[i] = new ArrayList<>();
        for(int i=0; i<m; i++){
            int num1 = edge_list[i][0];
            int num2 = edge_list[i][1];
            adj_list[num1].add(num2);
            adj_list[num2].add(num1);
        }
        
        int[][] dp = new int[k][n+1];
        for(int i=0; i<k; i++){
            for(int j=0; j<=n; j++){
                dp[i][j] = 101;
            }
        }
        dp[0][gps_log[0]] = 0;
        
        for(int i=0; i<k-1; i++) {
			for(int j=1; j<=n; j++) {
				dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]);
                
				for(int l=0; l<adj_list[j].size(); l++) {
                    int num = adj_list[j].get(l);
					dp[i+1][j] = Math.min(dp[i+1][j], dp[i][num]);
				}
                if(gps_log[i+1] != j) dp[i+1][j]++;
			}
		}
        
        return (dp[k-1][gps_log[k-1]] == 101) ? -1 : dp[k-1][gps_log[k-1]];
    }
}