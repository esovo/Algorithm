import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int max = 0, cnt = 0;
        int[] check = new int[d+1];
        for(int i=start; i<end; i++) {
            if(check[sushi[i]]==0) cnt++;
            check[sushi[i]]++;
        }

        while(start < N){
            if(check[c]!=0) max = Math.max(max, cnt);
            else max = Math.max(max, cnt+1);

            if(check[sushi[start]]==1) cnt--;
            check[sushi[start]]--;

            if(check[sushi[end]]==0) cnt++;
            check[sushi[end]]++;

            start++;
            end++;
        }

        System.out.println(max);
    }

}