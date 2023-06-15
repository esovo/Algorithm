import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > K) break;
            list.add(num);
        }

        int answer = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (K == 0) break;
            int cnt = K / list.get(i);
            K -= list.get(i) * cnt;
            answer += cnt;
        }

        System.out.println(answer);
    }

}