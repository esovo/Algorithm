import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
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
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int len = end-start+1;
            for(int j=0; j<len/2; j++){
                int temp = arr[start+j];
                arr[start+j] = arr[end-j];
                arr[end-j] = temp;
            }
        }

        for(int i=0; i<N-1; i++) sb.append(arr[i]).append(" ");
        sb.append(arr[N-1]);
        System.out.print(sb);
    }

}