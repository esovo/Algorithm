import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push_front":
                    queue.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    queue.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                        continue;
                    }
                    sb.append(queue.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                        continue;
                    }
                    sb.append(queue.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append(1).append("\n");
                        continue;
                    }
                    sb.append(0).append("\n");
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                        continue;
                    }
                    sb.append(queue.peekFirst()).append("\n");
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                        continue;
                    }
                    sb.append(queue.peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

}