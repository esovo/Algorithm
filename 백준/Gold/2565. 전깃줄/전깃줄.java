import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Line implements Comparable<Line> {
        int A, B;
        Line(int A, int B){
            this.A = A;
            this.B = B;
        }

        public int compareTo(Line l){
            return this.A-l.A;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Line[] lines = new Line[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines[i] = new Line(a, b);
        }
        Arrays.sort(lines);

        int[] dp = new int[N];
        int max = 0;
        for(int i=0; i<N; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(lines[j].B < lines[i].B){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        System.out.println(N-max);
    }

}