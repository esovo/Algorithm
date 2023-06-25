import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(stack.isEmpty()){
                        sb.append(-1).append("\n");
                        continue;
                    }
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        sb.append(1).append("\n");
                        continue;
                    }
                    sb.append(0).append("\n");
                    break;
                case "top":
                    if(stack.isEmpty()){
                        sb.append(-1).append("\n");
                        continue;
                    }
                    sb.append(stack.peek()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

}
