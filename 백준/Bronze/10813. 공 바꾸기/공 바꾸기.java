import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = i+1;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int ord1 = Integer.parseInt(st.nextToken())-1;
            int ord2 = Integer.parseInt(st.nextToken())-1;
            int temp = arr[ord1];
            arr[ord1] = arr[ord2];
            arr[ord2] = temp;
        }

        for(int i=0; i<N-1; i++) sb.append(arr[i]).append(" ");
        sb.append(arr[N-1]);
        System.out.print(sb);
    }

}