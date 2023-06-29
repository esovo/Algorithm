import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<Edge>[] list;
    static int max = 0, idx = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N];
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            if (list[from] == null) list[from] = new ArrayList<>();
            if (list[to] == null) list[to] = new ArrayList<>();
            list[from].add(new Edge(to, weight));
            list[to].add(new Edge(from, weight));
        }

        if (N == 1) {
            System.out.println(0);
            return;
        }

        if (N == 2) {
            System.out.println(list[0].get(0).weight * 2);
            return;
        }

        visited = new boolean[N];
        visited[0] = true;
        dfs1(0, 0);

        int num = idx;
        max = 0;
        idx = 0;
        visited = new boolean[N];
        visited[num] = true;
        dfs2(num, 0, -1);

        System.out.println(max);

    }

    private static void dfs1(int num, int weight) {
        if (num != 0 && list[num].size() == 1) {
            if (max < weight) {
                max = weight;
                idx = num;
            }
            return;
        }

        for (int i = 0; i < list[num].size(); i++) {
            if (visited[list[num].get(i).to]) continue;
            visited[list[num].get(i).to] = true;
            dfs1(list[num].get(i).to, weight + list[num].get(i).weight);
            visited[list[num].get(i).to] = false;
        }
    }

    private static void dfs2(int num, int weight, int prev) {
        if (list[num].size() == 1 && list[num].get(0).to == prev) {
            if (max < weight) {
                max = weight;
                idx = num;
            }
            return;
        }

        for (int i = 0; i < list[num].size(); i++) {
            if (visited[list[num].get(i).to]) continue;
            visited[list[num].get(i).to] = true;
            dfs2(list[num].get(i).to, weight + list[num].get(i).weight, num);
            visited[list[num].get(i).to] = false;
        }
    }

}