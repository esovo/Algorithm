import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        String str;
        Set<Character> set;
        outer:
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            set = new HashSet<>();
            char prev = str.charAt(0);
            set.add(prev);
            for (int j = 1; j < str.length(); j++) {
                if (prev == str.charAt(j)) continue;
                if (set.contains(str.charAt(j))) continue outer;
                prev = str.charAt(j);
                set.add(prev);
            }
            ans++;
        }

        System.out.println(ans);
    }

}