class Solution {
    
    // 미니맥스 알고리즘 참고한 풀이
    
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        map = board;
        return dfs(aloc[0], aloc[1], bloc[0], bloc[1]);
    }
    
    public int dfs(int curX, int curY, int postX, int postY) {
        if (map[curX][curY] == 0) return 0;

        int answer = 0;
        for(int i=0; i<4; i++){
            int dx = curX + dr[i];
            int dy = curY + dc[i];
            if(dx<0 || dx>=map.length || dy<0 || dy>=map[0].length || map[dx][dy]==0) continue;
            
            map[curX][curY] = 0;
            int cnt = dfs(postX, postY, dx, dy)+1;
            map[curX][curY] = 1;
            
            if(answer%2 == 0){
                if(cnt%2 == 1) answer = cnt;
                else answer = Math.max(answer, cnt);
            }
            else{
                if(cnt%2 == 1) answer = Math.min(answer, cnt);
            }
        }
    
        return answer;
    }
 
}