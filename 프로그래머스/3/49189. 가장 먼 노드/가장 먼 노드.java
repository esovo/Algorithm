import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
        for(int i=0; i<edge.length; i++){
            adj[edge[i][0]-1].add(edge[i][1]-1);
            adj[edge[i][1]-1].add(edge[i][0]-1);
        }
        
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        
        int max = 0;
        while(!q.isEmpty()){
            int idx = q.poll();
            
            for(int i=0; i<adj[idx].size(); i++){
                if(visited[adj[idx].get(i)]) continue;
                dist[adj[idx].get(i)] = dist[idx]+1;
                q.add(adj[idx].get(i));
                visited[adj[idx].get(i)] = true;
                max = Math.max(max, dist[adj[idx].get(i)]);
            }
        }
        
        int answer = 0;
        for(int i=0; i<n; i++) if(max==dist[i]) answer++;
        return answer;
    }
    
}