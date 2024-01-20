import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); 
            int K = Integer.parseInt(st.nextToken());
            int[] times = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) times[i] = Integer.parseInt(st.nextToken());

            List<Integer>[] graph = new ArrayList[N];
            int[] enter = new int[N];
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken())-1;
                int end = Integer.parseInt(st.nextToken())-1;
                if(graph[start] == null) graph[start] = new ArrayList<>();
                graph[start].add(end);
                enter[end]++;
            }
            int W = Integer.parseInt(br.readLine())-1;

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[N];
            int[] dp = new int[N];
            for(int i=0; i<N; i++){
                if(enter[i]==0) {
                    queue.offer(i);
                    dp[i] = times[i];
                    visited[i] = true;
                }
            }

            while(!queue.isEmpty()){
                int cur = queue.poll();
                if(graph[cur] == null) continue;
                for(int i=0; i<graph[cur].size(); i++){
                    int temp = graph[cur].get(i);
                    if(enter[temp] > 0) enter[temp]--;
                    dp[temp] = Math.max(dp[temp], dp[cur]+times[temp]);
                    if(enter[temp] != 0) continue;
                    if(!visited[temp]) queue.offer(temp);
                    visited[temp] = true;
                }
            }
            sb.append(dp[W]).append("\n");
        }

        System.out.println(sb);
    }

}