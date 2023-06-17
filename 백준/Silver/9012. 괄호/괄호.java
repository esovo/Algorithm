import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        outer:
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            Stack<Character> st = new Stack<>();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '(') st.push(chars[j]);
                else {
                    if (st.isEmpty()) {
                        sb.append("NO").append("\n");
                        continue outer;
                    }
                    st.pop();
                }
            }
            if (st.isEmpty()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

}