import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int[] p;
    static HashMap<Integer, Boolean> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        for(int i=0; i<truth; i++) map.put(Integer.parseInt(st.nextToken()), true);

        p = new int[N+1];
        for(int i=1; i<N+1; i++) p[i] = i;

        ArrayList<Integer>[] list = new ArrayList[M];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int par = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
            int num = Integer.parseInt(st.nextToken());
            list[i].add(num);
            for(int j=1; j<par; j++){
                int num2 =  Integer.parseInt(st.nextToken());
                union(num, num2);
                list[i].add(num2);
            }
        }

        int count = 0;
        for(int i=0; i<M; i++){
            boolean possible = true;
            for(int j=0; j<list[i].size(); j++){
                if(map.containsKey(find(list[i].get(j)))){
                    possible = false;
                    break;
                }
            }
            if(possible) count++;
        }
        System.out.println(count);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(map.containsKey(y)) p[x] = y;
        else p[y] = x;
    }

    static int find(int x){
        if(p[x] == x) return x;
        return find(p[x]);
    }
    
}