import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[1000];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int j = 123; j < 1000; j++) {
                if (check[j]) continue;
                String str = Integer.toString(j);
                // 수에 0이 들어가는 경우
                if (str.charAt(1) == '0' || str.charAt(2) == '0') {
                    check[j] = true;
                    continue;
                }
                // 수에 겹치는 숫자가 들어가는 경우
                if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2)) {
                    check[j] = true;
                    continue;
                }

                int str_cnt = 0;
                int ball_cnt = 0;
                for (int k = 0; k < 3; k++) {
                    char n1 = Integer.toString(num).charAt(k);

                    for (int l = 0; l < 3; l++) {
                        char n2 = Integer.toString(j).charAt(l);

                        if (n1 == n2 && k == l) str_cnt++;
                        else if (n1 == n2 && k != l) ball_cnt++;
                    }
                }

                if (str_cnt != strike || ball_cnt != ball) {
                    check[j] = true;
                    continue;
                }
            }
        }

        int ans = 0;
        for (int i = 123; i < 1000; i++) {
            if (!check[i]) ans++;
        }
        System.out.println(ans);

    }

}