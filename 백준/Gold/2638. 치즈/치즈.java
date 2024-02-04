import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Cheese{
        int x, y;
        Cheese(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 파티 수

        map = new int[N][M];
        List<Cheese> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) list.add(new Cheese(i, j));
            }
        }

        // 치즈 외부 공기 찾기
        bfs(0, 0);

        // 치즈 찾고 녹이기
        int time = 0;
        while(true){
            int size = list.size();
            if(size==0) break;
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
            for(int i=0; i<size; i++){
                Cheese cheese = list.get(i);
                if(check(cheese.x, cheese.y)){
                    pq.offer(i);
                }
            }

            while(!pq.isEmpty()){
                int idx = pq.poll();
                Cheese cheese = list.remove(idx);
                bfs(cheese.x, cheese.y);
            }
            time++;
        }
        System.out.println(time);
    }

    static boolean check(int x, int y){
        int count = 0;
        for(int i=0; i<4; i++){
            int dx = x+dir[i][0];
            int dy = y+dir[i][1];
            if(map[dx][dy]==2) count++;
        }
        return count>=2;
    }

    static void bfs(int x, int y){
        Queue<Cheese> queue = new LinkedList<>();
        queue.offer(new Cheese(x, y));
        map[x][y] = 2;

        while(!queue.isEmpty()){
            Cheese cur = queue.poll();
            for (int i=0; i<4; i++) {
                int dx = cur.x + dir[i][0];
                int dy = cur.y + dir[i][1];
                if (dx<0 || dy<0 || dx>=N || dy>=M || map[dx][dy]!=0) continue;
                map[dx][dy] = 2;
                queue.offer(new Cheese(dx, dy));
            }
        }
    }

}