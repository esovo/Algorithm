class Solution {
    
    static int n, ans;
    static int[][] dungeons;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        ans = 0;
        n = dungeons.length;
        visited = new boolean[n];
        dfs(0, k);
        return ans;
    }
    
    private void dfs(int cnt, int hp){
        ans = Math.max(ans, cnt);
        if(cnt == n){
            ans = n;
            return;
        }
        
        for(int i=0; i<n; i++){
            if(visited[i] || hp<dungeons[i][0]) continue;
            visited[i] = true;
            dfs(cnt+1, hp-dungeons[i][1]);
            visited[i] = false;
        }
    }
    
}