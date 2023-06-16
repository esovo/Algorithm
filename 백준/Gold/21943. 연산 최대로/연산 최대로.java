import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int Q, ans = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        if (P == 0 || Q == 0) {
            if (P == 0) {
                ans = 1;
                for (int i = 0; i < N; i++) ans *= arr[i];
            } else for (int i = 0; i < N; i++) ans += arr[i];
        }
        else {
            int[] comb = new int[Q + 1];
            dfs(comb, 0);
        }

        System.out.println(ans);

    }

    public static void dfs(int[] comb, int idx) {
        if (idx == arr.length) {
            int result = 1;
            for(int i=0; i<comb.length; i++) result *= comb[i];
            ans = Math.max(ans, result);
            return;
        }
        for (int i = 0; i < comb.length; i++) {
            comb[i] += arr[idx];
            dfs(comb, idx + 1);
            comb[i] -= arr[idx];
        }
    }

}