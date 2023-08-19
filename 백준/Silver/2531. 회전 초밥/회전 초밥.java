import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N+k];
        for(int i=0; i<N; i++) sushi[i] = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++) sushi[N+i] = sushi[i];

        int start = 0, end = k;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=start; i<end; i++){
            if(map.containsKey(sushi[i])) map.put(sushi[i], map.get(sushi[i])+1);
            else map.put(sushi[i], 1);
        }

        while(start < N){
            if(map.containsKey(c)) max = Math.max(max, map.size());
            else max = Math.max(max, map.size()+1);

            if(map.get(sushi[start])>1) map.put(sushi[start], map.get(sushi[start])-1);
            else map.remove(sushi[start]);

            if(map.containsKey(sushi[end])) map.put(sushi[end], map.get(sushi[end])+1);
            else map.put(sushi[end], 1);
            
            start++;
            end++;
        }

        System.out.println(max);
    }

}